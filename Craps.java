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
/* Source Code test run #1:
Enter the seed.
100
Enter wager.
650
Oh, you are going for broke, huh?
roll is 2, 5
You won, you now have 1650
Enter wager.
9
Aw cmon, take a chance!
roll is 5, 1
roll is 2, 1
roll is 3, 3
You won, you now have 1659
Enter wager.


Source Code test run #2:
Enter wager.
501
Oh, you are going for broke, huh?
roll is 2, 5
You won, you now have 1501
Enter wager.
502
Oh, you are going for broke, huh?
roll is 5, 1
roll is 2, 1
roll is 3, 3
You won, you now have 2003
Enter wager.
503
Oh, you are going for broke, huh?
roll is 2, 2
roll is 5, 6
roll is 3, 2
roll is 1, 4
roll is 3, 1
You won, you now have 2506
Enter wager.
504
Oh, you are going for broke, huh?
roll is 6, 6
You lost, you now have 2002
Enter wager.
505
Oh, you are going for broke, huh?
roll is 4, 5
roll is 6, 5
roll is 4, 2
roll is 5, 1
roll is 5, 5
roll is 5, 2
You lost, you now have 1497
Enter wager.
509
Oh, you are going for broke, huh?
roll is 3, 4
You won, you now have 2006
Enter wager.
510
Oh, you are going for broke, huh?
roll is 3, 3
roll is 4, 5
roll is 3, 2
roll is 6, 1
You lost, you now have 1496
Enter wager.
519
Oh, you are going for broke, huh?
roll is 6, 6
You lost, you now have 977
Enter wager.
650
Oh, you are going for broke, huh?
roll is 2, 3
roll is 4, 6
roll is 3, 5
roll is 1, 1
roll is 6, 5
roll is 2, 6
roll is 6, 5
roll is 2, 5
You lost, you now have 327
Enter wager.
327
roll is 5, 4
roll is 3, 1
roll is 5, 1
roll is 2, 4
roll is 2, 6
roll is 1, 3
roll is 5, 6
roll is 3, 6
You won, you now have 654
Enter wager.
650
Oh, you are going for broke, huh?
roll is 1, 3
roll is 2, 2
You won, you now have 1304
Enter wager.
9
Aw cmon, take a chance!
roll is 5, 5
roll is 3, 6
roll is 5, 4
roll is 1, 1
roll is 4, 3
You lost, you now have 1295
Enter wager.


Source Code test run #3:
Enter the seed.
50
Enter wager.
100
roll is 2, 1
roll is 6, 5
roll is 2, 2
roll is 5, 1
roll is 1, 5
roll is 3, 3
roll is 1, 6
You lost, you now have 900
Enter wager.
9
Aw cmon, take a chance!
roll is 3, 1
roll is 3, 6
roll is 6, 5
roll is 6, 4
roll is 2, 2
You won, you now have 909
Enter wager.
8
Aw cmon, take a chance!
roll is 3, 3
roll is 5, 6
roll is 1, 3
roll is 3, 4
You lost, you now have 901
Enter wager.
1
Aw cmon, take a chance!
roll is 3, 1
roll is 3, 3
roll is 3, 3
roll is 3, 1
You won, you now have 902
Enter wager.
900
Oh, you are going for broke, huh?
roll is 4, 2
roll is 4, 6
roll is 4, 5
roll is 3, 6
roll is 3, 6
roll is 4, 1
roll is 5, 1
You won, you now have 1802
Enter wager.
1800
Oh, you are going for broke, huh?
roll is 6, 4
roll is 3, 2
roll is 3, 6
roll is 1, 2
roll is 1, 5
roll is 6, 5
roll is 3, 6
roll is 5, 6
roll is 4, 6
You won, you now have 3602
Enter wager.
3600
Oh, you are going for broke, huh?
roll is 6, 3
roll is 5, 5
roll is 3, 6
You won, you now have 7202
Enter wager.
500
roll is 5, 4
roll is 3, 6
You won, you now have 7702
Enter wager.
501
Oh, you are going for broke, huh?
roll is 2, 3
roll is 5, 4
roll is 6, 4
roll is 1, 1
roll is 2, 2
roll is 4, 2
roll is 5, 2
You lost, you now have 7201
Enter wager.
450
roll is 6, 1
You won, you now have 7651
Enter wager.
7651
Oh, you are going for broke, huh?
roll is 3, 5
roll is 5, 6
roll is 5, 4
roll is 3, 5
You won, you now have 15302
Enter wager.
15302
Oh, you are going for broke, huh?
roll is 5, 5
roll is 2, 2
roll is 6, 3
roll is 4, 6
You won, you now have 30604
Enter wager.
30604
Oh, you are going for broke, huh?
roll is 6, 3
roll is 5, 4
You won, you now have 61208
Enter wager.
61208
Oh, you are going for broke, huh?
roll is 5, 6
You won, you now have 122416
Enter wager.
122416
Oh, you are going for broke, huh?
roll is 5, 2
You won, you now have 244832
Enter wager.
244832
Oh, you are going for broke, huh?
roll is 2, 6
roll is 3, 1
roll is 4, 2
roll is 5, 3
You won, you now have 489664
Enter wager.
489664
Oh, you are going for broke, huh?
roll is 6, 1
You won, you now have 979328
Enter wager.
979328
Oh, you are going for broke, huh?
roll is 6, 6
You lost, you now have 0

Process finished with exit code 0
 */