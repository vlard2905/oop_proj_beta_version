package app.oop_proj.museums;

import app.oop_proj.Entertainments;

public class HistoricalMuseum extends Entertainments {
    String[] array = {};
    @Override
    public void setPriceOfEntering() {
        super.setPriceOfEntering(12);
    }
    @Override
    public void fillArray() {
        super.fillArray(array, 40);
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
    public void setFactor_D() {
        super.setFactor_D(false);
    }
    public String[] getArray() {
        return array;
    }
    @Override
    public void setFactor_A() {
        super.setFactor_A(true);
    }

    @Override
    public void setFactor_L() {
        super.setFactor_L(false);
    }
}
