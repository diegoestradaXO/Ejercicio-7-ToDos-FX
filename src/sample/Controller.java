package sample;

import ShoppingItem.ShoppingItem;
import ShoppingList.ShoppingList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Controller {
    Button addShoppingListButton;
    @FXML
    Button deleteButton;
    @FXML
    Button editButton;

    @FXML
    TableView<ShoppingList> shoppingListTable;
    @FXML
    TableColumn nameColumn;
    @FXML
    TableColumn dateColumn;
    @FXML
    TableColumn toDoColumn;
    @FXML
    TableColumn estimatedColumn;
    @FXML

    ObservableList<ShoppingList> myShoppingLists = FXCollections.observableArrayList();

    public void initialize(){
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<List,String>("name")
        );
        dateColumn.setCellValueFactory(
                new PropertyValueFactory<List,String>("date")
        );
        shoppingListTable.setItems(myShoppingLists);
    }
    public void addShoppingList(ActionEvent event){
        Parent root;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddShoppingList.fxml"));
            root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            AddShoppingListController addShoppingListController =loader.getController();
            ObservableList<ShoppingList> shoppingLists = shoppingListTable.getItems();
            AddShoppingListController.setShoppingLists(shoppingLists);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void deleteShoppingList(ActionEvent event){
        ShoppingList shoppingListSelected = shoppingListTable.getSelectionModel().getSelectedItem(); //Se obtiene la lista seleccionada de entre toda la tableList

        myShoppingLists.remove(shoppingListSelected);//Se elimina la lista seleccionada de la lista de listas.
    }

    public void editShoppingList(ActionEvent event){
                    Parent root;
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TasksInList.fxml"));
                root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                ShoppingListSelectedController tasksInListController =loader.getController();
                ShoppingList selectedList = shoppingListTable.getSelectionModel().getSelectedItem();
                if (selectedList != null){
                    tasksInListController.currentList=selectedList;
                    tasksInListController.setShoppingListName(selectedList.getName());
                    tasksInListController.setShoppingListDescription(selectedList.getDescription());
                    tasksInListController.shoppingItemName.setCellValueFactory(new PropertyValueFactory<ShoppingItem, String >("name"));
                    tasksInListController.shoppingItemQuantity.setCellValueFactory(new PropertyValueFactory<ShoppingItem, Integer>("cuantity"));
                    tasksInListController.shoppingItemState.setCellValueFactory(new PropertyValueFactory<ShoppingItem, Boolean>("bought"));
                }

                stage.show();
            }catch (IOException e){
                e.printStackTrace();
            }
        }


}

