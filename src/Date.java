import java.util.Calendar;
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    public Date() {
        Date today = Calendar.getInstance().getTime();
        year = today.getYear();
        month = today.getMonth();
        day = today.getDay();
    } //create an object with today’s date (see Calendar class)
    public Date(String date) {
        String[] dateArray = date.split("/",0);
        this.month = Integer.parseInt(dateArray[0]);
        this.day = Integer.parseInt(dateArray[1]);
        this.year = Integer.parseInt(dateArray[2]);
    } //take “mm/dd/yyyy” and create a Date object
    public boolean isValid() {
    } //check if a date is a valid calendar date
    @Override public String toString() {
        return month + "/" + day + "/" + year;
    }
    @Override public boolean equals(Object o) {
        if(o instanceof Date) {
            Date date = (Date)o;
            if(date.month == this.month && date.day == this.day && date.year == this.year) {
                return true;
            }
        }
        return false;
    }
}