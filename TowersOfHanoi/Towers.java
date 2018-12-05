/** Towers is a class to create & maintain the three pegs in Towers of Hanoi
 *  It's basically the game environment itself
 *
 *  @author Mark Allan Puchala II
 *  @version 0.0
 */


import java.util.ListIterator; // We're importing this to use in displayTowers()
                               // where we'll be printing the Stacks to screen.

import java.util.Arrays;       // We're using this to store the win condition
                               // It's a String of the original stack of rings as an array

class Towers
{

    public boolean victory;             // Tracks whether we've won the game yet
    private Peg peg [] = new Peg[3];    // This groups the three pegs together
    private String winCondition;        // This is the first peg's original state


    /** Towers(int numRings) is a constructor
     * It creates all the pegs, stores the win condition, and tracks that we haven't won yet.
     * @param numRings is the number of rings we'll play our game with
     */
    public Towers(int numRings) // *********************************************
    {
        if (numRings >= 1 && numRings <= 64)                                    // If the number of rings is between 1 & 64
        {                                                                       // then
            peg[0] = new Peg(numRings);                                         // initialize the first peg with all rings
            peg[1] = new Peg();                                                 // And the other two pegs
            peg[2] = new Peg();                                                 // with no rings
            victory = false;                                                    // Record that we haven't won yet
            winCondition = Arrays.toString(peg[0].getStack().toArray());        // And set our win Condition (It's what the first peg looks like)
        } // end if                                                             //
        else                                                                    // But if we don't have the right number of rings
        {                                                                       //
            System.out.print(" - Please pick a number between 1 and 64 : ");    // SAY SO. The TowersGame class will make us input another number
        } // end else                                                           // And then it will run this function all over again.
    } // end Towers(int numRings) **********************************************

