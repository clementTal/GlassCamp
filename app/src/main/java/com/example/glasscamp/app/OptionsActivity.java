package com.example.glasscamp.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.glasscamp.app.adapters.CustomScrollAdapter;
import com.example.glasscamp.app.views.CustomCard;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class OptionsActivity extends Activity {

    private CardScrollView cardScrollView;
    List<CustomCard> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cards = new ArrayList<CustomCard>();
        CustomCard card = new CustomCard(this, R.layout.view_param_limit, new HashMap<Integer, String>(), new HashMap<Integer, Integer>());
        cards.add(card);
        card = new CustomCard(this, R.layout.view_param_transfer, new HashMap<Integer, String>(), new HashMap<Integer, Integer>());
        cards.add(card);

        cardScrollView = new CardScrollView(this);
        CustomScrollAdapter adapter = new CustomScrollAdapter(cards);
        cardScrollView.setAdapter(adapter);
        cardScrollView.activate();
        cardScrollView.setSelection(1);
        setContentView(cardScrollView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options, menu);
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
