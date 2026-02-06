package com.example.hambrecero;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecetaAdapter extends RecyclerView.Adapter<RecetaAdapter.VH> {

    private final Context context;
    private final List<Receta> lista;

    public RecetaAdapter(Context context, List<Receta> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_receta, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Receta r = lista.get(position);

        holder.tvNombre.setText(r.getNombre());
        holder.tvDesc.setText(r.getDescripcion());

        // Imagen local (si la tienes)
        if (r.getImgResId() != 0) {
            holder.img.setImageResource(r.getImgResId());
        }

        // Click en el item -> abre detalle
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetalleRecetaActivity.class);
            intent.putExtra("id", r.getId());
            intent.putExtra("nombre", r.getNombre());
            intent.putExtra("descripcion", r.getDescripcion());
            intent.putExtra("imgResId", r.getImgResId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvNombre, tvDesc;

        VH(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgItemReceta);
            tvNombre = itemView.findViewById(R.id.tvItemNombre);
            tvDesc = itemView.findViewById(R.id.tvItemDesc);
        }
    }
}
