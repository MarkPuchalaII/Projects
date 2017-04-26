// Solitaire Matching Game - list of random integer values - 10-99
// remove any consecutive pair whose first or second digits match. (i.e. 10 & 12 | 35 & 45)
// WIN   CASE : All values removed
// LOSE CASE : No consecutive pairs
//
// Put them in the ArrayList
// Scan the list with the ListIterator
// Remove the first matching pair
// Using ListIterator. Display the remaining values
// repeat

import java.util.ArrayList;                                                     // Use ArrayList to put our numbers in
import java.util.ListIterator;                                                  // Use ListIterator to count our numbers
import java.util.Random;                                                        // Use Random to generate our numbers
                                                                                //
                                                                                //
                                                                                //
class Solitaire {                                                               // Begin our class
	public static void main(String[] args) {                                      // Open a main function (such spaghetti code...)
		Random generate = new Random();                                             // Create a random number generator!
		ArrayList<String> list = new ArrayList<String>();                           // Create an ArrayList!
		                                                                            // Generator makes them, ArrayList holds them.
		System.out.println("Welcome to Solitaire!");                                // Let's welcome our player (witness, more like)
                                                                                //
                                                                                //
		ListIterator<String> check = list.listIterator();                           // Let's create a ListIterator
		for ( int i = 0; i < 40; i++){                                              // And count to 40
			check.add(String.format("%02d",generate.nextInt(99) + 1));                // While we use said Iterator to add random numbers
		} //end for                                                                 // The ArrayList should now be 40 long.
                                                                                // Now...
		while (check.hasPrevious()){                                                // because we need to "use the same iterator"
			check.previous();                                                         // Let's go back to the beginning/
		} // end while                                                              // Why couldn't we just use a new one???
                                                                                // Anyway..
		System.out.println("Here's our starting list:");                            // Let's announce the list we made!
		while (check.hasNext()){                                                    // And one by one,
			System.out.print(check.next() + "  ");                                    // let's populate that bad boy.
		} // end while                                                              //
		while (check.hasPrevious()){                                                // remember, same iterator.
			check.previous();                                                         // Let's go back to the beginning.
		} // end while                                                              //
		System.out.println();                                                       // Make a space for readability.
		System.out.println("Let's play!!");                                         // AND LET'S PLAY!
                                                                                // Let's make variables!
		boolean flag = false;                                                       // A flag to count if we removed a pair!
		String a;                                                                   // a = the first half of any test pair
		String b;                                                                   // b = the NEXT half of any test pair
		do {                                                                        // So let's get started...
			flag = false;                                                             // First, assume we haven't removed a pair
			while (check.hasNext()) {                                                 // Now, as long as there are values to check
				a = check.next();                                                       // Set a to the current one
				if (check.hasNext()) b = check.next(); // end if                        // Check if there even IS a b (might be at the end)
				else break;  //end else                                                 // And either set b or leave for being at the end.
                                                                                // Let's check our two numbers
				if (a.charAt(0) == b.charAt(0) || a.charAt(1) == b.charAt(1)){          // If either their first or second digits match
					System.out.println("A = " + a + "    B = " + b);                      // Let's say what they were
					System.out.println("Before : " + list);                               // What the list looked like when they were there
					check.previous(); check.remove();                                     // AND REMOVE them! First go to A. Then remove it.
					check.previous(); check.remove();                                     // Then go to B. Then remove it!
					flag = true;                                                          // Hold up a flag because you removed a pair!
					System.out.println("After  : " + list + "\n");                        // And show what the list looks like afterward
				} // end if                                                             // If we're not at the list's beginning
				if(check.hasPrevious()) check.previous(); // end if                     // then take a step back so we don't skip a number
			} // end while                                                            // But now, if we didn't remove a pair...
		} while (flag == true); //end do-while                                      // Then we're leaving the loop.
                                                                                //
		if (list.size() > 0) System.out.println("LOSER!"); // end if                // If there are still values in the list, WE LOST!
		else System.out.println("WINNER!"); //end else                              // Otherwise, WE WON!
		System.out.println("And the game is OVER!");                                // GAME OVER! YAY! We're done!
	} //end main                                                                  //
}  //end Solitaire                                                              //
