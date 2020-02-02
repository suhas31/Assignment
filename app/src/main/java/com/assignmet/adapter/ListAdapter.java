package com.assignmet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.assignmet.model.ListRows;
import com.assignmet.R;
import com.assignmet.databinding.ListBinding;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<ListRows> arrayList;
    private Context context;
    private LayoutInflater layoutInflater;

    public ListAdapter(ArrayList<ListRows> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ListBinding myListBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false);
        return new ViewHolder(myListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListRows listRows = arrayList.get(position);
        holder.bind(listRows);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ListBinding listBinding;

        public ViewHolder(@NonNull ListBinding myListBinding) {
            super(myListBinding.getRoot());
            this.listBinding = myListBinding;
        }

        public void bind(ListRows listRows) {
            this.listBinding.setListmodel(listRows);
            listBinding.executePendingBindings();
        }

        public ListBinding getListBinding() {
            return listBinding;
        }
    }
}
