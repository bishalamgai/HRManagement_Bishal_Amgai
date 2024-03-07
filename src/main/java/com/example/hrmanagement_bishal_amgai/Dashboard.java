package com.example.hrmanagement_bishal_amgai;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard {
    public Button admin;

    public void Exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void Admin(ActionEvent actionEvent) throws IOException {
        Parent secondScene = FXMLLoader.load(getClass().getResource("Employee.fxml"));
        // Create a new stage for the second scene
        Stage secondStage = new Stage();
        secondStage.setTitle("User Scene");
        secondStage.setScene(new Scene(secondScene));
        Stage firstSceneStage = (Stage) admin.getScene().getWindow();
        firstSceneStage.close();
        // Show the second stage
        secondStage.show();}
    }

