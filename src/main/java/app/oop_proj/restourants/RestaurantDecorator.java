package app.oop_proj.restourants;

import javafx.scene.control.Label;

public class RestaurantDecorator implements Restaurants { //Decorator pattern.

    Restaurants restaurant;

    public RestaurantDecorator(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void checkMenu(Label label) {
        label.setText("Menu: \n");
    }
    @Override
    public void checkCousinType(Label label) {
        label.setText("Cousin type: \n");
    }
}
