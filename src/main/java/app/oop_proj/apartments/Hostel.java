package app.oop_proj.apartments;

import app.oop_proj.general_logic.Apartments;

public class Hostel extends Apartments {
    int max_count = 5, average_count = 3, romantic = 2;//different patterns of count of places.
    double price_lux = 50.0, average_price = 30.0, romantic_price = 25.0;//different patterns of prices.

    @Override
    public void setCount() {
        setCount_of_residents(max_count);
    }

    @Override
    public void setPrice() {
        setPrice_of_resident(price_lux);
    }
}
