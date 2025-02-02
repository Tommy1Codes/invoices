/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package INVOICES;

/**
 *
 * @author topmm
 */
public class Sessions {
    
    private String studentName;
    private int sessionHours;
    private String sessionDate;
    
    
    public Sessions(String inStudentName, int inSessionHours, String inSessionDate)
            {
                studentName = inStudentName;
                sessionHours = inSessionHours;
                sessionDate = inSessionDate;
            }

    public String getStudentName() {
        return studentName;
    }

    public int getSessionHours() {
        return sessionHours;
    }

    public String getSessionDate() {
        return sessionDate;
    }
    
    
    
}
