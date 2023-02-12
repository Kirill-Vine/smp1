package project1;
public enum Major {
    CS("CS", "SAS","01:198"),
    MATH("MATH", "SAS", "01:640"),
    EE("EE","SOE", "14:332"),
    ITI("ITI","SC&I", "04:547"),
    BAIT("BAIT", "RBS","33:136");


    final String major;
    final String school;
    final String classCode;


    private Major(String tempMajor, String tempSchool, String tempClassCode) {
        major = tempMajor;
        school = tempSchool;
        classCode = tempClassCode;
    }

    public static Major setMajor(String input) {
        Major output;
        switch (input) {
            case "CS":
                output = Major.CS;
                break;
            case "MATH":
                output = Major.MATH;
                break;
            case "EE":
                output = Major.EE;
                break;
            case "ITI":
                output = Major.ITI;
                break;
            case "BAIT":
                output = Major.BAIT;
                break;
            default:
                System.out.println("Major does not exist");
                output = null;

        }
        return output;

    }

    public String getSchool() {
        return school;
    }


    public String getMajor() {
        return major;
    }


    public String getClassCode() {
        return classCode;
    }
}



