import java.util.Scanner;

class TowersGame
{

    public static boolean validMove(Towers game, int startPeg, int endPeg)
    {
        int firstRing = game.getTopDiameter(startPeg);
        int secondRing = game.getTopDiameter(endPeg);
        int countingRings = game.countRings(startPeg);
        if ((firstRing > secondRing
                && secondRing > 0)
                || startPeg == endPeg
                || countingRings <= 0)
                {
            System.out.println("INVALID MOVE");
            return false;
        } else
        {
            game.move(startPeg, endPeg);
            return true;
        }
    }


    public static void main(String[] args)
    {

        int ringNumbers;
        Towers tower;
        boolean victory = false;


        System.out.println("Welcome to the TOWERS OF HANOI!!");
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("HOW TO PLAY:");
        System.out.println(" - Select a peg to move the top ring from <- You type '1', '2', or '3'");
        System.out.println(" - Select a peg to move that same ring to <- Type ANYTHING else to break the game.");
        System.out.println(" - Get all the rings - in the same order - from peg 1 to peg 2!");

        System.out.println();
        System.out.print("How many rings would you like? : ");

        do
        {
            ringNumbers = input.nextInt();
            tower = new Towers(ringNumbers);
        } while (ringNumbers < 1 || ringNumbers > 64);


        System.out.println();
        System.out.println("LET'S MAKE A MOVE!");

        tower.displayTowers();

        do
        {
            System.out.print("Move ");
            int first = input.nextInt();
            // System.out.print("test");
            if (first < 1 || first > 3)
            {
                break;
            } else
            {
                System.out.print(" to ");
                int second = input.nextInt();

                validMove(tower, first, second);
                victory = tower.testForWin();
                // System.out.println("Great job!");// validMove(tower, first, last);
            }
        } while (victory == false);
        System.out.println("GAME OVER");
    }
}
