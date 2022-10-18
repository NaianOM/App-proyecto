package com.example.mysplash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.mysplash.json.MyInfo;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Formulario extends AppCompatActivity implements Serializable {

    private static final String TAG = "Formulario";
    private EditText nombre, contrasena, correo_usuario, telefono, fecha, descripcion, altura;
    private CheckBox terminos, politicas;
    private Switch enfermedades;
    private RadioGroup trabajo_antes;
    private RadioButton Fradio_siem, radio_no;
    private Button btnRegistro;
    public static final String archivo = "registro.json";
    private String json2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        List<MyInfo> list = new ArrayList<MyInfo>();
        EditText nombre = findViewById(R.id.nombre);
        EditText contrasena = findViewById(R.id.contrasena_usuario);
        EditText correo_usuario = findViewById(R.id.correo_usuario);
        EditText telefono = findViewById(R.id.telefono);
        EditText descripcion = findViewById(R.id.descripcion);
        EditText fecha = findViewById(R.id.fecha);
        EditText altura = findViewById(R.id.altura);
        RadioButton radio_si = (RadioButton) findViewById(R.id.radio_si);
        RadioButton radio_no = (RadioButton) findViewById(R.id.radio_no);
        Switch enfermedad = (Switch) findViewById(R.id.enfermedad);
        Button Registrar = findViewById(R.id.btnRegistro);
        String terminos = "nulo";
        String politicas = "";


        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyInfo info = new MyInfo();

                info.setNombre(String.valueOf(nombre.getText()));
                info.setContrasena(String.valueOf(contrasena.getText()));
                info.setCorreo_usuario(String.valueOf(correo_usuario.getText()));
                info.setTelefono(String.valueOf(telefono.getText()));
                info.setDescripcion(String.valueOf(descripcion.getText()));
                info.setDescripcion(String.valueOf(descripcion.getText()));
                boolean enfermedad = enfermedades.isChecked();

                if (nombre.getText().length() == 0 | contrasena.getText().length() == 0 | correo_usuario.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Debe de llenar los campos requeridos", Toast.LENGTH_LONG).show();
                    return;
                }
                if (radio_si.isChecked() && radio_no.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Debe de leer los términos, condiciones y políticas de la empresa", Toast.LENGTH_LONG).show();
                }
                List2Json(info, list);
            }
        });
    }

        public void Objet2Json(MyInfo info){
            Gson gson = null;
            String json = null;
            String mensaje = null;
            gson = new Gson();
            json = gson.toJson(info);
            if(json != null){
                Log.d(TAG, json);
                mensaje ="OK json";
            }
            else{
                mensaje = "Error object2Json";
            }
            Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
        }
        private boolean writeFile(String text){
        File file = null;
        FileOutputStream fileOutputStream = null;
        try{
            file = getFile();
            fileOutputStream = new FileOutputStream( file );
            fileOutputStream.write(text.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
            Log.d(TAG, "Bien");
            return true;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return false;
        }
        private File getFile(){
        return new File(getDataDir(),archivo);
        }
        public void List2Json(MyInfo info, List<MyInfo> list){
            Gson gson = null;
            String json = null;
            gson = new Gson();
            list.add(info);
            json = gson.toJson(list, ArrayList.class);
            if(json == null){
                Log.d(TAG, "Error json");
            }
            else{
                Log.d(TAG, json);
                writeFile(json);
            }
            Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();
        }
        public void Regresar (View view){
            Intent Regresar = new Intent(this, Login.class);
            startActivity(Regresar);
        }
}