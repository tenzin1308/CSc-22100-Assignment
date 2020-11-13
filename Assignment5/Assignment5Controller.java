/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment5;


import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javax.xml.bind.JAXB;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import javax.xml.bind.annotation.XmlElement;





public class Assignment5Controller {
    
    private enum PenSize {
        SMALL(2),
        MEDIUM(6),
        LARGE(10),
        XLARGE(14);

        final int radius;

        PenSize(int radius) {
            this.radius = radius;
        }
    }

    private enum DrawColor {
        BLACK(Color.BLACK),
        RED(Color.RED),
        GREEN(Color.GREEN),
        BLUE(Color.BLUE),
        BROWN(Color.BROWN);

        final Color color;

        DrawColor(Color color) {
            this.color = color;
        }
    }

    /**
     * Private member to set the pen size
     */
    private PenSize penSize = PenSize.MEDIUM;
    /**
     * Private member to set the color
     */
    private DrawColor drawColor = DrawColor.BLACK;
    /**
     * Private member for the horizontal slide bar
     */
    private double slideBarValue;
    /**
     * Private member for red color of background
     */
    private int red;
    /**
     * Private member for green color of background
     */
    private int green;
    
    /**
     * Private member of List type to store the circle
     */
    private List<A5Shape> listShapes;
    /**
     * Private member to store individual circle
     */
    private ListA5Shape circleShapes;
    /**
     * Private member for file chooser
     */
    private FileChooser fc;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton rbBlack;

    @FXML
    private ToggleGroup tgColor;

    @FXML
    private RadioButton rbGreen;

    @FXML
    private RadioButton rbRed;

    @FXML
    private RadioButton rbBlue;

    @FXML
    private RadioButton rbBrown;

    @FXML
    private RadioButton rbSmall;

    @FXML
    private ToggleGroup tgPenSize;

    @FXML
    private RadioButton rbMed;

    @FXML
    private RadioButton rbLarge;

    @FXML
    private RadioButton rbXLarge;

    @FXML
    private Button btnSerializeXML;

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnClear;

    @FXML
    private Text txtBG;

    @FXML
    private Text txtWhite;

    @FXML
    private Slider slideBar;

    @FXML
    private Text txtBlue;

    @FXML
    private Pane panelDraw;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        panelDraw.getChildren().add(new Circle(event.getX(), event.getY(), penSize.radius, drawColor.color));
        listShapes.add(new A5Shape(event.getX(), event.getY(), penSize.radius));
        
    }

    @FXML
    void colorChangeEventHandler(ActionEvent event) {
        if (rbBlack.isSelected()) {
            drawColor = DrawColor.BLACK;
        } else if (rbGreen.isSelected()) {
            drawColor = DrawColor.GREEN;
        } else if (rbRed.isSelected()) {
            drawColor = DrawColor.RED;
        } else if (rbBlue.isSelected()){
            drawColor = DrawColor.BLUE;
        } else{
            drawColor = DrawColor.BROWN;
        }
    }

    @FXML
    void penSizeChangeEventHandler(ActionEvent event) {
        if (rbSmall.isSelected()) {
            penSize = PenSize.SMALL;
        } else if (rbMed.isSelected()) {
            penSize = PenSize.MEDIUM;
        } else if (rbLarge.isSelected()){
            penSize = PenSize.LARGE;
        } else {
            penSize = PenSize.XLARGE;
        }
    }

    @FXML
    void undoButtonEventHandler(ActionEvent event) {
        panelDraw.getChildren().remove(panelDraw.getChildren().size() - 1);
        listShapes.remove(listShapes.size() - 1);
    }

    @FXML
    void clearButtonEventHandler(ActionEvent event) {
        panelDraw.getChildren().clear();
        listShapes.removeAll(listShapes);
    }
    
    @FXML
    void SerializeXMLButtonEventHandler(ActionEvent event) throws IOException {
        
        //Working code
        circleShapes.setShapes(listShapes);
        fc.setTitle("Save Dialog");
        fc.setInitialFileName("SerializeXML");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML file", "*.xml"),
                new FileChooser.ExtensionFilter("Text file", "*.txt"));
        
        try{
            
            File file = fc.showSaveDialog(null);
            fc.setInitialDirectory(file.getParentFile());
            try {
                try (XMLEncoder x = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath().toString())))) {
                    x.writeObject(circleShapes);
                }
            }catch (FileNotFoundException ex){
                Logger.getLogger(Assignment5Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch (Exception ex){
            
        }

    }
    
    @FXML
    void initialize() {
        
        listShapes = new ArrayList<>();
        circleShapes = new ListA5Shape();
        
        slideBar.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                    Number oldvalue, Number newValue){
                slideBarValue = (double) newValue;
                red = 255 - (int) (slideBarValue);
                green = 255 - (int) slideBarValue;
                panelDraw.setStyle(String.format("-fx-background-color: #%02x%02x%02x", red, green, 255));
            }
        });
        panelDraw.setStyle(String.format("-fx-background-color: #%02x%02x%02x", 255, 255, 255));
        fc = new FileChooser();
        assert rbBlack != null : "fx:id=\"rbBlack\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert tgColor != null : "fx:id=\"tgColor\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbGreen != null : "fx:id=\"rbGreen\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbRed != null : "fx:id=\"rbRed\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbBlue != null : "fx:id=\"rbBlue\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbBrown != null : "fx:id=\"rbBrown\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbSmall != null : "fx:id=\"rbSmall\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert tgPenSize != null : "fx:id=\"tgPenSize\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbMed != null : "fx:id=\"rbMed\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbLarge != null : "fx:id=\"rbLarge\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbXLarge != null : "fx:id=\"rbXLarge\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert btnSerializeXML != null : "fx:id=\"btnSerializeXML\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert btnUndo != null : "fx:id=\"btnUndo\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert txtBG != null : "fx:id=\"txtBG\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert txtWhite != null : "fx:id=\"txtWhite\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert slideBar != null : "fx:id=\"slideBar\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert txtBlue != null : "fx:id=\"txtBlue\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert panelDraw != null : "fx:id=\"panelDraw\" was not injected: check your FXML file 'Assignment5.fxml'.";
    }
}