    /** testForWin() is a simple method that simply checks our win condition
     *  If we have won, it will trigger our resident boolean value, recording so.
     *  @return victory = false means we haven't won yet.
     *  @return victory = true means WE WON!
     */
    public boolean testForWin() // *********************************************
    {
        String tester = Arrays.toString(peg[1].getStack().toArray());           // Find out what's on the second peg
        if (tester.equals(winCondition))                                        // And if it matches our win condition
        {                                                                       // Well, then.
            return victory = true;                                              // WE WON! Let's celebrate!
        } // end if                                                             // But if it didn't match our win condition
        else                                                                    // GUESS WHAT
        {                                                                       // Yeah, that's right.
            return victory = false;                                             // We didn't win, yet.
        } // end else
    } // end boolean testForWin() **********************************************
                                                                            // *
    /** countRings(int pegNumber) counts the rings on a given Peg              *
     * @param pegNumber the number designating which peg we're looking at.     *
     * @return peg[pegNumber-1].getRings() gets the number of rings on the peg *
     *                                                                         *
     */                                                                     // *
    public int countRings(int pegNumber) // ************************************
    {
        return peg[pegNumber-1].getRings();   // report the number of rings on this peg
    } // end int countRings(int pegNumber)  ************************************
                                                                            // *
    /** getTopDiameter(int pegNumber) finds the ring on the top of the stack   *
     *  and determines what its diameter is.                                   *
     * @param pegNumber is the number of the peg we're looking at              *
     * return return peg[pegNumber-1].getTopRing() is the top ring of  our peg *
     * return 0 means our peg didn't have a ring on top of it.                 *
     */                                                                     // *
    public int getTopDiameter(int pegNumber)  // *******************************
    {
        if (countRings(pegNumber) > 0)                                          // If there's at least one ring on the peg
        {                                                                       // then
            return peg[pegNumber-1].getTopRing();                               // Report what the top ring is
        } // end if                                                             //
        else                                                                    // otherwise
        {                                                                       //
            return 0;                                                           // report that there wasn't a ring
        } // end else                                                           //
    } // end int getTopDiameter(int pegNumber) *********************************
                                                                            // *
    /** move(int startPeg, int endPeg) moves a ring from one peg to another.   *
     *  @param startPeg is the peg we're moving our ring FROM                  *
     *  @param endPeg is the peg we're moving our ring TO                      *
     */                                                                     // *
    public void move(int startPeg, int endPeg)  // *****************************
    {
        if (countRings(startPeg) > 0 && endPeg != startPeg)                     // If the first peg has more than one ring
        {                                                                       // and the first & second pegs aren't the same
                if (getTopDiameter(startPeg) < getTopDiameter(endPeg)           // Then let's Check if the first peg has a smaller top ring than the second
                        || getTopDiameter(endPeg) == 0)                         // Also, what if the second peg doesn't even have any rings?
                        {                                                       // If ANY of these were true?
                    peg[endPeg-1].pushRing(peg[startPeg-1].popRing());          // Then we're pushing a ring from the first peg to the second peg!
                } // end if                                                     //
        } // end if                                                             // After all's said and done...
        displayTowers();                                                        // Let's show those towers again!
    } // end void  *************************************************************
                                                                            // *
    /** displayTowers() is a complex function used to display all the pegs.    *
     * First it creates ListIterators of all the pegs' stacks                  *
     * Then it determines which peg has the largest stack.                     *
     * After all this is done, it prings all of the stacks.                    *
     * Finally, if some fatal glitch ends the game without closing the program *
     * we have a final else statement to cover that.                           *
     */                                                                     // *
    public void displayTowers() // *********************************************
    {
        if (victory == false)                                                       // If we haven't won yet
        {                                                                           // Then let's make some ListIterators!
            ListIterator listy[] = new ListIterator[3];                             // We'll use them to visualize each entire stack!
            for (int i = 0; i <= 2; i++)                                            // Let's use a for-loop.
            {                                                                       // This will make things easy to use
                listy[i] = peg[i].getStack().listIterator(peg[i].getStack().size());// if we ever make a Towers of Hanoi with more than three pegs.
            } // enf for loop                                                       //
            int maxStack = 0;                                                       // Let's make an int to track the largest stack size. We'll set it to 0 for now.
            for (Peg each : peg)                                                    // And for every peg we have...
            {                                                                       //
                if (each.getStack().size() > maxStack)                              // If they're larger than the current "max stack"
                {                                                                   //
                    maxStack = each.getStack().size();                              // Then maxStack recognizes them as the largest stack!
                } // end if                                                         //
            } // enf for loop                                                       //
            System.out.println();                                                   // Now let's space things out wth a NewLine.
            System.out.println(String.format("%10s","Peg 1") +                      // Let's make some Column Headers!
                               String.format("%10s","Peg 2") +                      // This will make the pegs easy to visualize
                               String.format("%10s","Peg 3"));                      // So we can play the game more effectively!
            System.out.println();                                                   // Let's make another NewLine.
            int counter = 0;                                                        // And make a counter to track how deep we are in the stacks.
            while (counter <= maxStack)                                             // While this counter's counting up to the largest stack's size
            {                                                                       //
                for (ListIterator each : listy)                                     // We're going to grab the current element of EACH peg!
                {                                                                   //   -- We plan to print them, row by row.
                    if (each.hasPrevious())                                         // If we check the current position in our current stack
                    {                                                               //   -- AND THERE'S AN ELEMENT THERE
                      System.out.print(String.format("%8s",each.previous()));       // Let's print that element!
                    } // end if                                                     //
                    else System.out.print(String.format("%8s",""));                 // Otherwise, let's just print some whitespace.
                } // end for loop                                                   // This loop ends when every stack element has been printed
                System.out.println();                                               // And we'll finish this row with a NewLine at the end.
                counter++;                                                          // ^increment counter so it can iterate as many times as our largest stack has elements.
            } // end while loop                                                     // And let's close the while loop once there aren't any more elements to print.
        } // end if                                                                 //
        else                                                                        // If we somehow called displayTowers() after we already won...
        {                                                                           //
            System.out.println("You aren't currently in a game..." +                // Then let's report that we aren't in a game right now.
                               " How did you get here?");                           // Also... Let's see if we can get the player to think about what they did.
        } // end else                                                               //
    } // end void displayTowers() **********************************************
}
