package lab5;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App extends Application {

    private GridPane cardGrid;

    private final String[] suits = {
    "clubs",
    "diamonds",
    "hearts",
    "spades"
};

    private final List<String> deck = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        // Create the deck
        createDeck();

        // Create the grid
        cardGrid = new GridPane();
        cardGrid.setHgap(20);
        cardGrid.setVgap(20);
        cardGrid.setAlignment(Pos.CENTER);

        // Display the cards
        displayCards();

        // Create Shuffle button
        Button shuffleButton = new Button("Shuffle");

        shuffleButton.setOnAction(e -> {
            Collections.shuffle(deck);
            displayCards();
        });

        HBox buttonBox = new HBox(shuffleButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new javafx.geometry.Insets(10));

        // Create layout
        BorderPane root = new BorderPane();
        root.setCenter(cardGrid);
        root.setBottom(buttonBox);

        // Create scene
        Scene scene = new Scene(root, 1400, 700);

        primaryStage.setTitle("52 Card Deck");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Create the deck of 52 cards
    private void createDeck() {

    // Clear the deck before creating new cards
    deck.clear();
    
    // Iterates through each suit and card number from 1 to 13
    for (String suit : suits) {
        for (int cardNumber = 1; cardNumber <= 13; cardNumber++) {
            deck.add("card-" + suit + "-" + cardNumber);
        }
    }
    }

    // Display cards in a GridPane
    private void displayCards() {

    // Clear the grid before displaying cards
    cardGrid.getChildren().clear();

    for (int i = 0; i < deck.size(); i++) {

        String cardName = deck.get(i);
        // Construct the image path for the current card
        String imagePath = "cards/" + cardName + ".png";

        var inputStream = getClass().getResourceAsStream(imagePath);

        Image image = new Image(inputStream);

        ImageView cardImage = new ImageView(image);

        cardImage.setFitWidth(85);
        cardImage.setFitHeight(120);
        cardImage.setPreserveRatio(true);

        int row = i / 13;
        int column = i % 13;

        cardGrid.add(cardImage, column, row);
        cardGrid.setStyle("-fx-background-color: green;"); // Set the background color of the grid to green
    }
}

    public static void main(String[] args) {
        launch(args);
    }
}