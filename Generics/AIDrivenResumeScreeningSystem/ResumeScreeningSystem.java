package Generics.AIDrivenResumeScreeningSystem;

import java.util.ArrayList;
import java.util.List;

public class ResumeScreeningSystem {

    // Wildcard method to process a list of resumes for various job roles
    public static void processResumes(List<? extends JobRole> jobRoles, List<Resume<? extends JobRole>> resumes) {
        System.out.println("\n--- Processing Resumes for Various Job Roles ---");
        if (resumes.isEmpty()) {
            System.out.println("No resumes to process.");
            return;
        }

        for (Resume<? extends JobRole> resume : resumes) {
            resume.displayResumeDetails();
            if (resume.screenResume()) {
                System.out.println("Resume for " + resume.getCandidateName() + " passed screening.");
            } else {
                System.out.println("Resume for " + resume.getCandidateName() + " failed screening.");
            }
        }
    }

    public static void main(String[] args) {
        // Define different job roles
        SoftwareEngineer seRole = new SoftwareEngineer("Software Engineer", "Engineering", "Java");
        DataScientist dsRole = new DataScientist("Data Scientist", "Analytics", "Machine Learning");
        ProductManager pmRole = new ProductManager("Product Manager", "Product", "SaaS");

        System.out.println("\n============================================");
        System.out.println("  AI-DRIVEN RESUME SCREENING SYSTEM");
        System.out.println("============================================");

        // Create resumes for different job roles
        Resume<SoftwareEngineer> resume1 = new Resume<>("Sohil khan", "RES001", seRole);
        Resume<DataScientist> resume2 = new Resume<>("Raj varshney", "RES002", dsRole);
        Resume<ProductManager> resume3 = new Resume<>("Tanuj", "RES003", pmRole);

        // Add resumes to a list for processing
        List<Resume<? extends JobRole>> allResumes = new ArrayList<>();
        allResumes.add(resume1);
        allResumes.add(resume2);
        allResumes.add(resume3);

        // Define a list of job roles (can be used for filtering/matching)
        List<JobRole> availableJobRoles = new ArrayList<>();
        availableJobRoles.add(seRole);
        availableJobRoles.add(dsRole);
        availableJobRoles.add(pmRole);

        // Process all resumes using the wildcard method
        processResumes(availableJobRoles, allResumes);
        System.out.println("--------------------------------------------");

        // Example of screening a specific resume
        System.out.println("\n--- Screening a Specific Resume ---");
        System.out.println("--------------------------------------------");
        resume1.displayResumeDetails();
        if (resume1.screenResume()) {
            System.out.println("Resume for " + resume1.getCandidateName() + " passed individual screening.");
        } else {
            System.out.println("Resume for " + resume1.getCandidateName() + " failed individual screening.");
        }
        System.out.println("--------------------------------------------");
    }
}