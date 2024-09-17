
package com.movi.mynotenavegable.cargar;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.movi.mynotenavegable.MainActivity;
import com.movi.mynotenavegable.modelo.Nota;
import com.movi.mynotenavegable.ui.nota.NotaViewModel;

import java.util.ArrayList;
import java.util.List;

public class CargarViewModel extends AndroidViewModel {
private List<Nota> notas= MainActivity.notas;
    public CargarViewModel(@NonNull Application application) {
        super(application);
    }

    public void agregarNota(String titulo, String contenido){
        if(titulo.isEmpty() || contenido.isEmpty()){
            Toast.makeText(getApplication(), "No puede guardar notas vacias..", Toast.LENGTH_SHORT).show();
        }else{
               notas.add(new Nota(titulo, contenido));
            Toast.makeText(getApplication(), "!Nota agregada con exito!", Toast.LENGTH_SHORT).show();
        }
    }
}
