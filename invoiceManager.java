/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package INVOICES;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *
 * @author topmm
 */
public class invoiceManager {
    
    static private double sessionRate = 130;
    
    private Student stArr[] = new Student[100];
    private int stArrCounter = 0;
    private int totalStudents;
    
    private Sessions sArr[] = new Sessions[100];
    private int sArrCounter = 0;
    
    private Payments pArr[] = new Payments[100];
    private int pArrCounter = 0;
    
    private String studentsFileName  = "Students.txt";  //StudentFile Format: <name>#<contact>
    private String sessionsFileName = "Sessions.txt";    //SessionsFile Format : <name>#<hours>#<dateOf>
    private String paymentsFileName = "Payments.txt";    //PaymentsFile Format : <name>#<amountPayed>#<dateOf>
    
    public invoiceManager() throws FileNotFoundException
    {
        fillStudentArray();
        fillSessionsArray();
        fillPaymentArray();
    }
    
    private void fillStudentArray() throws FileNotFoundException
    {
        Scanner scfile = new Scanner(new File(studentsFileName));
        while(scfile.hasNextLine()==true)
        {
            Scanner scline = new Scanner(scfile.nextLine()).useDelimiter("#");
            while(scline.hasNext()==true)
            {              
            String name = scline.next();
            //System.out.println(name);
            String contact = scline.next();
            //System.out.println(contact);
            Student s = new Student(name, contact);
            stArr[stArrCounter]  = s;
            stArrCounter++;
            }    
            scline.close();  
            
            totalStudents = stArrCounter;
        }
        scfile.close();        
    }
    
    public int getTotalStudents()
    {
        return stArrCounter;
    }
    
    private void fillSessionsArray() throws FileNotFoundException
    {
        
        Scanner scsfile = new Scanner(new File(sessionsFileName));
        //System.out.println("dog1");
        while (scsfile.hasNextLine()==true)
        {   //System.out.println("dog2");
            Scanner scsline = new Scanner(scsfile.nextLine()).useDelimiter("#");
            while(scsline.hasNext()==true)
            {
            String name = scsline.next();
            //System.out.println(name);
            int hours = scsline.nextInt();
            String day = scsline.next();
            
            Sessions s = new Sessions(name, hours, day);
            sArr[sArrCounter] = s;
            sArrCounter++;
            }
            scsline.close();
        }
        scsfile.close();
    }
    
    public int getTotalSessions()
    {
        return sArrCounter;
    }
    
    private void fillPaymentArray() throws FileNotFoundException
    {
        Scanner scpfile = new Scanner(new File(paymentsFileName));
        
        while(scpfile.hasNextLine())
        {
            Scanner scpline = new Scanner(scpfile.nextLine()).useDelimiter("#");
            while(scpline.hasNext()==true)
            {
            String name = scpline.next();
            double amountPayed = scpline.nextDouble();
            String datePayed = scpline.next();
            
            Payments p = new Payments(name, amountPayed, datePayed);
            pArr[pArrCounter]=p;
            pArrCounter++;
            } 
            scpline.close();
        }
        scpfile.close();
    }
    
    
    private int countNumberOfSessionsFor(String name)
    {
        int x=0;
        for (int i = 0; i <sArrCounter; i++) 
        {
            if(sArr[i].getStudentName().contains(name))
            {
                x=x+sArr[i].getSessionHours();            }
        }
        return x;
    }
    
    
    
    private double getTotalAmountPayed(String name)
    {
        double t = 0;
        for (int i = 0; i <pArrCounter; i++)
        {
            if(pArr[i].getStudentName().contains(name))
            {
                t = t+pArr[i].getStudentPayment();
            }
        }
        return t;
    }
    
    private double TotalAmountDueAssuming0Pay(String name)
    {
        double t = sessionRate * countNumberOfSessionsFor(name);
        return t;
    }
    
    private int countSessionsPayed(String name)
    {
        int t = (int) ((getTotalAmountPayed(name))/sessionRate);
        return t;
    }
    
    private int countUnpaidSessions(String name)
    {
        int t = countNumberOfSessionsFor(name)-countSessionsPayed(name);
        return t;
    }
    
    public double amountDue(String name)
    {
        double t = sessionRate*countUnpaidSessions(name);
        return t;
    }
    
    public String produceInvoiceSummary()
    {
        String s = "";
        for (int i = 0; i <stArrCounter; i++) 
        {
            s = s + stArr[i].getStudentName()+": We have completed "+countUnpaidSessions(stArr[i].getStudentName())+
                    " session(s). The total amount currently due is: R"+amountDue(stArr[i].getStudentName())+'\n';
        }
        return s;
    }
    
    public double CurrentInvoiceTotal()
    {
        double x = 0;
        for (int i = 0; i <stArrCounter; i++) 
        {
           x = x+amountDue(stArr[i].getStudentName());
        }
        return x;
    }
    
    public String CurrentInvoiceTotalToString()
    {
        String s = "You are currently owed the folllowing amount in total: R"+CurrentInvoiceTotal();
        return s;
    }
}

