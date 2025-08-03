package Generics.PersonalizedMealPlanGenerator;

public class KetoMeal implements MealPlan {
    private String name;
    private String ingredients;

    public KetoMeal(String name, String ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public String getDescription() {
        return name + " (Ingredients: " + ingredients + ")";
    }

    @Override
    public void prepareMeal() {
        System.out.println("Preparing keto meal: " + name);
    }
}