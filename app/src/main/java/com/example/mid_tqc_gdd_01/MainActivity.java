package com.example.mid_tqc_gdd_01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView show;
    private  String[] meal = {"美味蟹保", "義式香腸堡", "蔬菜水果堡","香腸潛艇堡"};
    private  boolean[] mealIcon = {false, false, false, false, false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    public void showDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("您點的餐點有");

        builder.setMultiChoiceItems(meal, mealIcon, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                mealIcon[which] = isChecked;
            }
        });

        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 將選擇的餐點顯示在 show TextView 上
                StringBuilder selectedMeals = new StringBuilder();
                for (int i = 0; i < meal.length; i++) {
                    if (mealIcon[i]) {
                        selectedMeals.append(meal[i]).append(" ");
                    }
                }
                show.setText(selectedMeals.toString());
            }
        });
        builder.setNegativeButton("離開", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 顯示一個Toast訊息並關閉對話框
                Toast.makeText(MainActivity.this, "離開", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.show(); // 顯示對話框
    }

    private void findViews() {
        show = findViewById(R.id.tvshow);
    }
}