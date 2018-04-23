package com.example.jjsampayo.livedata;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jjsampayo.livedata.databinding.ItemMainListBinding;

import java.util.ArrayList;

/**
 * Created by
 *      jjsampayo on 19/03/2018.
 */

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolderMain> {
    private Context context;

    private ArrayList<GodModel> data;

    public AdapterMain(Context context, ArrayList<GodModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolderMain onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMainListBinding binding = ItemMainListBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolderMain(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(ViewHolderMain holder, int position) {
        holder.binding.setGodModel(data.get(position));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolderMain extends RecyclerView.ViewHolder {
        ItemMainListBinding binding;

        public ViewHolderMain(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
