/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

import java.util.TreeSet;

/**
 *
 * @author tenzintashi
 */
public class ShapeList extends TreeSet{
    
    /**
     * A add method that adds an instance of Shape class in a list
     * @param shape An instance of Shape class 
     * @return A true boolean value if the instance is added else returns false
     */

    public boolean add(Shape shape) {
        if(this.contains(shape)){
            return false;
        }
        return super.add(shape);
    }

    /**
     * A method that filters out only the 2D shapes
     *
     * @return A ShapeList of all 2D shapes
     */
    public ShapeList get2DShapes() {
        ShapeList ShapeList2D = new ShapeList();
        for (Object item : this) {
            if(!(item instanceof Shape3D)){
                ShapeList2D.add(item);
            }
        }
        return ShapeList2D;
    }
    
    /**
     * A method that filters out only the 3D shapes
     * @return A ShapeList of all 3D shapes
     */
    public ShapeList get3DShapes(){
        ShapeList ShapeList3D = new ShapeList();
        for (Object item : this) {
            if(item instanceof Shape3D){
                ShapeList3D.add(item);
            }
        }
        return ShapeList3D;
    }
    
    /**
     * A method to get the size of the ShapeList
     * @return The integer value of the size of the ShapeList
     */
    public int getSize(){
        return this.size();
    }
    
    /**
     * A method to print the list of the shapes in a specified table formate.
     */
    public void printFormatted(){
//                                                8           13          9               25                          22  
        System.out.print(String.format("%s", "+--------+-------------+---------+-------------------------+----------------------+\n"));
        System.out.print(String.format("%s", "|-ID-----|-Name--------|-Color---|-Dimensions--------------|-Description----------|\n".replace("-", " ")));
        System.out.print(String.format("%s", "+--------+-------------+---------+-------------------------+----------------------+\n"));
        for (Object item : this) {
            if(item instanceof Shape2D){
                System.out.println(String.format("| %-6d | %-11s | %-7s | %-23s | %-20s |", ((Shape2D) item).id, ((Shape2D) item).name, ((Shape2D) item).getColorName(), ((Shape2D) item).getDimensions(), ((Shape2D) item).description));
                System.out.println(String.format("%s", "+--------+-------------+---------+-------------------------+----------------------+"));
            }else{
                System.out.println(String.format("| %6d | %11s | %7s | %23s | %20s |", ((Shape3D) item).id, ((Shape3D) item).name, ((Shape3D) item).getColorName(), ((Shape3D) item).getDimensions(), ((Shape3D) item).description));
                System.out.println(String.format("%s", "+--------+-------------+---------+-------------------------+----------------------+"));
            }
        }
    }
    
    
}
