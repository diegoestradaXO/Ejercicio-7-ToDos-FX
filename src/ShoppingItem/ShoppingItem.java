package ShoppingItem;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ShoppingItem {
    SimpleStringProperty name;
    SimpleIntegerProperty quantity;
    SimpleDoubleProperty price;
    SimpleBooleanProperty pending = new SimpleBooleanProperty(false);

    public ShoppingItem(String name, int quantity, float price) {//Constructor
        this.name = new SimpleStringProperty();
        this.quantity = new SimpleIntegerProperty();
        this.price = new SimpleDoubleProperty();
        this.name.set(name);
        this.quantity.set(quantity);
        this.price.set(price);
    }
    public String getName() {//Obtiene el nombre del producto
        return this.name.get();
    }

    public int getQuantity() {//obtiene la cantidad de un producto
        return this.quantity.get();
    }

    public double getPrice() {//obtiene el precio
        return this.price.get();
    }

    public boolean getState() {//estado, puede ser pendiente o completado
        return this.pending.get();
    }
    public void changeState(){
        if (this.getState() == true){
            this.pending.set(false);
        }else{
            this.pending.set(true);
        }
    }
}
