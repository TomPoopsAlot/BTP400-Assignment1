package com.student.student;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This class is responsible for the Student scene
 * @author Tom Schwartz
 */
public class studentController implements Initializable {

    public static String username;

    @FXML private ListView<String> mediaList;
    @FXML private ListView<String> borrowingList;

    @FXML private Text nameText;
    @FXML private Text roleText;

    @FXML private Button printButton;
    @FXML private Text success;

    /**
     * This function is the initial start of the fxml file and what changes will be made
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        LoadMedia();
        LoadInventory();

        int index = GetCurrentStudentIndex();

        nameText.setText("");
        roleText.setText("");
        nameText.setText("Name: " + lmsApplication.students.get(index).getName());
        roleText.setText("Status: " + lmsApplication.students.get(index).getRole().toString());
        success.setVisible(false);
    }

    /**
     * This function loads up the media and all data on it
     */
    private void LoadMedia(){
        mediaList.getItems().clear();
        for(Media med : lmsApplication.listOfMedia){
            mediaList.getItems().add(String.valueOf(med));
        }
        mediaList.refresh();
    }

    /**
     * This function loads the books borrowed of the student
     */
    private void LoadInventory(){

        int index = 0;

        for (int i = 0; i < lmsApplication.students.size(); i ++){
            if (lmsApplication.students.get(i).getUsername().equals(username)){
                index = i;
                break;
            }
        }

        borrowingList.getItems().clear();
        for(Media med : lmsApplication.students.get(index).getBooksTaken()){
            borrowingList.getItems().add(String.valueOf(med));
        }
        borrowingList.refresh();
    }

    /**
     * This function gets the current students index out of the list of students
     * @return returns the index of the current student -- [int]
     */
    private int GetCurrentStudentIndex(){
        int index = 0;

        for (int i = 0; i < lmsApplication.students.size(); i ++){
            if (lmsApplication.students.get(i).getUsername().equals(username)){
                index = i;
                break;
            }
        }
        return index;
    }

    @FXML private TextField titleTextField;

    /**
     * This function searchs for the book/movie/etc... from the list of medias
     * @throws IOException
     */
    @FXML
    protected void searchBook() throws IOException {

    String search_text = titleTextField.getText().strip().toLowerCase();
        LoadMedia();

        if (search_text.length() >= 2) {
            ArrayList<String> results = new ArrayList<>();

            for(String book: mediaList.getItems()) {
                if (book.toLowerCase().contains(search_text)) results.add(book);
            }

            mediaList.getItems().clear();
            if (results.size() > 0){
                for(String found_book : results) mediaList.getItems().add(found_book);
                mediaList.refresh();
            }
        }
    }

    /**
     * This function writes the students borrowing books in the txt file.
     * @throws IOException
     */
    @FXML
    protected void WriteListToTextFile() throws IOException{

        int index = GetCurrentStudentIndex();

        FileWriter writer = new FileWriter("listOfMedia.txt");
        for(Media med : lmsApplication.students.get(index).getBooksTaken()){
            writer.write(med + System.lineSeparator());
        }
        writer.close();

        success.setVisible(true);
    }
}
