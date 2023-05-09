package app.oop_proj.museums;

import app.oop_proj.general_logic.Entertainments;
import javafx.scene.control.Label;

public class ClassicalArtMuseum extends Entertainments implements Museums{
    String[] array = {"Kunsthistorisches Museum Wien" , "Albertina Museum" , "Leopold Museum" ,
        "Belvedere Palace Museum" , "MAK - Museum of Applied Arts" + "Kunsthalle Wien" ,
        "Austrian Gallery Belvedere" , "MUMOK - Museum of Modern Art" , "Mozarthaus Vienna" ,
        "Vienna Museum" , "Vienna Secession" , "Wien Museum Karlsplatz" , "Bank Austria Kunstforum" ,
        "Kunsthalle Exnergasse" , "Museum of Contraception and Abortion" , "Belvedere 21" , "Liechtenstein Palace" ,
        "The Hofburg" , "The Austrian National Library" , "Freud Museum Vienna" , "Collection of Historical Musical Instruments" ,
        "Museum of Art Fakes" , "Künstlerhaus Vienna" , "Museum of Applied Arts Vienna" , "Schloss Ambras Innsbruck" ,
        "Österreichische Galerie im Oberen Belvedere" , "Essl Museum" , "Oskar Kokoschka Haus" , "Austrian Theater Museum" , "Architekturzentrum Wien" , "Klimt Villa Vienna" ,
        "Bank Austria Kunstforum" , "The Belvedere Winter Palace" , "Jewish Museum Vienna" , "Sigmund Freud Museum" ,
        "Kunst Haus Wien" , "Vienna Museum of Technology" , "The Prunksaal" , "MAK - Austrian Museum of Applied Arts" , "Imperial Treasury Vienna" ,
        "Museum of Military History" , "Kunst Haus Wien" , "Museum of Modern Art" , "Museum of Fine Arts Vienna" , "Secession Building" ,
        "Vienna University of Applied Arts", "Museum Moderner Kunst Stiftung Ludwig"};
    @Override
    public void fillArray() {
        super.fillArray(array, 50);
    }
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
    @Override
    public void setFactor_A() {
        super.setFactor_A(false);
    }
    @Override
    public void setFactor_L() {
        super.setFactor_L(false);
    }

    public String[] getArray() {
        return array;
    }


    @Override
    public void readRules(Label label) {
        MuseumCenter center = new MuseumCenter();
        center.addSpecialRule("(Special-rule-Classical-Museum)\n");
        label.setText(center.getGeneralMuseumRules());
    }
}
