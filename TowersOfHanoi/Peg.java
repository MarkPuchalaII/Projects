/**
 * Peg is a class to represent one of the three pegs in the game Towers of Hanoi
 * It can start with a number of rings on it, ranging from 1-64.
 *
 * @author Mark Puchala II
 * @version 0.0
 */

import java.util.Stack;  // Implemented for the use of the rings Stack variable.

class Peg
{
    private Stack<Integer> rings = new Stack<Integer>(); // The peg's stack of rings
    private int peggyRings;                              // The number of rings on the stack


    /** Peg() is an empty constructor method
     */
    public Peg() // ************************************************************
    {
                                                                                // Nothing really going on in this one, is there?
    } // end Peg()  ************************************************************
                                                                            // *
    /** Peg(int ringNumber) is a constructor method                            *
     * It places a number of rings onto the peg's stack                        *
     *  @param ringNumber the number of rings on the peg                       *
     */                                                                     // *
    public Peg(int ringNumber) // **********************************************
    {
        peggyRings = ringNumber;                                                // Assign the number of rings on the stack
        while (ringNumber > 0)                                                  // And while you still have rings
        {                                                                       //
            rings.push(ringNumber--);                                           // add the largest ring onto the stack
        } // end while (ringNumber > 0)
    } // end Peg() *************************************************************
                                                                            // *
                                                                            // *
    /** getStack() is an accessor method                                       *
     * it gets the Stack variable, rings                                       *
     *  @return rings is a Stack variable                                      *
     */                                                                     // *
    public Stack getStack() // *************************************************
    {
        return rings;                                                           // GRAB THAT STACK!
    } // end getStack()  *******************************************************
                                                                            // *
    /** getRings() is an accessor method                                       *
     * it gets the int variable, peggyRings                                    *
     *  @return peggyRings is the number of rings currently on the stack       *
     */                                                                     // *
    public int getRings() // ***************************************************
    {
        return peggyRings;                                                      // Grab the number of rings in the stack
    } // end int getRings() ****************************************************
                                                                            // *
    /** getTopRing is an accessor method                                       *
     * it peeks at the stack's top value                                       *
     *  @return rings.peek() is the stack's top value                          *
     *  @return 0 is a way of saying there are "0 rings" on the stack          *
     */                                                                     // *
    public int getTopRing() // *************************************************
    {
        if (!rings.empty())                                                     // If the stack isn't empty
        {                                                                       //
            return rings.peek();                                                // peek at the top value
        } // end if                                                             //
        else                                                                    // Otherwise
        {                                                                       //
            return 0;                                                           // Report that there aren't any rings
        } // end else
    } // end int() *************************************************************
                                                                            // *
                                                                            // *
    /** pushRing(int diameter) pushes a value on top of the stack              *
     * It also increases peggyRings, to track that a value has been pushed.    *
     *  @param diameter is the diameter of the specific ring to be pushed      *
     *  @return 0 is a way of saying you couldn't push anything                *
     *  @return rings.push(diameter) pushes a specific ring onto the stack     *
     */                                                                     // *
    public int pushRing(int diameter) // ***************************************
    {
        if (!rings.empty()                                                      // If the stack isn't empty
            && rings.peek () < diameter)                                        // And its top value is smaller
        {                                                                       // than the current ring
                return 0;                                                       // ABORT
        } // end if                                                             // Otherwise
        peggyRings++;                                                           // increment the number or rings
        return rings.push(diameter);                                            // and push that ring on the peg!
    } // end int() *************************************************************
                                                                            // *
                                                                            // *
    /** int popRing() pops a ring off of the stack                             *
     *  @return rings.pop() pops a ring off the stack                          *
     *  @return 0 signifies there wasn't a ring to pop                         *
     */                                                                     // *
    public int popRing()  // ***************************************************
    {
        if (!rings.empty())                                                     // If the stack isn't empty
        {                                                                       // then
            --peggyRings;                                                       // decrement the number of rings
            return rings.pop();                                                 // and pop that ring off the stack!
        } // end if                                                             //
        else                                                                    // otherwise
        {                                                                       //
            return 0;                                                           // Report that there isn't a ring to pop!
        } // end else
    } // end int() *************************************************************
                                                                            // *
} // end Peg                                                                   *
