package fr.sons_of_a_peach.masterfruits;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecViewHolder extends RecyclerView.ViewHolder {

    public ImageView menuText;

    public RecViewHolder(View itemView){
        super(itemView);

        menuText = (ImageView)itemView.findViewById(R.id.imageView);
    }
}