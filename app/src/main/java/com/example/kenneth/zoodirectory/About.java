package com.example.kenneth.zoodirectory;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



/**
 * Created by Kenneth on 2/8/2016.
 */
public class About extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_page);


        Button button = (Button) findViewById(R.id.backbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView call = (TextView) findViewById(R.id.callus);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myPhoneNumberUri = "tel:888-8888";
                Intent myActivity2 = new Intent(Intent.ACTION_DIAL, Uri.parse(myPhoneNumberUri));
                startActivity(myActivity2);
            }
        });


    }
}
