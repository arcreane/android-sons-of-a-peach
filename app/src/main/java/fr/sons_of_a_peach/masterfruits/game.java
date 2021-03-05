package fr.sons_of_a_peach.masterfruits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class game extends AppCompatActivity {

    ImageView selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = (ImageView) v;
            }
        };
        ImageView img1 = findViewById(R.id.imageView1);
        img1.setOnClickListener(click);

        ImageView img2 = findViewById(R.id.imageView2);
        img2.setOnClickListener(click);

        ImageView img3 = findViewById(R.id.imageView3);
        img3.setOnClickListener(click);

        ImageView img4 = findViewById(R.id.imageView4);
        img4.setOnClickListener(click);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(Banana.getImage());
        list.add(Plum.getImage());
        list.add(Strawberry.getImage());
        list.add(Lemon.getImage());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        MenuRecAdapter menuRecAdapter = new MenuRecAdapter(list);
        recyclerView.setAdapter(menuRecAdapter);

    }

    // list of available fruit
    Fruits Grapes = new Fruits("Grapes", true, false, R.drawable.peach);
    Fruits Orange = new Fruits("Orange", false, true, R.drawable.peach);
    Fruits Lemon = new Fruits("Lemon", false, true, R.drawable.peach);
    Fruits Plum = new Fruits("Plum", true, false, R.drawable.peach);
    Fruits Banana = new Fruits("Banana", false, true, R.drawable.peach);
    Fruits Kiwi = new Fruits("Kiwi", false, true, R.drawable.peach);
    Fruits Strawberry = new Fruits("Strawberry", false, false, R.drawable.peach);
    Fruits Raspberry = new Fruits("Raspberry", false, false, R.drawable.peach);

    // Fruit basket = Fruits
    Fruits[] Fruits = {Banana, Kiwi, Strawberry, Raspberry, Grapes, Orange, Lemon, Plum};
    Fruits[] generated_answer = generate_random();

    public Fruits[] generate_random() {
        int inserted_fruit = 0;
        Fruits[] result = new Fruits[4];

        while (inserted_fruit != 4) {
            Random rnd = new Random();
            int proposition = rnd.nextInt(Fruits.length);
            boolean isValid = true;

            for (int i = 0; i < result.length; i++) {
                if (result[i] != null) {
                    if (result[i].getNom().equals(Fruits[proposition].getNom())) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                result[inserted_fruit] = Fruits[proposition];
                inserted_fruit++;
            }
        }
        return result;
    }

    public void choosePeach(View v) {

        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setBackgroundResource(R.drawable.peach);
    }


    //ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
    //imageView1.setBackgroundResource(R.drawable.fraise);


    /**
     * Function who take a generated answer in argument and check if the attempt is ok
     * p_generated_answer : returned by generate_answer()
     * p_user_input : an array of string who represent the user answer
     * return :
     *
     * @return an array of integer
     */
    public Integer[] user_attempt_checker(Fruits[] p_generated_answer, String[] p_user_input) {
        Integer[] result = new Integer[4];
        // on boucle sur les resultats de l'utilisateur
        // si le fruit est absent on met 0 dans un tableau
        for (int i = 0; i < p_user_input.length; i++) {
            int checked_result = 0;
            for (int j = 0; j < p_generated_answer.length; j++) {
                if (p_user_input[i].equals(p_generated_answer[j].getNom())) {
                    if (i == j) {
                        // sil le fruit est présent et bien placé on met 2 dans un tableau
                        checked_result = 2;
                    } else {
                        // si le fruit est présent on met 1 dans un tableau
                        checked_result = 1;
                    }
                }
            }
            result[i] = checked_result;
        }
        // on fait un sort() descendant sur le tableau
        Arrays.sort(result, Collections.reverseOrder());
        // on retourne le tableau ex: [2,1,0,0]
        return result;
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

    public void selectFruit(View view) {
        ImageView img = (ImageView) view;
        if (selected != null) {
            selected.setImageDrawable(img.getDrawable());
            selected.setLayoutParams(new LinearLayout.LayoutParams(100 , 100));
        }
    }
}