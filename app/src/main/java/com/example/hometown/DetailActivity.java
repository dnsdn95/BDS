package com.example.hometown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView title,desc;
    String title_text, desc_text;
    ImageView image;
    int type ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        image = findViewById(R.id.image);
        Intent intent = getIntent();
        title_text = intent.getStringExtra("title");
        desc_text = intent.getStringExtra("desc");
        type = intent.getIntExtra("type",0);

        if (type ==1){
            image.setImageDrawable(getResources().getDrawable(R.drawable.apart));
        } else if (type == 2){
            image.setImageDrawable(getResources().getDrawable(R.drawable.villa));
        } else if(type == 3){
            image.setImageDrawable(getResources().getDrawable(R.drawable.opis));
        }
        title = findViewById(R.id.title);
        title.setText(title_text);
        desc = findViewById(R.id.desc);
        desc.setText(desc_text);
    }
}