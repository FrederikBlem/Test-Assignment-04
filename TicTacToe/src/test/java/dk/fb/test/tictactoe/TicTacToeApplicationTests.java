package dk.fb.test.tictactoe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase; //?? - didn't end up needing this?? - Guess it's JUnit3??

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TicTacToeApplicationTests {

    @Test
    void contextLoads() {
    }

    //region Board tests
    @Test
    public void test_Board_Creation_Is_Not_Null()
    {
        Board board = new Board();
        assertNotNull(board);
    }

    @Test
    public void test_New_Board_Has_Empty_Board_Slots()
    {
        Board board = new Board();

        // Only for visual confirmation
        board.PrintBoard();

        // Run through board slots
        for (String boardSlot: board.boardSlots
             ) {
            assertNull(boardSlot);
        }
    }
    //endregion Board tests

    //region Player tests
    @Test
    public void Test_Player_Is_Created()
    {
        Player player = new Player("X");
        assertNotNull(player);
    }

    @Test
    public void Test_Player_Is_Created_With_Turn_Symbol()
    {
        Player player = new Player("X");
        assertEquals("X", player.turnSymbol);
    }
    //endregion Player tests

    //region Adversary tests
    @Test
    public void Test_Adversary_Is_Created()
    {
        Adversary adversary = new Adversary("O");
        assertNotNull(adversary);
    }

    @Test
    public void Test_Adversary_Is_Created_With_Turn_Symbol()
    {
        Adversary adversary = new Adversary("O");
        assertEquals("O", adversary.turnSymbol);
    }
    //endregion Adversary tests
}
