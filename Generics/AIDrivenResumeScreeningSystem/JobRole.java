package Generics.AIDrivenResumeScreeningSystem;

public abstract class JobRole {
    private String title;
    private String department;

    public JobRole(String title, String department) {
        this.title = title;
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }

    public abstract void displayRoleDetails();
}