package fr.sons_of_a_peach.masterfruits;

import android.util.Log;
import android.util.SparseIntArray;

import java.util.Arrays;

public class ArrayFruits {

 public static Fruits[] getArray() {

        Fruits[] tableau;


        tableau = new Fruits[3];
        tableau[0] = new Fruits("fraise", true, true, R.drawable.fraise);
        tableau[1] = new Fruits("framboise", true, false, R.drawable.fraise );
        tableau[2] = new Fruits("banane", false, true, R.drawable.fraise);

        //for (int i = 0; i <= 3; i++ ) Log.d("this is my array", "arr: " + Arrays.toString(tableau));

         return new Fruits[] {tableau[0],tableau[1],tableau[2]};
    }
}
