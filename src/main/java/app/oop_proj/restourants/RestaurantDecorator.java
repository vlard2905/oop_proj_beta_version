package app.oop_proj.restourants;
import javafx.scene.control.Label;
public class RestaurantDecorator implements Restaurants { //Decorator pattern.
    Restaurants restaurant;
    public RestaurantDecorator(Restaurants restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public String checkMenu() {
        return "...";
    }
    @Override
    public String checkCousinType() {
        return "...";
    }
}
