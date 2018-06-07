package com.example.batikan.listviewexample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;

public class ListViewActivity extends AppCompatActivity {

    // HashMap
    private String[] ulkeler =
            {"Türkiye", "Almanya", "Avusturya", "Amerika","İngiltere",
                    "Macaristan", "Yunanistan", "Rusya", "Suriye", "İran", "Irak",
                    "Şili", "Brezilya"};

    private HashMap<String, String> map = new HashMap<>();

    void kitalar(){
        map.put("Türkiye", "Asya ve Avrupa");
        map.put("Almanya", "Avrupa");
        map.put("Avusturya", "Avrupa");
        map.put("Amerika", "Kendisi Büyük Bir Kıta");
        map.put("İngiltere", "Avrupa");
        map.put("Macaristan", "Avrupa");
        map.put("Yunanistan", "Avrupa");
        map.put("Rusya", "Asya");
        map.put("Suriye", "Asya");
        map.put("İran", "Asya");
        map.put("Irak", "Asya");
        map.put("Şili", "Güney Amerika");
        map.put("Brezilya", "Güney Amerika");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listemiz=(ListView) findViewById(R.id.listView1);

        //(B) adımı
        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler);

        //(C) adımı
        listemiz.setAdapter(veriAdaptoru);
        kitalar();
        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final String ulke = ulkeler[position];


                AlertDialog.Builder diyalogOlusturucu =
                        new AlertDialog.Builder(ListViewActivity.this);

                diyalogOlusturucu.setMessage(map.get(ulke))

                        .setCancelable(false)
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                diyalogOlusturucu.create().show();
            }
        });
    }
}
