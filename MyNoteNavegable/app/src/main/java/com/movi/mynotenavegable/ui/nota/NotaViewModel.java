package com.movi.mynotenavegable.ui.nota;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.movi.mynotenavegable.modelo.Nota;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NotaViewModel extends AndroidViewModel {
    private MutableLiveData<List<Nota>> mNota;

    public NotaViewModel(@NonNull Application application) {
        super(application);
        mNota = new MutableLiveData<>(new ArrayList<>());
    }

    public LiveData<List<Nota>> getMNota() {
        return mNota;
    }

    public void agregarNota(Nota nota) {
        List<Nota> notas = mNota.getValue();
        if (notas == null) {
            notas = new ArrayList<>();
        }
        notas.add(nota);
        Collections.sort(notas, new Comparator<Nota>() {
            @Override
            public int compare(Nota o1, Nota o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        });
        mNota.setValue(notas);
    }
}



