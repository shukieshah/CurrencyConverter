package com.example.shuka.currencyconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by shuka on 8/9/2016.
 */
public class CurrencyCalculator extends Activity {

    private Spinner initialCurrencySpinner;
    private Spinner preferredCurrencySpinner;

    String itemSelectedInSpinner1;
    String itemSelectedInSpinner2;
    String finalResult;
    double value;
    boolean currenciesEqual = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculation_layout);
        addItemsToSpinners();
        addListenersToSpinners();
    }


    public void onCalculate(View view){

        EditText currencyValueEditText = (EditText) findViewById(R.id.value_edit_text);

                //if not, get the value from the edit text and use the quantity class to create a quantity object and convert using to() method
                //call toString and make a string variable: finalresultstring = "" + value + "item selected" + "/n" + "=/n" + newValue + " seconditemselected"
                //set the intent for going back and pass in putExtra: finalresultString AND seconditemselected
        //finally, go back and edit menu dialogs


        if (currencyValueEditText.getText().toString().matches("")) {
                Toast.makeText(this, "You did not enter a value", Toast.LENGTH_SHORT).show();
                return;
        }
        else {


            finalResult = CalculateConversion(itemSelectedInSpinner1, itemSelectedInSpinner2);

            if (!currenciesEqual){
                DecimalFormat df = new DecimalFormat("#.00");
                String stringVal = df.format(value);


                Intent goingBack = new Intent();

                goingBack.putExtra("Result", finalResult);
                goingBack.putExtra("First Item", itemSelectedInSpinner1);
                goingBack.putExtra("Second Item", itemSelectedInSpinner2);
                goingBack.putExtra("Initial Value", stringVal);

                setResult(RESULT_OK, goingBack);

                finish();
            }




        }

    }

    public void addItemsToSpinners(){

        initialCurrencySpinner = (Spinner) findViewById(R.id.initial_currency_spinner);
        preferredCurrencySpinner = (Spinner) findViewById(R.id.preferred_currency_spinner);

        ArrayAdapter<CharSequence> initialSpinner
                = ArrayAdapter.createFromResource(this, R.array.currency_types,
                android.R.layout.simple_spinner_item);
        initialSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        initialCurrencySpinner.setAdapter(initialSpinner);

        ArrayAdapter<CharSequence> preferredSpinner
                = ArrayAdapter.createFromResource(this, R.array.currency_types,
                android.R.layout.simple_spinner_item);
        preferredSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        preferredCurrencySpinner.setAdapter(preferredSpinner);

    }
    public void addListenersToSpinners(){

        EditText currencyValueEditText = (EditText) findViewById(R.id.value_edit_text);
        initialCurrencySpinner = (Spinner) findViewById(R.id.initial_currency_spinner);
        preferredCurrencySpinner = (Spinner) findViewById(R.id.preferred_currency_spinner);



        initialCurrencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
               itemSelectedInSpinner1 =
                        initialCurrencySpinner.getItemAtPosition(pos).toString();


            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

            });

        preferredCurrencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                itemSelectedInSpinner2 =
                        preferredCurrencySpinner.getItemAtPosition(pos).toString();


            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });


        }

    public String CalculateConversion(String initialCurrency, String preferredCurrency){

        EditText currencyValueEditText = (EditText) findViewById(R.id.value_edit_text);

        if(initialCurrency.equals(preferredCurrency)){
            Toast.makeText(this, "Both currencies are equivalent", Toast.LENGTH_SHORT).show();
            currenciesEqual = true;
            return null;

        }
        else{

            currenciesEqual = false;
            value = Double.parseDouble(currencyValueEditText.getText().toString());
            CurrencyQuantity initialQuantity = null;
            String finalResult = "";

            switch (initialCurrency) {
                case "US Dollar (USD $)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.USD);
                    break;
                case "Euro (EUR €)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.EUR);
                    break;
                case "Japanese Yen (JPY ¥)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.JPY);
                    break;
                case "British Pound (GBP £)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.GBP);
                    break;
                case "Australian Dollar (AUD $)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.AUD);
                    break;
                case "Swiss Franc (CHF Fr)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.CHF);
                    break;
                case "Canadian Dollar (CAD $)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.CAD);
                    break;
                case "Mexican Peso (MXN $)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.MXN);
                    break;
                case "Chinese Yuan (CNY ¥)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.CNY);
                    break;
                case "New Zealand Dollar (NZD $)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.NZD);
                    break;
                case "Swedish Krona (SEK kr)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.SEK);
                    break;
                case "Russian Ruble (RUB \u20BD)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.RUB);
                    break;
                case "Hong Kong Dollar (HKD $)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.HKD);
                    break;
                case "Norwegian Krone (NOK kr)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.NOK);
                    break;
                case "Singapore Dollar (SGD $)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.SGD);
                    break;
                case "Turkish Lira (TRY ₺)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.TRY);
                    break;
                case "South Korean Won (KRW ₩)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.KRW);
                    break;
                case "South African Rand (ZAR R)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.ZAR);
                    break;
                case "Brazilian Real (BRL R$)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.BRL);
                    break;
                case "Indian Rupee (INR ₹)":
                    initialQuantity = new CurrencyQuantity(value, CurrencyQuantity.Unit.INR);
                    break;
                default:
                    break;


            }

            switch (preferredCurrency) {
                case "US Dollar (USD $)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.USD).toString();
                    break;
                case "Euro (EUR €)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.EUR).toString();
                    break;
                case "Japanese Yen (JPY ¥)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.JPY).toString();
                    break;
                case "British Pound (GBP £)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.GBP).toString();
                    break;
                case "Australian Dollar (AUD $)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.AUD).toString();
                    break;
                case "Swiss Franc (CHF Fr)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.CHF).toString();
                    break;
                case "Canadian Dollar (CAD $)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.CAD).toString();
                    break;
                case "Mexican Peso (MXN $)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.MXN).toString();
                    break;
                case "Chinese Yuan (CNY ¥)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.CNY).toString();
                    break;
                case "New Zealand Dollar (NZD $)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.NZD).toString();
                    break;
                case "Swedish Krona (SEK kr)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.SEK).toString();
                    break;
                case "Russian Ruble (RUB \u20BD)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.RUB).toString();
                    break;
                case "Hong Kong Dollar (HKD $)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.HKD).toString();
                    break;
                case "Norwegian Krone (NOK kr)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.NOK).toString();
                    break;
                case "Singapore Dollar (SGD $)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.SGD).toString();
                    break;
                case "Turkish Lira (TRY ₺)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.TRY).toString();
                    break;
                case "South Korean Won (KRW ₩)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.KRW).toString();
                    break;
                case "South African Rand (ZAR R)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.ZAR).toString();
                    break;
                case "Brazilian Real (BRL R$)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.BRL).toString();
                    break;
                case "Indian Rupee (INR ₹)":
                    finalResult = initialQuantity.to(CurrencyQuantity.Unit.INR).toString();
                    break;
                default:
                    break;

            }

            return finalResult;

        }


    }
}
