package one;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Gui extends Application {

    private final HelperClass helper = new HelperClass();
    private final ShoppingCart shoppingCart = new ShoppingCart();

    private TextField nameField = new TextField();
    private TextField priceField = new TextField();
    private TextField quantityField = new TextField();
    private Button getResult = new Button();
    private Button addItem = new Button();
    private Button displayButton = new Button();
    private Label name = new Label();
    private Label price = new Label();
    private Label quantity = new Label();
    private Label addedLabel = new Label();
    private Label resultLabel = new Label("");


    private void updateUI() {
        nameField.setPromptText(helper.getMessage("prompt.itemName"));
        priceField.setPromptText(helper.getMessage("prompt.itemPrice"));
        quantityField.setPromptText(helper.getMessage("prompt.itemQuantity"));
        getResult.setText(helper.getMessage("total.bill"));
        displayButton.setText(helper.getMessage("prompt.displayButton"));
        addItem.setText(helper.getMessage("prompt.addItem"));
        name.setText(helper.getMessage("field.name"));
        price.setText(helper.getMessage("field.price"));
        quantity.setText(helper.getMessage("field.quantity"));
        addedLabel.setText(helper.getMessage("prompt.itemAdded"));
        resultLabel.setText(helper.getMessage("total.bill"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        HBox langBar = getHBox();

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(16));

        ColumnConstraints labelCol = new ColumnConstraints(80);
        ColumnConstraints fieldCol = new ColumnConstraints();
        fieldCol.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().addAll(labelCol, fieldCol);

        quantityField.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("\\d*(\\.\\d*)?")) {
                return change;
            }
            return null;
        }));
        priceField.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("\\d*(\\.\\d*)?")) {
                return change;
            }
            return null;
        }));


        // Labels in col 0, fields in col 1
        grid.add(name, 0, 0);
        grid.add(price, 0, 1);
        grid.add(quantity, 0, 2);
        grid.add(nameField, 1, 0);
        grid.add(priceField, 1, 1);
        grid.add(quantityField, 1, 2);

        String fieldStyle = "-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #cccccc; -fx-padding: 4 8 4 8;";
        nameField.setStyle(fieldStyle);
        priceField.setStyle(fieldStyle);
        quantityField.setStyle(fieldStyle);

        Label addedLabel = new Label();
        addedLabel.setStyle("-fx-text-fill: #4caf50; -fx-font-size: 12;");

        addItem.setStyle("-fx-background-color: #5b8dd9; -fx-text-fill: white; -fx-background-radius: 5;");
        getResult.setStyle("-fx-background-color: #5b8dd9; -fx-text-fill: white; -fx-background-radius: 5;");
        displayButton.setStyle("-fx-background-color: #7aab7a; -fx-text-fill: white; -fx-background-radius: 5;");

        HBox addItemRow = new HBox(10, addItem, addedLabel);
        addItemRow.setPadding(new Insets(0, 16, 8, 16));
        addItemRow.setAlignment(Pos.CENTER_LEFT);

        addItem.setOnAction(e -> {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());
            shoppingCart.addItem(name, new Item(price, quantity));
            nameField.clear();
            priceField.clear();
            quantityField.clear();
        });


        resultLabel.setWrapText(true);
        resultLabel.setStyle("-fx-text-fill: #333333; -fx-font-size: 13;");

        HBox buttonRow = new HBox(10, getResult, displayButton);
        buttonRow.setPadding(new Insets(0, 16, 8, 16));

        HBox resultRow = new HBox(resultLabel);
        resultRow.setPadding(new Insets(0, 16, 12, 16));

        getResult.setOnAction(e -> resultLabel.setText(helper.getMessage("total.bill") + shoppingCart.getTotalBill()));
        displayButton.setOnAction(e -> resultLabel.setText(shoppingCart.displayBill()));

        updateUI();

        VBox card = new VBox(grid, addItemRow, buttonRow, resultRow);
        card.setStyle("-fx-background-color: white; -fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color: #dddddd; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.08), 8, 0, 0, 2);");
        card.setPadding(new Insets(4, 0, 4, 0));

        VBox root = new VBox(langBar, card);
        root.setPadding(new Insets(16));
        root.setSpacing(14);
        root.setStyle("-fx-background-color: #efefef; -fx-font-family: 'Segoe UI', sans-serif;");

        Scene scene = new Scene(root, 420, 360);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Shopping Cart");
        primaryStage.show();
    }

    private HBox getHBox() {
        Button urdu = new Button("اردو");
        Button english = new Button("English");
        Button japanese = new Button("日本語");
        Button finnish = new Button("Suomi");
        Button swedish = new Button("Svenska");

        urdu.setOnAction(e -> {
            helper.setLocale("ur");
            updateUI();
        });
        english.setOnAction(e -> {
            helper.setLocale("en");
            updateUI();
        });
        japanese.setOnAction(e -> {
            helper.setLocale("ja");
            updateUI();
        });
        finnish.setOnAction(e -> {
            helper.setLocale("fi");
            updateUI();
        });
        swedish.setOnAction(e -> {
            helper.setLocale("sv");
            updateUI();
        });

        HBox langBar = new HBox(urdu, english, japanese, finnish, swedish);
        langBar.setPadding(new Insets(10));
        langBar.setSpacing(10);
        langBar.setStyle("-fx-background-color: #786565; -fx-background-radius: 8;");
        return langBar;
    }
}