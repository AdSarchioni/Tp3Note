
package com.movi.mynotenavegable.ui.nota;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.movi.mynotenavegable.MainActivity;
import com.movi.mynotenavegable.databinding.FragmentNotaBinding;
import com.movi.mynotenavegable.modelo.Nota;

import java.util.List;

public class NotaFragment extends Fragment {

    private FragmentNotaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotaViewModel notaViewModel =
                new ViewModelProvider(this).get(NotaViewModel.class);

        binding = FragmentNotaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


notaViewModel.getMNota().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
    @Override
    public void onChanged(Boolean aBoolean) {
        NotaAdapter adapter = new NotaAdapter(MainActivity.notas, inflater);
        GridLayoutManager glm = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        binding.lista.setAdapter(adapter);
        binding.lista.setLayoutManager(glm);
    }
});
     notaViewModel.mandarLista();
        return root;
    }

}




