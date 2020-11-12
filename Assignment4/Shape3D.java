/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

import java.awt.Color;

/**
 *
 * @author tenzintashi
 */
public abstract class Shape3D extends Shape2D{
    
    /**
     * A final double datatype with access level modifier public that contains the length value
     */
    public final double length;

    /**
     * A non-default constructor which takes 7 parameter
     * @param id A integer datatype which holds the id
     * @param name A String datatype which holds the name
     * @param description A String datatype which holds the description
     * @param color  An object of a class Color
     * @param height A double datatype which holds the height value
     * @param width A double datatype which holds the width value
     * @param length A double datatype which holds the length value
     */
    public Shape3D(int id, String name, String description, Color color, double height, double width, double length) {
        super(id, name, description, color, height, width);
        this.length = length;
    }
    
    /**
     * A toString Method being override from String class.
     * @return A String formated value
     */
    @Override
    public String toString(){
        return String.format("%s %f", super.toString(), this.length);
    }
    
    /**
     * A compareTo method which compares the name, color, id, description, width, height, and length member fields
     * @param shape An instance of a Shape class
     * @return An Integer value depending upon the result of the comparison.
     */
    @Override
    public int compareTo(Shape shape){
        if (super.compareTo(shape) == 0){
            if(this.length == ((Shape3D) shape).length) {
                return 0;
            }else{
                return 1;
            }
        }
        return -1;
    }
    
    /**
     * A method that returns the dimensions of the 2D shape
     * @return A String formated value containing the dimension of the shape
     */
    @Override
    public String getDimensions(){
        return String.format("%.2f X %.2f X %.2f", this.height, this.width, this.length);
    }
}
