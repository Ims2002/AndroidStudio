package com.jesuspinar.tourism.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jesuspinar.tourism.R;

public class ObjAdapter extends RecyclerView.Adapter<ObjAdapter.ObjViewHolder> {

    //ToDo: Refactor Data array that will be used to handle data through the view holder
    private final Object[] data;
    //private final ArrayList<Object> data;
    //ToDo: Refactor click interface that will be used to handle clicks
    private final IClickListener listener;

    public ObjAdapter(Object[] data, IClickListener listener) {
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ObjAdapter.ObjViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_obj, parent, false);
        return new ObjViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjAdapter.ObjViewHolder holder, int position) {
        Object obj = data[position];
        holder.bindData(obj);
    }

    @Override
    public int getItemCount() {
        assert data != null;
        return data.length;
    }


    /**
     * This class represents a item of the data array
     */
    public static class ObjViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //ToDo: implement obj properties that will be represented
        //private final TextView tvName;
        private final IClickListener listener;

        public ObjViewHolder(View itemView, IClickListener listener) {
            super(itemView);
            //tvName = itemView.findViewById(R.id.tvName);
            this.listener = listener;
        }

        public void bindData(Object o){
            //tvName.setText(o.getName());
        }

        /**
         * It does something when item of the data array is clicked
         * @param view
         */
        @Override
        public void onClick(View view) {
            if (listener != null){
                listener.onClick(getAdapterPosition());
            }
        }
    }
}
