package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private Label language_title;
    @FXML
    private Label first_name;
    @FXML
    private Label second_name;
    @FXML
    private Label email_label;


    @FXML
    private TextField first;
    @FXML
    private TextField email;
    @FXML
    private TextField second;

    @FXML
    private Button save;
    @FXML
    private void handleButtonAction() {
        String table_name = null;
        String selectedLanguage = menu.getValue();
        switch (selectedLanguage) {
            case "English" -> table_name = "employee_en";
            case "Farsi" -> table_name = "employee_fa";
            case "Japanese" -> table_name = "employee_jp";
        }
        AddEmployees.setUser(first.getText(), second.getText(), email.getText(), table_name);
        first.setText("");
        second.setText("");
        email.setText("");

        System.out.println("Save button clicked!");
    }

    @FXML
    private ChoiceBox<String> menu;
    @FXML
    private void handleChange() {
        String selectedLanguage = menu.getValue();
        switch (selectedLanguage) {
            case "English" -> loadLanguage("en");
            case "Farsi" -> loadLanguage("fa");
            case "Japanese" -> loadLanguage("jp");
        }

    }
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void loadLanguage(String language) {
        Locale locale = new Locale(language);
        ResourceBundle bundle = ResourceBundle.getBundle("text", locale);
        language_title.setText(bundle.getString("language"));
        first_name.setText(bundle.getString("first"));
        second_name.setText(bundle.getString("last"));
        email_label.setText(bundle.getString("email"));
        save.setText(bundle.getString("save"));
        stage.setTitle(bundle.getString("title"));

    }
    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

}