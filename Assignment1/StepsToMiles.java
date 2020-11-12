/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author tenzintashi
 * 
 */

public class StepsToMiles {
    
    // Private Variables
    private String name;
    private double feet;
    private double inches;
    
    // Constructors
    /**
     * This is a default Constructor that set private variable "name" to null
     * and private variable "feet" and "inches" to -1
     */
    public StepsToMiles(){
        this.name = null;
        this.feet = -1;
        this.inches = -1;      
    }
    /**
     * This is a non-default Constructor that takes three parameter and set the 
     * private variable to the value of this parameter respectively.
     * @param name This is the first parameter to StepsToMiles method
     * @param feet This is the second parameter to StepsToMiles method
     * @param inches This is the third parameter to StepsToMiles method
     */
    public StepsToMiles(String name,double feet,double inches){
        this.name = name;
        this.feet = feet;
        this.inches = inches;
    }
    
    // Mutators method for private variable
    /**
     * This is Mutator method that set the value for private variable "name"
     * @param name A string containing the person's name
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * This is Mutator method that set the value for private variable "feet"
     * @param feet A double containing the person's height (feet)
     */
    public void setFeet(double feet){
        this.feet = feet;
    }
    /**
     * This is Mutator method that set the value for private variable "inches"
     * @param inches A double containing the person's height (inches) 
     */
    public void setInches(double inches){
        this.inches = inches;
    }
    
    // Accessors method for private variable
    /**
     * Gets the Person's name
     * @return A string representing the person's name
     */
    public String getName(){
        return this.name;
    }
    /**
     * Gets the Person's feet
     * @return A double representing the person's feet
     */
    public double getFeet(){
        return this.feet;
    }
    /**
     * Gets the Person's inches
     * @return A double representing the person's inches
     */
    public double getInches(){
        return this.inches;
    }    
    
    /**
     * Method that converts person's height (feet + inches) to inches
     * @return A double representing person's height in inches
     */
    public double height_inches(){
        return (this.feet * 12) + this.inches;
    }

    /**
     * Method that converts steps to miles depending on person's stride length
     * @param steps A integer containing the number of steps
     * @return A double representing the miles for the given steps
     */
    public double miles(int steps){
        return (strideLength_inches() * steps)/(12 * 5280);
    }

    /**
     * Method that calculates the stride length using person's height in inches
     * @return A double representing the stride length
     */
    public double strideLength_inches(){
        return height_inches() * 0.413;
    }
    
    /**
     * Method that gives the current Date using Gregorian Calendar
     * @return A string representing the current date
     */
    public String currDate(){
        GregorianCalendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        return String.format("%d/%d/%d", month, day, year);
    }
    
    /**
     * Method that gives the detailed output in string format 
     * @param steps A integer parameter that contain the steps
     * @return A string representing the final output using String Format
     */
    public String formateAsString(int steps){
        String result = String.format("%13s: %s \n%13s: %.2f' %.2f\" \n%13s: %.2f \n%13s: %,d \n%13s: %.2f miles\n",
                "Name", getName(),"Height", getFeet(), getInches(), "Stride", strideLength_inches(), "Steps", steps, "Walk", miles(steps));
        return result;
    }
    
}
