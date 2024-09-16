package com.movi.mynotenavegable.ui.nota;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.movi.mynotenavegable.R;
import com.movi.mynotenavegable.modelo.Nota;
import java.util.ArrayList;
import java.util.List;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolderNota> {

    private List<Nota> listNotas;
    private LayoutInflater li;

    public NotaAdapter(LayoutInflater li) {
        this.li = li;
        this.listNotas = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolderNota onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.tarjeta, parent, false);
        return new ViewHolderNota(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderNota holder, int position) {
        Nota nota = listNotas.get(position);
        holder.tvNombre.setText(nota.getNombre());
        holder.tvNota.setText(nota.getNota());
    }

    @Override
    public int getItemCount() {
        return listNotas.size();
    }

    public void setNotas(List<Nota> notas) {
        this.listNotas = notas;
        notifyDataSetChanged();
    }

    public class ViewHolderNota extends RecyclerView.ViewHolder {
        TextView tvNombre, tvNota;

        public ViewHolderNota(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvTitulo);
            tvNota = itemView.findViewById(R.id.tvNota);
        }
    }
}

