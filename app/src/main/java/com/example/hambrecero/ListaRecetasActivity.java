package com.example.hambrecero;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaRecetasActivity extends AppCompatActivity {

    private RecyclerView rvRecetas;
    private RecetaAdapter adapter;
    private List<Receta> recetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_recetas);

        Log.d("API", "ONCREATE ListaRecetasActivity");

        rvRecetas = findViewById(R.id.rvRecetas);

        rvRecetas.setLayoutManager(new LinearLayoutManager(this));

        recetas = new ArrayList<>();

        adapter = new RecetaAdapter(this, recetas);
        rvRecetas.setAdapter(adapter);

        cargarDesdeApi();
    }

    private void cargarDesdeApi() {
        RecetaApi api = ApiClient.getClient().create(RecetaApi.class);

        api.getRecipes().enqueue(new Callback<List<RecipeOutDto>>() {
            @Override
            public void onResponse(Call<List<RecipeOutDto>> call, Response<List<RecipeOutDto>> response) {
                Log.d("API", "Código HTTP: " + response.code());

                if (response.isSuccessful() && response.body() != null) {
                    List<RecipeOutDto> dtos = response.body();
                    Log.d("API", "Recipes recibidas: " + dtos.size());

                    recetas.clear();
                    for (RecipeOutDto dto : dtos) {
                        recetas.add(RecetaMapper.fromApi(dto));
                    }
                    adapter.notifyDataSetChanged();

                    if (recetas.isEmpty()) {
                        Log.d("API", "La API devolvió lista vacía");
                    }
                } else {
                    Log.e("API", "Error " + response.code());
                    usarDatosLocales();
                }
            }

            @Override
            public void onFailure(Call<List<RecipeOutDto>> call, Throwable t) {
                Log.e("API", "Fallo conexión: " + t.getMessage());
                usarDatosLocales();
            }
        });
    }

    private void usarDatosLocales() {
        recetas.clear();
        recetas.add(new Receta(
                1L,
                "Lentejas económicas",
                "Receta fácil, barata y nutritiva",
                R.drawable.lentejas
        ));
        adapter.notifyDataSetChanged();
    }
}
