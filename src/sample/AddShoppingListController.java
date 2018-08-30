package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ShoppingList.ShoppingList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class AddShoppingListController {
    @FXML
    Label nameLabel;

    @FXML
    javafx.scene.control.Button createBotton;

    @FXML
    javafx.scene.control.TextField nameInput;

    @FXML
    javafx.scene.control.TextArea descriptionInput;

    @FXML
    javafx.scene.control.TextField dateInput;




    static ObservableList<ShoppingList> shoppingLists =FXCollections.observableArrayList();

    public static void setShoppingLists(ObservableList<ShoppingList> myShoppingList){
        shoppingLists= myShoppingList;
    }
    public void create(javafx.event.ActionEvent event) {
        ShoppingList listToAadd = new ShoppingList("", "", "");
        shoppingLists.add(listToAadd);
        ShoppingList listToAdd = new ShoppingList(nameInput.getText(), descriptionInput.getText(), dateInput.getText());
        shoppingLists.add(listToAdd);
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShoppingListSelected.fxml"));
            root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}