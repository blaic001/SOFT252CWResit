/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.Appointment;
import model.People;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import static controller.Utilitys.doctorList;
import static controller.Utilitys.patientList;
import static controller.Utilitys.tempPatientList;
/**
 *
 * @author charl
 */
public class Secretary extends People {
    //approve patient accounts
    public static void patientApprove (JTextArea area){
        area.setText("");
        for(int i = 0; i < tempPatientList.size(); i++){
                new TextAreaOutputStream_1(area).print("\n" + (i) + ". " + tempPatientList.get(i).getForename());
        
        String response = JOptionPane.showInputDialog(null, "Approve? Y/N");
            if (response.equals("Y")){
                patientList.add(tempPatientList.remove(i));
                JOptionPane.showMessageDialog(null, "Account Approved");
            }
            else if (response.equals("N")){
                    tempPatientList.remove(i);
            }
        }
        area.setText("");
    }
 
    //create an appointment between a patient and a free doctor
    public static void createAppointment (JTextArea area){
        for (int i = 0; i < Utilitys.patientList.size(); i++){
            new TextAreaOutputStream_1(area).print("\n" + i + Utilitys.patientList.get(i).getForename());
        }
        int patient = Integer.parseInt(JOptionPane.showInputDialog("Choose the patient"));
        
        Patient patientSelect = Utilitys.patientList.get(patient);
        
        for(int i = 0; i < doctorList.size(); i++){
            new TextAreaOutputStream_1(area).print("\n" + (i) + ". " + doctorList.get(i).getForename());
        }
        int doctor = Integer.parseInt(JOptionPane.showInputDialog(null, "Select your doctor number:"));
        
        Doctor doctorSelect = Utilitys.doctorList.get(doctor);
        area.setText("");
        for (int i = 0; i < 9; i++){
            new TextAreaOutputStream_1(area).print("\n" + "Slot " + i);
        }
        String slot = JOptionPane.showInputDialog("Choose the Slot (1-8)");
        new TextAreaOutputStream_1(area).print("slot " + slot + " chosen");
        
        String notes = "";
        
        Appointment a = new Appointment(doctorSelect, patientSelect, slot, notes);
        Utilitys.appointmentList.add(a);
    }
    //give medicines to patients if available
        public static void stockCheck (JTextArea area){
            area.setText("");
            for (int i = 0; i < Utilitys.medicineList.size(); i++){
                new TextAreaOutputStream_1(area).print("\n" + Utilitys.medicineList.get(i).getName() + "\t" + Utilitys.medicineList.get(i).getQuantity());
            }
            
        }
    //order and stock medicines if necessary
    public static void orderMedicine(JTextArea area){
            area.setText("");
            for (int i = 0; i < Utilitys.medicineList.size(); i++){
                new TextAreaOutputStream_1(area).print("\n" + i + " " + Utilitys.medicineList.get(i).getName() + "\t" + Utilitys.medicineList.get(i).getQuantity());
            }
            int mediAdd = Integer.parseInt(JOptionPane.showInputDialog("Which medicine number do you wish to add to?"));
            int howMuch = Integer.parseInt(JOptionPane.showInputDialog("How much by?"));
            mediAdd = Utilitys.medicineList.get(mediAdd).getQuantity();
            int finalValue = medicineMath(mediAdd, howMuch);
            
            Utilitys.medicineList.get(mediAdd).setQuantity(finalValue);
            
            area.setText("");
            for (int i = 0; i < Utilitys.medicineList.size(); i++){
                new TextAreaOutputStream_1(area).print("\n" + i + " " + Utilitys.medicineList.get(i).getName() + "\t" + Utilitys.medicineList.get(i).getQuantity());
            }
        
            
        }
    public static int medicineMath(int mediAdd, int howMuch){
        return mediAdd + howMuch;
    }
    //remove patients
    public static void patientRemove (JTextArea area){
        area.setText("");
        for (int i = 0; i < Utilitys.patientList.size(); i++){
            new TextAreaOutputStream_1(area).print("\n" + i + " " + patientList.get(i).getId());   
        }
        int patientRem = Integer.parseInt(JOptionPane.showInputDialog("Choose patient number to remove:"));
        
        Utilitys.patientList.remove(patientRem);
        
        JOptionPane.showMessageDialog(null, "Patient Removed");
    }
        
    }