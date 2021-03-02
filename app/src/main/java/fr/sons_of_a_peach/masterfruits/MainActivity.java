package fr.sons_of_a_peach.masterfruits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //on affecte l'attribut au bouton : id = play
        this.play = (Button)findViewById(R.id.play);

        //on crée un listener au click du bouton
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //on crée une nouvelle action Intent
                //getApplicationContext recupere ts les elements de l'app
                //2e parametre = la cible
                Intent nlleActivite = new Intent(getApplicationContext(), game.class);

                //on start l'activité avec en parametre l'Intent.
                startActivity(nlleActivite);

                //il faut arreter l'ancienne activité
                finish();

            }
        });

    }
}