package app.oop_proj.general_logic;

public abstract class Apartments implements Place {
    int count_of_residents;
    double price_of_resident;
    public void setCount_of_residents(int count_of_residents) {
        this.count_of_residents = count_of_residents;
    }
    public void setPrice_of_resident(double price_of_resident) {
        this.price_of_resident = price_of_resident;
    }
    public abstract void setCount();
    public abstract void setPrice();

    @Override
    public String getInfo() {
        return "Count: " + count_of_residents + " Price: " + price_of_resident;
    }
}
