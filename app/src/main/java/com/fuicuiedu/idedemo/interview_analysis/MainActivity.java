package com.fuicuiedu.idedemo.interview_analysis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.fuicuiedu.idedemo.interview_analysis.xml.XmlActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String[] dates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.main_lv);

        dates = new String[]{
                "xml解析",
                "json解析",
                "html解析"
        };

        adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,dates);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), XmlActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"json解析未实现",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"html解析未实现",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
