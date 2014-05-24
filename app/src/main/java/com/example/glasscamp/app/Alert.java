package com.example.glasscamp.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.glasscamp.app.adapters.CustomScrollAdapter;
import com.example.glasscamp.app.views.CustomCard;
import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Alert extends Activity {
    List<CustomCard> cards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cards = new ArrayList<CustomCard>();

        Bundle b = getIntent().getExtras();
        String date = b.getString("date");
        String balance = b.getString("balance");
        String dealAmount = b.getString("dealAmount");

        HashMap<Integer, String> values = new HashMap<Integer, String>();
        values.put(R.id.TV_date_alert, date);
        values.put(R.id.TV_deal_alert, dealAmount);
        values.put(R.id.TV_balance_estimated, balance);


        CustomCard card = new CustomCard(this, R.layout.activity_alert, values, new HashMap<Integer, Integer>());
        cards.add(card);

        CardScrollView cardScrollView = new CardScrollView(this);
        CustomScrollAdapter adapter = new CustomScrollAdapter(cards);
        cardScrollView.setAdapter(adapter);
        cardScrollView.activate();
        cardScrollView.setSelection(1);
        setContentView(cardScrollView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
