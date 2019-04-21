package model;

public class Subject {

    private String subjectName;
    private float progressPersent;

    //for local imaage res
    private int subIcon;

    //empty cons


    public Subject() {
    }


    public Subject(String subjectName, float progressPersent, int subIcon) {
        this.subjectName = subjectName;
        this.progressPersent = progressPersent;
        this.subIcon = subIcon;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public float getProgressPersent() {
        return progressPersent;
    }

    public void setProgressPersent(float progressPersent) {
        this.progressPersent = progressPersent;
    }

    public int getSubIcon() {
        return subIcon;
    }

    public void setSubIcon(int subIcon) {
        this.subIcon = subIcon;
    }
}
