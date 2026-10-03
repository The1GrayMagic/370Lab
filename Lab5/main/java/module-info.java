module lab5 {
    requires javafx.controls;
    requires javafx.fxml;

    opens lab5 to javafx.fxml;
    exports lab5;
}
