package ShoppingList;

import ShoppingItem.ShoppingItem;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class ShoppingList {
    SimpleStringProperty name;
    SimpleStringProperty description;
    SimpleStringProperty date;
    private ArrayList<ShoppingItem> shoppingItems;

    public ShoppingList(String name,String description, String date){//Constructor
        this.name = new SimpleStringProperty();
        this.description= new SimpleStringProperty();
        this.date = new SimpleStringProperty();
        this.shoppingItems= new ArrayList<>();
        this.name.set(name);
        this.description.set(description);
        this.date.set(date);

    }
    public String getName(){
        return this.name.get();
    }

    public String getDescription(){
        return this.description.get();
    }
    public boolean addProduct(ShoppingItem product){//Agrega un producto
        if(findShoppingItem(product.getName())){
            return false;
        }
        else{
            this.shoppingItems.add(product);
            return true;
        }
    }
    public boolean findShoppingItem(String name){
        for (ShoppingItem item : this.shoppingItems){
            if(item.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

}

