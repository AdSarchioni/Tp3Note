
package com.movi.mynotenavegable.ui.nota;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.movi.mynotenavegable.R;
import com.movi.mynotenavegable.databinding.FragmentNotaBinding;
import com.movi.mynotenavegable.modelo.Nota;
import java.util.List;

public class NotaFragment extends Fragment {

    private NotaViewModel mViewModel;
    private FragmentNotaBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentNotaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mViewModel = new ViewModelProvider(requireActivity()).get(NotaViewModel.class);

        final NotaAdapter adapter = new NotaAdapter(inflater);
        binding.lista.setAdapter(adapter);
        binding.lista.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));

        mViewModel.getMNota().observe(getViewLifecycleOwner(), new Observer<List<Nota>>() {
            @Override
            public void onChanged(List<Nota> notas) {
                adapter.setNotas(notas);
            }
        });

        return root;
    }
}



