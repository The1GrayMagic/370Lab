package lab5;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



//chatgpt example to use to understand code



public class App extends Application {

    private final Random random = new Random();

    private final List<String> cards = new ArrayList<>();

    private ImageView cardImage;
    private Label cardName;


    @Override
    public void start(Stage stage) {

        // -------------------------
        // Add card image file names
        // -------------------------

        cards.add("card-diamonds-2.png");
        cards.add("card-diamonds-3.png");
        cards.add("card-hearts-king.png");
        cards.add("card-spades-ace.png");

        // Add the rest of your card PNG names here


        // -------------------------
        // Title
        // -------------------------

        Label title = new Label("Pick a Random Card");


        // -------------------------
        // Card Image
        // -------------------------

        cardImage = new ImageView();

        cardImage.setFitWidth(200);
        cardImage.setFitHeight(300);
        cardImage.setPreserveRatio(true);


        // -------------------------
        // Card Name
        // -------------------------

        cardName = new Label("No card selected");


        // -------------------------
        // Random Card Button
        // -------------------------

        Button randomButton = new Button("Pick Card");

        randomButton.setOnAction(event -> {
            pickRandomCard();
        });


        // -------------------------
        // Layout
        // -------------------------

        VBox root = new VBox();

        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(
                title,
                cardImage,
                cardName,
                randomButton
        );


        // -------------------------
        // Scene
        // -------------------------

        Scene scene = new Scene(root, 500, 600);


        // Optional CSS
        scene.getStylesheets().add(
                getClass()
                        .getResource("/styles.css")
                        .toExternalForm()
        );


        // -------------------------
        // Window
        // -------------------------

        stage.setTitle("Random Card Picker");

        stage.setScene(scene);

        stage.show();
    }


    // --------------------------------
    // Pick Random Card
    // --------------------------------

    private void pickRandomCard() {

        int randomIndex = random.nextInt(cards.size());

        String selectedCard = cards.get(randomIndex);


        Image image = new Image(
                getClass()
                        .getResource("/cards/" + selectedCard)
                        .toExternalForm()
        );


        cardImage.setImage(image);

        cardName.setText(selectedCard);
    }


    // --------------------------------
    // Main
    // --------------------------------

    public static void main(String[] args) {

        launch(args);
    }
}