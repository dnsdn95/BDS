package com.example.hometown;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hometown.adapter.VillaAdapter;
import com.example.hometown.item.VillatItem;

public class VillaActivity extends AppCompatActivity {
    ListView listview ;
    VillaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_villa);

        adapter = new VillaAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.villa_list);
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.villa),
                "보나빌라", "광진구 구의동 ") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.villa),
                "삼광빌라", "광진구 자양동 ") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.villa),
                "선경빌라", "광진구 중곡동") ;

        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                VillatItem item = (VillatItem) parent.getItemAtPosition(position) ;
                String titleStr = item.getTitle() ;
                String descStr = item.getDesc() ;

                Intent intent = new Intent(VillaActivity.this, DetailActivity.class);
                intent.putExtra("title",titleStr);
                intent.putExtra("desc",descStr);
                intent.putExtra("type",2);
                startActivity(intent);

            }
        }) ;
    }
}