package app.oop_proj.water_entertainments;

import app.oop_proj.Entertainments;
import app.oop_proj.museums.Museums;
import javafx.scene.control.Label;

public class Pool extends Entertainments implements Water_Entertainments{
    String[] array = {"Krapfenwaldlbad" , "Döblinger Bad" , "Kongressbad" , "Schafbergbad" , "Gänsehäufel" ,
            "Höpflerbad" , "Schönbrunnerbad" , "Kombibad Döbling" , "Stadionbad" , "Brigittenauer Bad" , "Amalienbad" , "Jörgerbad" ,
            "Dianabad" , "Hietzinger Bad" , "Laabner Badesee" , "Angelibad" , "City Baths Vienna" , "Gartenbad Hütteldorf" ,
            "Pötzleinsdorfer Bad" , "Theresienbad" , "Donaustadtbrücke" , "Gerasdorfer Straße" , "Haiderhofbad" , "Hietzinger Bad" ,
            "Hirschstettner Bad" , "Hohe Warte Bad" , "Kahlenbergerdorf" , "Meidlinger Bad" , "Ottakringer Bad" , "Schönheitsbad " , "Schwedenplatz"};
    @Override
    public void setPriceOfEntering() {
        super.setPriceOfEntering(12);
    }
    @Override
    public void setFactor_P() {
        super.setFactor_P(true);
    }

    @Override
    public void setFactor_C() {
        super.setFactor_C(false);
    }
    @Override
    public void fillArray() {
        super.fillArray(array, 30);
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
    public void getSchedule(Label label) {

    }
}

