package app.oop_proj.controllers;

import app.oop_proj.ApplicationInAt;
import app.oop_proj.general_logic.City;
import app.oop_proj.general_logic.MenuBarInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;

/**
 * Class for choosing city.
 * @see ControllerCityChooser
 */
public class ControllerCityChooser implements Serializable, MenuBarInterface {
    @Serial
    private static final long serialVersionUID = -3694130527841881838L;
    Stage stage;
    @FXML
    private RadioButton RadioGraz;
    @FXML
    private RadioButton RadioSalzburg;
    @FXML
    private RadioButton RadioVienna;
    @FXML
    private Button MakeTripButton;
    public void switchToScene2(ActionEvent event) throws IOException {
        City city = new City();

        if(RadioVienna.isSelected()) {
            city.setCityName("Vienna");
        } else if (RadioGraz.isSelected()) {
            city.setCityName("Graz");
        } else if (RadioSalzburg.isSelected()) {
            city.setCityName("Salzburg");
        }

        int result = JOptionPane.showConfirmDialog(null,"Are you sure, that " + city.getCityName() + " is the place you want to go?", "In.at questioner",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.NO_OPTION){
            return;
        }

        FileOutputStream fos = new FileOutputStream("CityDATA.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(city);
            oos.close();
            fos.close();
            MakeTripButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(ApplicationInAt.class.getResource("scene2.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 800, 500);
            stage.setScene(scene);
            stage.show();
    }

    @Override
    public void readInformation() {
        MenuBarInterface.super.readInformation();
    }

    @Override
    public void exitTheProgramInMenu() {
        MenuBarInterface.super.exitTheProgramInMenu();
    }
}
