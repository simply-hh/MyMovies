package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 16039009 on 23/7/2018.
 */

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> movies;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movies = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Inflate a new view hierarchy from the specified xml resource (layout_id)
        // and return the root View of the inflated hierarchy.
        View rowView = inflater.inflate(layout_id, parent, false);
        ImageView ivRating = rowView.findViewById(R.id.imageView);
        TextView tvTitle =  rowView.findViewById(R.id.textViewTitle);
        TextView tvDesc = rowView.findViewById(R.id.textViewDesc);
        Movie currentItem = movies.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvDesc.setText(currentItem.getYear() + " - " + currentItem.getGenre());
        if (currentItem.getRated().equals("g")) {
            ivRating.setImageResource(R.drawable.rating_g);
        }
        else if (currentItem.getRated().equals("pg")){
            ivRating.setImageResource(R.drawable.rating_pg);
        }
        else if (currentItem.getRated().equals("pg13")){
            ivRating.setImageResource(R.drawable.rating_pg13);
        }
        else if (currentItem.getRated().equals("nc16")) {
            ivRating.setImageResource(R.drawable.rating_nc16);
        }
        else if (currentItem.getRated().equals("m18")) {
            ivRating.setImageResource(R.drawable.rating_m18);
        }
        else{
            ivRating.setImageResource(R.drawable.rating_r21);
        }
        return rowView;
    }
}
