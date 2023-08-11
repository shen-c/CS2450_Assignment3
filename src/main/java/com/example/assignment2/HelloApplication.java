package com.example.assignment2;
import java.util.List;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        // Top Menu
        MenuBar menuBar = new MenuBar();
        Menu screensMenu = new Menu("MENU");
        MenuItem screenOneItem = new MenuItem("Customer");
        MenuItem screenTwoItem = new MenuItem("Orders");
        screensMenu.getItems().addAll(screenOneItem, screenTwoItem);
        menuBar.getMenus().add(screensMenu);
        root.setTop(menuBar);

        // Screen One Layout
        GridPane screenOne = new GridPane();
        screenOne.setHgap(10);
        screenOne.setVgap(10);
        screenOne.setPadding(new Insets(10));

        // Name
        Label nameLabel = new Label("Name");
        TextField nameField = new TextField();
        nameField.setPromptText("John, Jane, Bob");
        nameField.setPrefWidth(scene.getWidth() / 2);
        nameField.textProperty().addListener((observable, oldValue, newValue) -> System.out.println("Name: " + newValue));
        screenOne.add(nameLabel, 0, 0);
        screenOne.add(nameField, 0, 1);

        // Gender
        Label genderLabel = new Label("Gender");
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        RadioButton other = new RadioButton("Other");
        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);
        other.setToggleGroup(genderGroup);
        HBox genderBox = new HBox(10, male, female, other);
        genderGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> System.out.println("Gender: " + ((RadioButton) newValue).getText()));
        screenOne.add(genderLabel, 1, 0);
        screenOne.add(genderBox, 1, 1);

        // Phone
        Label phoneLabel = new Label("Phone");
        TextField phoneField = new TextField();
        phoneField.setPrefWidth(scene.getWidth() / 2);
        phoneField.textProperty().addListener((observable, oldValue, newValue) -> System.out.println("Phone: " + newValue));
        screenOne.add(phoneLabel, 0, 2);
        screenOne.add(phoneField, 0, 3);

        // Email
        Label emailLabel = new Label("Email");
        TextField emailField = new TextField();
        emailField.setPrefWidth(scene.getWidth() / 2);
        emailField.textProperty().addListener((observable, oldValue, newValue) -> System.out.println("Email: " + newValue));
        screenOne.add(emailLabel, 1, 2);
        screenOne.add(emailField, 1, 3);


        // Street
        Label streetLabel = new Label("Street");
        TextField streetField = new TextField();
        streetField.setPrefWidth(scene.getWidth() / 2);
        streetField.textProperty().addListener((observable, oldValue, newValue) -> System.out.println("Street: " + newValue));
        screenOne.add(streetLabel, 0, 4);
        screenOne.add(streetField, 0, 5);

        // City
        Label cityLabel = new Label("City");
        TextField cityField = new TextField();
        cityField.setPrefWidth(scene.getWidth() / 2);
        cityField.textProperty().addListener((observable, oldValue, newValue) -> System.out.println("City: " + newValue));
        screenOne.add(cityLabel, 1, 4);
        screenOne.add(cityField, 1, 5);

        // State
        Label stateLabel = new Label("State");
        TextField stateField = new TextField();
        stateField.setPrefWidth(scene.getWidth() / 2);
        stateField.textProperty().addListener((observable, oldValue, newValue) -> System.out.println("State: " + newValue));
        screenOne.add(stateLabel, 0, 6);
        screenOne.add(stateField, 0, 7);

        // Zip Code
        Label zipLabel = new Label("Zip Code");
        TextField zipField = new TextField();
        zipField.setPrefWidth(scene.getWidth() / 2);
        zipField.textProperty().addListener((observable, oldValue, newValue) -> System.out.println("Zip Code: " + newValue));
        screenOne.add(zipLabel, 1, 6);
        screenOne.add(zipField, 1, 7);



        // Screen Two
        GridPane screenTwo = new GridPane();
        screenTwo.setHgap(10);
        screenTwo.setVgap(10);
        screenTwo.setPadding(new Insets(10));

        // Number
        Label numberLabel = new Label("Number");
        TextField numberField = new TextField();
        numberField.setMaxWidth(100);
        numberField.textProperty().addListener((observable, oldValue, newValue) -> System.out.println("Number: " + newValue));
        screenTwo.add(numberLabel, 0, 0);
        screenTwo.add(numberField, 0, 1);

        // Date
        Label dateLabel = new Label("Date");
        DatePicker dateField = new DatePicker();
        GridPane.setHalignment(dateField, HPos.RIGHT);
        GridPane.setHalignment(dateLabel, HPos.RIGHT);
        dateField.setPrefWidth(scene.getWidth() / 5);
        dateField.valueProperty().addListener((observable, oldValue, newValue) -> System.out.println("Date: " + newValue));
        screenTwo.add(dateLabel, 1, 0);
        screenTwo.add(dateField, 1, 1);


        // Customer
        Label customerLabel = new Label("Customer");
        ComboBox<String> customerDropdown = new ComboBox<>();
        customerDropdown.setPrefWidth(scene.getWidth());
        GridPane.setColumnSpan(customerDropdown, GridPane.REMAINING);
        customerDropdown.getItems().addAll("John", "Bob", "Jane");
        screenTwo.add(customerLabel, 0, 2);
        screenTwo.add(customerDropdown, 0, 3);

        // Item
        Label itemLabel = new Label("Item");
        ComboBox<String> itemDropdown = new ComboBox<>();
        itemDropdown.setPrefWidth(scene.getWidth()/2);
        itemDropdown.getItems().addAll("Caesar Salad", "Cobb Salad", "Greek Salad");
        screenTwo.add(itemLabel, 0, 4);
        screenTwo.add(itemDropdown, 0, 5);

        // Price
        Label priceLabel = new Label("Price");
        TextField priceField = new TextField();
        priceField.setMaxWidth(120);
        GridPane.setHalignment(priceLabel, HPos.RIGHT);
        GridPane.setHalignment(priceField, HPos.RIGHT);
        priceField.textProperty().addListener((observable, oldValue, newValue) -> System.out.println("Price: " + newValue));
        screenTwo.add(priceLabel, 1, 4);
        screenTwo.add(priceField, 1, 5);

        // Orders
        Label ordersLabel = new Label("Orders");
        ListView<Order> orderListView = new ListView<>();
        orderListView.setPrefWidth(scene.getWidth());
        GridPane.setColumnSpan(orderListView, GridPane.REMAINING);
        screenTwo.add(ordersLabel, 0, 6);
        screenTwo.add(orderListView, 0, 7);


        // Create the buttons
        Button searchButton1 = new Button("Search");
        Button addButton1 = new Button("Add");
        Button updateButton1 = new Button("Update");
        Button deleteButton1 = new Button("Delete");
        Button searchButton2 = new Button("Search");
        Button addButton2 = new Button("Add");
        Button updateButton2 = new Button("Update");
        Button deleteButton2 = new Button("Delete");

        // Set the horizontal alignment of each button to right
        GridPane.setHalignment(searchButton2, HPos.RIGHT);
        GridPane.setHalignment(addButton2, HPos.RIGHT);
        GridPane.setHalignment(updateButton2, HPos.RIGHT);
        GridPane.setHalignment(deleteButton2, HPos.RIGHT);
        GridPane.setHalignment(searchButton1, HPos.RIGHT);
        GridPane.setHalignment(addButton1, HPos.RIGHT);
        GridPane.setHalignment(updateButton1, HPos.RIGHT);
        GridPane.setHalignment(deleteButton1, HPos.RIGHT);

        // Add Hbox for buttons
        HBox buttonBox2 = new HBox(3);
        buttonBox2.minWidth(300);
        buttonBox2.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox2.getChildren().addAll(searchButton2, addButton2, updateButton2, deleteButton2);

        HBox buttonBox1 = new HBox(3);
        buttonBox1.minWidth(300);
        buttonBox1.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox1.getChildren().addAll(searchButton1, addButton1, updateButton1, deleteButton1);

        //add buttons to screens
        screenOne.add(buttonBox1, 1, 8);
        GridPane.setHalignment(buttonBox1, HPos.RIGHT);
        screenTwo.add(buttonBox2, 1, 8);
        GridPane.setHalignment(buttonBox2, HPos.RIGHT);


        // Menu actions
        screenOneItem.setOnAction(event -> root.setCenter(screenOne));
        screenTwoItem.setOnAction(event -> {
            root.setCenter(screenTwo);
            updateOrderListView(orderListView);
        });

        //Search button customer
        searchButton1.setOnAction(event -> {
            String nameToSearch = nameField.getText().trim();
            Map<String, String[]> data = readCSV("customer.csv");
            String[] customerData = data.get(nameToSearch);
            if (customerData != null) {
                nameField.setText(nameToSearch);
                // Assuming the order in the CSV is: name, gender, phone, email, street, city, state, zip
                if (customerData[0].equalsIgnoreCase("male")) male.setSelected(true);
                else if (customerData[0].equalsIgnoreCase("female")) female.setSelected(true);
                else other.setSelected(true);
                phoneField.setText(customerData[1]);
                emailField.setText(customerData[2]);
                streetField.setText(customerData[3]);
                cityField.setText(customerData[4]);
                stateField.setText(customerData[5]);
                zipField.setText(customerData[6]);
            } else {
                System.out.println("No data found for: " + nameToSearch);
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Name not found");
                alert.setContentText("The customer's name you entered was not found in the database.");
                alert.showAndWait();
            }
        });

        //add button customer
        addButton1.setOnAction(event -> {
            if (validateAllFields(screenOne)) {
                String[] values = {
                        nameField.getText().trim(),
                        ((RadioButton) genderGroup.getSelectedToggle()).getText(),
                        phoneField.getText().trim(),
                        emailField.getText().trim(),
                        streetField.getText().trim(),
                        cityField.getText().trim(),
                        stateField.getText().trim(),
                        zipField.getText().trim()
                };

                writeToCSV("customer.csv", values);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Data added successfully!");
                alert.showAndWait();
            }
        });

        updateButton1.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Not Working");
            alert.setHeaderText(null);
            alert.setContentText("The Update button is not working");
            alert.showAndWait();
        });

        deleteButton1.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Not Working");
            alert.setHeaderText(null);
            alert.setContentText("The Delete button is not working");
            alert.showAndWait();
        });

        addButton2.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Not Working");
            alert.setHeaderText(null);
            alert.setContentText("The Add function is not working");
            alert.showAndWait();
        });

        updateButton2.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Not Working");
            alert.setHeaderText(null);
            alert.setContentText("The Update function is not working");
            alert.showAndWait();
        });

        deleteButton2.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Not Working");
            alert.setHeaderText(null);
            alert.setContentText("The Delete function is not working");
            alert.showAndWait();
        });

        searchButton2.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Not Working");
            alert.setHeaderText(null);
            alert.setContentText("The Search function is not working");
            alert.showAndWait();
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX App");
        primaryStage.show();
    }

    //used to validate if all fields are filled in a gridpane
    public boolean validateAllFields(GridPane gridPane) {
        for (Node node : gridPane.getChildren()) {
            if (node instanceof TextField) {
                TextField textField = (TextField) node;
                if (!validateNotEmpty(textField)) {
                    return false;
                }
            }
        }
        return true;
    }

    //used to validate if a single textfield is empty
    public boolean validateNotEmpty(TextField textField) {
        String fieldName = (String) textField.getUserData();
        if (textField.getText() == null || textField.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("No field can be empty!");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    //CSV writer
    public void writeToCSV(String filename, String[] values) {

        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.append(String.join(",", values));
            writer.append("\n");
            writer.flush();
            writer.close();
            System.out.println("successfully wrote to csv");
        } catch (IOException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Failed to write to file: " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    //CSV reader specifically for orders
    public List<Order> readCsvToOrders(String filename) {
        List<Order> orders = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Order order = new Order(values[0], values[1], values[2], values[3], values[4]);
                orders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // CS reader
    public Map<String, String[]> readCSV(String filename) {
        Map<String, String[]> data = new HashMap<>();

        try {
            File file = new File(filename);

            if (!file.exists()) {
                System.out.println("Unable to find the specified file.");
                return data;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 8) {
                    data.put(values[0], new String[]{values[1], values[2], values[3], values[4], values[5], values[6], values[7]});
                }
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    // Update ListView of orders
    private void updateOrderListView(ListView<Order> x) {
        List<Order> orders = readCsvToOrders("orders.csv");
        x.getItems().clear();
        x.getItems().addAll(orders);
    }
}