package com.example.hrmanagement_bishal_amgai;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Label messageText;

    @FXML
    protected void onHelloButtonClick() {

        try {
            Parent secondScene = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            // Create a new stage for the second scene
            Stage secondStage = new Stage();
            secondStage.setTitle("User Scene");
            secondStage.setScene(new Scene(secondScene));
            Stage firstSceneStage = (Stage) messageText.getScene().getWindow();
            firstSceneStage.close();
            // Show the second stage
            secondStage.show();}
        catch (IOException e) {
            e.printStackTrace();
        }


        }


    }