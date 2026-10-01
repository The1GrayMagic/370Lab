package lab5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Grid extends Application {

    private final List<Button> cards = new ArrayList<>();
    // private final List<Card> cards = new ArrayList<>();





    @Override
    public void start(Stage stage) {

        String namebutton;
        for (int i = 0; i < 52; i++) {
            namebutton = "Randomize " + i;
           // cards.add(new Card(namebutton ));
            cards.add(new Button(namebutton ));

        }





        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setGridLinesVisible(true);
        grid.setVgap(5);
        grid.setHgap(5);

        int index =0;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 13; y++) {
                //grid.add(cards.get(index), x, y);
                index++;
            }
        }





        VBox root = new VBox();

        root.setSpacing(20);
        grid.setAlignment(Pos.CENTER); //center grid not root.

        root.getChildren().addAll(

                grid
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

        stage.setTitle("blank");

        stage.setScene(scene);

        stage.show();
    }

    private Button newButtonMethod(int numb){
        String name = "random " + numb;

        Button randomButton = new Button(name);

        randomButton.setOnAction(event -> {
            Button clickedButton = (Button) event.getSource();

            System.out.println(clickedButton.getText());

        });

        return randomButton;
    }

    public static void main(String[] args) {

        launch(args);
    }

    public void getListofNames(){

    };
  
}

//trying to make the way to store and sort the images/cards
//class Card extends Image {

  //  private String locationDir;
    //Image image ;

    // public Card (String location){
         //locationDir = location;

       //  super(
               //  getClass()
          //               .getResource("/cards/" + locationDir)
        //                 .toExternalForm()
     //    );
 //}


//}
