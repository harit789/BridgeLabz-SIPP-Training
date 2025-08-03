package Generics.PersonalizedMealPlanGenerator;

import java.util.ArrayList;
import java.util.List;

public class MealPlanGenerator {

    // Generic method to validate and generate a personalized meal plan
    public static void generateMealPlan(String userName, List<Meal<? extends MealPlan>> meals) {
        System.out.println("\n--- Generating Meal Plan for " + userName + " ---");
        if (meals.isEmpty()) {
            System.out.println("No meals selected for the plan.");
            return;
        }

        System.out.println("Your Personalized Meal Plan:");
        for (Meal<? extends MealPlan> meal : meals) {
            meal.displayMeal();
            meal.getMealPlanType().prepareMeal();
        }
        System.out.println("Meal plan generated successfully!");
    }

    public static void main(String[] args) {
        // Create different meal types
        VegetarianMeal veggieBurger = new VegetarianMeal("Veggie Burger", "Black beans, quinoa, lettuce, tomato");
        VeganMeal lentilSoup = new VeganMeal("Lentil Soup", "Lentils, carrots, celery, vegetable broth");
        KetoMeal salmonAvocado = new KetoMeal("Salmon with Avocado Salad", "Salmon, avocado, mixed greens");
        HighProteinMeal chickenBroccoli = new HighProteinMeal("Grilled Chicken with Broccoli", "Chicken breast, broccoli, olive oil");

        System.out.println("\n============================================");
        System.out.println("  PERSONALIZED MEAL PLAN GENERATOR");
        System.out.println("============================================");

        // Create Meal objects using the generic Meal class
        Meal<VegetarianMeal> mondayLunch = new Meal<>("Monday Lunch", veggieBurger);
        Meal<VeganMeal> tuesdayDinner = new Meal<>("Tuesday Dinner", lentilSoup);
        Meal<KetoMeal> wednesdayBreakfast = new Meal<>("Wednesday Breakfast", salmonAvocado);
        Meal<HighProteinMeal> thursdayDinner = new Meal<>("Thursday Dinner", chickenBroccoli);

        // Generate a meal plan for a user
        List<Meal<VegetarianMeal>> user1Meals = new ArrayList<>();
        user1Meals.add(mondayLunch);
        generateMealPlan("Sohil", (List<Meal<? extends MealPlan>>) (List<?>) user1Meals);
        System.out.println("--------------------------------------------");

        List<Meal<VeganMeal>> user2Meals = new ArrayList<>();
        user2Meals.add(tuesdayDinner);
        generateMealPlan("Raj", (List<Meal<? extends MealPlan>>) (List<?>) user2Meals);
        System.out.println("--------------------------------------------");

        List<Meal<? extends MealPlan>> mixedMeals = new ArrayList<>();
        mixedMeals.add(mondayLunch);
        mixedMeals.add(tuesdayDinner);
        mixedMeals.add(wednesdayBreakfast);
        mixedMeals.add(thursdayDinner);
        generateMealPlan("Tanuj (Mixed Plan)", mixedMeals);
        System.out.println("--------------------------------------------");
    }
}