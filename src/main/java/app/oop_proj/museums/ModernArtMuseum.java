package app.oop_proj.museums;

import app.oop_proj.general_logic.Entertainments;
import javafx.scene.control.Label;

public class ModernArtMuseum extends Entertainments implements Museums{
    String[] array = {"Albertina Modern" ,
            "Belvedere 21" ,
            "Essl Museum" ,
            "Kunsthalle Wien" ,
            "Leopold Museum" ,
            "MUMOK - Museum of Modern Art Ludwig Foundation Vienna" ,
            "Museum of Applied Arts and Contemporary Art" ,
            "Museum of Contemporary Art" ,
            "Museum of Young Art" ,
            "Secession" ,
            "21er Haus Bank Austria" ,
            "Kunstforum" ,
            "Galerie Belvedere" ,
            "Galerie Krinzinger" ,
            "Galerie nächst St. Stephan" ,
            "Georg Kargl Fine Arts" ,
            "KunstHausWien" ,
            "Kunsthistorisches Museum Vienna - Imperial Treasury" ,
            "M21 - Museum Twenty One" ,
            "MAK - Austrian Museum of Applied Arts / Contemporary Art" ,
            "Museum of Modern Art Salzburg" ,
            "Schleifmühlgasse 12-14" ,
            "Vienna Art Week" ,
            "Vienna Contemporary" ,
            "Wiener Art Foundation" ,
            "Galerie Steinek" ,
            "Künstlerhaus Vienna" ,
            "WestLicht. Schauplatz für Fotografie" ,
            "Galerie Prisma"};
    @Override
    public void setPriceOfEntering() {
        super.setPriceOfEntering(12);
    }
    @Override
    public void setFactor_P() {
        super.setFactor_P(false);
    }
    public String[] getArray() {
        return array;
    }
    @Override
    public void setFactor_C() {
        super.setFactor_C(true);
    }
    @Override
    public void fillArray() {
        super.fillArray(array, 30);
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

    @Override
    public void readRules(Label label) {
        MuseumCenter center = new MuseumCenter();
        center.addSpecialRule("(Special-rule-Modern-Museum)\n");
        label.setText(center.getGeneralMuseumRules());
    }
}
