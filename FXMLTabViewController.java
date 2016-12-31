/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PriceAction101;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Man Eesh
 * 
 *
 */


public class FXMLTabViewController implements Initializable {
 @FXML 
    private TableView tabView;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        
        
        //Get observable list from DB
        
       TableColumn product= new TableColumn("SYMBOL");
       product.setEditable(false);
       tabView.getColumns().add(product);
       tabView.setItems(null);
        
        
    }    
    
}
