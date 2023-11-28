package com.example.iot_plantmate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
//
//        // Inicio de sesión
//        FirebaseAuth mAuth = FirebaseAuth.getInstance();
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Inicio de sesión exitoso
//                            obtenerDatosUsuario();
//                        } else {
//                            // Fallo en el inicio de sesión
//                            Toast.makeText(LoginActivity.this, "Autenticación fallida.", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//// Obtención de datos del usuario
//        private void obtenerDatosUsuario() {
//            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//            if (user != null) {
//                String userId = user.getUid();
//
//                DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("usuarios").child(userId);
//                userRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        // Obtener datos del usuario y actualizar la interfaz de usuario
//                        Usuario usuario = dataSnapshot.getValue(Usuario.class);
//                        actualizarInterfazUsuario(usuario);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//                        // Manejar errores de lectura de la base de datos
//                    }
//                });
//            }
//        }
//
//// Método para actualizar la interfaz de usuario con los datos del usuario
//        private void actualizarInterfazUsuario(Usuario usuario) {
//            // Actualizar vistas con los datos del usuario
//            textViewName.setText(usuario.getNombre());
//            textViewEmail.setText(usuario.getEmail());
//            // Agregar más actualizaciones según sea necesario
//        }

    }
}