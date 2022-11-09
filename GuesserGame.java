import java.util.Scanner;


public class GuesserGame {
    public static void main(String[] args) {
        
        // creating object from Umpire
        Umpire umpireDecision = new Umpire();

        // Collecting Data from Guesser and Players
        umpireDecision.collectNumFromGuesser();
        umpireDecision.collectNumFromPlayers();

        /*
         * Comparing result from different players with Guessor number
         * 
         * Results will come on console screen
         */
        umpireDecision.compareResult();

        
    }
}

class Umpire{

    int numFromGuesser;
    int [] numFromPlayers;

    /*
     * Here Umpire collecting result from Guesser
     */
    void collectNumFromGuesser(){

        Guesser guesserPerson=new Guesser();
        numFromGuesser = guesserPerson.guessingNumber();
    }

    /*
     * Collecting how many numbers of player's are going to play
     */

    void collectNumFromPlayers(){

        System.out.println("Enter, How many number of players you guy's are:");
        Scanner scan = new Scanner(System.in);
        int numberOfPlayers = scan.nextInt();
        Players player = new Players(numberOfPlayers);
        numFromPlayers = player.getNumbersOfPlayers();
    }


    /*
     * This method compare the different values from guesser and players
     * 
     * evaluate results and come up with result on console screen
     */
    void compareResult(){

       boolean status = false;

       for (int i = 0; i < numFromPlayers.length; i++) {
        if (numFromPlayers[i] == numFromGuesser) {
            status = true;
            System.out.println("Players " + (i + 1) + " won the match");
        }
     }

     if(!status)
     {
        System.out.println("Not a single player win in the match");
     }
    }
}


class Guesser{

    int guesserGuessNum;

    /*
     * Taking input from console to store it into guesserGuessNum
     */

    int guessingNumber()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Guessor kindly guess any number and add it here");
        guesserGuessNum = scan.nextInt();
        return guesserGuessNum;
    }
}



class Players {

    int numberOfPlayers;

    public Players(int numberOfPlayers)
    {
        this.numberOfPlayers = numberOfPlayers;
    } 

    /*
     * Taking input from numberOfPlayers
     */

    public int [] getNumbersOfPlayers()
    {
        int [] players = new int[numberOfPlayers];

        for(int i=0; i<numberOfPlayers; i++)
        {
            System.out.println("Player " + (i+1) + " kindly guess the number:");
            players[i] = new Scanner(System.in).nextInt();
        }

        return players;
    }
    
}