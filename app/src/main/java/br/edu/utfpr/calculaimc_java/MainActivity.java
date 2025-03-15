package br.edu.utfpr.calculaimc_java;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etAltura;
    private EditText etPeso;

    private TextView tvResultado;

    private Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAltura = findViewById( R.id.etAltura );
        etPeso = findViewById( R.id.etPeso );

        tvResultado = findViewById( R.id.tvResultado );

        btCalcular = findViewById( R.id.btCalcular );

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btCalcularOnClick();
            }
        } );

        btCalcular.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Este é o botão Calcular", Toast.LENGTH_SHORT).show();

                return false;
            }
        });



    } //fim do método onClick

    private void btCalcularOnClick() {

        //entrada
        if ( etAltura.getText().toString().equals( "" ) ) {
            Log.e( "MainActivity", "Ocorreu um erro de campo vazio" );
            etAltura.setError( "Campo Altura deve ser preenchido." );
            return;
        }

        if ( etPeso.getText().toString().equals( "" ) ) {
            etPeso.setError( "Campo Peso deve ser preenchido." );
            return;
        }

        double altura = Double.parseDouble( etAltura.getText().toString() );
        double peso =    Double.parseDouble( etPeso.getText().toString() );


        //processamento
        double resultado = peso / Math.pow( altura, 2 ) ;

        //saída
        DecimalFormat df = new DecimalFormat( "0.00" );
        tvResultado.setText( df.format( resultado ) );

        System.out.println( "teste" );

    }

    public void btLimparOnClick( View v ) {
        etAltura.setText( "" );
        etPeso.setText( "" );
        tvResultado.setText( "0.0" );
        etAltura.requestFocus();
    }


} //fim da MainActivity