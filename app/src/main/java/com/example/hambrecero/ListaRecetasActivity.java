package com.example.hambrecero;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaRecetasActivity extends AppCompatActivity {

    private RecyclerView rvRecetas;
    private RecetaAdapter adapter;
    private final List<Receta> recetas = new ArrayList<>();
    private TextView tvEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_recetas);

        Log.d("API", "ONCREATE ListaRecetasActivity");

        tvEmpty = findViewById(R.id.tvEmpty);

        rvRecetas = findViewById(R.id.rvRecetas);
        rvRecetas.setLayoutManager(new LinearLayoutManager(this));

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

                    actualizarEmptyState();

                } else {
                    String err = "";
                    try {
                        if (response.errorBody() != null) err = response.errorBody().string();
                    } catch (IOException ignored) {}

                    Log.e("API", "Error " + response.code() + " body=" + err);

                    recetas.clear();
                    adapter.notifyDataSetChanged();
                    actualizarEmptyState();
                }
            }

            @Override
            public void onFailure(Call<List<RecipeOutDto>> call, Throwable t) {
                Log.e("API", "Fallo conexión: " + t.getMessage(), t);

                recetas.clear();
                adapter.notifyDataSetChanged();
                actualizarEmptyState();
            }
        });
    }

    private void actualizarEmptyState() {
        if (recetas.isEmpty()) {
            tvEmpty.setVisibility(View.VISIBLE);
            rvRecetas.setVisibility(View.GONE);
        } else {
            tvEmpty.setVisibility(View.GONE);
            rvRecetas.setVisibility(View.VISIBLE);
        }
    }
}
