package com.example.recycleviewtest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewtest.R;
import com.example.recycleviewtest.model.Movie;

import java.util.List;

public class AdapterMovies extends RecyclerView.Adapter<AdapterMovies.MyViewHolder> {
    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView gender;
        private TextView year;
        private ImageView rate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textViewTitle);
            gender = itemView.findViewById(R.id.textViewGender);
            year = itemView.findViewById(R.id.textViewYear);
            rate = itemView.findViewById(R.id.imageViewRate);
        }
    }

    private List<Movie> movies;

    public AdapterMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_details, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = this.movies.get(position);

        holder.title.setText(movie.getTitle());
        holder.gender.setText(movie.getGender());
        holder.year.setText(movie.getYear().toString());
        holder.rate.setImageResource(movie.getRate() > 70 ? R.drawable.ic_baseline_star_rate_24 : R.drawable.ic_baseline_star_half_24);
    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }
}
