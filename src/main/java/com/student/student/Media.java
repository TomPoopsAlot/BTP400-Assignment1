package com.student.student;

import java.io.Serializable;

/**
 * This class holds all the information regarding the Media. It takes care of getters, toString,
 * search for searching the database, and  borrowing and returning media copies.
 * @author Tom Schwartz
 */
enum Category implements Serializable {
    BOOK,
    MAGAZINE,
    MOVIE
}
public class Media implements Serializable {
    private int owned;
    private int available;
    private String name;
    private Category category;

    /**
     * This is the constructor for the Media class
     * @param name This parameter is the students name -- [String]
     * @param category This parameter is the Category -- [Category]
     * @param owned This parameter is the owned amount of books/movies/etc... -- [int]
     */
    public Media(String name, Category category, int owned) {
        super();
        this.name = name;
        this.owned = owned;
        this.available = owned;
        this.category = category;

    }

    /**
     *  This function is a getter for the Media's name & category
     * @return returns the Media's name and category
     */
    public String getName() {
        return "--" + name + ", Category: " + category;
    }

    // UN-NEEDED IN Final --TESTING ONLY--
    /**
     * This function lets a student borrow a book
     * @param stu This parameter is an object of Student
     * @return returns either true or false depending on the results
     */
    public boolean borrow(Student stu) {
        if (available > 0) {
            available--;
            stu.assign(this);
            return true;

        } else {
            return false;
        }

    }

    /**
     * This function searches the provided name (Parameter MediaTitle) and searches the database of Media for the correct name
     * @param MediaTitle This parameter is the media's Title/name -- [String]
     */
    public void search(String MediaTitle) {
        String title = MediaTitle;
        for (int i = 0; i < lmsApplication.listOfMedia.size(); i++) {
            if (name.equals(title)) {
                System.out.println(name);
                System.out.println("Copies Available: " + available);
                break;
            }
        }
    }

    /**
     * This function returns the output variable to a toString
     * @return returns the output as a string -- [String]
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("Title: " + name + "\nOwned: " + owned + "\nAvailable: " + available + "\nCategory: " + category + "\n");
        return out.toString();
    }

    /**
     * This function adds the Media's availabilities by 1
     */
    public void returned() {
        available++;
    }
}