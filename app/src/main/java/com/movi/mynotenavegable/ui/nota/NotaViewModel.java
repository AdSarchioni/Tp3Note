
package com.movi.mynotenavegable.ui.nota;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.movi.mynotenavegable.MainActivity;
import com.movi.mynotenavegable.modelo.Nota;

import java.util.ArrayList;
import java.util.List;

public class NotaViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean>mNotas;


    public NotaViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<Boolean> getMNota(){
        if(mNotas==null){
            mNotas=new MutableLiveData<>();
        }
        return mNotas;
    }

     public void mandarLista(){
        if(MainActivity.notas.size()>0){
            mNotas.setValue(true);
        }else{
            Toast.makeText(getApplication(), "No hay notas guardadas.", Toast.LENGTH_LONG).show();

        }
}
}



