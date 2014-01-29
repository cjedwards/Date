package date;

public class Date {

    public static int month = 4;
    public static int day = 9;
    public static int year = 1972;
    private static final String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};

    public Date() {

    }

    public Date(Date dt) {
        this();
    }

    
    public Date(int dn, int y) {
        int m = dn/12;
        int d = dn/30;
        
        setDate(m, d, y);
    }

    
    public Date(int m, int d, int y) {
        setDate(m, d, y);
    }

    
    public Date(String m, int d, int y) {
        setDate(monthToInt(m), d, y);
    }

    
    public static void getDate() {
        getMonth();
        getDay();
        getYear();
    }

    
    public static int getMonth() {
        return month;
    }

    
    public static int getDay() {
        return day;
    }

    
    public static int getYear() {
        return year;
    }

    
    private void setDate(int m, int d, int y) {
        setYear(y);
        setMonth(m);
        setDay(d);
    }

    
    public static void setMonth(int m) {
        if (m < 12 && m > 0 ) month = m; else printErr();
    }

    
    public static void setDay(int d) { //check the months with 30 days.
        if ( month == 3 || month == 5 || month == 8 || month == 10 ) {
            if (d <= 30 && d > 0 ) day = d; 
            else printErr();
        } else if ( month == 2) {  //check February!
            if (isLeapYear()) {
                if (d <= 29 && d > 0) day = d; else printErr();
            } else if (d <= 28 && d > 0) day = d; //not a leapyear
            else printErr();
        } else {  // must be the long months
            if (d <= 31 && d > 0 ) day = d; else printErr();
        }
    }

    
    public static void setYear(int y) {
        if (y < 2500 && y > 0 ) year = y; else printErr();
    }
  
    
    private static void printErr() {
        System.out.println("Error with input: " + months[month] + " / " + day + " / " + year);
    }
    
    
    private static void printErr(String e) {
        System.out.println("Unknown month spelling : " + e + ". Valid format is June or Jun ");
    }
    
    
    private static boolean isLeapYear() {
        if ( year %4 == 0){ //basic premise, check gregorian rules
            if ( year % 100 == 0 && year%400 == 0) return true;
            else if (year % 100 == 0) return false;
            else return true;
        } else return false;
    }
 
    
    private static int monthToInt(String m) {
        int monthInt = 0;                       //strip whitespace and
        switch (fixMonthSpelling(m.trim())) {   //fix case issues
            case "January": monthInt = 1; break;
            case "Jan": monthInt = 1; break;
            case "February": monthInt = 1; break;
            case "Feb": monthInt = 1; break;
            case "March": monthInt = 2; break;
            case "Mar": monthInt = 2; break;
            case "April": monthInt = 3; break;
            case "Apr": monthInt = 3; break;
            case "May": monthInt = 4; break;
            case "June": monthInt = 5; break;
            case "Jun": monthInt = 5; break;
            case "July": monthInt = 6; break;
            case "Jul": monthInt = 6; break;
            case "August": monthInt = 7; break;
            case "Aug": monthInt = 7; break;
            case "September": monthInt = 8; break;
            case "Sep": monthInt = 8; break;
            case "October": monthInt = 9; break;
            case "Oct": monthInt = 9; break;
            case "November": monthInt = 10; break;
            case "Nov": monthInt = 10; break;
            case "December": monthInt = 11; break;
            case "Dec": monthInt = 11; break;
            default : printErr(m.trim());
            } 
            return monthInt;
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
