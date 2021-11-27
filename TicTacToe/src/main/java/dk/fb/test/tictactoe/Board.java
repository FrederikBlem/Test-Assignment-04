package dk.fb.test.tictactoe;

public class Board {

    public String[] boardCells;

    public Board()
    {
        ClearBoard();
    }

    public void ClearBoard()
    {
        boardCells = new String[9];

        for (int i = 0; i < 9; i++)
        {
            boardCells[i] = ".";
        }
    }

    public void PrintBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + boardCells[0] + " | "
                + boardCells[1] + " | " + boardCells[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + boardCells[3] + " | "
                + boardCells[4] + " | " + boardCells[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + boardCells[6] + " | "
                + boardCells[7] + " | " + boardCells[8]
                + " |");
        System.out.println("|---|---|---|");
    }


    public int getEmptyCells() {
        int countEmptyCells = 0;
        for (String boardCell: boardCells)
        {
            if (boardCell == ".")
            {
                countEmptyCells++;
            }
        }
        return countEmptyCells;
    }
}
