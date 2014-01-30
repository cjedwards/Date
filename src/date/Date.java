package date;

import javax.swing.JOptionPane;

public class Date {

    public static int month = 4;
    public static int day = 9;
    public static int year = 1972;
    public static final String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	public static int dayCount = 100;
	
    public Date() {
    }

    public Date(Date dt) {
        this();
    }
    
    public Date(int dn, int y) {
        setDate(monthFromDayNumber(dn,y), dayFromDayNumber(dn,y), y);
    }
    
    public Date(int m, int d, int y) {
        setDate(m, d, y);
    }
    
    public Date(String m, int d, int y) {
        setDate(monthToInt(m), d, y);
    }

	 public static int getDay() {
        return day;
    }
	 
	public static int getDayCount() {
		if (isLeapYear()) return dayCount+1;
		else return dayCount;
    }

    
    public static int getYear() {
        return year;
    }
	
	public static int getMonth() {
        return month;
    }

    public static void setDate(int m, int d, int y) {
        setDay(d);
        setYear(y);
        setMonth(m);
    }
   
    public static void setMonth(int m) {
        if (m <= 12 && m > 0 ) month = m; else Err.print("month",m);
    }
    
    public static void setDay(int d) { //check the months with 30 days.
        if ( month == 3 || month == 5 || month == 8 || month == 10 ) {
            if (d <= 30 && d > 0 ) day = d; 
            else Err.print("day",d); 
        } else if ( month == 2) {  //check February!
            if (isLeapYear()) {
                if (d <= 29 && d > 0) day = d; else Err.print("day",d); 
            } else if (d <= 28 && d > 0) day = d; //not a leapyear
            else Err.print("day",d);
        } else {  // must be the long months
            if (d <= 31 && d > 0 ) day = d; else Err.print("day",d);
        }
    }
    
    public static void setYear(int y) {
        if (y < 9999 && y > 0 ) year = y; else Err.print("year",y);
    }
    
    private static boolean isLeapYear() {
        if ( year %4 == 0){ //basic premise, check gregorian rules
            if ( year % 100 == 0 && year %400 == 0) return true;
            else if ( year % 100 == 0 ) return false;
            else return true;
        } else return false;
    }
 
    
    private static int monthToInt(String m) {
        int monthInt = 0;                       //strip whitespace and
        switch (fixMonthSpelling(m.trim())) {   //fix case issues
            case "January":  monthInt = 1; dayCount = 0; break;
            case "Jan": 	 monthInt = 1; dayCount = 0; break;
            case "February": monthInt = 2; dayCount = 31; break; 
            case "Feb": 	 monthInt = 2; dayCount = 31; break;
            case "March": 	 monthInt = 3; dayCount = 59; break; 
            case "Mar": 	 monthInt = 3; dayCount = 59; break;
            case "April": 	 monthInt = 4; dayCount = 90; break;
            case "Apr": 	 monthInt = 4; dayCount = 90; break;
            case "May": 	 monthInt = 5; dayCount = 120; break;
            case "June": 	 monthInt = 6; dayCount = 151; break;
            case "Jun": 	 monthInt = 6; dayCount = 151; break;
            case "July": 	 monthInt = 7; dayCount = 181; break;
            case "Jul": 	 monthInt = 7; dayCount = 181; break;
            case "August": 	 monthInt = 8; dayCount = 212; break;
            case "Aug": 	 monthInt = 8; dayCount = 212; break;
            case "September":monthInt = 9; dayCount = 243; break;
            case "Sep": 	 monthInt = 9; dayCount = 243; break; 
            case "October":  monthInt = 10; dayCount = 273; break; 
            case "Oct": 	 monthInt = 10; dayCount = 273; break;
            case "November": monthInt = 11; dayCount = 304; break;
            case "Nov": 	 monthInt = 11; dayCount = 304; break;
            case "December": monthInt = 12; dayCount = 334; break;
            case "Dec": 	 monthInt = 12; dayCount = 334; break;
            default : Err.print("month not found: ",m.trim());
            } 
            return monthInt;
        }
	private static int monthFromDayNumber(int dn, int y){
		if (dn<32) return 1;
		else if (dn<60) return 2;
		else if (dn<91) return 3;
		else if (dn<121) return 4;
		else if (dn<152) return 5;
		else if (dn<182) return 6;
		else if (dn<213) return 7;
		else if (dn<244) return 8;
		else if (dn<273) return 9;
		else if (dn<305) return 10;
		else if (dn<335) return 11;
		else return 12;
	}
	
	private static int dayFromDayNumber(int dn, int y){
		if (dn<32) return dn;
		else if (dn<60) return dn-31;
		else if (dn<91) return dn-59;
		else if (dn<121) return dn-90;
		else if (dn<152) return dn-120;
		else if (dn<182) return dn-151;
		else if (dn<213) return dn-181;
		else if (dn<244) return dn-212;
		else if (dn<273) return dn-243;
		else if (dn<305) return dn-273;
		else if (dn<335) return dn-304;
		else return dn-334;
	}
	}
    
    // make the user input to lower case then upper case only the first letter
    private static String fixMonthSpelling(String str){
        String newStr = str.toLowerCase();
        char[] monthArray = newStr.toCharArray();
        monthArray[0] = Character.toUpperCase(monthArray[0]);
        String fixedMonth = new String(monthArray);
        return fixedMonth;
    }


    

    
}
