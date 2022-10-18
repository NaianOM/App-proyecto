package com.example.mysplash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mysplash.json.MyInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    public static String TAG = "mensaje";
    private List<MyInfo> list;
    String json = null;
    public static String nombre_usuario, contrasena_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        EditText nombre = findViewById(R.id.nombre);
        EditText contrasena = findViewById(R.id.contrasena);
        Button login = findViewById(R.id.btn_login);

        Read();
        json2List(json);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre_usuario = String.valueOf(nombre.getText());
                contrasena_usuario = String.valueOf(contrasena.getText());
                acceso();
            }
        });
    }
    //Métodos

    public boolean Read(){
        if(!isFileExits()){
            return false;
        }
        File file = getFile();
        FileInputStream fileInputStream = null;
        byte[] bytes = null;
        bytes = new byte[(int)file.length()];
        try{
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytes);
            json = new String(bytes);
            Log.d(TAG, json);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
    public void json2List(String json){
        Gson gson = null;
        String mensaje = null;
        if(json == null || json.length() == 0){
            Toast.makeText(getApplicationContext(), "Error json null or empty", Toast.LENGTH_SHORT).show();
            return;
        }
        gson = new Gson();
        Type listType = new TypeToken<ArrayList<MyInfo>>(){}.getType();
        list = gson.fromJson(json, listType);
        if(list == null || list.size() == 0){
            Toast.makeText(getApplicationContext(), "Error list is null or empty", Toast.LENGTH_LONG).show();
            return;
        }
    }
    private File getFile(){
        return new File(getDataDir() , Formulario.archivo);
    }

    private boolean isFileExits(){
        File file = getFile();
        if(file == null){
            return false;
        }
        return file.isFile() && file.exists();
    }
    public void acceso(){
        int i = 0;
        for(MyInfo myInfo : list){
            if (myInfo.getNombre().equals(nombre_usuario)&&myInfo.getContrasena().equals(contrasena_usuario)){
                Intent acceso = new Intent(this, Acceder.class);
                startActivity(acceso);
                i = 1;

            }
        }
        if (i == 0){
            Toast.makeText(getApplicationContext(), "El usuario y/o contraseña no son correctos",Toast.LENGTH_LONG).show();
        }
    }

    public void Olvidocontrasena (View view){
        Intent Olvidocontrasena = new Intent(this, OlvideContrasena.class);
        startActivity(Olvidocontrasena);
    }

    public void Registrarse (View view){
        Intent Registrarse = new Intent(this, Formulario.class);
        startActivity(Registrarse);
    }
}