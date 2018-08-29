package sample;

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

import java.util.List;

public class Controller {
    @FXML
    TableView<List> shoppingListTable;
    @FXML
    TableColumn nameColumn;
    @FXML
    TableColumn dateColumn;
    @FXML
    TableColumn toDoColumn;
    @FXML
    TableColumn estimatedColumn;
    @FXML
    Button addShoppingListButton;
    @FXML
    Button deleteButton;
    @FXML
    Button editButton;
    ObservableList<List> myShoppingList =FXCollections.observableArrayList();

    public void initialize(){
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<List,String>("name")
        );
        dateColumn.setCellValueFactory(
                new PropertyValueFactory<List,String>("date")
        );
        shoppingListTable.setItems(myShoppingList);
    }
    public void addShoppingList(ActionEvent event){
        Parent root;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddList.fxml"));
            root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            //Mandar lista
            AddlistControler addlistControler =loader.getController();
            ObservableList<List> listas = listsTable.getItems();
            AddlistControler.setListas(listas);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

