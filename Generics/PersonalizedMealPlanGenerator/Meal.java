package Generics.PersonalizedMealPlanGenerator;

public class Meal<T extends MealPlan> {
    private String mealName;
    private T mealPlanType;

    public Meal(String mealName, T mealPlanType) {
        this.mealName = mealName;
        this.mealPlanType = mealPlanType;
    }

    public String getMealName() {
        return mealName;
    }

    public T getMealPlanType() {
        return mealPlanType;
    }

    public void displayMeal() {
        System.out.println("Meal: " + mealName + ", Type: " + mealPlanType.getMealType() + ", Description: " + mealPlanType.getDescription());
    }
}