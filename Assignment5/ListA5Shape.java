/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment5;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author tenzintashi
 */
public class ListA5Shape {
    
    @XmlElement(name="shape")
    private List<A5Shape> shapes;

    public void setShapes(List<A5Shape> shapes) {
        this.shapes = shapes;
    }
    
    public List<A5Shape> getShapes(){
        return shapes;
    }
    
}
