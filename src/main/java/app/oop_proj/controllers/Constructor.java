package app.oop_proj.controllers;

import java.io.FileWriter;
import java.io.IOException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.net.URL;
import java.util.ResourceBundle;

import app.oop_proj.*;
import app.oop_proj.museums.ClassicalArtMuseum;
import app.oop_proj.museums.HistoricalMuseum;
import app.oop_proj.museums.ModernArtMuseum;
import app.oop_proj.restourants.DeluxRestourant;
import app.oop_proj.restourants.FamilyRestourant;
import app.oop_proj.restourants.FustFood;
import app.oop_proj.water_entertainments.Aquapark;
import app.oop_proj.water_entertainments.Pool;
import app.oop_proj.water_entertainments.Sauna;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;

public class Constructor implements Serializable, Initializable {
    @Serial
    private static final long serialVersionUID = -3981825062549136371L;
    User collective;
    private ArrayList<User> company = new ArrayList<>();
    Trip tripCharacteristics;
    FileInputStream cityD = new FileInputStream("CityDATA.ser");
    ObjectInputStream inCity = new ObjectInputStream(cityD);
    FileInputStream userD = new FileInputStream("UserDATA.bin");
    ObjectInputStream inUser = new ObjectInputStream(userD);
    public void setUserCompany() throws IOException, ClassNotFoundException {
        try {
            while (true) {
                User newUser = (User) inUser.readObject();
                company.add(newUser);
            }
        } catch (EOFException ignored) {
        }/* finally {
            inUser.close();
            userD.close();
        }*/
    }
    FileInputStream tripD = new FileInputStream("TripDATA.bin");
    ObjectInputStream inTrip = new ObjectInputStream(tripD);
    public void setTripCharacteristics() throws IOException, ClassNotFoundException {
        try {
            tripCharacteristics = (Trip) inTrip.readObject();
            tripCharacteristics.city = (City) inCity.readObject();
        } catch (EOFException ignored) {
        } /*finally {
            inTrip.close();
            tripD.close();
        }*/


    }
    public String printCompany() {
       /*System.out.println(Arrays.toString(company.toArray()));
        System.out.println(tripCharacteristics.toString());*/
        System.out.println("Age:" + company.get(1).getAgeOfUser() +"\nName:"+ company.get(1).getNameOfUser() +"\nMale:"+ company.get(1).isMale() +"\nFemale:"+
                company.get(1).isFemale() +"\nAllergy:"+ company.get(1).isAllergy() +"\nChild:"+ company.get(1).isChild() +"\nLgbt:"+
                company.get(1).isLgbt() +"\nPets:"+ company.get(1).isPets() +"\nDisables:"+ company.get(1).isDisabilities());
        System.out.println("City:" + tripCharacteristics.getCity().getCityName() +"Active:" + tripCharacteristics.isActiveTrip()+"Passive:" + tripCharacteristics.isPassiveTrip() +"Time:"+ tripCharacteristics.getTime());
        String data = Arrays.toString(company.toArray()) + tripCharacteristics.toString() + "Age:" + collective.getAgeOfUser() + "Name:"+ collective.getNameOfUser() +"Male:"+ collective.isMale() +"Female:"+
                collective.isFemale() +"Allergy:"+ collective.isAllergy() +"Child:"+ collective.isChild() +"Lgbt:"+
                collective.isLgbt() +"Pets:"+ collective.isPets() +"Disablts:"+ collective.isDisabilities();
        return data;
    }
    public Constructor() throws IOException, ClassNotFoundException {
        setUserCompany();
        setTripCharacteristics();
        setCollectiveSpecialities();

    }
    public void setCollectiveSpecialities(){
        collective = new User();
        collective.setNameOfUser("Company");
        collective.setAgeOfUser(company.get(0).getAgeOfUser());
        for (int i = 0; i < company.size(); i++) {
            if (company.get(i).isMale()) {
                collective.setMale(true);
            }
            if (company.get(i).isFemale()) {
                collective.setFemale(true);
            }
            if (company.get(i).isNon_binary()) {
                collective.setNon_binary(true);
            }
            if (company.get(i).isAllergy()) {
                collective.setAllergy(true);
            }
            if (company.get(i).isChild()) {
                collective.setChild(true);
            }
            if (company.get(i).isDisabilities()) {
                collective.setDisabilities(true);
            }
            if (company.get(i).isLgbt()) {
                collective.setLgbt(true);
            }
            if (company.get(i).isPets()) {
                collective.setPets(true);
            }
            if (i <= company.size() - 2) {
                if (company.get(i + 1).getAgeOfUser() < company.get(i).getAgeOfUser()) {
                    collective.setAgeOfUser(company.get(i + 1).getAgeOfUser());
                }
            }
        }
    }
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button CDButton;
    @FXML
    private Button CSButton;
    @FXML
    private Button SDGHButton;
    @FXML
    private Button SSButton;
    @FXML
    private ProgressBar SchedulFullnessBar;
    @FXML
    private ChoiceBox<String> ChoiceEvent;
    @FXML
    private TreeView<String> TreeViewLast;
    @FXML
    private Button ConfirmEvent;
    @FXML
    private Label percentLabel;
    @FXML
    private Label testLabel;
    double progress = 0;
    @FXML
    void increaseProgressBar() {
        testLabel.setText(printCompany());
        progress += 1.0 / tripCharacteristics.getTime();
        SchedulFullnessBar.setProgress(progress);
        percentLabel.setText(Math.round(progress * 100) + "%");
    }
    public void AddEventButtonClicked() throws IOException {

    }
    @FXML
    private TreeTableColumn<String, String> DayCol = new TreeTableColumn<>();
    @FXML
    private TreeTableColumn<String, String> NameCol = new TreeTableColumn<>();
    Boolean help = true;
    Integer countOfDayEvents = getCountOfEventsOnOneDay();
    public int getCountOfEventsOnOneDay() throws IOException, ClassNotFoundException {
        setTripCharacteristics();
        assert tripCharacteristics != null;
        if(tripCharacteristics.isActiveTrip()) {
            countOfDayEvents = 4;
        } if(tripCharacteristics.isPassiveTrip()) {
            countOfDayEvents = 2;
        }
        return countOfDayEvents;
    }
    double countOfDays = tripCharacteristics.getTime();
    int counter = 0, Day = 1;
    TreeItem<String > root = new TreeItem<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChoiceEvent.getItems().addAll(getAllAllowed());
    }
    public Entertainments setFactor(Entertainments obj) {
        obj.setFactor_A();
        obj.setFactor_C();
        obj.setFactor_D();
        obj.setFactor_L();
        obj.setFactor_P();
        return obj;
    }
    public boolean compareObjectConditions(Entertainments attractive, User user) {
        boolean check = true;
        if (attractive.isChildrenFactor() && user.isChild()) {
            check = false;
        }
        if (attractive.isPetsFactor() && user.isPets()) {
            check = false;
        }
        if (attractive.isLGBTQ_factor() && user.isLgbt()) {
            check = false;
        }
        if (attractive.isDisabilitiesFactor() && user.isDisabilities()) {
            check = false;
        }
        if (attractive.isRiskOfAllergy() && user.isAllergy()) {
            check = false;
        }
        return check;
    }
    private String[] getAllAllowed() {
        ArrayList<String> AllAllowed = new ArrayList<>();
        setCollectiveSpecialities();
        AllAllowed.add("Own place");
        ClassicalArtMuseum CAM = new ClassicalArtMuseum();
        CAM = (ClassicalArtMuseum) setFactor(CAM);
        HistoricalMuseum HM = new HistoricalMuseum();
        HM = (HistoricalMuseum) setFactor(HM);
        ModernArtMuseum MAM = new ModernArtMuseum();
        MAM = (ModernArtMuseum) setFactor(MAM);
        DeluxRestourant DR = new DeluxRestourant();
        DR = (DeluxRestourant) setFactor(DR);
        FamilyRestourant FR = new FamilyRestourant();
        FR = (FamilyRestourant) setFactor(FR);
        FustFood FF = new FustFood();
        FF = (FustFood) setFactor(FF);
        Aquapark A = new Aquapark();
        A = (Aquapark) setFactor(A);
        Pool P = new Pool();
        P = (Pool) setFactor(P);
        Sauna S = new Sauna();
        S = (Sauna) setFactor(S);
        if (compareObjectConditions(CAM, collective)){
            AllAllowed.addAll(Arrays.asList(CAM.getArray()));
        }
        if (compareObjectConditions(HM, collective)){
            AllAllowed.addAll(Arrays.asList(HM.getArray()));
        }
        if (compareObjectConditions(DR, collective)){
            AllAllowed.addAll(Arrays.asList(DR.getArray()));
        }
        if (compareObjectConditions(FR, collective)){
            AllAllowed.addAll(Arrays.asList(FR.getArray()));
        }
        if (compareObjectConditions(FF, collective)){
            AllAllowed.addAll(Arrays.asList(FF.getArray()));
        }
        if (compareObjectConditions(A, collective)){
            AllAllowed.addAll(Arrays.asList(A.getArray()));
        }
        if (compareObjectConditions(P, collective)){
            AllAllowed.addAll(Arrays.asList(P.getArray()));
        }
        if (compareObjectConditions(MAM, collective)){
            AllAllowed.addAll(Arrays.asList(MAM.getArray()));
        }
        if (compareObjectConditions(S, collective)){
            AllAllowed.addAll(Arrays.asList(S.getArray()));
        }
        return AllAllowed.toArray(new String[AllAllowed.size()]);
    }
    String value;
    @FXML
    private Label LabelLast;
    String LabelText = "Day 1:";
    public void addEventsForDay() {
        value = ChoiceEvent.getValue();
        LabelText += value + ", ";
        LabelLast.setText(LabelText);
        counter++;
        if (counter > countOfDayEvents) {
            JOptionPane.showMessageDialog(null, "It's more than your schedule plan... But you can choose more if you wish.");
        }
    }
    public void addDays() {
        Day++;
        counter = 0;
        if (Day <= tripCharacteristics.getTime()) {
            value = "Day " + Day + ":";
            LabelText += "\n" + value;
            LabelLast.setText(LabelText);
            increaseProgressBar();
        } else {
            LabelText += "\n" + "Your trip is ready!";
            LabelLast.setText(LabelText);
            saveText();
        }
    }

    public void clearDaySchedule() {
        int lastChar = LabelText.length() - 1;
        char j = LabelText.charAt(lastChar);
        while(j != ':') {
            j = LabelText.charAt(--lastChar);
        }
        LabelText = LabelText.substring(0, lastChar + 1);
        LabelLast.setText(LabelText);
    }
    public void clearSchedule() {
        LabelText = "Day 1:";
        counter = 0;
        Day = 1;
        LabelLast.setText(LabelText);
    }
    public void saveText() {
        try {
            FileWriter writer = new FileWriter("file.txt");
            writer.write(LabelText);
            writer.close();
            System.out.println("Text saved to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the text to file.");
            e.printStackTrace();
        }
    }
}
