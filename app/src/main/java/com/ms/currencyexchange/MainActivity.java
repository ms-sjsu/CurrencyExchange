package com.ms.currencyexchange;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView txt;
    static TextView crt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.dollarValue);
        crt = findViewById(R.id.convertValue);
        Intent intent = getIntent();
        txt.setText(intent.getStringExtra("msg1"));
        crt.setText(intent.getStringExtra("msg2"));
    }

    public void applyConversion(View v)
    {
        double converted=0;

        int amount = Integer.valueOf(txt.getText().toString());
        String currency = crt.getText().toString();
        String unique1 = "com.ms.broadcastreceiversConverted";

        if(currency.equals("British Pound"))
            converted = amount * 0.76;
        else if (currency.equals("Euro"))
            converted = amount * 0.89;
        else if (currency.equals("Indian Rupee"))
            converted = amount * 70.86;

        String finalMessage = "Dollar amount $"+amount+" converted to "+converted+" "+currency;

        Intent broadcastIntent = new Intent();
        broadcastIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        broadcastIntent.setComponent((new ComponentName("com.ms.currencyconverterapp","com.ms.currencyconverterapp.RecieverFromCurrencyExchange")));
        broadcastIntent.setAction(unique1);
        broadcastIntent.putExtra("message3", finalMessage);
        sendBroadcast(broadcastIntent);
    }

    public void finishApp(View v) {
        MainActivity.this.finish();
    }
}
