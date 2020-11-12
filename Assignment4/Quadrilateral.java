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
public class Quadrilateral extends Shape2D{

    /**
     * A non-default constructor which takes 6 parameter
     * @param id A integer datatype which holds the id
     * @param name A String datatype which holds the name
     * @param description A String datatype which holds the description
     * @param color  An object of a class Color
     * @param height A double datatype which holds the height value
     * @param width A double datatype which holds the width value
     */
    public Quadrilateral(int id, String name, String description, Color color, double height, double width) {
        super(id, name, description, color, height, width);
    }

    /**
     * A concrete method for the abstract method area
     * @return A double datatype value of the area of the 2D shape
     */
    @Override
    public double area() {
        return (this.height * this.width);
    }

    /**
     * A concrete method for the abstract method perimeter
     * @return A double datatype value of the perimeter of the 2D shape
     */
    @Override
    public double perimeter() {
        return 2*(this.width + this.height);
    }
    
}
