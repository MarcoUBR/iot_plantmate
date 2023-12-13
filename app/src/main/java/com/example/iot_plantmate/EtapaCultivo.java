package com.example.iot_plantmate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class EtapaCultivo extends AppCompatActivity {

    TextView textViewFechaEtapa;
    EditText editTextNombreEtapa, editTextObservaciones, editTextMedidas,
            editTextHorasCalor, editTextTierraEtapa, editTextUbicacionEtapa,
            editTextSubstratoEtapa;

    private FirebaseAuth firebaseAuth;
    private String userId;
    private String idEtapa;  // Nueva variable para almacenar el ID de la etapa

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etapa_cultivo);

        textViewFechaEtapa = findViewById(R.id.textViewFechaEtapa);
        editTextNombreEtapa = findViewById(R.id.editTextNombreEtapa);
        editTextObservaciones = findViewById(R.id.editTextObservaciones);
        editTextMedidas = findViewById(R.id.editTextMedidas);
        editTextHorasCalor = findViewById(R.id.editTextHorascalor);
        editTextTierraEtapa = findViewById(R.id.editTextTierraEtapa);
        editTextUbicacionEtapa = findViewById(R.id.editTextUbicacionEtapa);
        editTextSubstratoEtapa = findViewById(R.id.editTextSubstratoEtapa);

        // Inicializar Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();

        // Obtener el ID del usuario actual
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            userId = user.getUid();
        }

        // Configurar el OnClickListener para el botón de registro
        Button btnRegistrarEtapa = findViewById(R.id.btnRegistrarEtapa);
        btnRegistrarEtapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarEtapa();
            }
        });
    }

    public void mostrarDatePicker(View view) {
        Calendar calendario = Calendar.getInstance();
        int anio = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        // Actualizar el TextView con la fecha seleccionada
                        String fechaSeleccionada = day + "/" + (month + 1) + "/" + year;
                        textViewFechaEtapa.setText(fechaSeleccionada);
                    }
                },
                anio, mes, dia);

        datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        datePickerDialog.show();
    }

    private void registrarEtapa() {
        // Obtén los valores de las vistas
        String nombreEtapa = editTextNombreEtapa.getText().toString().trim();
        String observaciones = editTextObservaciones.getText().toString().trim();
        String medidas = editTextMedidas.getText().toString().trim();
        String horasCalor = editTextHorasCalor.getText().toString().trim();
        String tierra = editTextTierraEtapa.getText().toString().trim();
        String ubicacion = editTextUbicacionEtapa.getText().toString().trim();
        String substrato = editTextSubstratoEtapa.getText().toString().trim();
        String fecha = textViewFechaEtapa.getText().toString().trim();

        // Verifica si los campos están vacíos
        if (nombreEtapa.isEmpty() || observaciones.isEmpty() || medidas.isEmpty() ||
                horasCalor.isEmpty() || tierra.isEmpty() || ubicacion.isEmpty() ||
                substrato.isEmpty() || fecha.isEmpty()) {
            // Muestra un mensaje de error
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            // Crea un nuevo objeto Etapa con el ID del usuario
            Etapa etapa = new Etapa(nombreEtapa, observaciones, medidas, horasCalor,
                    tierra, ubicacion, substrato, fecha);

            // Obtén una referencia a la base de datos de Firebase
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference()
                    .child("users").child(userId).child("etapas");

            // Genera un nuevo ID para la etapa
            idEtapa = databaseReference.push().getKey();

            // Asigna el ID al objeto Etapa
            etapa.setId(idEtapa);

            // Guarda la etapa en la base de datos usando el ID generado
            databaseReference.child(idEtapa).setValue(etapa);

            // Muestra un mensaje de éxito
            Toast.makeText(this, "Etapa registrada con éxito", Toast.LENGTH_SHORT).show();
            // Reinicia los campos del formulario
            limpiarCampos();
        }
    }
    // Método para limpiar los campos del formulario
    private void limpiarCampos() {
        editTextNombreEtapa.setText("");
        editTextObservaciones.setText("");
        editTextMedidas.setText("");
        editTextHorasCalor.setText("");
        editTextTierraEtapa.setText("");
        editTextUbicacionEtapa.setText("");
        editTextSubstratoEtapa.setText("");
        textViewFechaEtapa.setText("Fecha: No Seleccionada");
    }

    // Clase interna para el modelo Etapa
    private static class Etapa {
        public String id;
        public String nombreEtapa, observaciones, medidas, horasCalor, tierra,
                ubicacion, substrato, fecha;

        public Etapa() {
            // Constructor vacío necesario para Firebase
        }

        public Etapa(String nombreEtapa, String observaciones, String medidas, String horasCalor,
                     String tierra, String ubicacion, String substrato, String fecha) {
            this.nombreEtapa = nombreEtapa;
            this.observaciones = observaciones;
            this.medidas = medidas;
            this.horasCalor = horasCalor;
            this.tierra = tierra;
            this.ubicacion = ubicacion;
            this.substrato = substrato;
            this.fecha = fecha;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}