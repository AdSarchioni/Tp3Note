
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
import com.movi.mynotenavegable.databinding.FragmentCargarBinding;
import com.movi.mynotenavegable.databinding.FragmentNotaBinding;
import com.movi.mynotenavegable.ui.nota.NotaViewModel;

public class CargarFragment extends Fragment {

    private CargarViewModel mViewModel;
    private FragmentCargarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

       binding.guardarButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mViewModel.agregarNota(binding.editTextTitulo.getText().toString(),binding.editTextNota.getText().toString());
               binding.editTextTitulo.setText("");
               binding.editTextNota.setText("");
           }
       });



        return root;

    }

}


