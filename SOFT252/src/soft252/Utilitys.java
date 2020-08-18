/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252;
import java.util.*; 
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 *
 * @author charl
 */

public class Utilitys {
    //creating linkedlist
    static LinkedList<Patient> tempPatientList = new LinkedList<Patient>();
    static LinkedList<Patient> patientList = new LinkedList<Patient>();
    static LinkedList<Doctor> doctorList = new LinkedList<Doctor>();
    static LinkedList<Secretary> secretaryList = new LinkedList<Secretary>();
    static LinkedList<Admin> adminList = new LinkedList<Admin>();
    static LinkedList<Appointment> appointmentList = new LinkedList<Appointment>();
    static LinkedList<Medicine> medicineList = new LinkedList<Medicine>();
    //creating enum for login
    static enum LoginType {
    PATIENT,
    DOCTOR,
    SECRETARY,
    ADMIN
    };

    static LoginType logintype;
    
    static String LoginID;
    //Getting an appointment by specifying an ID
    public static LinkedList<Appointment> getIdAppointment(String Id){
        LinkedList<Appointment> appList = new LinkedList<Appointment>();
        for (int i = 0; i < appointmentList.size(); i++){
            if (logintype==LoginType.PATIENT){
                if (appointmentList.get(i).getPatient().getId().equals(Id))
                    appList.add(appointmentList.get(i));
                }
            if (logintype==LoginType.DOCTOR){
                if (appointmentList.get(i).getDoctor().getId().equals(Id)){
                    appList.add(appointmentList.get(i));
                }
            }
        }
        return appList;   
        
        
    }
    
    
    
    //deleting secretary or doctors account
    public static void deleteAccountSecDoc(JTextArea area) {
        area.setText("");
        String comment = JOptionPane.showInputDialog(null, "Doctor or Secretary?");
        //loops doctors and choose which to delete
        if (comment.equals("Doctor")){
            for(int i = 0; i < doctorList.size(); i++){
                new TextAreaOutputStream_1(area).print("\n" + (i) + ". " + doctorList.get(i).getForename());
            }
            int number = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the Secretary number:"));
            
            doctorList.remove(number);
            
        }
        //loops secretaries and choose which to delete
        if (comment.equals("Secretary")){
            for(int i = 0; i < secretaryList.size(); i++){
                new TextAreaOutputStream_1(area).print("\n" + (i) + ". " + secretaryList.get(i).getForename());
            }
            int number = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the Secretary number:"));
            
            secretaryList.remove(number);
        }


    }
    //loops patients and choose which to delete
    public static void deleteAccountPatient(JTextArea area) {
        area.setText("");
        for(int i = 0; i < patientList.size(); i++){
                new TextAreaOutputStream_1(area).print((i) + ". " + patientList.get(i).getForename());
            }
            int number = Integer.parseInt(JOptionPane.showInputDialog(null, "Select the Patient number:"));
            
            patientList.remove(number);
    }
    
    
    //rate doctors and provide feedback
    public static void rateDoctor (JTextArea area) {
        area.setText("");
        //select a doctor from the list
        for(int i = 0; i < doctorList.size(); i++){
        new TextAreaOutputStream_1(area).print((i) + ". " + doctorList.get(i).getForename() + "\n");
        }
        int number = Integer.parseInt(JOptionPane.showInputDialog(null, "Select your doctor number:"));
        int rating = Integer.parseInt(JOptionPane.showInputDialog(null, "Rate between 1-10:"));        
        String comment = JOptionPane.showInputDialog(null, "Any comments?");
        
        doctorList.get(number).doctorRatingList.add(("Rating: " + rating + "/10 \n") + ("Comment: " + comment));
        
        }
    
