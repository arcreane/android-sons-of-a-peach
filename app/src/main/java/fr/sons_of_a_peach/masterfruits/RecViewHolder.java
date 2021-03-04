package fr.sons_of_a_peach.masterfruits;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecViewHolder extends RecyclerView.ViewHolder {

    public TextView menuText;

    public RecViewHolder(View itemView){
        super(itemView);

        menuText = (TextView)itemView.findViewById(R.id.textView);
    }
}