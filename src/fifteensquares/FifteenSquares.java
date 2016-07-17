/*
* JONATHAN HERRERA
* I tried to create the game from scratch without following the tutorial and this
* monstrosity occurred. This code is terribly unoptimized but it works, for the most part.
* I have been able to preveent the user from entering invalid inputs as well as keeping the blank from leaving the array
* I have been having trouble allowing the user to define the width and height of the array as well as move whole rows/columns
* I also had the intention to make the game check if the user has actually won
*/
package fifteensquares;

    public class FifteenSquares {
             
    //these are all classes turned into objects
    //turning classes into objects allows you to access their methods, given the method is not static
        static View view = new View();
        //created an object out of the class View so I can access its methods
        static Movements move = new Movements();
        static Input input = new Input();
        static Randomness random = new Randomness();
        
        static Integer [][] rxc = new Integer[4][4];
        //creating a multi-dimensional array with the name rxc
        //I am making an Integer object as opposed to an int b/c Integer can be manipulated more for formatting
        //this is static so that all methods can access the array and modify it
        //if it was marked as final than the array would never change values

        static int searchFor = 16;
        //this is the value that we are going to move
    
    public static void createGrid() {
    //this will create the grid with the values in the appropriate positions 
        int count = 1;
        //this is for the 'for loop' so that it will create each number in each position
        
        for(int i = 0; i < 4; i++) {
        //this will start at the first row then after printing all the column numbers, move to the next
            for (int j = 0; j < 4; j++) {
            //a number will be printed in each column of a row before switching rows
                rxc[i][j] = count;
                //for each corresponding position in the array, a number from 0-15 will be placed 
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
                count++;
                //after a number is placed inside, the count will increase by one for the next iteration
                    //the loop will occur again inserting the next number
            }
            System.out.println(" ");
            //after the [j] loop is complete, a line break will occur and the next row will print
        }   
    }  

    public static void main(String[] args) {
        
        createGrid();
        System.out.println("");
        random.randomGrid();
        view.drawGrid();
        while(true){
        //creates an infinite loop allowing the user to continuously make moves
            move.userMove();
        }
    }  
}
