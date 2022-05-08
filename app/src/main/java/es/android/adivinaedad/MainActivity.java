package es.android.adivinaedad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView edadTxt;
    private EditText editTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTxt=findViewById(R.id.nombre);
        edadTxt=findViewById(R.id.edad);

        BaseDeDatos db = new BaseDeDatos(getApplicationContext());
        findViewById(R.id.consultarEdad).setOnClickListener(view -> {
            try{
                edadTxt.setText(db.buscarNombreEdad(editTxt.getText().toString()) + "");
            } catch (Exception ex){
                Log.e("AdivinaEdad", "Error", ex);
                Toast.makeText(getApplicationContext(),"", Toast.LENGTH_LONG).show();
            }
        });
    }
}