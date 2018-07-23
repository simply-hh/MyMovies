package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailedMovie extends AppCompatActivity {
    ImageView ivRating;
    TextView title;
    TextView year;
    TextView desc;
    TextView watched;
    TextView theater;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_movie);
        ivRating = findViewById(R.id.imageViewRating);
        title = findViewById(R.id.textViewTitle);
        year = findViewById(R.id.textViewYear);
        desc = findViewById(R.id.textViewDesc);
        watched = findViewById(R.id.textViewWatch);
        theater = findViewById(R.id.textViewTheater);
        ratingBar = findViewById(R.id.ratingBar);
        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        year.setText(intent.getStringExtra("year"));
        desc.setText(intent.getStringExtra("desc"));
        watched.setText(intent.getStringExtra("watch"));
        theater.setText(intent.getStringExtra("theater"));
        String rating = intent.getStringExtra("rating");
        if (rating.equals("g")) {
            ivRating.setImageResource(R.drawable.rating_g);
        }
        else if (rating.equals("pg")){
            ivRating.setImageResource(R.drawable.rating_pg);
        }
        else if (rating.equals("pg13")){
            ivRating.setImageResource(R.drawable.rating_pg13);
        }
        else if (rating.equals("nc16")) {
            ivRating.setImageResource(R.drawable.rating_nc16);
        }
        else if (rating.equals("m18")) {
            ivRating.setImageResource(R.drawable.rating_m18);
        }
        else{
            ivRating.setImageResource(R.drawable.rating_r21);
        }
        int userRating = intent.getIntExtra("userRating", 0);
        ratingBar.setRating(userRating);
    }
}
