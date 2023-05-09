package app.oop_proj.water_entertainments;

import javafx.scene.control.Label;

public class StandardSchedule extends WaterEntertainBridge {
    String schedule;
    public StandardSchedule(Water_Entertainments waterEntertainment) {
        super(waterEntertainment);
    }
    public void setSchedule() {
        this.schedule = "Standard-schedule";
    }
    @Override
    public String getSchedule() {
          return "...";
    }
}
