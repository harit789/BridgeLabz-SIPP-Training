package Generics.AIDrivenResumeScreeningSystem;

public class DataScientist extends JobRole {
    private String expertiseArea;

    public DataScientist(String title, String department, String expertiseArea) {
        super(title, department);
        this.expertiseArea = expertiseArea;
    }

    @Override
    public void displayRoleDetails() {
        System.out.println("Job Role: " + getTitle() + ", Department: " + getDepartment() + ", Expertise Area: " + expertiseArea);
    }
}