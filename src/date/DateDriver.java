package date;

import javax.swing.JOptionPane;

public class DateDriver {
    
    private static int inpD, inpY;
    
	static Date dt = new Date();
	
    public static boolean isInteger( String inp )  {  
     try {  
        Integer.parseInt( inp );  
        return true;  
     } catch( NumberFormatException e) {  
        return false;  
     }  
    }  
    public static void main(String[] args) {
		boolean runForever = true;
		while (runForever) {
			if (getInput() && Err.noErr) getOutput();
		    
			int cont = JOptionPane.showConfirmDialog(null, "Enter another date?", "Continue?", JOptionPane.YES_NO_OPTION);
			if (cont == JOptionPane.YES_OPTION) runForever = true;
			else runForever=false;
		}
	}
        
	public static boolean getInput() {
		String inp = new String();
		
        String inpM = JOptionPane.showInputDialog("Enter month name or number. eg January, Jan, 1");
		if (inpM == null || inpM.isEmpty()) {	Err.print(inpM); return false; }

		inp = (JOptionPane.showInputDialog("Enter day number. eg (22)"));
		if (isInteger(inp)) { inpD = Integer.valueOf(inp); } else { Err.print(inp); return false; }

		inp = (JOptionPane.showInputDialog("Enter year number. eg (2002)"));
		if (isInteger(inp)) { inpY = Integer.valueOf(inp); } else { Err.print(inp); return false; } 

        if (isInteger(inpM)) {    // info pre-validated, decide what object to create
            dt = new Date(Integer.valueOf(inpM), inpD, inpY);
        }  else {
            dt = new Date(inpM, inpD, inpY);
		}
        return true;
    }
    
    private static void getOutput(){
        Object[] outTypes = { "MM/DD/YY", "May 9, 1972", "DDD YYYY" };
        Object selectedValue = JOptionPane.showInputDialog(null,"Choose one", "Output Style",JOptionPane.INFORMATION_MESSAGE, null,outTypes, outTypes[0]);

        if (selectedValue == "MM/DD/YY"){
                JOptionPane.showMessageDialog(null, dt.month + "/" + dt.day + "/" + dt.year);
        } else if ( selectedValue == "May 9, 1972") {
                JOptionPane.showMessageDialog(null, dt.months[dt.month-1] + " " + dt.day + ", " + dt.year);
        } else if ( selectedValue == "DDD YYYY") {
                JOptionPane.showMessageDialog(null, "");
        } else {
                JOptionPane.showMessageDialog(null, "");
        }

    }
}
