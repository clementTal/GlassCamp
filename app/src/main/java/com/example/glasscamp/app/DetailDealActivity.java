package com.example.glasscamp.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.glasscamp.app.adapters.CustomScrollAdapter;
import com.example.glasscamp.app.objects.Deal;
import com.example.glasscamp.app.views.DetailCard;
import com.example.glasscamp.app.views.ListCard;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;


public class DetailDealActivity extends Activity
{
    private ArrayList<DetailCard> cards;
    private CardScrollView cardScrollView;
    private Deal deal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        deal = getIntent().getExtras().getParcelable("Deal");
        createCards();

        cardScrollView = new CardScrollView(this);
        CustomScrollAdapter adapter = new CustomScrollAdapter(cards);
        cardScrollView.setAdapter(adapter);
        cardScrollView.activate();
        setContentView(cardScrollView);
        setContentView(R.layout.activity_detail_deal);
    }

    private void createCards()
    {
        DetailCard card = new DetailCard(this, deal);
        cards.add(card);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail_deal, menu);
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
