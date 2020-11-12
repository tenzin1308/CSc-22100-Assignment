/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

/**
 *
 * @author tenzintashi
 */
import java.awt.*;

public abstract class Shape2D extends Shape {

    /**
     * A final double datatype with an access level modifier public that contains the height value
     */
    public final double height;
    /**
     * A final double datatype with an access level modifier public that contains the width value
     */
    public final double width;

    /**
     * A non-default constructor which takes 6 parameter
     * @param id A integer datatype which holds the id
     * @param name A String datatype which holds the name
     * @param description A String datatype which holds the description
     * @param color  An object of a class Color
     * @param height A double datatype which holds the height value
     * @param width A double datatype which holds the width value
     */
    public Shape2D(int id, String name, String description, Color color, double height, double width) {
        super(id, name, description, color);
        this.height = height;
        this.width = width;
    }
    
    /**
     * A toString Method being override from String class.
     * @return A String formated value
     */
    @Override
    public String toString(){
        return String.format("%s %f %f", super.toString(), this.height, this.width);
    }
    
    /**
     * A compareTo method which compares the name, color, id, description, width, and height member fields
     * @param shape An instance of a Shape class
     * @return An Integer value depending upon the result of the comparison.
     */
    @Override
    public int compareTo(Shape shape) {

        if (super.compareTo(shape) == 0) {
            if (this.width == ((Shape2D) shape).width && this.height == ((Shape2D) shape).height) {
                return 0;
            }else if (this.width == ((Shape2D) shape).width && this.height > ((Shape2D) shape).height){
                return 1;
            }
        }
        return -1;
    }
    
    /**
     * A method that returns the dimensions of the 2D shape
     * @return A String formated value containing the dimension of the shape
     */
    public String getDimensions(){
        return String.format("%.2f X %.2f", this.height, this.width);
    }
}
