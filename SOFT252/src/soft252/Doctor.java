/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Doctor extends People {
    
    public LinkedList<String> doctorRatingList;
    private String feedback = "";
    
    private String notes = "";
    
    private String pescription = "";
    
    public LinkedList<String> patientPescriptionList;
    
    
    
    public Doctor (){
        doctorRatingList = new LinkedList<String>();
    }

    
    public String getNotes(){
        return notes;
    }
    
    public void setNotes(String notes){
        this.notes = notes;
    }
    
    public String getFeedback(){
        return feedback;
    }
    
    public void setFeedback(String feedback){
        this.feedback = feedback;
    }
    //view appointments
    public static void viewAppointments(JTextArea area){
        area.setText("");
        for (int i = 0; i < Utilitys.doctorList.size(); i++){
                    
            if (Utilitys.doctorList.get(i).getId().equals(Utilitys.LoginID)){
                LinkedList<Appointment> appList = Utilitys.getIdAppointment(Utilitys.LoginID);
                for (int j = 0; j < appList.size(); j++){
                    new TextAreaOutputStream_1(area).print("\n" + appList.get(j).getDoctor().getId()
                    + "\t" + appList.get(j).getPatient().getId()
                    + "\t" + appList.get(j).getTimeslot());
                    
                } 
            }
        }
    }
    
    
    //make notes during a consultation
    public static void makeNotes(JTextArea area){
        area.setText("");
        for (int i = 0; i < Utilitys.appointmentList.size(); i++) {;
            new TextAreaOutputStream_1(area).print("\n" + Utilitys.appointmentList.get(i).getTimeslot());
        }
        
        String timeslot = (JOptionPane.showInputDialog("Choose timeslot:"));
        
        getAppointmentTS(timeslot);
        
        String notes = JOptionPane.showInputDialog("Write notes");
        
        Utilitys.appointmentList.get(Integer.parseInt(timeslot)).setNotes(notes);
        
    }
    //gets the timeslot
    public static Appointment getAppointmentTS (String timeslot){
        for (int i = 0; i < Utilitys.appointmentList.size(); i++) {
            if (timeslot.equals(Utilitys.appointmentList.get(i).getTimeslot())){
            return Utilitys.appointmentList.get(i);
            }
        }
        return null;
    }
    //inspect patient history
    public static void patientHistory(JTextArea area) {
        area.setText("");
        for (int i = 0; i < Utilitys.patientList.size(); i++){
            new TextAreaOutputStream_1(area).print(Utilitys.patientList.get(i).getForename());
        }
        int number = Integer.parseInt(JOptionPane.showInputDialog("Select patient number"));
        
        for (int j = 0; j < Utilitys.patientList.get(number).patientHistoryList.size(); j++){
            new TextAreaOutputStream_1(area).print("\n" + Utilitys.patientList.get(number).patientHistoryList.get(j));
        }
        
    }
    //propose and create future appointments for a specific patient
    public static void chooseAppointment (JTextArea area){
        area.setText("");
        for (int i = 0; i < Utilitys.patientList.size(); i++){
            new TextAreaOutputStream_1(area).print("\n" + i + Utilitys.patientList.get(i).getForename());
        }
        int patient = Integer.parseInt(JOptionPane.showInputDialog("Choose the patient"));
        
        Patient patientSelect = Utilitys.patientList.get(patient);
        
        
        
        Doctor doctorSelect = null;
        
        for (int i = 0; i < Utilitys.doctorList.size(); i++){
                    
            if (Utilitys.doctorList.get(i).getId().equals(Utilitys.LoginID)){
                doctorSelect = Utilitys.doctorList.get(i);     
                }
        }    
        
        for (int i = 0; i < 9; i++){
            new TextAreaOutputStream_1(area).print("\n" + "Slot " + i);
        }
        String slot = (JOptionPane.showInputDialog("Choose the Slot"));
        new TextAreaOutputStream_1(area).print("\n" + "slot " + slot + " chosen");
        
        String notes = "";
        
        Appointment a = new Appointment(doctorSelect, patientSelect, slot, notes);
        Utilitys.appointmentList.add(a);
    }
    
    //prescribe medicines and dosages
    
    public static void prescribeMedicine (JTextArea area) {
        area.setText("");
        for (int i=0; i < Utilitys.medicineList.size(); i++){
            new TextAreaOutputStream_1(area).print(i + Utilitys.medicineList.get(i).getName());
        }
        int mediNumber = Integer.parseInt(JOptionPane.showInputDialog("Prescribe medicine number: "));
        
        Utilitys.medicineList.get(mediNumber).setQuantity(Utilitys.medicineList.get(mediNumber).getQuantity() - 1);
        
        for (int i = 0; i < Utilitys.patientList.size(); i++){
            new TextAreaOutputStream_1(area).print(i + Utilitys.patientList.get(i).getId());
        }
        
        int patNumber = Integer.parseInt(JOptionPane.showInputDialog("Choose patient number: "));
        
        Utilitys.patientList.get(patNumber).patientMedicineList.add(Utilitys.medicineList.get(mediNumber));
        
    }
    //create new medicines and request secretaries to order these
    public static void newMedicine() {
        String medicineName = JOptionPane.showInputDialog("Enter the medicine name:");
        int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity:"));
        String dosage = JOptionPane.showInputDialog("Enter the dosage:");
        
        Medicine m = new Medicine (medicineName, quantity, dosage);
        
        Utilitys.medicineList.add(m);
        
    }
}
