package app.oop_proj.water_entertainments;

import javafx.scene.control.Label;

public class HolidaySchedule extends WaterEntertainBridge{
    public HolidaySchedule(Water_Entertainments waterEntertainment) {
        super(waterEntertainment);
    }

    @Override
    public void setSchedule() {

    }

    @Override
    public void getSchedule(Label label) {
        label.setText("schedule-holiday");
    }
}
