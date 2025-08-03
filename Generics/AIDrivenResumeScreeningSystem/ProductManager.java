package Generics.AIDrivenResumeScreeningSystem;

public class ProductManager extends JobRole {
    private String productFocus;

    public ProductManager(String title, String department, String productFocus) {
        super(title, department);
        this.productFocus = productFocus;
    }

    @Override
    public void displayRoleDetails() {
        System.out.println("Job Role: " + getTitle() + ", Department: " + getDepartment() + ", Product Focus: " + productFocus);
    }
}