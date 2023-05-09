package app.oop_proj.restourants;

import app.oop_proj.general_logic.Entertainments;

public class FustFood extends Entertainments implements Restaurants{
    String[] array = {"McDonald's" , "Burger King" , "KFC" , "Subway" , "Five Guys" , "Johnny's Burger Company" , "Jack the Ripperl" ,
            "BURGERISTA" , "Swing Kitchen" , "L'Orient" , "Frittenwerk" , "Bier & Bierli" , "Charlie P's Pub & Dining" , "Ludwig & Adele" , "Kentucky Fried Chicken" , "Oh My Deer" , "The Säulenhalle" , "Brooklyn Burger Bar" ,
            "Flames" , "T.G.I. Fridays" , "Burger Factory" , "Schachtelwirt" , "Cactus Mexican Grill & Bar" , "Boogie's American Burgers" , "Heldenplatz" , "Indian Fast Food" , "Schnitzelwirt" , "Noodle Palace" ,
            "Grand Ferdinand Restaurant" , "Tel Aviv Beach" , "Das Campus" , "Schachtelwirt" , "Classic American Pizza" , "S'Baggers" , "The View Rooftop" ,
            "Nachtschwärmer" , "Curry Insel" , "Deli Bluem" , "Le Burger" , "Okiru Running Sushi" , "Wrenkh Wiener Kochsalon" , "Weltcafé" , "Karma Ramen" ,
            "Swing Kitchen" , "Zum Wohl" , "Yori" , "Burger's Bar" , "Jimmy's"};
    @Override
    public void setPriceOfEntering() {
        super.setPriceOfEntering(12);
    }
    @Override
    public void setFactor_P() {
        super.setFactor_P(false);
    }
    @Override
    public void setFactor_C() {
        super.setFactor_C(false);
    }

    @Override
    public void setFactor_D() {
        super.setFactor_D(false);
    }
    @Override
    public void fillArray() {
        super.fillArray(array, 50);
    }
    @Override
    public void setFactor_A() {
        super.setFactor_A(false);
    }
    public String[] getArray() {
        return array;
    }
    @Override
    public void setFactor_L() {
        super.setFactor_L(false);
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

