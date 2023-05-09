package app.oop_proj.restourants;

import javafx.scene.control.Label;

public class LuxuryRestaurantAgency extends RestaurantDecorator{
    Boolean performance;
    public LuxuryRestaurantAgency(Restaurants restaurant) {
        super(restaurant);
    }

    public String getLuxuryMenu() {
        return "(Luxury-menu)";
    }

    public String getLuxuryCousin() {
        return "(Specific-cousin)";
    }

    public void orderThePerformance() { //additional function for decorator mission.
        this.performance = true;
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
