package dk.fb.test.tictactoe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TicTacToeApplicationTests {

    @Test
    void contextLoads() {
    }

    //region Board tests
    @Test
    public void Test_Board_Creation_Is_Not_Null()
    {
        Board board = new Board();
        assertNotNull(board);
    }

    @Test
    public void Test_New_Board_Has_Cells_With_Empty_Symbol_Only()
    {
        Board board = new Board();

        // Only for visual confirmation
        board.PrintBoard();

        // Run through board slots
        for (String boardCell: board.boardCells
             ) {
            assertEquals(".", boardCell);
        }
    }

    @Test
    public void Should_Count_9_Empty_Board_Cells_On_New_Board()
    {
        Board board = new Board();

        // Only for visual confirmation
        board.PrintBoard();

        assertEquals(9, board.getEmptyCells());
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

    //region Game tests
    @Test
    public void Test_Game_Instance_Is_Created()
    {
        Game game = new Game();
        assertNotNull(game);
    }

    @Test
    public void Test_Game_Instance_Starts_On_Turn_0()
    {
        Game game = new Game();
        assertEquals(0, game.GetTurn());
    }

    @Test
    public void Test_Game_Instance_Turn_Can_Increase()
    {
        Game game = new Game();
        game.NextTurn();
        assertEquals(1, game.GetTurn());
    }

    @Test
    public void Test_Game_Instance_Turns_Cant_Increase_Past_8()
    {
        Game game = new Game();
        for (int i = 0; i < 9; i++)
        {
            game.NextTurn();
        }

        assertEquals(8, game.GetTurn());
    }

    @Test
    public void Should_Return_Move_Is_Legal_On_New_Board()
    {
        Board board = new Board();
        board.ClearBoard();
        Game game = new Game();

        assertTrue(game.checkLegalMove(board, 0));
    }

    @Test
    public void Should_Return_Move_Is_Illegal_On_Occupied_Board_Slot()
    {
        Board board = new Board();
        Game game = new Game();

        board.boardCells[1] = game.ai_Symbol;

        assertFalse(game.checkLegalMove(board, 1));
    }

    @Test
    public void Should_Place_ai_Symbol_On_New_Board_Once()
    {
        Board board = new Board();
        Game game = new Game();
        board.ClearBoard(); //For testing purposes

        System.out.println("Testing placing ai symbol on new board: ");
        board.PrintBoard();
        board = game.ai_Move(board);

        System.out.println("Updated board print: ");
        board.PrintBoard();
        assertTrue(Arrays.asList(board.boardCells).contains(game.ai_Symbol));
    }

    //TODO: Find workaround for test that halts because the view is read-only.
    /*
    @Test
    public void Should_Place_Player_Symbol_On_New_Board_Once()
    {
        Board board = new Board();
        Game game = new Game();

        board = game.player_Move(board);

        System.out.println("Testing placing player symbol on new board: ");
        board.PrintBoard();
        assertTrue(Arrays.asList(board.boardCells).contains(game.playerSymbol));
    }
    */

    @Test
    public void Game_Should_Be_Won_By_Player_If_Cells_0_1_2_Are_Occupied_By_player_symbol()
    {
        Board board = new Board();
        Game game = new Game();

        //TODO: replace with game.player_Move(board) if possible to get input in future...
        board.boardCells[0] = game.playerSymbol;
        board.boardCells[1] = game.playerSymbol;
        board.boardCells[2] = game.playerSymbol;


        assertTrue(game.GetIsWin(board, game.playerSymbol));
    }

    @Test
    public void Game_Should_Be_Won_By_Player_If_Cells_3_4_5_Are_Occupied_By_player_symbol()
    {
        Board board = new Board();
        Game game = new Game();

        //TODO: replace with game.player_Move(board) if possible to get input in future...
        board.boardCells[3] = game.playerSymbol;
        board.boardCells[4] = game.playerSymbol;
        board.boardCells[5] = game.playerSymbol;


        assertTrue(game.GetIsWin(board, game.playerSymbol));
    }

    @Test
    public void Game_Should_Be_Won_By_If_Cells_6_7_8_Are_Occupied_By_player_symbol()
    {
        Board board = new Board();
        Game game = new Game();

        //TODO: replace with game.player_Move(board) if possible to get input in future...
        board.boardCells[6] = game.playerSymbol;
        board.boardCells[7] = game.playerSymbol;
        board.boardCells[8] = game.playerSymbol;

        assertTrue(game.GetIsWin(board, game.playerSymbol));
    }

    @Test
    public void Game_Should_Be_Won_If_Cells_0_3_6_Are_Occupied_By_player_symbol()
    {
        Board board = new Board();
        Game game = new Game();

        //TODO: replace with game.player_Move(board) if possible to get input in future...
        board.boardCells[0] = game.playerSymbol;
        board.boardCells[3] = game.playerSymbol;
        board.boardCells[6] = game.playerSymbol;

        assertTrue(game.GetIsWin(board, game.playerSymbol));
    }

    @Test
    public void Game_Should_Be_Won_If_Cells_1_4_7_Are_Occupied_By_player_symbol()
    {
        Board board = new Board();
        Game game = new Game();

        //TODO: replace with game.player_Move(board) if possible to get input in future...
        board.boardCells[1] = game.playerSymbol;
        board.boardCells[4] = game.playerSymbol;
        board.boardCells[7] = game.playerSymbol;

        assertTrue(game.GetIsWin(board, game.playerSymbol));
    }

    @Test
    public void Game_Should_Be_Won_If_Cells_2_5_8_Are_Occupied_By_player_symbol()
    {
        Board board = new Board();
        Game game = new Game();

        //TODO: replace with game.player_Move(board) if possible to get input in future...
        board.boardCells[2] = game.playerSymbol;
        board.boardCells[5] = game.playerSymbol;
        board.boardCells[8] = game.playerSymbol;

        assertTrue(game.GetIsWin(board, game.playerSymbol));
    }

    @Test
    public void Game_Should_Be_Won_If_0_4_8_Are_Occupied_By_player_symbol()
    {
        Board board = new Board();
        Game game = new Game();

        //TODO: replace with game.player_Move(board) if possible to get input in future...
        board.boardCells[0] = game.playerSymbol;
        board.boardCells[4] = game.playerSymbol;
        board.boardCells[8] = game.playerSymbol;

        assertTrue(game.GetIsWin(board, game.playerSymbol));
    }

    @Test
    public void Game_Should_Be_Won_If_2_4_6_Are_Occupied_By_player_symbol()
    {
        Board board = new Board();
        Game game = new Game();

        //TODO: replace with game.player_Move(board) if possible to get input in future...
        board.boardCells[2] = game.playerSymbol;
        board.boardCells[4] = game.playerSymbol;
        board.boardCells[6] = game.playerSymbol;

        assertTrue(game.GetIsWin(board, game.playerSymbol));
    }

    @Test
    public void Game_Should_Not_Be_Won_After_Single_Move()
    {
        Board board = new Board();
        Game game = new Game();

        //TODO: replace with game.player_Move(board) if possible to get input in future...
        board.boardCells[2] = game.playerSymbol;

        assertFalse(game.GetIsWin(board, game.playerSymbol));
    }
    //endregion Game tests

}
