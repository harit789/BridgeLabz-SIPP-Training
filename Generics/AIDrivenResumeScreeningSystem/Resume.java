package Generics.AIDrivenResumeScreeningSystem;

public class Resume<T extends JobRole> {
    private String candidateName;
    private String resumeId;
    private T targetJobRole;

    public Resume(String candidateName, String resumeId, T targetJobRole) {
        this.candidateName = candidateName;
        this.resumeId = resumeId;
        this.targetJobRole = targetJobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getResumeId() {
        return resumeId;
    }

    public T getTargetJobRole() {
        return targetJobRole;
    }

    public void displayResumeDetails() {
        System.out.println("\nResume ID: " + resumeId);
        System.out.println("Candidate Name: " + candidateName);
        targetJobRole.displayRoleDetails();
    }

    // Method to simulate screening logic
    public boolean screenResume() {
        System.out.println("Screening resume for " + candidateName + " for role: " + targetJobRole.getTitle());
        // Simple screening logic: always pass for demonstration
        return true;
    }
}