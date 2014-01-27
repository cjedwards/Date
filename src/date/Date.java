package date;

public class Date {

    private static int month = 0;
    private static int day = 0;
    private static int year = 0;

    public Date() {
        this(0, 0, 0);
    }

    public Date(Date dt) {

        this();
    }

    public Date(int dn, int y) {

    }

    public Date(int m, int d, int y) {
        setDate(m, d, y);
    }

    public Date(String m, int d, int y) {

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
        setMonth();
        setDay();
        setYear();
    }

    public static void setMonth() {

    }

    public static void setDay() {

    }

    public static void setYear() {

    }

    public static void main(String[] args) {

        Date date = new Date();
        Date dt = new Date(date);

        int m = 11;
        int d = 22;
        int y = 2011;

        dt.setDate(m, d, y);

    }

}
