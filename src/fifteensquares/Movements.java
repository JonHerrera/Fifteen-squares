/*
 * JONATHAN HERRERA
 */
package fifteensquares;

//Importing the array and searchFor(blank) value to be used as well as other variables
    import static fifteensquares.FifteenSquares.rxc;
    import static fifteensquares.FifteenSquares.searchFor;
    import static fifteensquares.Input.choice;
    import static fifteensquares.Input.move;

    public class Movements {
        
        View view = new View();
        
        public int moveDown(int i, int j) {                            
//        System.out.println("Moving down to "  + rxc[i+1][j]);
        rxc[i][j] = rxc[i+1][j];
        //the starting position of the value is now going to be occupied by the value of the position it is moving to
        rxc[i+1][j] = searchFor;
        //the old position is now getting the value of the next position
        //moves down one row
        //moves the space down one
        return i;
    }
    
        public int moveUp(int i, int j) {
//            System.out.println("Moving up to "  + rxc[i-1][j]);
            rxc[i][j] = rxc[i-1][j];
            rxc[i-1][j] = searchFor;
            //moves the space up one
            return i;
        }

        public int moveRight(int i, int j) {
 //           System.out.println("Moving right to "  + rxc[i][j+1]);
            rxc[i][j] = rxc[i][j+1];
            rxc[i][j+1] = searchFor;
            //moves the space right one
            return j;
        }

        public int moveLeft(int i, int j) {                            
//            System.out.println("Moving left to "  + rxc[i][j-1]);
            rxc[i][j] = rxc[i][j-1];
            rxc[i][j-1] = searchFor;
            //moves the space left one
            return j;
        }
        
        public void userMove() {
        //this is to move the blank square around

            System.out.print("Move: ");
         
            int choice = choice();
            int i, j, x, y;
            //I am initializing the variables here so that they may be used throughout each code block below
            int diff;
            //this will be the difference of Xpos and the users choice
            int m;
            //just an integer for the difference loop
            
            outerloop:
            //this outerloop is where the program will go after it makes a move
                for(i = 0; i < 4; i++) {
                    for(j = 0; j < 4; j++) {
                    //searching thorugh the array to find the position of the user's choice
                        if(rxc[i][j] == searchFor) {
                        //once I found the user's choice it will begin to look for the blank space, 0
                            for(x = 0; x < 4; x++) {
                                for(y = 0; y < 4; y++) {
                                    if(rxc[x][y] == choice) {
                                        if(i == x){
                                        //If the users choice and the blank are in the same row then...
                                            //diff = Math.abs(x - j);
                                            if(j < y) {
                                            //the row is now confirmed so it will check if its to the right or left of the blank
                                                System.out.println("You move right.");
                                                move.moveRight(i, j);
                                                break outerloop;
                                                //this will perform the move function then break out to the outerloop
                                                //w/o this break, multiple moves would occur in a single sequence
                                            }
                                            else if(j > y) {
                                                System.out.println("You move left.");
                                                move.moveLeft(i, j);
                                                break outerloop;
                                            }
                                        }
                                        else if(j == y) {
                                        //if the user's selection is in the same column then...
                                            if(i < x) {
                                            //it will check to see if it is in the row above...
                                                System.out.println("You move down.");
                                                move.moveDown(i, j);
                                                break outerloop;
                                            }
                                            else if(i > x) {
                                            //or in the row below
                                                System.out.println("You moved up.");
                                                move.moveUp(i, j);
                                                break outerloop;
                                            }
                                        }
                                        else {
                                            System.out.println("That number can't be picked!");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            System.out.println("");
            //for spacing
            view.drawGrid();
            //so the user can see their move
        }
    }
