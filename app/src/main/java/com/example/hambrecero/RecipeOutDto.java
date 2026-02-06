package com.example.hambrecero;

import java.util.List;

public class RecipeOutDto {

    private long id;
    private String name;
    private int difficulty;
    private boolean vegetarian;
    private double estimatedCost;
    private String lastModified;
    private int servings;
    private List<Long> ingredientIds;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public String getLastModified() {
        return lastModified;
    }

    public int getServings() {
        return servings;
    }

    public List<Long> getIngredientIds() {
        return ingredientIds;
    }
}
