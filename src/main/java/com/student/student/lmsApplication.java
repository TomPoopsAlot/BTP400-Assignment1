package com.student.student;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class lmsApplication extends Application {

    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Media> listOfMedia = new ArrayList<>();
    public static Scene currentScene;

    @Override
    public void start(Stage stage) throws IOException {

        students.add(new Student("Johnny","stu1","stu1", Roles.GRADSTUDENT));
        students.add(new Student("Ryan","stu2","stu2", Roles.ALUMNI));
        students.add(new Student("Billy","stu3","stu3", Roles.CURRENT));

        listOfMedia.add(new Media("Java 101", Category.BOOK, 10));
        listOfMedia.add(new Media("Java 202", Category.BOOK, 5));
        listOfMedia.add(new Media("Java 303", Category.BOOK, 7));
        listOfMedia.add(new Media("C++ Tutorial 1", Category.MOVIE, 3));
        listOfMedia.add(new Media("C++ Tutorial 2", Category.MOVIE, 4));

        listOfMedia.get(0).borrow(students.get(0));
        listOfMedia.get(3).borrow(students.get(0));

        listOfMedia.get(1).borrow(students.get(1));
        listOfMedia.get(2).borrow(students.get(1));

        listOfMedia.get(1).borrow(students.get(2));
        listOfMedia.get(2).borrow(students.get(2));

        FXMLLoader fxmlLoader = new FXMLLoader(lmsApplication.class.getResource("StudentLogin.fxml"));
        currentScene = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("Library Management System!");
        stage.setScene(currentScene);
        stage.show();
    }

    /**
     * This function changes the scene from the login to the student
     * @param fxmlFile This Parameter is the name of the fxmlFile that will be changed
     * @throws IOException throws IOException if something is wrong
     */
    public static void ChangeScene(String fxmlFile) throws IOException{
        Window window = currentScene.getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(lmsApplication.class.getResource(fxmlFile));
        Stage stage = (Stage) window;
        currentScene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(currentScene);
    }

    /**
     * This function calls the launch function and starts the whole code
     * @param args String[] for args
     */
    public static void main(String[] args) {
        launch();
    }
}