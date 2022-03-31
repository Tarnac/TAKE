/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.beans;

import java.util.ArrayList;
import java.util.Arrays;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import models.Student;

/**
 *
 * @author Tarnacki
 */
@ManagedBean(name="tableBean",eager=true)
@Dependent
public class TableBean {
    
    private final ArrayList<Student> students
        = new ArrayList<>(Arrays.asList(
        new Student("Jan","Kowalski", 4.2),
                new Student("Adam","Nowak",3.5),
                new Student("Michał","Woźny",3.2),
                new Student("Jakub","Nowak",3.75),
                new Student("Marek","Piłka",4.1),
                new Student("Cezary","Cezary",3.95),
                new Student("Janusz","Piła",2.9)
        ));

    /**
     * Creates a new instance of TableBean
     */
    public TableBean() {
    }

    /**
     * @return the students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }
    
}
