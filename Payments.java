/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package INVOICES;

/**
 *
 * @author topmm
 */
public class Payments {
    
    private String studentName;
    private double studentPayment = 0;
    private String paymentDate;
    
    public Payments(String inStudentName, double inStudentPayment, String inPaymentDate)
    {
        studentName = inStudentName;
        studentPayment = inStudentPayment;
        paymentDate = inPaymentDate;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getStudentPayment() {
        return studentPayment;
    }

    public String getPaymentDate() {
        return paymentDate;
    }
    
    
    
}
