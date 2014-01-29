package date;

import javax.swing.JOptionPane;

public class DateDriver {
    
    
    private static int inpD, inpM, inpY;
        
    public static void main(String[] args) {

    Date date = new Date();
    Date dt = new Date(date);

    inpM = JOptionPane.showInputDialog("Enter month name or number. eg January, Jan, 1");
    inpD = Integer.valueOf(JOptionPane.showInputDialog("Enter day number. eg (22)"));
    inpY = Integer.valueOf(JOptionPane.showInputDialog("Enter year number. eg (2002)"));
    
    dt.setDate(inpM, inpD, inpY);
    
    Object[] possibleValues = { "MM/DD/YY", "May 9, 1972", "DDD YYYY" };
    Object selectedValue = JOptionPane.showInputDialog(null,"Choose one", "Output Style",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);

    if (selectedValue == "MM/DD/YY"){
            JOptionPane.showMessageDialog(null, DatermonthInt + "/" + Date.day + "/" + year);
    } else if ( selectedValue == "May 9, 1972") {
            JOptionPane.showMessageDialog(null, monthStr + day + "," + year);
    } else if ( selectedValue == "DDD YYYY") {
            JOptionPane.showMessageDialog(null, "");
    } else {
            JOptionPane.showMessageDialog(null, "");
    }
    //       resetData();



    System.out.println(" dt.getDay() -> " + dt.getDay());
    System.out.println(" day -> " + day);
    }
}
