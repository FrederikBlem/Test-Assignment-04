package dk.fb.test.tictactoe;

public class Board {

    public String[] boardSlots;
    public String turn;

    public Board()
    {
        boardSlots = new String[9];
    }


    public void PrintBoardOld()
    {
        System.out.println(" ");
        System.out.println(String.join(boardSlots[0], boardSlots[1], boardSlots[2]));
        System.out.println(String.join(boardSlots[3], boardSlots[4], boardSlots[5]));
        System.out.println(String.join(boardSlots[6], boardSlots[7], boardSlots[8]));
        System.out.println(" ");
    }


    public void PrintBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + boardSlots[0] + " | "
                + boardSlots[1] + " | " + boardSlots[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + boardSlots[3] + " | "
                + boardSlots[4] + " | " + boardSlots[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + boardSlots[6] + " | "
                + boardSlots[7] + " | " + boardSlots[8]
                + " |");
        System.out.println("|---|---|---|");
    }


}
