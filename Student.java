/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package INVOICES;

/**
 *
 * @author topmm
 */
public class Student {      
    
    private String studentName;
    private String studentContact;
    
    public Student(String inStudentName,String inStudentContact)
    {
        studentName = inStudentName;
        studentContact = inStudentContact;        
    }
    
    public String getStudentName()
    {
        return studentName;
    }
    
    public String getStudentContact()
    {
        return studentContact;
    }
}
