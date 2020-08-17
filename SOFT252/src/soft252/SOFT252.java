/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252;
import gui.guiPatient;
import gui.guiDoctor;
import gui.guiAdmin;
import gui.GuiSecretary;
import gui.GuiLogin;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author charl
 */
public class SOFT252 {
    public static GuiLogin login = new GuiLogin();
    public static guiPatient patientGui = new guiPatient();
    public static guiDoctor doctorGui = new guiDoctor();
    public static GuiSecretary secretaryGui = new GuiSecretary();
    public static guiAdmin adminGui = new guiAdmin();

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //call method to read in data
        DataHandler.jsonReader();
        //call method to create gui
        guiSetup();
        
        //login to the system
        
    } 
    //method to create gui
    public static void guiSetup(){
        login.setVisible(true);
        patientGui.setVisible(false);
        adminGui.setVisible(false);
        doctorGui.setVisible(false);
        secretaryGui.setVisible(false);
    }
    //method for logging in
    public static void loginGo(){

        String attemptPassword;
        String attemptId;
        String personType = JOptionPane.showInputDialog(null, "P or A or D or S");
        //checks what user they are
        if (personType.equals("P"))
        {    
            attemptId = JOptionPane.showInputDialog(null, "Enter your ID:");
            attemptPassword = JOptionPane.showInputDialog(null, "Enter your Password:");
            Utilitys.LoginID = attemptId;
            for (int i = 0; i < Utilitys.patientList.size(); i++){       
                if (Utilitys.patientList.get(i).getId().equals(attemptId)){
                    if (Utilitys.patientList.get(i).getPassword().equals(attemptPassword)){
                        //opens patient gui
                        login.setVisible(false);
                        patientGui.setVisible(true);
                        Utilitys.logintype = Utilitys.LoginType.PATIENT;
                    }
                }
            }    
        }
        else if (personType.equals("A")) 
        {
            attemptId = JOptionPane.showInputDialog(null, "Enter your ID:");
            attemptPassword = JOptionPane.showInputDialog(null, "Enter your Password:");
            Utilitys.LoginID = attemptId;
            for (int i = 0; i < Utilitys.adminList.size(); i++){   
                if (Utilitys.adminList.get(i).getId().equals(attemptId)){
                    if (Utilitys.adminList.get(i).getPassword().equals(attemptPassword)){
                        //opens admin gui
                        login.setVisible(false);
                        adminGui.setVisible(true);
                        Utilitys.logintype = Utilitys.LoginType.ADMIN;
                    }
                }
            }
        }
        else if (personType.equals("D")) 
        {
            attemptId = JOptionPane.showInputDialog(null, "Enter your ID:");
            attemptPassword = JOptionPane.showInputDialog(null, "Enter your Password:");
            Utilitys.LoginID = attemptId;
            for (int i = 0; i < Utilitys.doctorList.size(); i++){   
                if (Utilitys.doctorList.get(i).getId().equals(attemptId)){
                    if (Utilitys.doctorList.get(i).getPassword().equals(attemptPassword)){
                        //opens doctors gui
                        login.setVisible(false);
                        doctorGui.setVisible(true);
                        Utilitys.logintype = Utilitys.LoginType.DOCTOR;
                    }
                }
            }
        }
        else if (personType.equals("S")) 
        {
            attemptId = JOptionPane.showInputDialog(null, "Enter your ID:");
            attemptPassword = JOptionPane.showInputDialog(null, "Enter your Password:"); 
            Utilitys.LoginID = attemptId;
            for (int i = 0; i < Utilitys.secretaryList.size(); i++){   
                if (Utilitys.secretaryList.get(i).getId().equals(attemptId)){
                    if (Utilitys.secretaryList.get(i).getPassword().equals(attemptPassword)){
                        //opens secretarys gui
                        login.setVisible(false);
                        secretaryGui.setVisible(true);
                        Utilitys.logintype = Utilitys.LoginType.SECRETARY;
                    }
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "User Doesn't Exist");
        }
    } 
}
