package app.oop_proj.controllers;

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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;

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
                company.get(1).isLgbt() +"\nPets:"+ company.get(1).isPets() +"\nDisablts:"+ company.get(1).isDisabilities());
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
    private TreeTableView<String> CoolDayTable;
    @FXML
    private Button SDGHButton;
    @FXML
    private Button SSButton;
    @FXML
    private ProgressBar SchedulFullnessBar;
    @FXML
    private ChoiceBox<String> ChoiceEvent;
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
        percentLabel.setText(progress*100 + "%");
    }
    public void AddEventButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationInAt.class.getResource("choicepannel.fxml"));
        Parent root = fxmlLoader.load(); // Load the FXML file and get the root node
        Constructor controller = fxmlLoader.getController(); // Get the controller instance
        controller.initializeChoicePanel(); // Call the method on the controller instance
        Stage stage = new Stage();
        Scene scene = new Scene(root, 275, 115);
        stage.setScene(scene);
        stage.show();
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
            countOfDayEvents = 2;
        } if(tripCharacteristics.isPassiveTrip()) {
            countOfDayEvents = 4;
        }
        return countOfDayEvents;
    }
    double countOfDays = tripCharacteristics.getTime();
    int counter = 0, counter1 = 0;
    TreeItem<String > root = new TreeItem<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i = 0; i < countOfDays; i++) {
            TreeItem<String> parent = new TreeItem<>("Day " + i);
            if (tripCharacteristics.isPassiveTrip()) {
                for(int j = 0; j < 2; j++) {
                    TreeItem<String> item = new TreeItem<>("");
                    parent.getChildren().add(item);
                }
            } if (tripCharacteristics.isActiveTrip()) {
                for(int j = 0; j < 4; j++) {
                    TreeItem<String> item = new TreeItem<>("");
                    parent.getChildren().add(item);
                }
            }
            root.getChildren().add(parent);
            root = parent;
        }

        DayCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<String, String> param) -> {
            String value = param.getValue().getValue();
            return new SimpleStringProperty(value);
        });

        /*if (help) {
            if (counter1 < countOfDays) {
                parent1 = new TreeItem<>(Double.toString(countOfDays));
                root.getChildren().add(parent1);
                help = false;
                counter1++;
            } else {
                JOptionPane.showMessageDialog(null, "Your trip is full!");
                return;
            }
        }
        if (parent1 != null && counter < countOfDayEvents){
            TreeItem<String> item = new TreeItem<>(value);
            parent1.getChildren().add(item);
            NameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<String, String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<String, String> param) {
                    return new SimpleStringProperty(param.getValue().getValue());
                }
            });
            counter++;
        } else {
            help = true;
            counter = 0;
        }
        CoolDayTable.setShowRoot(false);*/
    }

    public void setFactor(Entertainments obj){
        obj.setFactor_A();
        obj.setFactor_C();
        obj.setFactor_D();
        obj.setFactor_L();
        obj.setFactor_P();
    }
    public void initializeChoicePanel() {
        ChoiceEvent.getItems().addAll(getAllAllowed());
    }
    public boolean compareObjectConditions(Entertainments attractive, User user) {
        boolean check = false;
        if (attractive.isChildrenFactor() == user.isChild()) {
            check = true;
        }
        if (attractive.isPetsFactor() == user.isPets()) {
            check = true;
        }
        if (attractive.isLGBTQ_factor() == user.isLgbt()) {
            check = true;
        }
        if (attractive.isDisabilitiesFactor() == user.isDisabilities()) {
            check = true;
        }
        if (attractive.isRiskOfAllergy() == user.isAllergy()) {
            check = true;
        }
        return check;
    }
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
        DeluxRestourant DR= new DeluxRestourant();
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
    String value;

    public String getValueParam() {
        return value;
    }

    public void closeChoicePannel() throws IOException {
        value = ChoiceEvent.getValue();
        ConfirmEvent.getScene().getWindow().hide();
    }

    public void addDataToTable() {

    }
}
