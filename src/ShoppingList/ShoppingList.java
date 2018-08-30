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

        this.name.set(name);
        this.description.set(description);
        this.date.set(date);
        this.shoppingItems= new ArrayList<>();

    }
    public String getName(){//obtiene el nombre de la lista
        return this.name.get();
    }

    public String getDescription(){//obtiene la descripcion
        return this.description.get();
    }
    public boolean addProduct(ShoppingItem product){//Mete un producto dentro de la lista
        if(findShoppingItem(product.getName())){
            return false;//no agregar repetidos
        }
        else{
            this.shoppingItems.add(product);//si no lo encuentra, lo agrega
            return true;
        }
    }
    public boolean findShoppingItem(String name){//busqueda de un producto
        for (ShoppingItem item : this.shoppingItems){
            if(item.getName() == (name)){
                return true;
            }
        }
        return false;
    }

}

