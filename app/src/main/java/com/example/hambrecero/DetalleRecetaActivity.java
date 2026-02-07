package com.example.hambrecero;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.hambrecero.R;
import android.widget.TextView;
import android.widget.ImageView;


public class DetalleRecetaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_receta);

        TextView tvNombre = findViewById(R.id.tvNombre);
        // TextView tvId = findViewById(R.id.tvId);
        TextView tvDescripcion = findViewById(R.id.tvDescripcion);
        ImageView imgReceta = findViewById(R.id.imgReceta);

        long id = getIntent().getLongExtra("id", -1);
        String nombre = getIntent().getStringExtra("nombre");
        String descripcion = getIntent().getStringExtra("descripcion");
        int imgResId = getIntent().getIntExtra("imgResId", 0);

        tvNombre.setText(nombre != null ? nombre : "Sin nombre");
        // tvId.setText("ID: " + id);
        tvDescripcion.setText(descripcion != null ? descripcion : "Sin descripción");
        if (imgResId != 0) {
            imgReceta.setImageResource(imgResId);
        } else {
            imgReceta.setVisibility(ImageView.GONE);
        }
    }
}
