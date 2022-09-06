package com.example.recycleviewtest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.recycleviewtest.R;
import com.example.recycleviewtest.RecyclerItemClickListener;
import com.example.recycleviewtest.adapter.AdapterMovies;
import com.example.recycleviewtest.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView reciclerViewMovies;
    private List<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getMovies();

        reciclerViewMovies = findViewById(R.id.reciclerViewMovies);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        reciclerViewMovies.setLayoutManager(layoutManager);
        reciclerViewMovies.setHasFixedSize(true);
        reciclerViewMovies.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));

        AdapterMovies adapter = new AdapterMovies(this.movies);
        reciclerViewMovies.setAdapter(adapter);

        reciclerViewMovies.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                reciclerViewMovies,
                new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Movie movie = movies.get(position);
                Toast.makeText(MainActivity.this, movie.getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Movie movie = movies.get(position);
                Toast.makeText(MainActivity.this, movie.getTitle() + " - " + movie.getYear().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }));
    }

    private void getMovies() {
        Movie movie = new Movie("Doutor Estranho no Multiverso da Loucura", "Ação", 2022, 75);
        this.movies.add(movie);

        movie = new Movie("O Carinha", "Comédia", 2022, 78);
        this.movies.add(movie);

        movie = new Movie("365 Dias Finais", "Romance", 2022, 68);
        this.movies.add(movie);

        movie = new Movie("A Hora do Desespero", "Thriller", 2021, 61);
        this.movies.add(movie);

        movie = new Movie("Shang-Chi e a Lenda dos Dez Anéis", "Ação", 2021, 77);
        this.movies.add(movie);

        movie = new Movie("Morbius", "Ação", 2022, 65);
        this.movies.add(movie);

        movie = new Movie("After: Depois da Verdade", "Drama", 2020, 73);
        this.movies.add(movie);

        movie = new Movie("A Órfã", "Drama", 2009, 70);
        this.movies.add(movie);
    }
}