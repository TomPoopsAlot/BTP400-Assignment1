package ca.assignment1.assignment1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        GridPane gp = new GridPane();
        HBox hb = new HBox(10);

        gp.setAlignment(Pos.CENTER);
        gp.setHgap(10);
        gp.setVgap(10);

        Label title = new Label("Login Page");
        title.setFont(new Font("Arial", 25));
        gp.getChildren().add(title);

        gp.add(new Label("Username: "), 0 ,1);
        TextField userName = new TextField();
        gp.add(userName, 1, 1);

        gp.add(new Label("password: "), 0 ,2);
        PasswordField passWord = new PasswordField();
        gp.add(passWord, 1, 2);

        Button btnLogin = new Button("Login");

        hb.setAlignment(Pos.BOTTOM_RIGHT);
        hb.getChildren().add(btnLogin);
        gp.add(btnLogin, 1, 3);

        final Text actionTarget = new Text();
        gp.add(actionTarget, 1, 6);


        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = userName.getText();
                String password = passWord.getText();

                File f = new File("librarians.txt");

                if((username.equals("admin")) && (password.equals("admin"))){
                    stage.hide();
                    Stage st = new Stage();
                    GridPane gpAdmin = new GridPane();
                    HBox hbAdmin = new HBox(10);

                    gpAdmin.add(new Label("Name: "), 0 ,1);
                    TextField Name = new TextField();
                    gpAdmin.add(Name, 1, 1);

                    gpAdmin.add(new Label("ID: "), 0 ,2);
                    PasswordField ID = new PasswordField();
                    gpAdmin.add(ID, 1, 2);

                    Button btnAddLib = new Button("Add");

                    hbAdmin.setAlignment(Pos.BOTTOM_RIGHT);
                    hbAdmin.getChildren().add(btnAddLib);
                    gpAdmin.add(btnAddLib, 1, 3);

                    Scene sc = new Scene(gpAdmin, 400, 400);
                    st.setTitle("Library Management System");
                    st.setScene(sc);
                    st.show();
                }
                else{
                    System.out.println("WorksWrong");
                }
            }
        });

        Scene scr = new Scene(gp, 400, 400);
        stage.setTitle("Library Management System");
        stage.setScene(scr);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}