package app.oop_proj.controllers;

import java.io.FileWriter;
import java.io.IOException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.net.URL;
import java.util.ResourceBundle;

import app.oop_proj.User;
import app.oop_proj.apartments.DeluxApartments;
import app.oop_proj.apartments.Hostel;
import app.oop_proj.apartments.StandartApartments;
import app.oop_proj.general_logic.*;
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
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;

/**
 * Class with main part of logic.
 * @see Constructor
 */

public class Constructor implements Serializable, Initializable, MenuBarInterface {
    @Serial
    private static final long serialVersionUID = -3981825062549136371L;
    private User collective;
    private ArrayList<User> company = new ArrayList<>();
    private Trip tripCharacteristics;
    private FileInputStream cityD = new FileInputStream("CityDATA.ser");
    private ObjectInputStream inCity = new ObjectInputStream(cityD);
    private FileInputStream userD = new FileInputStream("UserDATA.bin");
    private ObjectInputStream inUser = new ObjectInputStream(userD);

    /**
     * This function add to array of users new user, which contains ObjectInputStream.
     * @throws IOException
     * @throws ClassNotFoundException
     *
     *
     */
    public void setUserCompany() throws IOException, ClassNotFoundException {
        try {
            while (true) {
                User newUser = (User) inUser.readObject();
                company.add(newUser);
            }
        } catch (EOFException ignored) {
        }
    }
    private FileInputStream tripD = new FileInputStream("TripDATA.bin");
    private ObjectInputStream inTrip = new ObjectInputStream(tripD);

    /**
     * This function will get from ObjectInputStream fields to object of type Trip.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void setTripCharacteristics() throws IOException, ClassNotFoundException {
        try {
            tripCharacteristics = (Trip) inTrip.readObject(); // reading from opened stream.
            tripCharacteristics.city = (City) inCity.readObject(); // reading from OIS the object of type City.
        } catch (EOFException ignored) {
        }
    }

    /**
     *  Checking function.
     * @return String - list of objects for checking their correctness.
     */
    public String printCompany() {
        System.out.println("Age:" + company.get(1).getAgeOfUser() +"\nName:"+ company.get(1).getNameOfUser() +"\nMale:"+ company.get(1).isMale() +"\nFemale:"+
                company.get(1).isFemale() +"\nAllergy:"+ company.get(1).isAllergy() +"\nChild:"+ company.get(1).isChild() +"\nLgbt:"+
                company.get(1).isLgbt() +"\nPets:"+ company.get(1).isPets() +"\nDisables:"+ company.get(1).isDisabilities());
        System.out.println("City:" + tripCharacteristics.getCity().getCityName() +"Active:" + tripCharacteristics.isActiveTrip()+"Passive:" + tripCharacteristics.isPassiveTrip() +"Time:"+ tripCharacteristics.getTime());
        String data = Arrays.toString(company.toArray()) + tripCharacteristics.toString() + "Age:" + collective.getAgeOfUser() + "Name:"+ collective.getNameOfUser() +"Male:"+ collective.isMale() +"Female:"+
                collective.isFemale() +"Allergy:"+ collective.isAllergy() +"Child:"+ collective.isChild() +"Lgbt:"+
                collective.isLgbt() +"Pets:"+ collective.isPets() +"Disablts:"+ collective.isDisabilities();
        return data;
    }
    public Constructor() throws IOException, ClassNotFoundException { // constructor for making all the objects of type Consructor with data.
        setUserCompany();
        setTripCharacteristics();
        setCollectiveSpecialities();

    }

