package com.doubleclick.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doubleclick.retrofit.Model.Post;
import com.doubleclick.retrofit.R;

import java.util.List;

/**
 * Created By Eslam Ghazy on 7/23/2022
 */
public class adapter extends RecyclerView.Adapter<adapter.viewHolder> {

    private List<Post> poats;

    public adapter(List<Post> poats) {
        this.poats = poats;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.title.setText(poats.get(position).getTitle());
        holder.userId.setText("" + poats.get(position).getUserId());
    }

    @Override
    public int getItemCount() {
        return poats.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private TextView userId, title;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            title = itemView.findViewById(R.id.title);
        }
    }
}
