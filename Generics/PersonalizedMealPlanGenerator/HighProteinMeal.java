package Generics.PersonalizedMealPlanGenerator;

public class HighProteinMeal implements MealPlan {
    private String name;
    private String ingredients;

    public HighProteinMeal(String name, String ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public String getDescription() {
        return name + " (Ingredients: " + ingredients + ")";
    }

    @Override
    public void prepareMeal() {
        System.out.println("Preparing high-protein meal: " + name);
    }
}