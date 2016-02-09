package com.example.kenneth.zoodirectory;

/**
 * Created by Kenneth on 2/5/2016.
 */

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_animalview);


        TextView title = (TextView) findViewById(R.id.animal_title);
        title.setText(getIntent().getExtras().getString("name"));
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(getIntent().getExtras().getString("desc"));

        try {
            ImageView imageView = (ImageView) findViewById(R.id.fullsizeimg);
            String filename = getIntent().getExtras().getString("logo");
            InputStream inputStream = getAssets().open(filename);
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Button button = (Button) findViewById(R.id.backbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
