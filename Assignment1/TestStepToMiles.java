/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.util.Scanner;

/**
 *
 * @author tenzintashi
 */
public class TestStepToMiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Instance of Scanner class to get the input from user for second Instance
        Scanner kb = new Scanner(System.in);
        
        System.out.printf("Enter Name: ");
        String name = kb.nextLine();
        System.out.printf("Enter Height (ft and in): ");
        double feet = kb.nextDouble();
        double inches = kb.nextDouble(); 
        
        // Skipping a line with new line character
        System.out.printf("\n");
//        First instance of StepsToMiles class using default constructor
        StepsToMiles object1 = new StepsToMiles();
        
        // Using mutator methods to set the name, feet and inches
        object1.setName("Jane Doe");
        object1.setFeet(5);
        object1.setInches(4.5);
        
        // Printing the today's date using First instance
        System.out.printf(" Today's Date: %s\n\n",object1.currDate());
        
        // Printing the result of first instance
        System.out.printf(object1.formateAsString(12345));
        
        // Skipping a line with new line character
        System.out.printf("\n");
        
//        Second instance of StepsToMiles class using non-default constructor        
        StepsToMiles object2 = new StepsToMiles(name,feet,inches);
        
        // Printing the result of second instance
        System.out.printf(object2.formateAsString(1000));
        
        
        // Close the Scanner class
        kb.close();
    }
    
}
