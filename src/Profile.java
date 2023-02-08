package project1;


import java.util.Scanner;
public class Profile implements Comparable<Profile> {
    private String lname;
    private String fname;
    private Date dob; //use the Date class described in (f)
    public Profile(String l, String f, Date d) {
        this.lname = l;
        this.fname = f;
        dob = d;
    }
    @Override public String toString() {
        return "" + lname + " " + fname + " " + dob.toString();
    }
    @Override public boolean equals(Object o) {
        if(o instanceof Profile) {
            Profile profile = (Profile)o;
            if(profile.lname == this.lname && profile.fname == this.fname && profile.dob.equals(this.dob)) {
                return true;
            }
        }
        return false;
    }
    @Override public int compareTo(Profile o) {
        if(o instanceof Profile) {
            int output;
            Profile profile = (Profile)o;
            output = this.lname.compareTo(profile.lname);
            if(output == 0) {
                output = this.fname.compareTo(profile.fname);
                if(output == 0) {
                    output = this.dob.compareTo(profile.dob);
                }
            }
            return output;
        }
        return 0;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String fname = sc.nextLine();
        String lname = sc.nextLine();
        String dobString = sc.nextLine();
        Date dob = new Date(dobString);
        Profile profile = new Profile(lname,fname,dob);
        System.out.println(profile.toString());
    }

}
