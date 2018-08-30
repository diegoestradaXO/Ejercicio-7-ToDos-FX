package sample;

import ShoppingItem.ShoppingItem;
import javafx.fxml.FXML;

import java.awt.*;
import java.awt.event.ActionEvent;

public class AddShoppingItemController {
    @FXML
    TextField nameInput;

    @FXML
    TextField quantityInput;

    @FXML
    TextField priceInput;

    @FXML
    Button createButton;

    public void createShoppingItem(ActionEvent event){
        ShoppingItem item = new ShoppingItem(nameInput.getText(),Integer.valueOf(quantityInput.getText()), Float.valueOf(priceInput.getText()));
        ShoppingListSelectedController.currentList.addProduct(item);
    }
}
