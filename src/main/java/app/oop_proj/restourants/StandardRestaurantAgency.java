package app.oop_proj.restourants;

import javafx.scene.control.Label;

public class StandardRestaurantAgency extends RestaurantDecorator{
    public StandardRestaurantAgency(Restaurants restaurant) {
        super(restaurant);
    }

    public String getStandardMenu() {
        return "(Standard-menu)";
    }

    public String getStandardCousin() {
        return "(Native-cousin)";
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
