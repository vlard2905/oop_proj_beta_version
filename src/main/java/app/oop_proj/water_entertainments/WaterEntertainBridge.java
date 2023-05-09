package app.oop_proj.water_entertainments;

import javafx.scene.control.Label;

public abstract class WaterEntertainBridge implements Water_Entertainments {
    protected Water_Entertainments waterEntertainment;

    public WaterEntertainBridge(Water_Entertainments waterEntertainment) {
        this.waterEntertainment = waterEntertainment;
    }

    public abstract String getSchedule();
}
