package fr.sons_of_a_peach.masterfruits;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuRecAdapter extends RecyclerView.Adapter<RecViewHolder>{

    private ArrayList<Integer> mList = new ArrayList<>();
    Activity context;

    public MenuRecAdapter(ArrayList<Integer> mList){
        this.mList = mList;
    }

    public int getItemCount(){
        return mList.size();
    }

    public RecViewHolder onCreateViewHolder(ViewGroup viewGroup, int position){

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_row_item, viewGroup, false);
        RecViewHolder pvh = new RecViewHolder(v);
        return pvh;
    }

    public void onBindViewHolder(RecViewHolder holder, int i){
        holder.menuText.setText(mList.get(i));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
