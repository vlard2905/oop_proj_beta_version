package app.oop_proj.controllers;

import app.oop_proj.ApplicationInAt;
import app.oop_proj.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

public class ControllerEditCompany implements Serializable, Initializable {

    @Serial
    private static final long serialVersionUID = -4369099107170258615L;
    int countOfUsers = 0;
    @FXML
    private Button AddNewUserButton;

    @FXML
    private Button BackButton;
    @FXML
    private AnchorPane DetailsOfUsingEditDialog;

    @FXML
    private Button EditCurrentCompanyButton;

    @FXML
    private Button NextButton;

    @FXML
    private ResourceBundle resources;

    @FXML
    private TreeView<String> treeView;

    @FXML
    private URL location;
    @FXML
    public void switchToScene3(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(ApplicationInAt.class.getResource("scene3.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 800, 500);
            stage.setScene(scene);
            stage.show();
    }

    public void selectItem() {

    }

    @FXML
    public void switchToScene4(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationInAt.class.getResource("scene4.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {

    }

    FileInputStream userD = null;
    ObjectInputStream in = null;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        TreeItem<String> rootItem = new TreeItem<>("Current members list");
        treeView.setRoot(rootItem);
        try {
            userD = new FileInputStream("UserDATA.bin");
            in = new ObjectInputStream(userD);
            User newUser = null;
            while ((newUser = (User) in.readObject()) != null) {
                TreeItem<String> newTreeItem = new TreeItem<>(newUser.getNameOfUser());
                TreeItem<String> newTreeItem1 = new TreeItem<>(Integer.toString(newUser.getAgeOfUser()));
                TreeItem<String> newTreeItem2 = new TreeItem<>(newUser.isSpecialties());
                TreeItem<String> newTreeItem3 = new TreeItem<>(newUser.isSex());
                newTreeItem.getChildren().addAll(newTreeItem1, newTreeItem2, newTreeItem3);
                rootItem.getChildren().add(newTreeItem);
            }
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (in != null) in.close();
                if (userD != null) userD.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
