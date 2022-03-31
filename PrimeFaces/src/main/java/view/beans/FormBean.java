/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.beans;

import java.util.Date;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tarnacki
 */
@ManagedBean(name="formBean", eager=true)
@Dependent
public class FormBean {

    private Integer firstNumber;
    private Integer secondNumber;
    
    
    /**
     * Creates a new instance of formBean
     */
    public FormBean() {
    }
    
    public Integer calculate() {
        Integer sum = null;
        
        if (firstNumber != null && secondNumber != null){
            sum = firstNumber + secondNumber;
        }
        
        return sum;
    }
    
    public Date getCurrentDate() {
        return new Date();
    }
    
    public void getGrowlMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(firstNumber + "+" + secondNumber + "=" + calculate()));
    }

    /**
     * @return the firstNumber
     */
    public Integer getFirstNumber() {
        return firstNumber;
    }

    /**
     * @param firstNumber the firstNumber to set
     */
    public void setFirstNumber(Integer firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * @return the secondNumber
     */
    public Integer getSecondNumber() {
        return secondNumber;
    }

    /**
     * @param secondNumber the secondNumber to set
     */
    public void setSecondNumber(Integer secondNumber) {
        this.secondNumber = secondNumber;
    }


}