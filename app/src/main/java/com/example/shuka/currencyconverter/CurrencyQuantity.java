package com.example.shuka.currencyconverter;

import java.text.DecimalFormat;


public class CurrencyQuantity {

    final double value;
    final Unit unit;


    public static enum Unit{
        USD(1.0d), EUR(0.90d), JPY(101.33d), GBP(0.77d),
        AUD(1.30d), CHF(0.98d), CAD(1.31d), MXN(18.38d),
        CNY(6.65d), NZD(1.39d), SEK(8.51d), RUB(64.72d),
        HKD(7.76d), NOK(8.37d), SGD(1.34d), TRY(2.96d),
        KRW(1092.11d), ZAR(13.37d), BRL(3.15d), INR(66.69d);



        final double byBaseUnit;

        private Unit(double inTsp){

            this.byBaseUnit = inTsp;

        }

        public double toBaseUnit(double value){

            return value/byBaseUnit;
        }

        public double fromBaseUnit(double value){

            return value*byBaseUnit;
        }


    }
    public CurrencyQuantity(double value, Unit unit){

        super();
        this.value = value;
        this.unit = unit;
    }

    public CurrencyQuantity to(Unit newUnit){

        Unit oldUnit = this.unit;
        return new CurrencyQuantity(newUnit.fromBaseUnit(oldUnit.toBaseUnit(value)), newUnit);
    }

    @Override
    public String toString(){

        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(value) + " " + unit.name();
        //return df.format(valueOriginal) + " " + oldUnit.name() + "/n" + "=/n" + df.format(value) + " " + unit.name();
    }

}
