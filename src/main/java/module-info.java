module ca.assignment1.assignment1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens ca.assignment1.assignment1 to javafx.fxml;
    exports ca.assignment1.assignment1;
}