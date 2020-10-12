package com.ardian.kalkulatorbagus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button hitung;
    RadioGroup opsi;
    RadioButton tambah,kurang,bagi,kali;
    TextView hasil;
    EditText angka_pertama, angka_kedua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hitung = findViewById(R.id.btn_hitung);
        opsi = findViewById(R.id.opsi);
        tambah = findViewById(R.id.tambah);
        kurang = findViewById(R.id.kurang);
        bagi = findViewById(R.id.bagi);
        kali = findViewById(R.id.kali);
        hasil = findViewById(R.id.hasil);
        angka_pertama = findViewById(R.id.angka1);
        angka_kedua = findViewById(R.id.angka2);

        opsi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.tambah :
                        kurang.setChecked(false);
                        bagi.setChecked(false);
                        kali.setChecked(false);
                        break;
                    case R.id.kurang :
                        tambah.setChecked(false);
                        bagi.setChecked(false);
                        kali.setChecked(false);
                        break;
                    case R.id.bagi :
                        kurang.setChecked(false);
                        tambah.setChecked(false);
                        kali.setChecked(false);
                        break;
                    case R.id.kali :
                        kurang.setChecked(false);
                        bagi.setChecked(false);
                        tambah.setChecked(false);
                        break;

                }
            }
        });


            hitung.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tambah.isChecked()) {
                        if ((angka_pertama.getText().length() > 0) && (angka_kedua.getText().length() > 0)) {
                            double angka1 = Double.parseDouble(angka_pertama.getText().toString());
                            double angka2 = Double.parseDouble(angka_kedua.getText().toString());
                            double result = angka1 + angka2;
                            hasil.setText(Double.toString(result));
                        } else {
                            Toast toast = Toast.makeText(MainActivity.this, "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                    else if (kurang.isChecked()) {
                        if ((angka_pertama.getText().length() > 0) && (angka_kedua.getText().length() > 0)) {
                            double angka1 = Double.parseDouble(angka_pertama.getText().toString());
                            double angka2 = Double.parseDouble(angka_kedua.getText().toString());
                            double result = angka1 - angka2;
                            hasil.setText(Double.toString(result));
                        } else {
                            Toast toast = Toast.makeText(MainActivity.this, "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                    else if (kali.isChecked()) {
                        if ((angka_pertama.getText().length() > 0) && (angka_kedua.getText().length() > 0)) {
                            double angka1 = Double.parseDouble(angka_pertama.getText().toString());
                            double angka2 = Double.parseDouble(angka_kedua.getText().toString());
                            double result = angka1 * angka2;
                            hasil.setText(Double.toString(result));
                        } else {
                            Toast toast = Toast.makeText(MainActivity.this, "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                    else if (bagi.isChecked()) {
                        if ((angka_pertama.getText().length() > 0) && (angka_kedua.getText().length() > 0)) {
                            double angka1 = Double.parseDouble(angka_pertama.getText().toString());
                            double angka2 = Double.parseDouble(angka_kedua.getText().toString());
                            double result = angka1 / angka2;
                            hasil.setText(Double.toString(result));
                        } else {
                            Toast toast = Toast.makeText(MainActivity.this, "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }
                }

            });
    }
}