package com.example.module5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import org.w3c.dom.Text;

import java.io.IOException;


public class HelloController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    /** onLoginButtonClick triggered by the login button
     * Checks if user entered password and username correctly with validateLogin
     * Switch
     * @param event
     */

    @FXML
    protected void onLoginButtonClick(ActionEvent event){

        String username = usernameField.getText();
        String password = passwordField.getText();

        if (DatabaseHelper.validateLogin(username,password)){
            System.out.println("Log in successfully!");
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();

            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("add_users_view.fxml"));
                Parent root = loader.load();

                Stage newStage = new Stage();
                newStage.setTitle("ADD");
                newStage.setScene(new Scene(root));
                newStage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failure");
            alert.setHeaderText(null);
            alert.setContentText("Login Failure: Incorrect username or password");
            alert.showAndWait();
        }


    }
}