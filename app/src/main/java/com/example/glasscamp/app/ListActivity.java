package com.example.glasscamp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.example.glasscamp.app.adapters.CustomScrollAdapter;
import com.example.glasscamp.app.objects.Balance;
import com.example.glasscamp.app.objects.Deal;
import com.example.glasscamp.app.views.CustomCard;
import com.example.glasscamp.app.views.ListCard;
import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clem on 23/05/14.
 */
public class ListActivity extends Activity
{

    private static int NUMBER_DEALS_DISPLAY_BY_CARD = 6;

    private ArrayList<ListCard> cards;
    private CardScrollView cardScrollView;
    private Balance balance;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        balance = new Balance();
        createCards();

        cardScrollView = new CardScrollView(this);
        CustomScrollAdapter adapter = new CustomScrollAdapter(cards);
        cardScrollView.setAdapter(adapter);
        cardScrollView.activate();
        setContentView(cardScrollView);

        cardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (cardScrollView.getSelectedItemPosition() < cards.size() - 1)
                {
                    Deal deal = balance.getDeals().get(cardScrollView.getSelectedItemPosition());
                    openDetailCard(deal);
                }
            }
        });
    }

    /**
     * Create cards to display.
     */
    private void createCards() {
        cards = new ArrayList<ListCard>();

        ArrayList<Deal> deals = balance.getDeals();
        int idDeal = 0;
        while (idDeal < deals.size())
        {
            List<Deal> dealList = new ArrayList<Deal>();
            for (int i = 0; (i < NUMBER_DEALS_DISPLAY_BY_CARD && i < deals.size()); i++) {
                Deal deal = deals.get(i);
                dealList.add(deal);
                idDeal++;
            }
            cards.add(new ListCard(this, balance.getEstimatedBalance() + "", dealList));
        }
    }

    private void openDetailCard(Deal deal)
    {
        Intent i = new Intent(this, DetailDealActivity.class);
        i.putExtra("Deal", deal);
        startActivity(i);
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
