package fr.sons_of_a_peach.masterfruits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //on affecte l'attribut au bouton : id = play
        this.play = (Button) findViewById(R.id.play);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exit:
                Toast.makeText(this, "byebye", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_settings:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}