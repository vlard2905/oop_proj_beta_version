package app.oop_proj.restourants;

import app.oop_proj.Entertainments;

public class FamilyRestourant extends Entertainments {
    String[] array = {"Figlmüller Wollzeile" , "Gasthaus Reinthaler" , "Gasthaus Pöschl" , "Fischerbräu" , "Schnattl" ,
            "Wienerwald" , "Gmoakeller" , "Schweizerhaus" , "Beograd" , "Salm Bräu" , "Griechenbeisl" , "Zum Alten Fassl" ,
            "Gasthaus Stefanie" , "Rathauskeller" , "Plachutta Hietzing" , "Wirtshaus zum Nepomuk" , "Meixner's Gastwirtschaft" , "Gasthaus Schilling" ,
            "Zwölf Apostelkeller" , "Schweizerhaus Prater" , "Gasthaus zur Oper" , "Gasthaus Ubl" , "Gasthaus Wolf" , "Altwienerhof" , "Gasthaus zur Alten Kaisermühle" ,
            "Kutschker 44" , "Gasthaus Wild" , "Schnitzelwirt" , "Gmoakeller" , "Gasthaus Kopp" , "Augustinerkeller" , "Gasthaus Steirereck" ,
            "Gasthaus Pfudl" , "Weinstube Josefstadt" , "Gasthaus Fuhrgassl-Huber" , "Pürstner" , "Kolariks Luftburg" , "Gasthaus Lederer" , "Gasthaus zur Palme" , "Schöne Perle" ,
            "Gasthaus Griechenbeisl" , "Gasthaus Tellerwirt" , "Wirtshaus Silberwirt" , "Brandauer Bierbögen" , "Gasthaus Zur Eiche" , "Gasthaus Pöschl" ,
            "Plutzer Bräu" , "Wiener Wiaz Haus" , "Schweizerhaus im Prater" , "Heuriger Mayer am Pfarrplatz."};
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
        super.fillArray(array, 50);
    }
    @Override
    public void setFactor_L() {
        super.setFactor_L(false);
    }
}

