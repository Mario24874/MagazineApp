package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MagazineApp extends Application {
    @Override
    public void start(Stage stage) {
        TextArea reportInput = new TextArea("Enter report here");
        TextArea magazineInput = new TextArea("Enter magazine text here");
        Button checkButton = new Button("Check");
        Label resultLabel = new Label();

        checkButton.setOnAction(e -> {
            boolean result = MagazineReport.canWriteReport(reportInput.getText(), magazineInput.getText());
            resultLabel.setText("Can write report: " + result);
        });

        VBox layout = new VBox(10, reportInput, magazineInput, checkButton, resultLabel);
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Magazine Report Checker");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class MagazineReport {
    public static boolean canWriteReport(String report, String magazine) {
        int[] charCount = new int[128];
        for (char c : magazine.toCharArray()) {
            charCount[c]++;
        }
        for (char c : report.toCharArray()) {
            if (charCount[c] == 0) return false;
            charCount[c]--;
        }
        return true;
    }
}