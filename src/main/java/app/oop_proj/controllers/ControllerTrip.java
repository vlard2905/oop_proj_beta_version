package app.oop_proj.controllers;

import app.oop_proj.ApplicationInAt;
import app.oop_proj.Trip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.DataFormat;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class ControllerTrip implements Initializable {
    LocalDate date1, date2;
    @FXML
    private RadioButton ActiveRadioBox;
    @FXML
    private Spinner<Integer> BudgetSpinner;
    @FXML
    private Button CreateScheduleButton;
    @FXML
    private DatePicker FinishDatePicker;
    @FXML
    private Button FamilyPatButton;
    @FXML
    private DatePicker StartDatePicker;
    @FXML
    private RadioButton PassiveRadioBox;
    @FXML
    private Button RomanticPanButton;
    @FXML
    private Button SchoolPatButton;
    @FXML
    private ToggleGroup style;
    FileOutputStream fos = new FileOutputStream("TripDATA.bin");
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    public ControllerTrip() throws IOException {
    }
    public void createTripButtonClicked(ActionEvent event) throws IOException {
        Trip trip = new Trip();
        try {
            trip.setBudget(BudgetSpinner.getValue());
            if (ActiveRadioBox.isSelected()) {
                trip.setActiveTrip(true);
            } else if (PassiveRadioBox.isSelected()) {
                trip.setPassiveTrip(true);
            }
            trip.setTime(getTimeController());
            oos.writeObject(trip);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Try to write correct symbols in each blank.");
        }
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationInAt.class.getResource("scene5.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100000);
        valueFactory.setValue(10);
        BudgetSpinner.setValueFactory(valueFactory);
    }

    public void getDate1(){
        this.date1 = StartDatePicker.getValue();
        String DateFormat = date1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public void getDate2(){
        this.date2 = StartDatePicker.getValue();
        String DateFormat = date2.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public long getTimeController() {
        LocalDate startDate = StartDatePicker.getValue();
        LocalDate endDate = FinishDatePicker.getValue();
        Duration duration = Duration.between(startDate.atStartOfDay(), endDate.atStartOfDay());
        return duration.toDays();
    }

}
