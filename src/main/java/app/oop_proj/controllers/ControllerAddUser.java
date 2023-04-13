package app.oop_proj.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import app.oop_proj.ApplicationInAt;
import app.oop_proj.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javax.swing.*;

public class ControllerAddUser implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddUserButton;

    @FXML
    private Spinner<Integer> AgeSpinner;

    @FXML
    private CheckBox AllergyCheckBox;

    @FXML
    private CheckBox ChildrenCheckBox;

    @FXML
    private CheckBox DisabilitiesCheckBox;

    @FXML
    private RadioButton FemaleRadioBox;

    @FXML
    private CheckBox LGBTCheckBox;

    @FXML
    private RadioButton MaleRadioBox;

    @FXML
    private TextField NameString;

    @FXML
    private RadioButton NonRadioBox;

    @FXML
    private Button CountButton;
    @FXML
    private Button ButtonGoToECC;

    @FXML
    private TextField CountField;


    @FXML
    private CheckBox PetsCheckBox;
    int countOfUsers = 0, counter = 0;

    public ControllerAddUser() throws IOException {
    }

    @FXML
    void initialize() {
        assert AddUserButton != null : "fx:id=\"AddUserButton\" was not injected: check your FXML file 'scene3.fxml'.";
        assert AgeSpinner != null : "fx:id=\"AgeSpinner\" was not injected: check your FXML file 'scene3.fxml'.";
        assert AllergyCheckBox != null : "fx:id=\"AllergyCheckBox\" was not injected: check your FXML file 'scene3.fxml'.";
        assert ChildrenCheckBox != null : "fx:id=\"ChildrenCheckBox\" was not injected: check your FXML file 'scene3.fxml'.";
        assert DisabilitiesCheckBox != null : "fx:id=\"DisabilitiesCheckBox\" was not injected: check your FXML file 'scene3.fxml'.";
        assert FemaleRadioBox != null : "fx:id=\"FemaleRadioBox\" was not injected: check your FXML file 'scene3.fxml'.";
        assert LGBTCheckBox != null : "fx:id=\"LGBTCheckBox\" was not injected: check your FXML file 'scene3.fxml'.";
        assert MaleRadioBox != null : "fx:id=\"MaleRadioBox\" was not injected: check your FXML file 'scene3.fxml'.";
        assert NameString != null : "fx:id=\"NameString\" was not injected: check your FXML file 'scene3.fxml'.";
        assert NonRadioBox != null : "fx:id=\"NonRadioBox\" was not injected: check your FXML file 'scene3.fxml'.";
        assert PetsCheckBox != null : "fx:id=\"PetsCheckBox\" was not injected: check your FXML file 'scene3.fxml'.";

    }

    public void setCountOfUsers() {
        this.countOfUsers = Integer.parseInt(CountField.getText());
        CountField.setText(String.valueOf(countOfUsers));
        CountField.setEditable(false);
        CountButton.setDisable(true);
    }

    FileOutputStream fos = new FileOutputStream("UserDATA.bin");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    public void clickOnAddButton(ActionEvent event) throws IOException {
        if(countOfUsers == 0) {
            JOptionPane.showMessageDialog(null, "Please, enter count of members in right corner.");
        } else if(counter < countOfUsers) {
            User user = new User();
            try {
                user.setNameOfUser(NameString.getText());
                user.setAgeOfUser(AgeSpinner.getValue());
                if (MaleRadioBox.isSelected()) {
                    user.setSex("Male");
                } else if (FemaleRadioBox.isSelected()) {
                    user.setSex("Female");
                } else if (NonRadioBox.isSelected()) {
                    user.setSex("Non-binary");
                }
                if (AllergyCheckBox.isSelected()) {
                    user.setSpecificCharacteristics("Allergy");
                }
                if (PetsCheckBox.isSelected()) {
                    user.setSpecificCharacteristics("Pets");
                }
                if (LGBTCheckBox.isSelected()) {
                    user.setSpecificCharacteristics("Lgbt");
                }
                if (DisabilitiesCheckBox.isSelected()) {
                    user.setSpecificCharacteristics("Disabilities");
                }
                if (ChildrenCheckBox.isSelected()) {
                    user.setSpecificCharacteristics("Child");
                }
                oos.writeObject(user);

                NameString.clear();
                MaleRadioBox.setSelected(false);
                FemaleRadioBox.setSelected(false);
                NonRadioBox.setSelected(false);
                AllergyCheckBox.setSelected(false);
                PetsCheckBox.setSelected(false);
                LGBTCheckBox.setSelected(false);
                DisabilitiesCheckBox.setSelected(false);
                ChildrenCheckBox.setSelected(false);
                counter++;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Try to write correct symbols in each blank.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Your company is full, it is pity, but you should make new company to add new user... Press button 'Go to ECC'");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        valueFactory.setValue(1);
        AgeSpinner.setValueFactory(valueFactory);
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        oos.close();
        fos.close();
        JOptionPane.showMessageDialog(null, "Congratulations! You created a company! (It means you have friends! Significant success!)");
        ButtonGoToECC.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationInAt.class.getResource("scene2.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setScene(scene);
        stage.show();
    }
}
