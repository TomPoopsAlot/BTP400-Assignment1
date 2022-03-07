package com.student.student;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

import java.io.IOException;

import static com.student.student.lmsApplication.*;

/**
 * This class is responsible for the Login scene
 * @author Tom Schwartz
 */
public class lmsController {

    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordTextField;
    @FXML private Text invalidLoginText;

    @FXML private Button loginButton;

    /**
     * This function checks the student login when the button is clicked
     * @throws IOException
     */
    @FXML
    protected void loginButtonClicked() throws IOException {
        System.out.println("Clicked Button");

        boolean foundLogin = false;

        for (Student student : lmsApplication.students){
            if (student.ValidateLogin(usernameTextField.getText(), passwordTextField.getText())){
                foundLogin = true;
            }
        }

        if (foundLogin){
            System.out.println("Valid Login!");
            studentController.username = usernameTextField.getText();
            lmsApplication.ChangeScene("student.fxml");
        }
        else {
            invalidLoginText.setVisible(true);
        }
    }


}