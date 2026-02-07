package com.example.hambrecero;

import java.util.Locale;

public class RecetaMapper {

    public static Receta fromApi(RecipeOutDto dto) {

        // ✅ CORTA (para la lista): solo coste
        String corta = String.format(Locale.getDefault(),
                "Coste: %.2f €", dto.getEstimatedCost());

        // ✅ LARGA (para el detalle): todo
        String larga = "Coste: " + dto.getEstimatedCost() + " €"
                + "\nRaciones: " + dto.getServings()
                + "\nDificultad: " + dto.getDifficulty()
                + "\nVegetariana: " + (dto.isVegetarian() ? "Sí" : "No");
                //+ "\nÚltima modificación: " + dto.getLastModified();

        int img = R.drawable.hortalizas;

        return new Receta(dto.getId(), dto.getName(), corta, larga, img);
    }
}

