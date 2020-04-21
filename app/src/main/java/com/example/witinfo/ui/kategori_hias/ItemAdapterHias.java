package com.example.witinfo.ui.kategori_hias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.witinfo.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ItemAdapterHias extends RecyclerView.Adapter<ItemAdapterHias.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<ItemDataHias> values;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference first = databaseReference.child("image");

    public ItemAdapterHias(Context context, ArrayList<ItemDataHias> values) {
        this.context=context;
        this.values= values;
        this.inflater=LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.item_list_hias, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ItemDataHias data=values.get(i);
        Glide.with( context)
                .load(data.pictK)
                .into(viewHolder.img_hasil_kategori);
        viewHolder.nama_tanaman.setText (data.namaK);
        viewHolder.harga_tanaman.setText (data.hargaK);
        viewHolder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }
        );

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_hasil_kategori;
        TextView nama_tanaman;
        TextView harga_tanaman;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_hasil_kategori= itemView.findViewById(R.id.image_hasil_kategori);
            nama_tanaman=itemView.findViewById(R.id.nama_tanaman);
            harga_tanaman=itemView.findViewById(R.id.harga_tanaman);


        }
    }
}
