package com.student.student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class holds all the information regarding the Student. It takes care of getters, log-in and toString
 * @author Tom Schwartz
 */
public class Student implements Serializable {

        private Roles role;
        private String name;
        private String username;
        private String password;
        private ArrayList<Media> booksTaken;

    /**
     * This function is the constructor
     * @param name This parameter is the students name -- [String]
     * @param username This parameter is the students username -- [String]
     * @param password This parameter is the students password -- [Roles]
     */
    public Student(String name, String username, String password, Roles role){
        super();
        this.role = role;
        this.name = name;
        this.username = username;
        this.password = password;
        booksTaken = new ArrayList<>();
    }

    /**
     *  This function is a getter for the students booksTaken
     * @return Returns the booksTaken variable of the student
     */
    public ArrayList<Media> getBooksTaken() {
        return booksTaken;
    }

    /**
     *  This function is a getter for the students username
     * @return returns the username variable of the student
     */
    public String getUsername(){
          return username;
    }

    /**
     *  This function is a getter for the students name
     * @return returns the name variable of the student
     */
    public String getName(){
        return name;
    }

    public Roles getRole(){
        return role;
    }

    /**
     * This function validates the student login and checks to see if the
     * @param username This parameter is the students username -- [String]
     * @param password This parameter is the students password -- [String]
     * @return returns true or false, depends on if the username and password match up to the correct ones
     */
    public boolean ValidateLogin(String username, String password)
    {
            return this.username.equals(username) && this.password.equals(password);
    }

    /**
     * This function Overrides the toString function
     * @return returns the booksTaken as a string
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Name: " + name);

        out.append("\nBooks Taken:\n");
        for(Media media: booksTaken){
            out.append(media.getName()).append("\n");
        }

        out.append("\n");
        return out.toString();
    }

    /**
     * This function adds a media to the booksTaken of a student
     * @param media -- [Media]
     */
    public void assign(Media media) {
        booksTaken.add(media);
    }

    // UN-NEEDED IN Final --TESTING ONLY--
    /**
     * This function lets the student return a media back into the library
     * @param media This parameter is an object of media used to add availability to medias -- [Media]
     * @return returns either true of false depending on the result
     */
    public boolean returnMedia(Media media) {
        for (int i=0; i< booksTaken.size(); i++) {
             if (booksTaken.get(i) == media) {
                 booksTaken.remove(i);
                 media.returned();
                 return true;
             }
       }
       return false;
    }
}
