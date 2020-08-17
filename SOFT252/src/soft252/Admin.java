/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import static soft252.Utilitys.doctorList;

/**
 *
 * @author charl
 */
public class Admin extends People {
    //add or remove doctor and secretary accounts
    public static void accountCreate (){
        Utilitys.createAccountSecDoc();
    }
    
    //provide feedback to each doctor based on ratings and comments from patients
    public static void doctorsFeedback(JTextArea area){
        area.setText("");
        for(int i = 0; i < doctorList.size(); i++){
            new TextAreaOutputStream_1(area).print("\n" + (i+1) + ". " + doctorList.get(i).getForename());
        }
        
        int number = Integer.parseInt(JOptionPane.showInputDialog(null, "Select your doctor number:"));
        
        
            
        for (int j = 0; j < doctorList.get(number).doctorRatingList.size(); j++){
                new TextAreaOutputStream_1(area).print("\n" + (number) + ". " + doctorList.get(number).doctorRatingList.get(j));
        }
            
            
        
        
        String feedback = JOptionPane.showInputDialog(null, "Enter your feedback:");
        
        doctorList.get(number).doctorRatingList.add(feedback);
    }
}
