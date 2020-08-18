/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Doctor;
import controller.Patient;

/**
 *
 * @author charl
 */
public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String timeslot;
    private String notes;
  
    public Appointment(Doctor doctor, Patient patient, String timeslot, String notes){
        this.doctor = doctor;
        this.patient = patient;
        this.timeslot = timeslot;
        this.notes = notes;
    }

    public Doctor getDoctor(){
        return this.doctor;
    }

    public Patient getPatient(){
        return this.patient;
    }
    
    public String getTimeslot(){
        return this.timeslot;
    }
    
    public String getNotes(){
        return this.notes;
    }
    
    public void setNotes(String notes){
        this.notes = notes;
    }
}
