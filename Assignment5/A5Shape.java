/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment5;

/**
 *
 * @author tenzintashi
 */
public class A5Shape {
    private double xCordinate;
    private double yCordinate;
    private double radius;

    public void setxCordinate(double xCordinate) {
        this.xCordinate = xCordinate;
    }

    public void setyCordinate(double yCordinate) {
        this.yCordinate = yCordinate;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getxCordinate() {
        return xCordinate;
    }

    public double getyCordinate() {
        return yCordinate;
    }

    public double getRadius() {
        return radius;
    }
    
    public A5Shape(){
        
    }

    public A5Shape(double xCordinate, double yCordinate, double radius) {
        this.xCordinate = xCordinate;
        this.yCordinate = yCordinate;
        this.radius = radius;
    }
    
    
}
