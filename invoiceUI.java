/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package INVOICES;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
/**
 *
 * @author topmm
 */
public class invoiceUI { public static void main(String[] args) throws FileNotFoundException {
    
    invoiceManager im = new invoiceManager();
    System.out.println(im.produceInvoiceSummary());
            System.out.println(im.CurrentInvoiceTotalToString());
    //sessions file problematic
        
    }
    
}
