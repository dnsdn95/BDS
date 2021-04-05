package com.example.hometown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hometown.adapter.ApartAdapter;
import com.example.hometown.item.ApartItem;

public class ApartActivity extends AppCompatActivity {
    ListView listview ;
    ApartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apart);

        adapter = new ApartAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.apart_list);
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.apart),
                "e편한세상", "광진구 구의동 ") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.apart),
                "자이", "광진구 자양동 ") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.apart),
                "sk뷰", "광진구 중곡동") ;

        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ApartItem item = (ApartItem) parent.getItemAtPosition(position) ;
                String titleStr = item.getTitle() ;
                String descStr = item.getDesc() ;

                Intent intent = new Intent(ApartActivity.this, DetailActivity.class);
                intent.putExtra("title",titleStr);
                intent.putExtra("desc",descStr);
                intent.putExtra("type",1);
                startActivity(intent);

            }
        }) ;
    }
}