    /**
     * Function will set all the collective characteristics to new object, which will represent company in one object.
     */
    public void setCollectiveSpecialities(){
        collective = new User(); // collective unit.
        collective.setNameOfUser("Company");
        collective.setAgeOfUser(company.get(0).getAgeOfUser());
        for (int i = 0; i < company.size(); i++) { // cycle for turning all the factors.
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
    private ProgressBar SchedulFullnessBar;
    @FXML
    private ChoiceBox<String> ChoiceEvent;
    @FXML
    private Label percentLabel;
    @FXML
    private Label testLabel;
    private double progress = 0;

    /**
     * Function which will increase progressbar.
     */
    @FXML
    void increaseProgressBar() {
        testLabel.setText(printCompany());
        progress += 1.0 / tripCharacteristics.getTime();
        SchedulFullnessBar.setProgress(progress);
        percentLabel.setText(Math.round(progress * 100) + "%");
    }
    Integer countOfDayEvents = getCountOfEventsOnOneDay(); // help variable for filling schedule.

    /**
     * Function for returning count of days.
     * @return Count of days
     * @throws IOException
     * @throws ClassNotFoundException
     */
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
    private int counter = 0, Day = 1;
    @FXML
    private ChoiceBox<String> ApatrmentsChoiceBox;

    /**
     * Initialize method - overriding method, but with function of filling choicebox.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ApatrmentsChoiceBox.getItems().addAll(getAllApartments());
        ChoiceEvent.getItems().addAll(getAllAllowed());
    }

    /**
     * Function for using patterns.
     * @param obj
     * @return Info in string
     */
    public String getAllInfo(Apartments obj) {
        obj.setCount();
        obj.setPrice();
        return obj.getInfo();
    }
    /**
     * Function for using patterns.
     *
     * @return Info in string
     */
    private String[] getAllApartments() {
        Apartments obj = new DeluxApartments();
        Apartments obj1 = new StandartApartments();
        Apartments obj2 = new Hostel();
        return new String[]{"Delux Apartments (" + getAllInfo(obj) +")", "Standart Apartments(" + getAllInfo(obj1) +")", "Hostel(" + getAllInfo(obj2) +")"};
    }

    /**
     * Activation of object.
     * @param obj Entertainment object for making it active
     * @return Activated object
     */
    private Entertainments setFactor(Entertainments obj) {
        obj.setFactor_A();
        obj.setFactor_C();
        obj.setFactor_D();
        obj.setFactor_L();
        obj.setFactor_P();
        return obj;
    }

    /**
     * Comparison for adding to choice list of user constructor items.
     * @param attractive place (factors)
     * @param user user (factors)
     * @return access to place of user.
     */
    private boolean compareObjectConditions(Entertainments attractive, User user) {
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

    /**
     * Initialization of objects, and providing a comparison.
     * @return all the places with user's access.
     */
    private String[] getAllAllowed() {
        ArrayList<String> AllAllowed = new ArrayList<>();
        setCollectiveSpecialities();
        AllAllowed.add("Own place");
        ClassicalArtMuseum CAM = new ClassicalArtMuseum();
        setFactor(CAM);
        HistoricalMuseum HM = new HistoricalMuseum();
        setFactor(HM);
        ModernArtMuseum MAM = new ModernArtMuseum();
        setFactor(MAM);
        DeluxRestourant DR = new DeluxRestourant();
        setFactor(DR);
        FamilyRestourant FR = new FamilyRestourant();
        setFactor(FR);
        FustFood FF = new FustFood();
        setFactor(FF);
        Aquapark A = new Aquapark();
        setFactor(A);
        Pool P = new Pool();
        setFactor(P);
        Sauna S = new Sauna();
        setFactor(S);
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
    private String value;
    @FXML
    private Label LabelLast;
    private String LabelText = "Day 1:";

    /**
     * Add events for one day.
     */
    public void addEventsForDay() {
        value = ChoiceEvent.getValue();
        LabelText += value + ", ";
        LabelLast.setText(LabelText);
        counter++;
        if (counter > countOfDayEvents) {
            JOptionPane.showMessageDialog(null, "It's more than your schedule plan... But you can choose more if you wish.");
        }
    }

    /**
     * Add new days to schedule.
     */
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

    public void checkMuseumRules() { // function for pattern.
        ClassicalArtMuseum obj = new ClassicalArtMuseum();
        obj.readRules(testLabel);
    }
    public void checkRestaurantMenu() { // function for pattern.
        DeluxRestourant obj = new DeluxRestourant();
        testLabel.setText(obj.checkMenu());
    }
    public void checkWaterSchedule() { // function for pattern.
        Sauna obj = new Sauna();
        testLabel.setText(obj.getSchedule());
    }

    /**
     * Clear day function.
     */
    public void clearDaySchedule() {
        int lastChar = LabelText.length() - 1;
        char j = LabelText.charAt(lastChar);
        while(j != ':') {
            j = LabelText.charAt(--lastChar);
        }
        LabelText = LabelText.substring(0, lastChar + 1);
        LabelLast.setText(LabelText);
    }

    /**
     * Function for reading information about program.
     */
    @Override
    public void readInformation() {
        MenuBarInterface.super.readInformation();
    }
    /**
     * Function for exiting program.
     */
    @Override
    public void exitTheProgramInMenu() {
        MenuBarInterface.super.exitTheProgramInMenu();
    }

    /**
     * Function for clearing schedule.
     */
    public void clearSchedule() {
        LabelText = "Day 1:";
        counter = 0;
        Day = 1;
        LabelLast.setText(LabelText);
    }

    /**
     * Function for saving schedule to txt file.
     */
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
