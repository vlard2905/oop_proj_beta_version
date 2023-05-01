package app.oop_proj.water_entertainments;

import javafx.scene.control.Label;

public class StandardSchedule extends WaterEntertainBridge {

    public StandardSchedule(Water_Entertainments waterEntertainment) {
        super(waterEntertainment);
    }

    @Override
    public void setSchedule() {

    }

    @Override
    public void getSchedule(Label label) {
          label.setText("standard-schedule");
    }
}
