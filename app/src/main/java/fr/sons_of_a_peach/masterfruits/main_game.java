package fr.sons_of_a_peach.masterfruits;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class main_game extends AppCompatActivity {

    Button b_minus_a, b_minus_b, b_minus_c,
            b_plus_a, b_plus_b, b_plus_c;

    Button b_check, b_resign;

    TextView tv_number_a, tv_number_b, tv_number_c;
    TextView tv_info, tv_output;

    Random r;

    int guessA = 1, guessB = 2, guessC = 3;
    int generatedA, generatedB, generatedC;
    int bulls = 0, cows = 0;

    String output = "";

    int tries = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        // Button
        // Buttons minus
        b_minus_a = (Button) findViewById(R.id.b_minus_a);
        b_minus_b = (Button) findViewById(R.id.b_minus_b);
        b_minus_c = (Button) findViewById(R.id.b_minus_c);
        // Button plus
        b_plus_a = (Button) findViewById(R.id.b_plus_a);
        b_plus_b = (Button) findViewById(R.id.b_plus_b);
        b_plus_c = (Button) findViewById(R.id.b_plus_c);
        // Button check
        b_check = (Button) findViewById(R.id.b_check);
        // Button resign
        b_resign = (Button) findViewById(R.id.b_resign);

        // TextView
        // User screen Number
        tv_number_a = (TextView) findViewById(R.id.tv_number_a);
        tv_number_b = (TextView) findViewById(R.id.tv_number_b);
        tv_number_c = (TextView) findViewById(R.id.tv_number_c);
        // Info about good numbers
        tv_info = (TextView) findViewById(R.id.tv_info);
        // Numbers output
        tv_output = (TextView) findViewById(R.id.tv_output);

        r = new Random();

        generateNumber();

        // Minus
        b_minus_a.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (guessA > 1) {
                    guessA--;
                }
                tv_number_a.setText("" + guessA);
            }
        });

        b_minus_b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (guessB > 1) {
                    guessB--;
                }
                tv_number_b.setText("" + guessB);
            }
        });

        b_minus_c.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (guessC > 1) {
                    guessC--;
                }
                tv_number_c.setText("" + guessC);
            }
        });

        // Plus
        b_plus_a.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (guessA < 9) {
                    guessA++;
                }
                tv_number_a.setText("" + guessA);
            }
        });

        b_plus_b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (guessB < 9) {
                    guessB++;
                }
                tv_number_b.setText("" + guessB);
            }
        });

        b_plus_c.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (guessC < 9) {
                    guessC++;
                }
                tv_number_c.setText("" + guessC);
            }
        });

        b_resign.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                b_resign.setEnabled(false);
                b_check.setEnabled(false);

                tv_info.setText("You lost! the number is : " + generatedA + " " + generatedB + " " + generatedC );
            }
        });

        b_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guessA == guessB || guessA == guessC || guessB == guessC){
                    tv_info.setText("Wrong input");
                } else {
                    tries++;
                    checkNumber();
                    checkWin();
                    bulls = 0;
                    cows = 0;
                }
            }
        });

    }

    private void checkWin() {
        if (bulls == 3){
            b_resign.setEnabled(false);
            b_check.setEnabled(false);
            tv_info.setText("You won in " + tries + " tries !");
        }
    }

    private void generateNumber(){
        // generate first digit
        generatedA = r.nextInt(9) + 1;

        // second digit
        do {
            generatedB = r.nextInt(9) + 1;
        } while (generatedA == generatedB);

        // third digit
        do {
            generatedC = r.nextInt(9) + 1;
        } while (generatedA == generatedC || generatedC == generatedA);

    }

    private void checkNumber(){
        // bulls
        if(guessA == generatedA){
            bulls++;
        }
        if(guessB == generatedB){
            bulls++;
        }
        if(guessC == generatedC){
            bulls++;
        }

        // crows
        if(guessA == generatedB || guessA == generatedC){
            cows++;
        }
        if(guessB == generatedA || guessB == generatedC){
            cows++;
        }
        if(guessC == generatedA || guessC == generatedB){
            cows++;
        }

        output = output + " " + tries + ". " + guessA + "" + guessB + "" + guessC + " - bulls: " +
                "Bulls : " + bulls + ", Cows: " + cows + "\n";
        tv_output.setText(output);
    }
}
