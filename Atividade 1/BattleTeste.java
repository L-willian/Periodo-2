// BattleTeste.java, feito por Willian, 2024-06-10
import java.util.Scanner;

public class BattleTeste {

    public static int readKey() {

        Scanner Scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int input = Scanner.nextInt();
        return input;
    }

    public static void main (String [] args){
        SimpleStartup dot = new SimpleStartup();
        boolean isAlive = true;
        int randomNum = (int)(Math.random() * 5);
        int [] locations = {randomNum, randomNum+1, randomNum+2};
        dot.setLocations(locations);
        int numOfGuesses = 0;

        while (isAlive==true){
           
            int guess = readKey();
            
            String result = dot.checkYourself(guess);

            ++numOfGuesses;

            if (result=="kill"){
                System.out.printf("You took %d guesses",numOfGuesses);
                isAlive = false;
            } 

        }  
    }  
}
