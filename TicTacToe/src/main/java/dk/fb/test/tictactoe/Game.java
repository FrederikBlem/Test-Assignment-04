package dk.fb.test.tictactoe;

import java.util.*;

//Should contain turn logic
public class Game {
    private int turnCount;
    private Boolean endFlag;
    private int emptyCellCount;
    public String playerSymbol;
    public String ai_Symbol;
    public String emptySymbol;
    public Scanner sc = new Scanner(System.in);

    public Game()
    {
        turnCount = 0;
        endFlag = false;
        emptyCellCount = 9;
        playerSymbol = "X";
        ai_Symbol = "O";
        emptySymbol = ".";
    }

    public int GetTurn()
    {
        return turnCount;
    }

    public void NextTurn()
    {
        if (turnCount < 8)
        {
            turnCount++;
        }
        else
        {
            //TODO: Manage ending the game.
            //EndGame();
        }
    }

    public void PlayGame()
    {
        Board board = new Board();
        board.ClearBoard();

        //Reentrant with these here.
        emptyCellCount = board.getEmptyCells();
        endFlag = false;

        System.out.println("New board print: ");
        board.PrintBoard();

        while (emptyCellCount > 0 && !endFlag)
        {
            turnCount++;
            System.out.println("Turn: " + turnCount);

            if (emptyCellCount % 2 == 1)
            {
                board = ai_Move(board);
                endFlag = GetIsWin(board, ai_Symbol);
            }
            else
            {
                board = player_Move(board);
                endFlag = GetIsWin(board, playerSymbol);
            }

            board.PrintBoard();

            emptyCellCount = board.getEmptyCells();
        }

        if (emptyCellCount == 0 && !endFlag)
        {
            System.out.println("Draw!");
        }

        if (endFlag)
        {
            if (GetIsWin(board, playerSymbol))
            {
                System.out.println("Human wins!");
            }

            if (GetIsWin(board, ai_Symbol))
            {
                System.out.println("Magical thinking rock wins!");
            }
        }
    }

    //TODO: Make sure this works!
    public Board ai_Move(Board board)
    {
        int randomNum = getRandomInt();

        System.out.println("Random int: " + randomNum);

        Boolean isLegalMove = false;

        while (!isLegalMove){
            isLegalMove = checkLegalMove(board, randomNum);
            System.out.println("Was it a legal move?: " + isLegalMove);
            if (!isLegalMove){
                randomNum = getRandomInt();
                System.out.println("Random int: " + randomNum);
            }
        }

        board.boardCells[randomNum] = ai_Symbol;

        return board;
    }

    public Board player_Move(Board board) {

        Boolean isLegalMove = false;

        System.out.println("Choose a position 0-8: ");
        int playerPos = sc.nextInt();

        while (!isLegalMove){
            isLegalMove = checkLegalMove(board, playerPos);
            if (!isLegalMove){
                System.out.println("Illegal position, choose a different position 0-8: ");
                playerPos = sc.nextInt();
            }
        }

        board.boardCells[playerPos] = playerSymbol;

        return board;
    }

    public Boolean checkLegalMove(Board board, int chosenIndex)
    {
        if (chosenIndex >= 0 && chosenIndex <= 8) //Prevent argumentOutOfRangeException - ugly code though.
        {
            if (board.boardCells[chosenIndex] == emptySymbol){
                return true;
            }
            else{
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public int getRandomInt(){
        System.out.println("Getting a random int: ");
        int minIndex = 0;
        int maxIndex = 9; //Random is ceiling exclusive

        Random rand = new Random();

        return rand.nextInt((maxIndex - minIndex)) + minIndex;
    }

    public boolean GetIsWin(Board board, String contestantSymbol)
    {
        int countToThree = 0;

        //Horizontal begin
        for (int i = 0; i <= 2; i++)
        {
            if (board.boardCells[i].contains(contestantSymbol))
            {
                countToThree++;
            }
        }

        if (countToThree == 3)
        {
            return true;
        }
        else
        {
            countToThree = 0;
        }

        for (int i = 3; i <= 5; i++)
        {
            if (board.boardCells[i].contains(contestantSymbol))
            {
                countToThree++;
            }
        }

        if (countToThree == 3)
        {
            return true;
        }
        else
        {
            countToThree = 0;
        }

        for (int i = 6; i <= 8; i++)
        {
            if (board.boardCells[i].contains(contestantSymbol))
            {
                countToThree++;
            }
        }

        if (countToThree == 3)
        {
            return true;
        }
        else
        {
            countToThree = 0;
        }
        //Horizontal end

        //Vertical begin
        for (int i = 0; i <= 8; i += 3)
        {
            if (board.boardCells[i].contains(contestantSymbol))
            {
                countToThree++;
            }
        }

        if (countToThree == 3)
        {
            return true;
        }
        else
        {
            countToThree = 0;
        }

        for (int i = 1; i <= 8; i += 3)
        {
            if (board.boardCells[i].contains(contestantSymbol))
            {
                countToThree++;
            }
        }

        if (countToThree == 3)
        {
            return true;
        }
        else
        {
            countToThree = 0;
        }

        for (int i = 2; i <= 8; i += 3)
        {
            if (board.boardCells[i].contains(contestantSymbol))
            {
                countToThree++;
            }
        }

        if (countToThree == 3)
        {
            return true;
        }
        else
        {
            countToThree = 0;
        }
        //Vertical end

        //Diagonal begin
        for (int i = 0; i <= 8; i += 4)
        {
            if (board.boardCells[i].contains(contestantSymbol))
            {
                countToThree++;
            }
        }

        if (countToThree == 3)
        {
            return true;
        }
        else
        {
            countToThree = 0;
        }

        for (int i = 2; i <= 6; i += 2)
        {
            if (board.boardCells[i].contains(contestantSymbol))
            {
                countToThree++;
            }
        }

        if (countToThree == 3)
        {
            return true;
        }
        else
        {
            countToThree = 0;
        }
        //Diagonal end

        return false;
    }
}
