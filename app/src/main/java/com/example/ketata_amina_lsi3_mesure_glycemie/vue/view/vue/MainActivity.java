package com.example.ketata_amina_lsi3_mesure_glycemie.vue.view.vue;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ketata_amina_lsi3_mesure_glycemie.R;
import com.example.ketata_amina_lsi3_mesure_glycemie.vue.view.controller.Controller;

public class MainActivity extends AppCompatActivity
{
    private final int REQUEST_CODE=1;
    private EditText etValeur;
    private Button bConsulter;
    private TextView tvAge;
    //private TextView tvRésultat ;
    private RadioButton rbOui,rbNon;
    private SeekBar sbAge;
    private Controller controller=Controller.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //listener SeekBar
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                Log.i("Information", "onProgressChanged " + i);
                tvAge.setText("Votre âge : "+ i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                // Action à effectuer lorsque l'utilisateur commence à déplacer la barre de progression
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                // Action à effectuer lorsque l'utilisateur arrête de déplacer la barre de progression
            }
        });
        // Ajouter un écouteur de clic pour le bouton "Consulter"
        bConsulter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Récupérer les valeurs entrées par l'utilisateur
                int age;
                float valeurMesurer;
                boolean verifAge=false,verifValeur=false;
                if(sbAge.getProgress()!=0)
                    verifAge=true;
                else
                    Toast.makeText(MainActivity.this, "Veillez verifier votre age", Toast.LENGTH_SHORT).show();
                if(!etValeur.getText().toString().isEmpty())
                    verifValeur=true;
                else
                    Toast.makeText(MainActivity.this, "veillez verifier la valeur mesurer", Toast.LENGTH_LONG).show();
                // Si les deux vérifications sont réussies, procéder à la création du patient
                if (verifAge && verifValeur)
                {
                    age = sbAge.getProgress();
                    valeurMesurer = Float.valueOf(etValeur.getText().toString());
                    boolean fasting = rbOui.isChecked();
                    //userAction:view---->Controller
                    // Appeler le contrôleur pour créer le patient
                    controller.createPatient(age,valeurMesurer,fasting);
                    //Update Controller----->View
                    //tvRésultat.setText(controller.getResult());
                    // Lancer une nouvelle activité pour afficher les résultats
                    Intent intent=new Intent(MainActivity.this,ConsultActivity.class);
                    intent.putExtra("reponse",controller.getResult());
                    startActivityForResult(intent,REQUEST_CODE);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE)
            if (resultCode==RESULT_CANCELED)
                Toast.makeText(MainActivity.this,"Erreur:resultat est null",Toast.LENGTH_SHORT).show();
    }
    // Méthode pour initialiser les composants de l'interface utilisateur
    private void init()
    {
        etValeur=(EditText) findViewById(R.id.etValeur);
        sbAge=(SeekBar) findViewById(R.id.sbage);
        tvAge=(TextView) findViewById(R.id.tvAge);
        rbOui=(RadioButton) findViewById(R.id.rbtOui);
        rbNon=(RadioButton) findViewById(R.id.rbtNon);
        //tvRésultat=(TextView) findViewById(R.id.tvRésultat);
        bConsulter=(Button) findViewById(R.id.btnConsulter);
    }
}

