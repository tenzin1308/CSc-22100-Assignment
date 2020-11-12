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
public class Quadrilateral3D extends Shape3D{
    
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
    public Quadrilateral3D(int id, String name, String description, Color color, double height, double width, double length) {
        super(id, name, description, color, height, width, length);
    }

    /**
     * A concrete method for the abstract method area
     * @return A double datatype value of the area of the 3D shape
     */
    @Override
    public double area() {
        return 2*(this.width*this.height + this.width*this.length + this.height*this.length);
    }

    /**
     * A concrete method for the abstract method perimeter
     * @return A double datatype value of the perimeter of the 3D shape
     */
    @Override
    public double perimeter() {
        return 4*(this.width + this.height + this.length);
    }
    
}
