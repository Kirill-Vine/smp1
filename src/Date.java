import java.util.Calendar;
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;
    public Date() {
        //bruh idk 0_0

    } //create an object with today’s date (see Calendar class)

    public Date(String date) {
        String[] dateArray = date.split("/", 0);
        try {
            this.month = Integer.parseInt(dateArray[0]);
            this.day = Integer.parseInt(dateArray[1]);
            this.year = Integer.parseInt(dateArray[2]);
        } catch (NumberFormatException nfe) {
            System.out.println("improper date");
            return;
        }
    }

    public Date (Date d) {
        this.month = d.month;
        this.day = d.day;
        this.year = d.year;
    }
    //take mm/dd/yyyy and create a Date object
    public boolean isValid() {
        final int JANUARY = 1;
        final int FEBRUARY = 2;
        final int MARCH = 3;
        final int APRIL = 4;
        final int MAY = 5;
        final int JUNE = 6;
        final int JULY = 7;
        final int AUGUST = 8;
        final int SEPTEMBER = 9;
        final int OCTOBER = 10;
        final int NOVEMBER = 11;
        final int DECEMBER = 12;
        final int QUADRENNIAL = 4;
        final int CENTENNIAL = 100;
        final int QUATERCENTENNIAL = 400;
        final int MONTHS_PER_YEAR = 12;
        final int LONG_MONTHS = 31;
        final int SHORT_MONTHS = 30;
        final int WEIRD_ONE = 28;
        final int LEAP_YEAR = 29;
        //idk how to get this :,|
        //MUST CHANGE =================================================
        final int CURRENT_YEAR = 2222;

        if(this.month > MONTHS_PER_YEAR || this.year > CURRENT_YEAR || this.month < JANUARY){
            System.out.println("improper date");
            return false;
        }
        switch(this.month){
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                if(this.day > LONG_MONTHS) {
                    System.out.println("long month");
                    return false;
                }
                break;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                if(this.day > SHORT_MONTHS){
                    System.out.println("improper date");
                    return false;
                }
                break;
            case FEBRUARY:
                if (this.year % QUADRENNIAL ==0 ) {
                    if(this.year % CENTENNIAL == 0) {
                        if(this.year %QUATERCENTENNIAL == 0) {
                            if(this.day > LEAP_YEAR) {
                                System.out.println("improper date");
                                return false;
                            }
                        }
                    } else {
                        if(this.day != LEAP_YEAR) {
                            System.out.println("improper date");
                            return false;
                        }
                    }
                }
                if(this.day != WEIRD_ONE) {
                    System.out.println("improper date");
                    return false;
                }
        }
        return true;
    } //check if a date is a valid calendar date


    @Override public String toString() {

        return this.month + "/" + this.day + "/" + this.year;
    }
    @Override public boolean equals(Object o) {
        if(o instanceof Date) {
            Date date = (Date) o;
            if (date.month == this.month && date.day == this.day && date.year == this.year) {
                return true;
            }
        }
        return false;
    }
    @Override public int compareTo(Date d) {
        if(this.year > d.year) {
            return 1;
        } else if (this.year == d.year) {
            if(this.month > d.month) {
                return 1;
            } else if (this.month == d.month) {
                if(this.day > d.day) {
                    return 1;
                } else if (this.day == d.day) {
                    return 0;
                }
            }
        }
        return -1;
    }
}