package com.example.iot_plantmate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Tutoriales extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;
    private List<String> videoUrls;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutoriales);

        // Inicializar la lista de URLs de videos
        videoUrls = new ArrayList<>();
        videoUrls.add("https://www.youtube.com/watch?v=VgJdIpcYwwg");
        videoUrls.add("https://www.youtube.com/watch?v=mkbaohuanNo");
        videoUrls.add("https://www.youtube.com/watch?v=ET2iTNOJTG8");
        videoUrls.add("https://www.youtube.com/watch?v=uniGzuqH3nE");
        videoUrls.add("https://www.youtube.com/watch?v=lFAlXkWK9X0");
        videoUrls.add("https://www.youtube.com/watch?v=3ywZU8Znmbk");
        videoUrls.add("https://www.youtube.com/watch?v=qyo6VBEWSJE");
        videoUrls.add("https://www.youtube.com/watch?v=sqRj7TXO9AI");
        // Agregar más URLs de videos según sea necesario

        // Configurar el RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        videoAdapter = new VideoAdapter(this, videoUrls);
        recyclerView.setAdapter(videoAdapter);
    }
}