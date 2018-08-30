package sample;


import ShoppingItem.ShoppingItem;
import ShoppingList.ShoppingList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class ShoppingListSelectedController {
    @FXML
    Label shoppingListName;

    @FXML
    TextField description;

    @FXML
    Button addShoppingItemButton;

    @FXML
    TableView<ShoppingItem> myShoppingItems;

    @FXML
    TableColumn shoppingItemName;

    @FXML
    TableColumn shoppingItemQuantity;

    @FXML
    TableColumn shoppingItemUnitPrice;

    @FXML
    TableColumn shoppingItemTotal;

    @FXML
    TableColumn shoppingItemState;
    static ShoppingList currentList;
    //Metodos para el controller en la ventana de una lista seleccionada
    public void setShoppingListName(String name){
        this.shoppingListName.setText(name);// Se coloca el nombre, ira en el label principal
    }

    public void setShoppingListDescription(String description){//agrega la descripcion al campo de texto
        this.description.setText(description);
    }

    public void addShoppingItem(ActionEvent event){
        Parent root;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddShoppingItem.fxml"));
            root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void setComplete(ActionEvent event){

    }

    public void setPending(ActionEvent event){

    }

}

