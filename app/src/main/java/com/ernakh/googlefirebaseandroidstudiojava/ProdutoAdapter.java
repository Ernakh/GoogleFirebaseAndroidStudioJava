package com.ernakh.googlefirebaseandroidstudiojava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder> {
    private List<Produto> produtos;

    public interface OnItemClickListener {
        void onItemClick(Produto produto);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public ProdutoAdapter(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int pos) {
        Produto p = produtos.get(pos);
        holder.txt1.setText(p.getNome());
        holder.txt2.setText("Estoque: " + p.getEstoque());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt1, txt2;
        public ViewHolder(View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(android.R.id.text1);
            txt2 = itemView.findViewById(android.R.id.text2);
        }
    }
}

