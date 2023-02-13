package project1;

public class TestBed() {
    String[] testStringDate = {"1/31/2003",
            "1/32/2003",
            "2/29/2004",
            "2/32/2004",
            "2/28/2003",
            "2/29/2003",
            "2/28/2003",
            "2/29/2003",
            "4/31/2003",
            "4/32/2003",
            "5/30/2003",
            "5/32/2003",
            "6/30/2003",
            "6/32/2003",
            "7/31/2003",
            "7/32/2003",
            "8/31/2003",
            "8/32/2003",
            "9/30/2003",
            "9/32/2003",
            "10/31/2003",
            "10/32/2003",
            "11/30/2003",
            "11/32/2003",
            "12/31/2003",
            "12/32/2003",
            "13/1/2003",
            "-1/31/2003",
            "1/0/2003",
            "1/1/2222",
            "3/31/2003",
            "3/32/2003"
    }
    String[][] testStringStudent {
        "John Smith 1/1/2002",
        "John Smith 1/1/2002",

    }

    public static void main() {
        Date test;
        for(int i = 0 ; i < testStringDate.length; i++) {
            test = new Date(testStringDate[i]);
            System.out.println(test.isValid());
        }
    }
}