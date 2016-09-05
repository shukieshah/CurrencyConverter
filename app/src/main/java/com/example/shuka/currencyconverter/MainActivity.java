package com.example.shuka.currencyconverter;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            DialogFragment myFragment = new MyDialogFragment();

            myFragment.show(getFragmentManager(), "theDialog");

            return true;
        } else if (id == R.id.exit_the_app) {

            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onConvert(View view){

        //intent is to open up another activity called CurrencyCalculator.java
        Intent calculatorScreenIntent = new Intent(this,
                CurrencyCalculator.class);

        final int result = 1;


        startActivityForResult(calculatorScreenIntent, result);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView resultTextView = (TextView)
                findViewById(R.id.result_text_view);
        ImageView currencyIconImageView = (ImageView)
                findViewById(R.id.result_image_view);

        String finalResult = data.getStringExtra("Result");
        String firstItem = data.getStringExtra("First Item");
        String stringVal = data.getStringExtra("Initial Value");
        String secondItem = data.getStringExtra("Second Item");


        for (int x = 0; x < firstItem.length() + 1; x++)
        {
            if(firstItem.substring(x, x+1).equals("("))
            {
                firstItem = firstItem.substring(x+1, x+4);
                break;
            }
        }

        finalResult = stringVal + " " + firstItem + "\n" + "=\n" + finalResult;

        resultTextView.setText(finalResult);

        switch (secondItem) {
            case "US Dollar (USD $)": currencyIconImageView.setImageResource(R.drawable.usd);
                break;
            case "Euro (EUR €)": currencyIconImageView.setImageResource(R.drawable.eur);
                break;
            case "Japanese Yen (JPY ¥)": currencyIconImageView.setImageResource(R.drawable.jpy);
                break;
            case "British Pound (GBP £)": currencyIconImageView.setImageResource(R.drawable.gbp);
                break;
            case "Australian Dollar (AUD $)": currencyIconImageView.setImageResource(R.drawable.aud);
                break;
            case "Swiss Franc (CHF Fr)": currencyIconImageView.setImageResource(R.drawable.chf);
                break;
            case "Canadian Dollar (CAD $)": currencyIconImageView.setImageResource(R.drawable.cad);
                break;
            case "Mexican Peso (MXN $)": currencyIconImageView.setImageResource(R.drawable.mxn);
                break;
            case "Chinese Yuan (CNY ¥)": currencyIconImageView.setImageResource(R.drawable.cny);
                break;
            case "New Zealand Dollar (NZD $)": currencyIconImageView.setImageResource(R.drawable.nzd);
                break;
            case "Swedish Krona (SEK kr)": currencyIconImageView.setImageResource(R.drawable.sek);
                break;
            case "Russian Ruble (RUB \u20BD)": currencyIconImageView.setImageResource(R.drawable.rub);
                break;
            case "Hong Kong Dollar (HKD $)": currencyIconImageView.setImageResource(R.drawable.hkd);
                break;
            case "Norwegian Krone (NOK kr)": currencyIconImageView.setImageResource(R.drawable.nok);
                break;
            case "Singapore Dollar (SGD $)": currencyIconImageView.setImageResource(R.drawable.sgd);
                break;
            case "Turkish Lira (TRY ₺)": currencyIconImageView.setImageResource(R.drawable.turky);
                break;
            case "South Korean Won (KRW ₩)": currencyIconImageView.setImageResource(R.drawable.krw);
                break;
            case "South African Rand (ZAR R)": currencyIconImageView.setImageResource(R.drawable.zar);
                break;
            case "Brazilian Real (BRL R$)": currencyIconImageView.setImageResource(R.drawable.brl);
                break;
            case "Indian Rupee (INR ₹)": currencyIconImageView.setImageResource(R.drawable.inr);
                break;
            default:
                break;


        }




    }


}
