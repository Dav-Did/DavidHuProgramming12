package com.example.module5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AddUsersView {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    /**
     * onSubmit triggered by the submit button
     * Checks for empty password or empty username and returns an error screen.
     * @param actionEvent
     */

    public void onSubmit(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()){
            DatabaseHelper.addUser(username,password);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Add User Successfully");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fail");
            alert.setHeaderText(null);
            alert.setContentText("Fail to Add User");
        }

    }
}
