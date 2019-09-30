package com.danhnh.project2609.adapter.ads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.danhnh.project2609.R;
import com.danhnh.project2609.model.Advertisement;

import java.util.ArrayList;

public class AdsImageAdapter extends RecyclerView.Adapter<AdsImageAdapter.AdsHolder> {
    private ArrayList<Advertisement> advertisementList;
    private Context context;
    public AdsImageAdapter(ArrayList<Advertisement> advertisementList, Context context) {
        this.advertisementList = advertisementList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdsImageAdapter.AdsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_image_slider, null);
        AdsHolder mh = new AdsHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdsImageAdapter.AdsHolder holder, int position) {

            Advertisement itemAds = advertisementList.get(position);
            holder.imgView.setImageResource( itemAds.getImage());

    }

    @Override
    public int getItemCount() {
        return advertisementList.size();
    }

    public class AdsHolder extends RecyclerView.ViewHolder {
            protected ImageView imgView;

        public AdsHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.single_image);
            imgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), imgView.getId()+"" , Toast.LENGTH_SHORT).show();

                }
            });
        }
    }


}
