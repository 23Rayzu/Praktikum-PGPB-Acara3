package com.example.penugasanacara3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etFirstNumber, etSecondNumber;
    Button btnMultiply, btnDivide, btnSubtract, btnAdd;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi elemen dari layout
        etFirstNumber = findViewById(R.id.et_firstNumber);
        etSecondNumber = findViewById(R.id.et_secondNumber);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);
        btnSubtract = findViewById(R.id.btn_subtract);
        btnAdd = findViewById(R.id.btn_add);
        tvResult = findViewById(R.id.tv_resultLabel);

        // Fungsi untuk tombol kali
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        // Fungsi untuk tombol bagi
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        // Fungsi untuk tombol kurang
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        // Fungsi untuk tombol tambah
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });
    }

    // Method untuk perhitungan
    private void calculate(char operator) {
        String firstNumberStr = etFirstNumber.getText().toString();
        String secondNumberStr = etSecondNumber.getText().toString();

        if (firstNumberStr.isEmpty() || secondNumberStr.isEmpty()) {
            Toast.makeText(this, "Masukkan kedua angka", Toast.LENGTH_SHORT).show();
            return;
        }

        double firstNumber = Double.parseDouble(firstNumberStr);
        double secondNumber = Double.parseDouble(secondNumberStr);
        double result = 0;

        switch (operator) {
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    Toast.makeText(this, "Tidak bisa membagi dengan 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '+':
                result = firstNumber + secondNumber;
                break;
        }

        tvResult.setText("Hasil: " + result);
    }
}
