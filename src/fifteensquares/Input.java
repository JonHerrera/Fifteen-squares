/*
 * JONATHAN HERRERA
 */
package fifteensquares;

    import java.util.Scanner;
    import java.util.InputMismatchException; 
    //for the exception

    public class Input {
      
        static Movements move = new Movements();
        static View view = new View();
        
        static Scanner user_input = new Scanner(System.in);
        //so the user can make their selection
   
        public static int choice() {
        //this will check whether or not the input is actually valid

            try {
                int choice = user_input.nextInt();
                
                if (choice >= 0) {
                      return choice; 
                      //if a valid option is selected, good
                }
                else {
                //for any negative integers
                    System.out.println(choice + " is an invalid Option.");
                    return choice();
                }
            }
            catch(InputMismatchException e) {
            //for anything not an integer
                user_input.next();
                System.out.println("Please enter a valid number.");
            }
            return choice();
        }
    }
