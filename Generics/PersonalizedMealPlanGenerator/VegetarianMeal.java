package Generics.PersonalizedMealPlanGenerator;

public class VegetarianMeal implements MealPlan {
    private String name;
    private String ingredients;

    public VegetarianMeal(String name, String ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public String getDescription() {
        return name + " (Ingredients: " + ingredients + ")";
    }

    @Override
    public void prepareMeal() {
        System.out.println("Preparing vegetarian meal: " + name);
    }
}