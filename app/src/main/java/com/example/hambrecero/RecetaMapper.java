package com.example.hambrecero;

public class RecetaMapper {

    public static Receta fromApi(RecipeOutDto dto) {

        String descripcion = "Coste: " + dto.getEstimatedCost() + "€"
                + "\nRaciones: " + dto.getServings()
                + "\nDificultad: " + dto.getDifficulty()
                + "\nVegetariana: " + (dto.isVegetarian() ? "Sí" : "No")
                + "\nÚltima modificación: " + dto.getLastModified();

        int img = R.drawable.lentejas; // imagen por defecto
        return new Receta(dto.getId(), dto.getName(), descripcion, img);
    }
}
