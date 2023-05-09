package app.oop_proj.water_entertainments;
import app.oop_proj.general_logic.Entertainments;

public class Sauna extends Entertainments implements Water_Entertainments{
    String[] array = {"Thermen- & Vitalhotel Bad Tatzmannsdorf" , "Asia Spa Leoben" , "Therme Loipersdorf" ,
            "Thermengolfhotel Stoiser" , "Falkensteiner Balance Resort Stegersbach" , "SPA Resort Styria" ,
            "Falkensteiner Therme & Golf Hotel Bad Waltersdorf" , "Therme Nova Köflach" , "Schaffelbad Loipersdorf" ,
            "Thermenhotel Stoiser " , "Spa Resort Therme Geinberg" , "Rogner Bad Blumau" , "Therme Laa - Hotel & Silent Spa" ,
            "Römertherme Baden" , "AQUA DOME Tirol Therme Längenfeld" , "Therme Wien" , "Danubius Health Spa Resort Margitsziget" ,
            "Therme Radenci" , "St. Martins Therme & Lodge" , "Alpentherme Gastein"};
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
    public void fillArray() {
        super.fillArray(array, 20);
    }
    @Override
    public void setFactor_L() {
        super.setFactor_L(true);
    }
    @Override
    public String getSchedule() {
        return "...";
    }
}