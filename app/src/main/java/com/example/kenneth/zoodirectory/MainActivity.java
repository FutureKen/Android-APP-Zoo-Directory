package com.example.kenneth.zoodirectory;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    List<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // build animal list
        animals = new ArrayList<>();
        animals.add(new Animal("Cute Cat", "cat-icon.png", "I'm not cute at all, I'm wild!", false));
        animals.add(new Animal("Chubby Panda", "panda-icon.png", "Lovely shape is not the real me, I am the master between light and dark.", false));
        animals.add(new Animal("Night Owl", "owl-icon.png", "Under the lunar light, I am the guardian of ancient spirit.", false));
        animals.add(new Animal("Snow Leopard", "snow-leopard-icon.png", "Let's go hunt, Mirana, I'm vigilant!", false));
        animals.add(new Animal("Yellow Dog", "dog-icon.png", "Wooong! Wooong! Wooong! Give me a bone!", false));
        animals.add(new Animal("Keeper David", "devid-icon.png", "Haha, I am the king here, they all act in obedience to me. Wait, why am I in a list of animals, get me oooooooout!", false));

        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new AnimalArrayAdaptor(this, R.layout.custom_row, animals));
        lv.setOnItemClickListener(this);

/*
        final ImageView fav = (ImageView) findViewById(R.id.fav);

        fav.setOnClickListener(new View.OnClickListener(){

            public void onClick(AdapterView<?> parent, View view, int position, long id)
            {
                Boolean favornot = animals.get(position)
                fav.set
                toast("something happend");

            }
        });

*/

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Animal animal = animals.get(position);

        Bundle args = new Bundle();
        args.putString("name", animal.getName());
        args.putString("logo", animal.getFilename());
        args.putString("desc", animal.getDescription());

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtras(args);
        if (position == animals.size() - 1) {
            alertbox(intent);
        } else {
            startActivity(intent);
        }
    }


    public void alertbox(final Intent intent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.mipmap.warning)
                .setTitle("Be careful")
                .setMessage("This animal is very dangerous, it may makes you feel uncomfortable, do you insist to take a look?")
                .setPositiveButton("Yes, never afraid!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No, I'm a coward!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Back to safety.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setCancelable(false)
        ;
        builder.create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.action_about:
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
                break;
            case R.id.action_uninstall:
                Intent uninstall = new Intent(Intent.ACTION_DELETE, Uri.parse("package:com.example.kenneth.zoodirectory"));
                startActivity(uninstall);
                break;
            default:
                toast("unknown action ...");
        }

        return true;
    }

    private void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}


