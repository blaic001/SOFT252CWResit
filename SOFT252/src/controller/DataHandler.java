/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Appointment;
import model.Medicine;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author charl
 */
public class DataHandler {
    
    public static void jsonReader (){
    { 
        // parsing file
        try {
        Object obj = new JSONParser().parse(new FileReader("medicineList.json")); 
        
        //casting obj to JSON array 
        JSONArray ja = (JSONArray) obj; 
        
        // getting object attributes
        for (int i = 0; i < ja.size(); i++){
            JSONObject jo = (JSONObject) ja.get(i);
            String name = (String) jo.get("name");
            int quantity = Integer.parseInt((String) jo.get("quantity")); 
            String dosage = (String) jo.get("dosage");
            
            Medicine m = new Medicine(name, quantity, dosage);
            Utilitys.medicineList.add(m);
        }        
        //This continues to cycle through all the JSON files.
        obj = new JSONParser().parse(new FileReader("adminList.json"));
        ja = (JSONArray) obj;
        
        for (int i = 0; i < ja.size(); i ++){
            JSONObject jo = (JSONObject) ja.get(i);
            String id = (String) jo.get("id");
            String password = (String) jo.get("password");
            String forename = (String) jo.get("forename");
            String surname = (String) jo.get("surname");
            String address = (String) jo.get("address");
            String age = (String) jo.get("age");
            String gender = (String) jo.get("gender");
            Admin a = new Admin();
            a.setForename(forename);
            a.setSurname(surname);
            a.setPassword(password);
            a.setAddress(address);
            a.setId(id);
            a.setAge(age);
            a.setGender(gender);
            Utilitys.adminList.add(a);
        }

        obj = new JSONParser().parse(new FileReader("patientList.json"));
        ja = (JSONArray) obj;
        
        for (int i = 0; i < ja.size(); i ++){
            JSONObject jo = (JSONObject) ja.get(i);
            String id = (String) jo.get("id");
            String password = (String) jo.get("password");
            String forename = (String) jo.get("forename");
            String surname = (String) jo.get("surname");
            String address = (String) jo.get("address");
            String age = (String) jo.get("age");
            String gender = (String) jo.get("gender");
            Patient p = new Patient();
            p.setForename(forename);
            p.setSurname(surname);
            p.setPassword(password);
            p.setAddress(address);
            p.setId(id);
            p.setAge(age);
            p.setGender(gender);
            Utilitys.patientList.add(p);
        }
        
        
        obj = new JSONParser().parse(new FileReader("secretaryList.json"));
        ja = (JSONArray) obj;
        
        for (int i = 0; i < ja.size(); i ++){
            JSONObject jo = (JSONObject) ja.get(i);
            String id = (String) jo.get("id");
            String password = (String) jo.get("password");
            String forename = (String) jo.get("forename");
            String surname = (String) jo.get("surname");
            String address = (String) jo.get("address");
            String age = (String) jo.get("age");
            String gender = (String) jo.get("gender");
            Secretary s = new Secretary();
            s.setForename(forename);
            s.setSurname(surname);
            s.setPassword(password);
            s.setAddress(address);
            s.setId(id);
            s.setAge(age);
            s.setGender(gender);
            Utilitys.secretaryList.add(s);
        }
        
        obj = new JSONParser().parse(new FileReader("doctorList.json"));
        ja = (JSONArray) obj;
        
        for (int i = 0; i < ja.size(); i ++){
            JSONObject jo = (JSONObject) ja.get(i);
            String id = (String) jo.get("id");
            String password = (String) jo.get("password");
            String forename = (String) jo.get("forename");
            String surname = (String) jo.get("surname");
            String address = (String) jo.get("address");
            String age = (String) jo.get("age");
            String gender = (String) jo.get("gender");
            Doctor d = new Doctor();
            d.setForename(forename);
            d.setSurname(surname);
            d.setPassword(password);
            d.setAddress(address);
            d.setId(id);
            d.setAge(age);
            d.setGender(gender);
            Utilitys.doctorList.add(d);
        }
        
        obj = new JSONParser().parse(new FileReader("tempPatientList.json"));
        ja = (JSONArray) obj;
        
        for (int i = 0; i < ja.size(); i ++){
            JSONObject jo = (JSONObject) ja.get(i);
            String id = (String) jo.get("id");
            String password = (String) jo.get("password");
            String forename = (String) jo.get("forename");
            String surname = (String) jo.get("surname");
            String address = (String) jo.get("address");
            String age = (String) jo.get("age");
            String gender = (String) jo.get("gender");
            Patient p = new Patient();
            p.setForename(forename);
            p.setSurname(surname);
            p.setPassword(password);
            p.setAddress(address);
            p.setId(id);
            p.setAge(age);
            p.setGender(gender);
            Utilitys.tempPatientList.add(p);
        }
        
//        obj = new JSONParser().parse(new FileReader("appointmentList.json"));
//        ja = (JSONArray) obj;
//        for (int i = 0; i < ja.size(); i ++){
//            JSONObject jo = (JSONObject) ja.get(i);
//            String doctor = (String) jo.get("doctor");
//            String patient = (String) jo.get("patient");
//            String timeslot =  (String) jo.get("timeslot");
//            String notes = (String) jo.get("notes");
//            
//            Doctor doc = Utilitys.doctorList.get(Integer.parseInt(doctor));
//            
//            Patient pat = Utilitys.patientList.get(Integer.parseInt(patient));
//            
//            Appointment a = new Appointment(doc, pat, timeslot, notes);
//            Utilitys.appointmentList.add(a);
//        }
        }
        //to catch exceptions
        catch(Exception e){
            e.printStackTrace();
        }
        
    }    
}
    //this is to write to all the files, when the user logs out
    public static void jsonWrite (){
        JSONArray patientA = new JSONArray();
        for (Patient pat : Utilitys.patientList){
            JSONObject patientDetails = new JSONObject();
            patientDetails.put("forename", pat.getForename());
            patientDetails.put("surname", pat.getSurname());
            patientDetails.put("password", pat.getPassword());
            patientDetails.put("address", pat.getAddress());
            patientDetails.put("id", pat.getId());
            patientDetails.put("age", pat.getAge());
            patientDetails.put("gender", pat.getGender());
            patientA.add(patientDetails);
        }
        writeJSON("patientList.json", patientA.toJSONString());
        
        JSONArray tempPatientA = new JSONArray();
        for (Patient pat : Utilitys.tempPatientList){
            JSONObject patientDetails = new JSONObject();
            patientDetails.put("forename", pat.getForename());
            patientDetails.put("surname", pat.getSurname());
            patientDetails.put("password", pat.getPassword());
            patientDetails.put("address", pat.getAddress());
            patientDetails.put("id", pat.getId());
            patientDetails.put("age", pat.getAge());
            patientDetails.put("gender", pat.getGender());
            tempPatientA.add(patientDetails);
        }
        writeJSON("tempPatientList.json", tempPatientA.toJSONString());
        
        JSONArray doctorA = new JSONArray();
        
        for (Doctor doc : Utilitys.doctorList){
            JSONObject doctorDetails = new JSONObject();
            doctorDetails.put("forename", doc.getForename());
            doctorDetails.put("surname", doc.getSurname());
            doctorDetails.put("password", doc.getPassword());
            doctorDetails.put("address", doc.getAddress());
            doctorDetails.put("id", doc.getId());
            doctorDetails.put("age", doc.getAge());
            doctorDetails.put("gender", doc.getGender());
            doctorA.add(doctorDetails);
    }
        writeJSON("doctorList.json", doctorA.toJSONString());
        
        JSONArray secretaryA = new JSONArray();
        
        for (Secretary sec : Utilitys.secretaryList){
            JSONObject secDetails = new JSONObject();
            secDetails.put("forename", sec.getForename());
            secDetails.put("surname", sec.getSurname());
            secDetails.put("password", sec.getPassword());
            secDetails.put("address", sec.getAddress());
            secDetails.put("id", sec.getId());
            secDetails.put("age", sec.getAge());
            secDetails.put("gender", sec.getGender());
            secretaryA.add(secDetails);
    }
        writeJSON("secretaryList.json", secretaryA.toJSONString());
        
        JSONArray adminA = new JSONArray();
        
        for (Admin adm : Utilitys.adminList){
            JSONObject adminDetails = new JSONObject();
            adminDetails.put("forename", adm.getForename());
            adminDetails.put("surname", adm.getSurname());
            adminDetails.put("password", adm.getPassword());
            adminDetails.put("address", adm.getAddress());
            adminDetails.put("id", adm.getId());
            adminDetails.put("age", adm.getAge());
            adminDetails.put("gender", adm.getGender());
            adminA.add(adminDetails);
    }
        writeJSON("adminList.json", adminA.toJSONString());
        
        JSONArray medicineA = new JSONArray();
        
        for (Medicine med : Utilitys.medicineList){
            JSONObject medDetails = new JSONObject();
            medDetails.put("name", med.getName());
            medDetails.put("quantity", Integer.toString(med.getQuantity()));
            medDetails.put("dosage", med.getDosage());
            medicineA.add(medDetails);
        }
        
        writeJSON("medicineList.json", medicineA.toJSONString());
        
        JSONArray appointmentA = new JSONArray();

        for (Appointment app : Utilitys.appointmentList){
            JSONObject appDetails = new JSONObject();
            
            appDetails.put("patient", app.getPatient().getForename());
            appDetails.put("doctor", app.getDoctor().getForename());
            appDetails.put("timeslot", app.getTimeslot());
            appDetails.put("notes", app.getNotes());
            
            
            
            appointmentA.add(appDetails);
        }
        writeJSON("appointmentList.json", appointmentA.toJSONString());
        
        System.exit(0);
    }
    
    private static void writeJSON(String filename, String jsonString)
    {
      PrintWriter pw = null;
      try
      {
              pw = new PrintWriter(new FileWriter(new File(filename)));
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
      
      pw.print(jsonString);
      pw.close();
      
    }
}