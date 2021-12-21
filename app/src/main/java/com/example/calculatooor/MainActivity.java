package com.example.calculatooor;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    TextView Text1;
    TextView Text2;
    int znackenie = 0;
    boolean Provznackenie;
    int forFunction = 0;
    String forswitchfunction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Text1 = findViewById(R.id.text);
        Text2 = findViewById(R.id.text2);
        Provznackenie = true;
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("zap", Text1.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Text1.setText(savedInstanceState.getString("zap"));
    }

    public void onClick(View v)
    {
        Button btn = findViewById(v.getId());

        if (btn.getText().toString().equals("+") ||
            btn.getText().toString().equals("-") ||
            btn.getText().toString().equals("*") ||
            btn.getText().toString().equals("/"))
        {
            znackenie = Integer.parseInt(Text1.getText().toString());
            function(btn.getText().toString(), znackenie, Provznackenie);
            Text1.setText(Text1.getText().toString() + btn.getText().toString());
            Provznackenie = false;
        }
        else if (btn.getText().toString().equals("DEL"))
        {
            Text1.setText("");
            Text2.setText("");
            Provznackenie = true;
        }
        else if (btn.getText().toString().equals("^"))
        {
            int cd = 2;
            znackenie = Integer.parseInt(Text1.getText().toString());
            int nadva = ((int) Math.pow(znackenie, cd));
            Text1.setText(Integer.toString(nadva));
            Provznackenie = false;
        }
        else if (btn.getText().toString().equals("√2"))
        {
            znackenie = Integer.parseInt(Text1.getText().toString());
            int sqr1 = ((int) Math.sqrt(znackenie));
            Text1.setText(Integer.toString(sqr1));
            Provznackenie = false;
        }
        else {
            switch (btn.getText().toString()) {
                case "=":
                    znackenie = Integer.parseInt(Text2.getText().toString());
                    function(btn.getText().toString(), znackenie, Provznackenie);
                    Provznackenie = true;
                    break;
                default:
                    if (Provznackenie) {
                        Text1.setText(Text1.getText().toString() + btn.getText().toString());
                    }
                    else {
                        Text1.setText(Text1.getText().toString() + btn.getText().toString());
                        Text2.setText(Text2.getText().toString() + btn.getText().toString());
                    }
                    break;
            }
        }
    }

    public void function (String btnStr, int znach, boolean prov)
    {
        if (prov)
        {
            forFunction = znach;
            forswitchfunction = btnStr;
        }
        else {
            switch (forswitchfunction)
            {
                case "-":
                    forFunction -= znach;
                    if (forFunction == 0)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Ошибка", Toast.LENGTH_SHORT);
                        toast.show();
                        Text1.setText("");
                        Text2.setText("");
                        Provznackenie = true;
                    }
                    break;
                case "*":
                    forFunction *= znach;
                    if (forFunction == 0)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Ошибка", Toast.LENGTH_SHORT);
                        toast.show();
                        Text1.setText("");
                        Text2.setText("");
                        Provznackenie = true;
                    }
                    break;
                case "+":
                    forFunction += znach;
                    if (forFunction == 0)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Ошибка", Toast.LENGTH_SHORT);
                        toast.show();
                        Text1.setText("");
                        Text2.setText("");
                        Provznackenie = true;
                    }
                    break;
                case "/":
                    forFunction /= znach;
                    if (forFunction == 0)
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Ошибка", Toast.LENGTH_SHORT);
                        toast.show();
                        Text1.setText("");
                        Text2.setText("");
                        Provznackenie = true;
                    }
                    break;
            }
            Text1.setText(Integer.toString(forFunction));
        }
    }
}
