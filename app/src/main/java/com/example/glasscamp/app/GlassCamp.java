package com.example.glasscamp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.example.glasscamp.app.adapters.MyCardScrollAdapter;
import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;


public class GlassCamp extends Activity {

    private ArrayList<Card> cards;
    private CardScrollView cardScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createCards();

        cardScrollView = new CardScrollView(this);
        MyCardScrollAdapter adapter = new MyCardScrollAdapter(cards);
        cardScrollView.setAdapter(adapter);
        cardScrollView.activate();
        setContentView(cardScrollView);

        //On card click
        cardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                tappedCard();
            }
        });

        setContentView(R.layout.main_activity);
    }

    /**
     * Create a list of cards
     */
    public void createCards()
    {
        cards = new ArrayList<Card>();

        Card card = new Card(this);
        card.setText("Welcom to CHARJ");
        card.setFootnote("swipe to see next cards");
        cards.add(card);

        card = new Card(this);
        card.setText("Do you like this?");
        card.setFootnote("swipe again!");
        card.setImageLayout(Card.ImageLayout.FULL);
        cards.add(card);
    }

    /**
     * Action to do when you have a card tapped.
     * Created on the main activity to have the context
     */
    private void tappedCard()
    {
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.glass_camp, menu);
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
