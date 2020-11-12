/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.security.SecureRandom;


/***
* 
* @author tenzintashi
*
* Representing a Tortoise and Hare race simulator
* 
*/
public class TortoiseAndHare {
    
    // Private variables
    private static final int MAX_MOVES = 100;
    private static final int MAX_ITERATIONS = 2000;
    private int tortoisePosition = 1;
    private int harePosition = 1;
    private int move = 0;
    private static SecureRandom randNumber ;

    /**
     * Default constructor to start the race.
     * It prints the message and the position of both Hare and Tortoise
     */
    public TortoiseAndHare() {
        System.out.printf("ON YOUR MARK,GET SET \nBANG !!!!!\nAND THEY'RE OFF !!!!!\n");
        printPositions();
    }
    /***
     * A private method that prints the current location of the Hare and Tortoise, 
     * representing by letter H and T respectively, and B if they are at same position.
     */
    private void printPositions() {
        while (move <= MAX_ITERATIONS && tortoisePosition != 100 && harePosition != 100) {
            String characterSpace = "";
            String hareSpace = "";
            String tortoiseSpace = "";
            String finalPosition;
            simulateTortoiseMove();
            simulateHareMove();
            if (tortoisePosition == harePosition) {
                for (int i = 1; i < tortoisePosition; i++) {
                    characterSpace += " ";
                }
                finalPosition = String.format("%s%s", characterSpace, "B");
            } else if (tortoisePosition < harePosition) {
                for (int i = 1; i < tortoisePosition; i++) {
                    tortoiseSpace += " ";
                }
                for (int i = tortoisePosition + 1; i < harePosition; i++) {
                    hareSpace += " ";
                }
                finalPosition = String.format("%s%s%s%s", tortoiseSpace, "T", hareSpace, "H");

            } else {
                for (int i = 1; i < harePosition; i++) {
                    hareSpace += " ";
                }
                for (int i = harePosition + 1; i < tortoisePosition; i++) {
                    tortoiseSpace += " ";
                }
                finalPosition = String.format("%s%s%s%s", hareSpace, "H", tortoiseSpace, "T");

            }
            System.out.println("Iteration: " + move);
            System.out.println(finalPosition);
            System.out.println("----------------------------------------------------------------------------------------------------");
            move += 1;

        }
        if (tortoisePosition == 100 && move <= MAX_ITERATIONS) {
            System.out.printf("TORTOISE WINS!!! YAY!!!\nTime Elapsed = %d seconds\n", move);
        } else if (harePosition == 100 && move <= MAX_ITERATIONS) {
            System.out.printf("HARE WINS!!! Yuch!\nTime Elapsed = %d seconds\n", move);
        } else if (tortoisePosition == 100 && harePosition == 100 && move <= MAX_ITERATIONS) {
            System.out.printf("It's tie\nTime Elapsed = %d seconds\n", move);
        } else {
            System.out.println("Time Out!");
        }

    }
    /***
     * 
     * This private method generates a random integer number between given range.
     * @param x A integer variable that holds the starting value of the range.
     * @param y A integer variable that holds the ending value of the range.
     * @return A integer value between the given range (x,y)
     */

    private int randomBetween(int x, int y) {
        
        randNumber = new SecureRandom();
        return randNumber.nextInt(y) + x;
    }
    /***
     * A private method to simulate the Tortoise movement using given condition.
     */

    private void simulateTortoiseMove() {
        int action = randomBetween(0, 10);
        switch (action) {
            case 0:
            case 1:
            case 2:
            case 3:
                int jump = randomBetween(1, 3);
                tortoisePosition += jump;
                break;
            case 4:
            case 5:
            case 6:
                int slip = randomBetween(1, 6);
                if (tortoisePosition - slip < 1) {
                    tortoisePosition = 1;
                    break;
                } else {
                    tortoisePosition -= slip;
                    break;
                }
            case 7:
            case 8:
                int walk = randomBetween(0, 2);
                tortoisePosition += walk;
                break;
            default:
                break;
        }
        if (tortoisePosition > MAX_MOVES) {
            tortoisePosition = MAX_MOVES;
        }
    }
    
    /***
     * A private method to simulate the Hare movement using given condition.
     */
    private void simulateHareMove() {
        int action = randomBetween(0, 10);
        switch (action) {
            case 0:
            case 1:
            case 2:
                int jump = randomBetween(1, 5);
                harePosition += jump;
                break;
            case 3:
            case 4:
                int smallSlip = randomBetween(1, 2);
                if (harePosition - smallSlip < 1) {
                    harePosition = 1;
                    break;
                } else {
                    harePosition -= smallSlip;
                    break;
                }
            case 5:
                int bigSlip = randomBetween(1, 7);
                if (harePosition - bigSlip < 1) {
                    harePosition = 1;
                    break;
                } else {
                    harePosition -= bigSlip;
                    break;
                }
            case 6:
            case 7:
            case 8:
                int walk = randomBetween(0, 2);
                harePosition += walk;
                break;
            default:
                break;
        }
        if (harePosition > MAX_MOVES) {
            harePosition = MAX_MOVES;
        }
    }

    /**
     * A static main method for creating instance of TortoiseAndHare class.
     * @param args
     */
    public static void main(String[] args) {
        TortoiseAndHare th1 = new TortoiseAndHare();
    }
}
