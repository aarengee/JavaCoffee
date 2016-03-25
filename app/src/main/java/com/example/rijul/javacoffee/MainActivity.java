package com.example.rijul.javacoffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.zip.CheckedInputStream;

public class MainActivity extends AppCompatActivity {

    private static int cups_ordered=0;
    private static int rate=20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Order(View view){
        switch(view.getId())
        {
            case R.id.minus_but:
                if(cups_ordered>0)cups_ordered--;
                break;
            case R.id.plus_but:cups_ordered++;
                break;
            case R.id.order_but:displayPrice(cups_ordered*rate+ Additionals());break;
            default:;

        }
        setCups_ordered(cups_ordered);
    }

    private double Additionals() {
        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.otg_cb);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.cream_cb);
        double addtoOrder=0;
        double rate_otg=1.5;
        double rate_cream=3;
        if (checkBox1.isChecked()){
            addtoOrder+=(rate_otg*cups_ordered);
        }
        if (checkBox2.isChecked()){
            addtoOrder+=(rate_cream*cups_ordered);
        }
        return addtoOrder;
    }

    private void setCups_ordered(int number) {
        TextView quantity =(TextView)findViewById(R.id.num_view);
        quantity.setText("" + number);
    }
    private void displayPrice(double number) {
        TextView priceTextView = (TextView)findViewById(R.id.price_view);
        priceTextView.setText("Price:" + NumberFormat.getCurrencyInstance().format(number));
    }

}
