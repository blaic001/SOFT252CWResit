/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JTextArea;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author charl
 */
public class SecretaryTest {
    
    public SecretaryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of patientApprove method, of class Secretary.
     */
//    @Test
//    public void testPatientApprove() {
//        System.out.println("patientApprove");
//        JTextArea area = null;
//        Secretary.patientApprove(area);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of createAppointment method, of class Secretary.
     */
//    @Test
//    public void testCreateAppointment() {
//        System.out.println("createAppointment");
//        JTextArea area = null;
//        Secretary.createAppointment(area);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of stockCheck method, of class Secretary.
     */
//    @Test
//    public void testStockCheck() {
//        System.out.println("stockCheck");
//        JTextArea area = null;
//        Secretary.stockCheck(area);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of orderMedicine method, of class Secretary.
     */
//    @Test
//    public void testOrderMedicine() {
//        System.out.println("orderMedicine");
//        JTextArea area = null;
//        Secretary.orderMedicine(area);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of medicineMath method, of class Secretary.
     */
    @Test
    public void testMedicineMath() {
        System.out.println("medicineMath Test");
        int mediAdd = 3;
        int howMuch = 4;
        int result = Secretary.medicineMath(mediAdd, howMuch);
        assertEquals(7, result);
    }

    /**
     * Test of patientRemove method, of class Secretary.
     */
//    @Test
//    public void testPatientRemove() {
//        System.out.println("patientRemove");
//        JTextArea area = null;
//        Secretary.patientRemove(area);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
