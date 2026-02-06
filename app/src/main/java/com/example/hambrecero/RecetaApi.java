package com.example.hambrecero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RecetaApi {

    @GET("recipes")
    Call<List<RecipeOutDto>> getRecipes();

    @GET("recipes/{id}")
    Call<RecipeOutDto> getRecipeById(@Path("id") long id);
}
