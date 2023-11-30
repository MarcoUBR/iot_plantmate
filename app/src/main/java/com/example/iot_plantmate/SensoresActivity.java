package com.example.iot_plantmate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SensoresActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> listHeaders;
    private HashMap<String, List<String>> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores);


        expandableListView = findViewById(R.id.expandableListView);

        // Datos de ejemplo para la lista expandible (reemplaza con tus datos)
        prepareListData();

        // Configurar adaptador para la lista expandible
        expandableListAdapter = new ExpandableListAdapter(this, listHeaders, listItems);
        expandableListView.setAdapter(expandableListAdapter);
    }

    // Método para preparar datos de ejemplo (reemplaza con tus datos reales)
    private void prepareListData() {
        listHeaders = new ArrayList<>();
        listItems = new HashMap<>();

        // Encabezados (nombres de plantas)
        listHeaders.add("Planta 1");
        listHeaders.add("Planta 2");

        // Contenido (sensores por planta)
        List<String> sensors1 = new ArrayList<>();
        sensors1.add("Sensor 1: Humedad");
        sensors1.add("Sensor 2: Temperatura");

        List<String> sensors2 = new ArrayList<>();
        sensors2.add("Sensor 1: PH");
        sensors2.add("Sensor 2: Luz");

        listItems.put(listHeaders.get(0), sensors1);
        listItems.put(listHeaders.get(1), sensors2);
    }
}