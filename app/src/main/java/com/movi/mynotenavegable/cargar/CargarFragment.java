package com.movi.mynotenavegable.cargar;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.movi.mynotenavegable.R;
import com.movi.mynotenavegable.ui.nota.NotaViewModel;

public class CargarFragment extends Fragment {

    private CargarViewModel mViewModel;
    private NotaViewModel notaViewModel;

    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cargar, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CargarViewModel.class);


        notaViewModel = new ViewModelProvider(requireActivity()).get(NotaViewModel.class);
        mViewModel.setNotaViewModel(notaViewModel);


        EditText etTitulo = getView().findViewById(R.id.editTextTitulo);
        EditText etNota = getView().findViewById(R.id.editTextNota);
        Button btnGuardar = getView().findViewById(R.id.guardarButton);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = etTitulo.getText().toString();
                String contenido = etNota.getText().toString();
                mViewModel.agregarNota(titulo, contenido);
                etTitulo.setText("");
                etNota.setText("");
            }
        });
    }
}



