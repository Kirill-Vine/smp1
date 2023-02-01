@author Michael Burton
public class Profile implements Comparable<Profile> {
    private String lname;
    private String fname;
    private Date dob; //use the Date class described in (f)
    public Profile(String l, String f, Date d) {
        this.lname = l;
        this.fname = f;
        Date dob = d;
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
    @Override public int compareTo(Object o) {
        if(o instanceof Profile) {
            Profile profile = (Profile)o;
            if(this.lname.compareTo(profile.lname)) {
                return 1;
            } else if (this.fname.compareTo(profile.fname)) {
                return 1;
            } else if (this.dob.compareTo(profile.dob)) {
                return 1;
            }
        }
        return false;
    }
}