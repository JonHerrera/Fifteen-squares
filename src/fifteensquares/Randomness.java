/*
 * JONATHAN HERRERA
 */
package fifteensquares;

    import static fifteensquares.FifteenSquares.rxc;
    import static fifteensquares.FifteenSquares.searchFor;

    import java.util.Random;

    public class Randomness {
        
        Movements move = new Movements();
                
        static Random rand = new Random();
        //I created a 'random' variable from the Random class which was imported
        //the Random() is a method that can now be used
        
           
    public static int randomNumber() {
    //random numbers will be used a lot so might as well make it a method
        int choice = rand.nextInt(4) + 1;
        //the numbers 1 tp 4 will be generated
        return choice;
        //this will return the random number to whatever called it
    }
    
        public static int randomNumber2() {
             int choice = rand.nextInt(2) + 1;
            //the numbers 1 tp 4 will be generated
            return choice;
            //this will return the random number to whatever called it
        }

        public static int randomNumber3() {
             int choice = rand.nextInt(3) + 1;
            //the numbers 1 tp 4 will be generated
            return choice;
            //this will return the random number to whatever called it
        }

        public void randomGrid() {
        
        int i;
        int j;
        
            for(int repeat = 0; repeat < 50; repeat++) {
            //this will loop the entirety. The # of repeats is the # of times the space moved
            //searching each column of each row until the value is found

                int rand = randomNumber();
                //once the position of X is found a rand# will generate
                //this will determine whether to move vertically up or down or horizontally left or right...
                int rand2 = randomNumber2();
                //for when there are only 2 options...
                int rand3 = randomNumber3();
                //and for when there are 3 options.

                outerloop:
                for(i = 0; i <= 3 ; i++) {
                    for(j = 0; j <= 3; j++) {
                    //it will constantly follow the value by going through the coordinates until it finds the value
                    //this if statment will grab the [i][j] of the value wanted
                        if(rxc[i][j] == searchFor) {
                        //the specified variable will be looked for and once it is, the following will occur

    //                        System.out.print("The starting position of " + searchFor + " is now at ");
    //                        System.out.print("[" + i + "]");
    //                        System.out.println("[" + j + "].");
                        //these reidiculous if statements check the borders/corners of the array
                        //these prevent the randomization process from moving to a position outside the array, breaking the code
                            if (i == 0 && j == 0) {
                            //checking top left corner
                                    switch(rand2) {
                                        case 1: move.moveDown(i, j); break outerloop;
                                        case 2: move.moveRight(i, j); break outerloop;
                                    }
                            }
                            else if(i == 0 && j == 3) {
                            //top right corner
                                switch(rand2) {
                                    case 1: move.moveDown(i, j); break outerloop;
                                    case 2: move.moveLeft(i, j); break outerloop; 
                                }
                            }                        
                            else if (i == 3 && j == 0) {
                            //bottom left corner
                                    switch(rand2) {
                                        case 1: move.moveUp(i, j); break outerloop;
                                        case 2: move.moveRight(i, j); break outerloop;
                                    }
                            }
                            else if (i == 3 && j == 3) {
                            //bottom right corner
                                switch(rand2) {
                                    case 1: move.moveUp(i, j); break outerloop;
                                    case 2: move.moveLeft(i, j); break outerloop;
                                }
                            }
                            else if (i == 0 && j > 0 || i == 0 && j < 3) {
                            //top border
                                switch(rand3) {
                                    case 1: move.moveLeft(i, j); break outerloop;
                                    case 2: move.moveDown(i, j); break outerloop;
                                    case 3: move.moveRight(i, j); break outerloop;
                                }
                            }
                            else if (i == 3 && j > 0 || i == 0 && j < 3) {
                            //bottom border
                                switch(rand3) {
                                    case 1: move.moveLeft(i, j); break outerloop;
                                    case 2: move.moveUp(i, j); break outerloop;
                                    case 3: move.moveRight(i, j); break outerloop;
                                }
                            }
                            else if (j == 0 && i > 0 || j == 0 && i < 3) {
                            //left border
                                switch(rand3) {
                                    case 1: move.moveUp(i, j); break outerloop;
                                    case 2: move.moveRight(i, j); break outerloop;
                                    case 3: move.moveDown(i, j); break outerloop;
                                }
                            }
                            else if (j == 3 && i > 0 || j == 0 && i < 3) {
                            //right border
                                switch(rand3) {
                                    case 1: move.moveUp(i, j); break outerloop;
                                    case 2: move.moveLeft(i, j); break outerloop;
                                    case 3: move.moveDown(i, j); break outerloop;
                                }
                            }
                            else {
                            //contained in the region where it does not have the chance of exiting the array
                                switch(rand) {
                                //each output is associated with a direction to move the space
                                    case 1: move.moveDown(i, j); break outerloop;
                                    case 2: move.moveUp(i, j); break outerloop;
                                    case 3: move.moveRight(i, j); break outerloop;
                                    case 4: move.moveLeft(i, j); break outerloop;
                                    default: System.out.println("What causes the default?");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
