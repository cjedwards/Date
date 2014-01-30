package date;

import static date.Date.day;
import static date.Date.month;
import static date.Date.months;
import static date.Date.year;

import javax.swing.JOptionPane;


public class Err {
	
	public static boolean noErr = true;
	
	public static void print() {
		noErr = false;
        System.out.println("Generic error with input: " + months[month] + " / " + day + " / " + year);
    }
    
    
    public static void print(String e) {
		noErr = false;
        JOptionPane.showMessageDialog(null, "Error with \"" + e + "\" Invalid format or spelling.");
    }

	public static void print(int e) {
		noErr = false;
        JOptionPane.showMessageDialog(null, "Error with \"" + e + "\" Invalid format or spelling.");
    }  

	public static void print(String r, String e) {
		noErr = false;
        JOptionPane.showMessageDialog(null, "Error in " + r + " with \"" + e + "\" Invalid format or spelling.");
    }  

	public static void print(String r, int e) {
		noErr = false;
        JOptionPane.showMessageDialog(null, "Error in " + r + " with \"" + e + "\" Invalid format or spelling.");
    }  
}
