package app.oop_proj.apartments;

import app.oop_proj.general_logic.Apartments;

public class DeluxApartments extends Apartments {
    protected int max_count = 5, average_count = 3, romantic = 2; //different patterns of count of places.
    protected double price_lux = 1000.0, average_price = 700.0, romantic_price = 500.0;//different patterns of prices.

    @Override
    public void setCount() {
        setCount_of_residents(max_count);
    }
    @Override
    public void setPrice() {
        setPrice_of_resident(price_lux);
    }
}
