package Generics.PersonalizedMealPlanGenerator;

public class VeganMeal implements MealPlan {
    private String name;
    private String ingredients;

    public VeganMeal(String name, String ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public String getDescription() {
        return name + " (Ingredients: " + ingredients + ")";
    }

    @Override
    public void prepareMeal() {
        System.out.println("Preparing vegan meal: " + name);
    }
}