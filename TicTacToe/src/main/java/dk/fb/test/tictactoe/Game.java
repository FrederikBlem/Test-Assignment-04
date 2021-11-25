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

    //public List<String> winCases =

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
            EndGame();
        }
    }

    public void PlayGame()
    {
        Board board = new Board();

        while (emptyCellCount > 0 && !endFlag)
        {
            turnCount++;
            System.out.println("Turn: " + turnCount);

            if (emptyCellCount % 2 == 1)
            {
                board = ai_Move(board);
            }
            else
            {
                board = player_Move(board);
            }

            board.PrintBoard();

            //endFlag = GameWonBy(board) != null;

            emptyCellCount = board.getEmptyCells();
        }

    }

    //TODO: Make sure this works!
    public Board ai_Move(Board board)
    {
        int randomNum = getRandomInt();

        Boolean isLegalMove = false;

        while (!isLegalMove){
            isLegalMove = checkLegalMove(board, randomNum);
            if (!isLegalMove){
                randomNum = getRandomInt();
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
            return false;
        }
        else if (board.boardCells[chosenIndex] == emptySymbol){
            return true;
        }
        else{
            return false;
        }
    }

    public int getRandomInt(){
        int minIndex = 0;
        int maxIndex = 9; //Random is ceiling exclusive

        Random rand = new Random();

        return rand.nextInt((maxIndex - minIndex)) + minIndex;
    }

    public void EndGame()
    {
        System.out.println("There are no remaining moves!");
    }


}
