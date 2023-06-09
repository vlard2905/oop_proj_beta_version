package app.oop_proj.water_entertainments;

import app.oop_proj.Entertainments;

public class Aquapark extends Entertainments {
    String[] array = {"Therme Wien" , "Happyland" , "Kaiserbründl" ,
            "Oberlaa Thermal Baths" , "Dianabad"};
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
        super.fillArray(array, 5);
    }
    @Override
    public void setFactor_D() {
        super.setFactor_D(true);
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
}

