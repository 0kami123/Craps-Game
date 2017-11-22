import java.util.Scanner;

import java.util.Random;

class Craps {
   
   static final boolean WIN = true;
    
    static final boolean LOSE = false;
    
    public static void main(String[] args) {
       
       Scanner input = new Scanner(System.in);
       
       int bankBalance = 1000;
        
        System.out.println("Enter the seed.");
       
       int seed = input.nextInt();
        
        Random random = new Random(seed);
        
        // Create a random number generator with the specified seed so that
       
       // we can duplicate our results.
        
        int wager;
       
       wager = getBet(input, bankBalance); // Get the bet from the user
        
        while (wager > 0 && bankBalance > 0) { // while user has wish and means to continue
           
           boolean won = rollDiceUntilWinOrLose(random); // play one round
            
            if (won) { // if they won, they get wins <bet> money
          
          bankBalance = bankBalance + wager;
              
              System.out.println("You won, you now have " + bankBalance);
           
           } else { // if they lost, they lose <bet> money
                
                bankBalance = bankBalance - wager;
                
                System.out.println("You lost, you now have " + bankBalance);
            
            }
            
            if ( bankBalance > 0) {
                
                wager = getBet(input, bankBalance); // If user can bet, let them
            
            }
        
        }
    
    }
/*
 * This method plays one round of craps and tells us whether the user
 * won or lost
 * input: random number generator (because it uses rollDice)
 * output: won or lost
 */
    
    static boolean rollDiceUntilWinOrLose(Random random) {
        
        int point = rollDice(random);
        
        if ( point == 7 || point == 11 )
            
            return WIN;
        
        else if ( point == 2 || point == 12)
            
            return LOSE;
       
       // roll until point or 7
        
        int nextRoll = rollDice(random);
        
        boolean winLose;
       
       while ( nextRoll != point && nextRoll != 7 ) {
            
            nextRoll = rollDice(random);
       
       }
       
       if ( nextRoll == 7 )
           
           winLose = false;
       
       else
          
          winLose = true;
       
       return winLose;
   
   }
  /*
   * Simulates rolling of dice by generating random numbers from a random
   * number generator.
   * input: random number generator to use. We need this because we want
   *         to use the *same* random number generator throughout and
   *         duplicate our results.
   * output: total after rolling the dice.
   */
    
    static int rollDice(Random random) {
        
        int die1 = random.nextInt(6) + 1;
        
        int die2 = random.nextInt(6) + 1;
        
        System.out.println("roll is " + die1 + ", " + die2);
        
        return die1 + die2;
   
   }
  /*
   * Returns the amount bet by the user. Performs input checking to ensure
   * that the user does not bet more than she has and she does not bet
   * a negative value.
   * input: amount user currently has. This is checked against the amount
   *         they wants to bet to make sure the bet is valid.
   * output: a valid bet
   */
    
    static int getBet(Scanner input, int total) {
       
       System.out.println("Enter wager.");
       
       int wager = input.nextInt();
       
       if (wager > 500){
       
       System.out.println("Oh, you are going for broke, huh?");
       
       }else if (wager < 10){
           
           System.out.println("Aw cmon, take a chance! ");
        
        }
        
        while ( wager < 0 || wager > total) {
           
           System.out.println("Sorry, you busted!");

            
            System.out.println("Enter wager.");
            
            wager = input.nextInt();
      
      }
        
        return wager;
    
    }
}


