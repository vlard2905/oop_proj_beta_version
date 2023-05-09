package app.oop_proj.restourants;

import app.oop_proj.general_logic.Entertainments;

public class DeluxRestourant extends Entertainments implements Restaurants{
    String[] array = {"Steirereck" ,
            "Edvard" , "Mörwald Gruppe" , "Silvio Nickol Gourmet Restaurant" , "Konstantin Filippou" ,
            "Le Ciel" , "Tian" , "Konstantin Filippou" , "Blue Mustard" , "Labstelle" , "Restaurant Opus" , "Kussmaul" , "Pichlmaiers Zum Herkner" ,
            "Restaurant Walter Bauer" , "Heunisch & Erben" , "Fabios" , "Artner auf der Wieden" , "Restaurant Vestibül" , "Palais Coburg" ,
            "Das Loft" , "Motto am Fluss" , "Restaurant Ikarus" , "Dstrikt Steakhouse" , "Dots im Brunnerhof" ,
            "Österreicher im MAK" , "Landhaus Bacher" , "Restaurant Hansen" , "La Véranda" , "Zum Schwarzen Kameel" , "On Market" , "Meierei im Stadtpark" ,
            "Restaurant im Stilwerk" , "Do&Co Albertina" , "Saziani Stub'n" , "Dstrikt Steakhouse" , "Pan e Vin" , "Wrenkh" , "Cuisino - Casino Restaurant Wien" ,
            "Mercado" , "Glacis Beisl" , "Habibi & Hawara" , "Restaurant Konrad" , "Das Schick" , "Figlmüller" ,
            "Le Salzgries" , "Rote Bar" , "Pürstner" , "TIAN Bistro am Spittelberg"};
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
    public void fillArray() {
        super.fillArray(array, 50);
    }
    @Override
    public void setFactor_D() {
        super.setFactor_D(false);
    }
    public String[] getArray() {
        return array;
    }
    @Override
    public void setFactor_A() {
        super.setFactor_A(false);
    }

    @Override
    public void setFactor_L() {
        super.setFactor_L(false);
    }

    @Override
    public String checkMenu() {
        Restaurants obj1 = null;
        RestaurantDecorator obj = new RestaurantDecorator(new StandardRestaurantAgency(obj1));
        return obj.checkMenu();
    }

    @Override
    public String checkCousinType() {
        Restaurants obj1 = null;
        RestaurantDecorator obj = new RestaurantDecorator(new StandardRestaurantAgency(obj1));
        return obj.checkMenu();
    }
}