    //check a doctors rating
    public static void doctorsRating (JTextArea area) {
        area.setText("");
        for(int i = 0; i < doctorList.size(); i++){
            new TextAreaOutputStream_1(area).print((i) + ". " + doctorList.get(i).getForename() + "\n");
        }
        int number = Integer.parseInt(JOptionPane.showInputDialog(null, "Select your doctor number:"));
        //display current ratings
        for (int i = 0; i < doctorList.get(number).doctorRatingList.size(); i++){
        new TextAreaOutputStream_1(area).print(doctorList.get(number).doctorRatingList.get(i) + "\n");
        }
        
    }
    //creates an account for admin or patients
    public static void createAccountAdmPat() {
               
        int i = 1231;
        String forename = JOptionPane.showInputDialog(null, "Enter your forename:");
        
        String surname = JOptionPane.showInputDialog(null, "Enter your surname:");
        
        String password = JOptionPane.showInputDialog(null, "Create your password:");
        
        String address = JOptionPane.showInputDialog(null, "Enter your address:");
        
        String age = JOptionPane.showInputDialog(null, "Enter your age:");
        
        String gender = JOptionPane.showInputDialog(null, "Enter your gender:");
        
        String roleCheck = JOptionPane.showInputDialog(null, "Are you a patient or admin?");
        
        
        //checks they say patient if they say patient they get built as a patient
        if (roleCheck.equals("patient")){
            Patient p = new Patient();
            String id = "P" + i;
            JOptionPane.showMessageDialog(null, "This is your ID: " + id);
            p.setForename(forename);
            p.setSurname(surname);
            p.setPassword(password);
            p.setAddress(address);
            p.setId(id);
            p.setAge(age);
            p.setGender(gender);
            JOptionPane.showMessageDialog(null, "Request Sent");
            
            tempPatientList.add(p);
            
        }
        //checks they say admin if they say admin they get built as an admin
        else if (roleCheck.equals("admin")){
            Admin a = new Admin();
            String id = "A" + i;
            JOptionPane.showMessageDialog(null, "This is your ID: " + id);
            a.setForename(forename);
            a.setSurname(surname);
            a.setPassword(password);
            a.setAddress(address);
            a.setId(id);
            a.setAge(age);
            a.setGender(gender);
            JOptionPane.showMessageDialog(null, "Account Created");
            
            adminList.add(a);
            
        } 
        
        
        
        
        }
    
    //creates an account for a secretary or doctor
    public static void createAccountSecDoc() {
               
        int i = 1231;
        
        String forename = JOptionPane.showInputDialog(null, "Enter your forename:");
        
        String surname = JOptionPane.showInputDialog(null, "Enter your surname:");
        
        String password = JOptionPane.showInputDialog(null, "Create your password:");
        
        String address = JOptionPane.showInputDialog(null, "Enter your address:");
        
        String age = JOptionPane.showInputDialog(null, "Enter your age:");
        
        String gender = JOptionPane.showInputDialog(null, "Enter your gender:");
        
        String roleCheck = JOptionPane.showInputDialog(null, "Is it a secretary or a doctor");
        
        //checks they say doctor if they say doctor they get built as an doctor
        if (roleCheck.equals("doctor")){
            Doctor d = new Doctor();
            String id = "D" + i;
            JOptionPane.showMessageDialog(null, "This is your ID: " + id);
            d.setForename(forename);
            d.setSurname(surname);
            d.setPassword(password);
            d.setAddress(address);
            d.setId(id);
            d.setAge(age);
            d.setGender(gender);
            JOptionPane.showMessageDialog(null, "Doctor Added");
            
            doctorList.add(d);
        }
        //checks they say secretary if they say secretary they get built as an secretary
        else if (roleCheck.equals("secretary")){
            Secretary s = new Secretary();
            String id = "S" + i;
            JOptionPane.showMessageDialog(null, "This is your ID: " + id);
            s.setForename(forename);
            s.setSurname(surname);
            s.setPassword(password);
            s.setAddress(address);
            s.setId(id);
            s.setAge(age);
            s.setGender(gender);
            JOptionPane.showMessageDialog(null, "Secretary Added");
            
            secretaryList.add(s);
        } 
    }
}
