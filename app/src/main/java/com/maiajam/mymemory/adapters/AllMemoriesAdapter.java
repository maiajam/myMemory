package com.maiajam.mymemory.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maiajam.mymemory.R;
import com.maiajam.mymemory.data.models.Memories;

import java.util.List;

public class AllMemoriesAdapter extends RecyclerView.Adapter<AllMemoriesAdapter.MemoriesHolder> {

    Context context;
    List<Memories> memoriesList ;

    public AllMemoriesAdapter(Context context,List<Memories> memoriesList) {
        this.context = context ;
        this.memoriesList = memoriesList;
    }

    @NonNull
    @Override
    public MemoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memory,null);
        return new MemoriesHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MemoriesHolder holder, int position) {

        Memories memoriyItem = new Memories();
        memoriyItem = memoriesList.get(position);

        holder.MemoryCOntent_txt.setText(memoriyItem.getMemoriesContent().toString());

    }

    @Override
    public int getItemCount() {
        return memoriesList.size();
    }

    public class MemoriesHolder extends RecyclerView.ViewHolder{

        TextView MemoryNameOwner_txt,MemoryCOntent_txt;
        public MemoriesHolder(@NonNull View itemView) {
            super(itemView);
            MemoryCOntent_txt =(TextView)itemView.findViewById(R.id.itemMemory_txt_MemoryContent);
            MemoryNameOwner_txt =(TextView)itemView.findViewById(R.id.itemMemory_txt_name);;
        }
    }
}
