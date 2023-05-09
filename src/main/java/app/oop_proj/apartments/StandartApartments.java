package app.oop_proj.apartments;

import app.oop_proj.general_logic.Apartments;

public class StandartApartments extends Apartments {
    int max_count = 5, average_count = 3, romantic = 2;//different patterns of count of places.
    double price_lux = 200.0, average_price = 120.0, romantic_price = 80.0;//different patterns of prices.
    @Override
    public void setCount() {
        setCount_of_residents(max_count);
    }
    @Override
    public void setPrice() {
        setPrice_of_resident(price_lux);
    }
}
