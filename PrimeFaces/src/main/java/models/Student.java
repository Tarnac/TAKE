/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Tarnacki
 */
public class Student {
    private String firstName;
    private String lastName;
    private double avgGrade;
    
    public Student(String firstName, String lastName, double avgGrade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.avgGrade = avgGrade;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the avgGrade
     */
    public double getAvgGrade() {
        return avgGrade;
    }

    /**
     * @param avgGrade the avgGrade to set
     */
    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }


}
