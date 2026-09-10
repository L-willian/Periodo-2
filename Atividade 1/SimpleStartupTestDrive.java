// SimpleStartupTestDrive.java, codigo base.
import java.util.Scanner;

public class SimpleStartupTestDrive{

    public static int readKeyboard(){

        Scanner sc = new Scanner(System.in);

        // Step 2: Prompt user for input
        System.out.print("Enter an integer: ");

        // Step 3: Read integer input
        int number = sc.nextInt();

        return number;
    }

    public static void main (String [] args){
        SimpleStartup dot = new SimpleStartup();
        boolean isAlive = true;
        int randomNum = (int)(Math.random() * 5);
        int [] locations = {randomNum, randomNum+1, randomNum+2};
        dot.setLocations(locations);
        int numOfGuesses = 0;

        while (isAlive==true){
           
            int guess = readKeyboard();
            
            String result = dot.checkYourself(guess);

            ++numOfGuesses;

            if (result=="kill"){
                System.out.printf("You took %d guesses",numOfGuesses);
                isAlive = false;
            } 

        }  
    }  
}