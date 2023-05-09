package app.oop_proj.general_logic;


import java.util.ArrayList;
import java.util.Arrays;

public abstract class Entertainments implements Place {
    protected ArrayList<String> Names = new ArrayList<>();
    protected int priceOfEntering;
    protected boolean petsFactor;
    protected boolean childrenFactor;
    protected boolean disabilitiesFactor;
    protected boolean riskOfAllergy;
    protected boolean LGBTQ_factor;

    public void setPriceOfEntering(int priceOfEntering) {
        this.priceOfEntering = priceOfEntering;
    }

    public void setFactor_P(Boolean smth) {
        this.petsFactor = smth;
    }

    public void setFactor_C(Boolean smth) {
        this.childrenFactor = smth;
    }

    public void setFactor_D(Boolean smth) {
        this.disabilitiesFactor = smth;
    }

    public void setFactor_A(Boolean smth) {
        this.riskOfAllergy = smth;
    }

    public void setFactor_L(Boolean smth) {
        this.LGBTQ_factor = smth;
    }

    public void fillArray(String[] array, int count){
        Names.addAll(Arrays.asList(array).subList(0, count));
    }

    public boolean isPetsFactor() {
        return petsFactor;
    }

    public boolean isChildrenFactor() {
        return childrenFactor;
    }

    public boolean isDisabilitiesFactor() {
        return disabilitiesFactor;
    }

    public boolean isRiskOfAllergy() {
        return riskOfAllergy;
    }

    public boolean isLGBTQ_factor() {
        return LGBTQ_factor;
    }

    public void printInfo(){
        String message = "If you have pet, you should go without it.";
    }
    public abstract void fillArray();
    public abstract void setPriceOfEntering();
    public abstract void setFactor_P();
    public abstract void setFactor_C();
    public abstract void setFactor_D();
    public abstract void setFactor_A();
    public abstract void setFactor_L();

    @Override
    public String getInfo() {
        return "...";
    }
}
