package com.ardian.kalkulatorbagus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity {
    Button hitung;
    RadioGroup opsi;
    RadioButton persegi_panjang, segitiga, lingkaran;
    TextView kel, lu;
    EditText angka_pertama, angka_kedua;
    LinearLayout data1, data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hitung = findViewById(R.id.btn_hitung);
        opsi = findViewById(R.id.opsi);
        persegi_panjang = findViewById(R.id.persegi_panjang);
        segitiga = findViewById(R.id.segitiga);
        lingkaran = findViewById(R.id.lingkaran);
        kel = findViewById(R.id.keliling);
        lu = findViewById(R.id.luas);
        angka_pertama = findViewById(R.id.angka1);
        angka_kedua = findViewById(R.id.angka2);
        data1 = findViewById(R.id.data1);
        data2 = findViewById(R.id.data2);

        opsi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.persegi_panjang:
                        segitiga.setChecked(false);
                        lingkaran.setChecked(false);
                        data2.setVisibility(View.VISIBLE);
                        break;
                    case R.id.segitiga:
                        persegi_panjang.setChecked(false);
                        lingkaran.setChecked(false);
                        data2.setVisibility(View.VISIBLE);
                        break;
                    case R.id.lingkaran:
                        segitiga.setChecked(false);
                        persegi_panjang.setChecked(false);
                        data2.setVisibility(View.GONE);
                        break;

                }
            }
        });


        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (persegi_panjang.isChecked()) {
                    if ((angka_pertama.getText().length() > 0) && (angka_kedua.getText().length() > 0)) {
                        double panjang = Double.parseDouble(angka_pertama.getText().toString());
                        double lebar = Double.parseDouble(angka_kedua.getText().toString());
                        double keliling = (2 * (panjang+lebar));
                        double luas = (panjang * lebar);
                        kel.setText(Double.toString(keliling));
                        lu.setText(Double.toString(luas));
                    } else {
                        Toast toast = Toast.makeText(MainActivity.this, "Mohon masukkan Sisi", Toast.LENGTH_LONG);
                        toast.show();
                    }
                } else if (segitiga.isChecked()) {
                    if ((angka_pertama.getText().length() > 0) && (angka_kedua.getText().length() > 0)) {
                        double alas = Double.parseDouble(angka_pertama.getText().toString());
                        double tinggi = Double.parseDouble(angka_kedua.getText().toString());
                        double keliling = alas + tinggi + tinggi;
                        double luas = (0.5 * alas * tinggi);
                        kel.setText(Double.toString(keliling));
                        lu.setText(Double.toString(luas));
                    } else {
                        Toast toast = Toast.makeText(MainActivity.this, "Mohon masukkan Alas & Tinggi", Toast.LENGTH_LONG);
                        toast.show();
                    }
                } else if (lingkaran.isChecked()) {
                    if ((angka_pertama.getText().length() > 0)) {
                        double diameter = Double.parseDouble(angka_pertama.getText().toString());
                        double keliling = ( 3.14 * diameter );
                        double jari = diameter/2;
                        double luas = (3.14 * pow(jari, 2));
                        kel.setText(Double.toString(keliling));
                        lu.setText(Double.toString(luas));
                    } else {
                        Toast toast = Toast.makeText(MainActivity.this, "Mohon masukkan Diameter", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Eitss... Jangan lupa pilih opsinya", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}

