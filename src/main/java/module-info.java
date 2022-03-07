module com.student.student {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.student.student to javafx.fxml;
    exports com.student.student;
}