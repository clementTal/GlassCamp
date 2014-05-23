package com.example.glasscamp.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.glasscamp.app.adapters.CustomScrollAdapter;
import com.example.glasscamp.app.views.CustomCard;
import com.example.glasscamp.app.views.ListCard;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;

/**
 * Created by clem on 23/05/14.
 */
public class ListActivity extends Activity
{

    private ArrayList<ListCard> cards;
    private CardScrollView cardScrollView;
    private Balance balance;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        balance = getIntent().getSerializableExtra("Balance");

        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();

        createCards();

        cardScrollView = new CardScrollView(this);
        CustomScrollAdapter adapter = new CustomScrollAdapter(cards);
        cardScrollView.setAdapter(adapter);
        cardScrollView.activate();
        setContentView(cardScrollView);
    }

    /**
     * Create cards to display.
     */
    private void createCards() {
        cards = new ArrayList<ListCard>();

        // TODO Add cards
        //cards.add(new CustomCard(this, R.drawable.cantine, R.string.sponsor_cantine));
        //cards.add(new CustomCard(this, R.drawable.arkea, R.string.sponsor_arkea));

        ArrayList deals = balance.getDeals();
        cards = new ArrayList<Card>()
        int idDeal = 0;
        for(Deal deal : deals) {
            if(idDeal % (NUMBER_DEALS_DISPLAY_BY_CARD - 1) == 0) {
                if(i == (NUMBER_DEALS_DISPLAY_BY_CARD - 1))
                    cards.add(card)
                Card card = new card(this);
                i =  0;
            }
            if(idDeal < NUMBER_DEALS_DISPLAY_BY_CARD){
                card.setText(card.getText()+", "deal.getAmount());
            }
            idDeal++;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.glass_camp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
