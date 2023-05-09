package app.oop_proj.water_entertainments;

import javafx.scene.control.Label;

public class HolidaySchedule extends WaterEntertainBridge{
    String schedule;
    public HolidaySchedule(Water_Entertainments waterEntertainment) {
        super(waterEntertainment);
    }
    public void setSchedule() {
        this.schedule = "schedule-holiday";
    }
    @Override
    public String getSchedule() {
        return "...";
    }
}
