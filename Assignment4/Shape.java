/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;
import java.awt.*;
/**
 *
 * @author tenzintashi
 */
abstract public class Shape implements Comparable<Shape>{
    
    /**
     * A final integer datatype with an access level modifier protected that hold 
     * the id number
     */
    protected final int id;
    /**
     * A final String datatype with an access level modifier protected that hold 
     * the name
     */
    protected final String name;
    /**
     * A final String datatype with an access level modifier protected that hold 
     * the description
     */
    protected final String description;
    /**
     * An object of class Color with an access level modifier protected
     */
    protected Color color;
    
    
    /**
     * A non-default constructor which takes 4 parameter
     * @param id A integer datatype which holds the id
     * @param name A String datatype which holds the name
     * @param description A String datatype which holds the description
     * @param color  An object of a class Color
     */
    public Shape(int id, String name, String description, Color color){
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
    }
    
    /**
     * Abstract method name area to calculate the area of the given shape
     * @return A double containing the area of the shape
     */
    abstract public double area();
    /**
     * Abstract method name perimeter to calculate the perimeter of the given shape
     * @return A double containing the perimeter of the shape
     */
    abstract public double perimeter();
    
    /**
     * A compareTo method being override which compares the name, and color member fields
     * @param shape An instance of a Shape class
     * @return An Integer value depending upon the result of the comparison.
     */
    @Override
    public int compareTo(Shape shape){
        if (this.name.compareTo(shape.name) == 0 ){
            if (this.getColorName().compareTo(shape.getColorName()) == 0){
                return 0;
            }else if(this.getColorName().compareTo(shape.getColorName()) < 0){
                return -1;
            }else{
                return 1;
            }
        }else if (this.name.compareTo(shape.name) < 0){
            return -1;
        }
        return 1;
        
    }
    
    /**
     * A toString Method being override from String class.
     * @return A String formated value
     */
    @Override
    public String toString(){
        return String.format("%d %s %s", this.id, this.name, this.description);
    }
    
    /**
     * A method to get the name of the color as String
     * @return A String value containing the name of the color
     */
    public String getColorName(){
       if (Color.BLACK == (this.color)) {
           return "Black";
       } else if (Color.BLUE == (this.color)) {
           return "Blue";
       } else if (Color.GREEN == (this.color)) {
           return "Green";
       } else if (Color.RED == (this.color)) {
           return "Red";
       } else if (Color.WHITE == (this.color)) {
           return "White";
       } else if (Color.CYAN == (this.color)) {
           return "Cyan";
       } else if (Color.YELLOW == (this.color)) {
           return "Yellow";
       } 
       return null;
    }
}

