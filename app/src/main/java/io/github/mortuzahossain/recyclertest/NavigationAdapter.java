package io.github.mortuzahossain.recyclertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mortuza Hossain on 29-Feb-2020
 * Email : mortuzahossain1997@gmail.com
 **/
public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.NavigationAdapterViewHolder> {

    private Context context;
    private List<NavigationModel> navigationModels;

    NavigationAdapter(Context context, List<NavigationModel> navigationModels) {
        this.context = context;
        this.navigationModels = navigationModels;
    }

    @NonNull
    @Override
    public NavigationAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new NavigationAdapterViewHolder(inflater.inflate(R.layout.single, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NavigationAdapterViewHolder holder, int position) {
        NavigationModel navigationModel = navigationModels.get(position % navigationModels.size());
        holder.tvTitle.setText(navigationModel.getTitle());
        holder.imageView.setImageResource(navigationModel.getId());
    }

    public int getActualItemCount() {
        if (navigationModels == null) {
            navigationModels = new ArrayList<>();
        }
        return navigationModels.size();
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    static class NavigationAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView imageView;

        NavigationAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
