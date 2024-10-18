package com.example.android_tp3_listadeusuarios;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.android_tp3_listadeusuarios.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private UserViewModelActivity userVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        userVM = new ViewModelProvider(this).get(UserViewModelActivity.class);
        tarea();
    }

    public void tarea() {
        binding.btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = binding.teNombre.getText().toString();
                int edad;
                if (!nombre.isEmpty() && !binding.teEdad.getText().toString().isEmpty()) {
                    try {
                        edad = Integer.parseInt(binding.teEdad.getText().toString());
                        Usuario usuario = new Usuario(nombre, edad);
                        userVM.agregarUsuario(usuario);
                        binding.teNombre.setText("");
                        binding.teEdad.setText("");
                    } catch (NumberFormatException e) {
                        binding.textView.setText("Error de formato de edad");
                    }
                } else {
                    binding.textView.setText("ERROR");
                }
                binding.teNombre.setText("");
                binding.teEdad.setText("");
            }
        });
        binding.btVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Usuario> lista = userVM.getUserList();
                String texto = "";
                for (Usuario u : lista) {
                    texto+= "Nombre: " + u.getNombre() + "Edad" + u.getEdad() + "";                }
            binding.textView.setText(texto);
            }
        });
    }
}