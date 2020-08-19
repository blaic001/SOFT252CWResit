/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Appointment;
import model.Medicine;
import model.People;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import static controller.Utilitys.doctorList;
/**
 *
 * @author charl
 */
public class Patient extends People {
    
    public LinkedList<Medicine> patientMedicineList;
    
    public LinkedList<String> patientHistoryList;
    //makes lists
    public Patient (){
        patientHistoryList = new LinkedList<String>();
        patientMedicineList = new LinkedList<Medicine>();
    }
                 
    String doctor;
    
    //request appointment
    public static void requestAppointment (JTextArea area) {
        area.setText("");
        Patient patientSelect = null;
        for (int i = 0; i < Utilitys.patientList.size(); i++){
            //loops through patients until it finds matching id      
            if (Utilitys.patientList.get(i).getId().equals(Utilitys.LoginID)){
                patientSelect = Utilitys.patientList.get(i);     
                }
        }    
            //loops through doctors
        for(int i = 0; i < doctorList.size(); i++){
            new TextAreaOutputStream_1(area).print((i) + ". " + doctorList.get(i).getForename() + "\n");
        }
        int doctor = Integer.parseInt(JOptionPane.showInputDialog(null, "Select your doctor number:"));
        
        Doctor doctorSelect = Utilitys.doctorList.get(doctor);
        
        for (int i = 0; i < 9; i++){
            new TextAreaOutputStream_1(area).print("\n" + "Slot " + i);
        }
        
        String slot = JOptionPane.showInputDialog("Choose the Slot (1-8)");
        new TextAreaOutputStream_1(area).print("slot " + slot + " chosen");
        
        String notes = "";
        //creates the appointment and adds it to the list
        Appointment a = new Appointment(doctorSelect, patientSelect, slot, notes);
        Utilitys.appointmentList.add(a);
    }
    
    
    //view appointment
    
    public static void viewAppointment (JTextArea area) {
        area.setText("");
        for (int i = 0; i < Utilitys.patientList.size(); i++){
            //checks patientlist for login id and then displays appointments listed        
            if (Utilitys.patientList.get(i).getId().equals(Utilitys.LoginID)){
                LinkedList<Appointment> appList = Utilitys.getIdAppointment(Utilitys.LoginID);
                for (int j = 0; j < appList.size(); j++){
                    new TextAreaOutputStream_1(area).print("\n" + appList.get(j).getDoctor().getId()
                    + "\t" + appList.get(j).getPatient().getId()
                    + "\t" + appList.get(j).getTimeslot());
                    
                }
                
            }
            
        }    
    }
    //view pescription
    
    public static void viewPescription(JTextArea area) {
        for (int i = 0; i < Utilitys.patientList.size(); i++){
            //checks patient ID to check pescription        
            if (Utilitys.patientList.get(i).getId().equals(Utilitys.LoginID)){
                for (int j = 0; j < Utilitys.patientList.get(i).patientMedicineList.size(); j ++)
                    new TextAreaOutputStream_1(area).print("\n" + Utilitys.patientList.get(i).patientMedicineList.get(j).getName()
                    + "\t" + Utilitys.patientList.get(i).patientMedicineList.get(j).getDosage());
                    
            }
        }
    }
    //delete patient account
    public static void accountTerminate () {
        
        for (int i = 0; i < Utilitys.patientList.size(); i++){
                    
            if (Utilitys.patientList.get(i).getId().equals(Utilitys.LoginID)){
                    Utilitys.patientList.remove(i);
                    break;
                }
            }
        }
    }
