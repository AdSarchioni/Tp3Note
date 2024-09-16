
package com.movi.mynotenavegable.cargar;

import androidx.lifecycle.ViewModel;
import com.movi.mynotenavegable.modelo.Nota;
import com.movi.mynotenavegable.ui.nota.NotaViewModel;

public class CargarViewModel extends ViewModel {
    private NotaViewModel notaViewModel;

    public void setNotaViewModel(NotaViewModel notaViewModel) {
        this.notaViewModel = notaViewModel;
    }

    public void agregarNota(String titulo, String contenido) {
        if (notaViewModel != null) {
            Nota nuevaNota = new Nota(titulo, contenido);
            notaViewModel.agregarNota(nuevaNota);
        }
    }
}