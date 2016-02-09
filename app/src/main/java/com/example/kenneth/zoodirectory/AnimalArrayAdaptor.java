package com.example.kenneth.zoodirectory;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class AnimalArrayAdaptor extends ArrayAdapter<Animal> {
    private final List<Animal> animals;

    public AnimalArrayAdaptor(Context context, int resource, List<Animal> animals) {
        super(context, resource, animals);
        this.animals = animals;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_row, null);

        final TextView textView = (TextView) row.findViewById(R.id.label);
        textView.setText(animals.get(position).getName());
        final ImageView favicon = (ImageView) row.findViewById(R.id.fav);

        favicon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                animals.get(position).changeFav();
                Toast.makeText(getContext(), animals.get(position).isFav() ? textView.getText() + " is your fav now!" : textView.getText() + "is NOT your fav any more!", Toast.LENGTH_SHORT).show();

                try {
                    if (animals.get(position).isFav()) {
                        favicon.setImageResource(R.mipmap.fav_icon);
                    } else {
                        favicon.setImageResource(R.mipmap.unfav_icon);
                    }
                    favicon.setScaleType(ImageView.ScaleType.CENTER_CROP);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            ImageView imageView = (ImageView) row.findViewById(R.id.icon);
            String filename = animals.get(position).getFilename();
            InputStream inputStream = getContext().getAssets().open(filename);
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);


            if (animals.get(position).isFav()) {
                favicon.setImageResource(R.mipmap.fav_icon);
            } else {
                favicon.setImageResource(R.mipmap.unfav_icon);
            }
            favicon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return row;
    }
}
