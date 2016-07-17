/*
 *  JONATHAN HERRERA
 *  Contained in this file are all the methods pertaining to displaying the
 *  grid onto the screen.
 */
package fifteensquares;

    import static fifteensquares.FifteenSquares.searchFor;
    import static fifteensquares.FifteenSquares.rxc;
    //so this happened automatically...
    //I assume it is simply calling the array from the other method in the other class
    //(Lucky this happened)

public class View {
    
    public void drawGrid() {
    //this will draw the updated array
    //the values are already created in the array
    //this will just move through the array printing the values that are scrambled inside in the order they appear
        for(int i = 0; i < 4; i++) {
        //this loop will occur at the same time as the other loop
            for (int j = 0; j < 4; j++) {
                if (rxc[i][j] == searchFor) {
                    System.out.printf("%4s", " " + " ");
                //when the array item is 0, a blank space will appear instead of 0
                }
                else {
                System.out.printf("%4s", rxc[i][j].toString() + " "); 
                //as the other loop creates numbers, this loop will write the numbers in its position
                //the space is used for formatting
                //the "%4s", indicates character spacing of 4 for a 's'tring
                    //since its for a String, the rxc[][] is cast as a String
                }
            }

            System.out.println(" ");
            //after the [j] loop is complete, a line break will occur and the next row will print
        } 
    }  
}
