
package com.movi.mynotenavegable;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.movi.mynotenavegable.databinding.ActivityMainBinding;
import com.movi.mynotenavegable.modelo.Nota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Configuración de la barra de la aplicación (parte superior)
    private AppBarConfiguration mAppBarConfiguration;

    // Objeto de vinculación que conecta las vistas (XML) con el código
    private ActivityMainBinding binding;

    // Lista para almacenar objetos de tipo Nota
    public static ArrayList<Nota> notas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Llamada al método onCreate de la superclase (AppCompatActivity)
        super.onCreate(savedInstanceState);

        // Inflamos el layout de la actividad utilizando el binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // Establecemos el contenido de la actividad utilizando el root del binding (la raíz del layout)
        setContentView(binding.getRoot());

        // Establecemos la barra de herramientas (toolbar) como la barra de la aplicación
        setSupportActionBar(binding.appBarMain.toolbar);

        // Inicializamos el DrawerLayout (el menú lateral)
        DrawerLayout drawer = binding.drawerLayout;

        // Inicializamos el NavigationView (vista que contiene las opciones del menú lateral)
        NavigationView navigationView = binding.navView;

        // Configuramos las secciones del menú y asociamos el DrawerLayout para manejar su apertura/cierre
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_nota, R.id.nav_cargar, R.id.nav_salir) // Los fragmentos que puede manejar
                .setOpenableLayout(drawer)  // Asociamos el DrawerLayout al AppBarConfiguration
                .build();

        // Controlador de navegación que se encarga de gestionar los fragmentos
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        // Vinculamos el NavController con la barra de la aplicación (para mostrar el título correcto en cada fragmento)
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        // Configuramos el NavigationView para que funcione con el NavController
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflamos el menú de opciones (los botones en la parte superior derecha de la barra de la aplicación)
        getMenuInflater().inflate(R.menu.main, menu);
        return true; // Devolvemos true para que se muestre el menú
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Controlamos la navegación "hacia arriba" (cuando el usuario presiona la flecha de retroceso en la barra de la aplicación)
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        // Devolvemos true si hay un fragmento al que se puede regresar, o llamamos al método original de la superclase
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

//    // Método público para agregar una nueva nota a la lista
//    public void addNota(Nota nota) {
//        notas.add(nota); // Agregamos la nota a la lista de notas
//    }
//
//    // Método público para obtener la lista de notas actuales
//    public ArrayList<Nota> getNotas() {
//        return notas; // Retornamos la lista de notas
//    }
}

