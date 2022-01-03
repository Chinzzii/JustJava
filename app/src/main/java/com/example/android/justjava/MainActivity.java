package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView priceTextView;
    private TextView quantityTextView;
    private TextView QuantTextView;
    private TextView nameTextView;
    private TextView extrasTextView;
    private EditText nameEditText;
    private CheckBox creamCheckBox;
    private CheckBox chocCheckBox;
    int quant = 0;
    int price = 5;
    int total = 0;
    private String name = "";
    private String extras = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        priceTextView = (TextView) findViewById((R.id.price_TextView));
        quantityTextView = (TextView) findViewById(R.id.quantity_TextView);
        QuantTextView = (TextView) findViewById(R.id.Quant_textView);
        nameTextView = (TextView) findViewById(R.id.Name_textView);
        extrasTextView = (TextView) findViewById(R.id.Extra_textView);
        nameEditText = (EditText) findViewById(R.id.Name_editText);
        creamCheckBox = (CheckBox) findViewById(R.id.Cream_checkBox);
        chocCheckBox = (CheckBox) findViewById(R.id.Choc_checkBox);
    }

    public void submitOrder(View view) {
        name = nameEditText.getText().toString();
        total = quant*price;
        if(creamCheckBox.isChecked() && chocCheckBox.isChecked()){
            total = total + 4;
            extras = "Whipped Cream, Chocolate Chips";
        }
        if(creamCheckBox.isChecked() && !chocCheckBox.isChecked()){
            total = total + 2;
            extras = "Whipped Cream Only";
        }
        if(chocCheckBox.isChecked() && !creamCheckBox.isChecked()){
            total = total + 2;
            extras = "Chocolate Chips Only";
        }
        if(!chocCheckBox.isChecked() && !creamCheckBox.isChecked()){
            extras = "Nothing";
        }
        displayQuat(quant);
        displayPrice(total);
        displaySummary(name, quant, extras);
    }

    public void displayPrice(int total) {
        priceTextView.setText("Total: $" + total);
    }

    public void displayQuat(int num) {
        quantityTextView.setText("" + num);
    }

    public void displaySummary(String name, int num, String extras){
        nameTextView.setText("Name: " + name);
        extrasTextView.setText("Extras: " + extras);
        QuantTextView.setText("Quantity: " + num);
    }

    public void increment(View view) {
        quant++;
        submitOrder(view);
    }

    public void decrement(View view) {
        quant--;
        submitOrder(view);
    }

}