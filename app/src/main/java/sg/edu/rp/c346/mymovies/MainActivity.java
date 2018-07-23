package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ListView lvMovie;
    ArrayList<Movie> alMovie;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMovie = findViewById(R.id.listViewMovie);
        alMovie = new ArrayList<>();
        Calendar date1 = Calendar.getInstance();
        date1.set(2014, 11, 15);
        Movie movie1 = new Movie("The Avengers", "2012", "pg13", "Action | Sci-Fi", date1, "Golden VIllage - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.", 4);
        date1.set(2015, 5, 15);
        Movie movie2 = new Movie("Planes", "2013", "pg", "Animation | Comedy", date1, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.", 2);
        alMovie.add(movie1);
        alMovie.add(movie2);
        caMovie = new CustomAdapter(this, R.layout.movie_items, alMovie);
        lvMovie.setAdapter(caMovie);
        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie currentMovie = alMovie.get(i);
                Intent intent = new Intent(getApplicationContext(),DetailedMovie.class);
                intent.putExtra("title", currentMovie.getTitle());
                intent.putExtra("year", currentMovie.getYear() + " - " + currentMovie.getGenre());
                intent.putExtra("desc", currentMovie.getDescription());
                intent.putExtra("watch", currentMovie.getDateString());
                intent.putExtra("theater", currentMovie.getIn_theatre());
                intent.putExtra("rating", currentMovie.getRated());
                intent.putExtra("userRating", currentMovie.getRating());
                startActivity(intent);
            }
        });
    }

}
