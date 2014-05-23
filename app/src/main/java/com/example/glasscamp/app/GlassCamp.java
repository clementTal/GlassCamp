package com.example.glasscamp.app;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.example.glasscamp.app.adapters.ScrollAdapter;
import com.example.glasscamp.app.objects.Balance;
import com.example.glasscamp.app.objects.Deal;
import com.example.glasscamp.app.views.ListCard;
import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;


public class GlassCamp extends Activity {
    private static final int NUMBER_DEALS_DISPLAY_BY_CARD = 5;

    private static int PICTURE_RESULT = 0;
    private ArrayList<Card> cards;
    private CardScrollView cardScrollView;
    private Balance balance;
    Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createFirstLevelCards();

        cardScrollView = new CardScrollView(this);
        ScrollAdapter adapter = new ScrollAdapter(cards);
        cardScrollView.setAdapter(adapter);
        cardScrollView.activate();
        setContentView(cardScrollView);

        //On card click
        cardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                if (cardScrollView.getSelectedItemPosition() < cards.size() - 1)
                {
                    switch (cardScrollView.getSelectedItemPosition())
                    {
                        case 0:
                            openCamera();
                            break;
                        case 1:
                            break;
                        case 2:
                            openList();
                            break;
                        default:
                            tappedCard(cardScrollView.getSelectedItemPosition());
                    }

                }
            }
        });
    }

    /**
     * Create a list of cards
     */
    public void createFirstLevelCards()
    {
        cards = new ArrayList<Card>();
        balance = initAccount();

        //Main card.
        Card card = new Card(this);
        card.setText(balance.getEstimatedBalance() + "€");
        card.setFootnote("Real balance : " + balance.getRealBalance() + "€");
        card.setImageLayout(Card.ImageLayout.FULL);
        card.addImage(R.drawable.cat);
        cards.add(card);

        // Income card
        card = new Card(this);
        card.addImage(R.drawable.dog);
        cards.add(card);

        // List icon card
        card = new Card(this);
        card.addImage(R.drawable.cat);
        cards.add(card);

        // options icon card
        card = new Card(this);
        card.addImage(R.drawable.cat);
        cards.add(card);
    }

    /**
     * Create an account and his previous deals
     */
    public Balance initAccount(){
        Balance balance = new Balance(1500.f, 1500.f);
        ArrayList<Deal> deals = balance.getDeals();
        Deal deal1 = new Deal(102.25f, "Auchan Rennes");
        deals.add(deal1);
        Deal deal2 = new Deal(63.88f, "Leclerc Brest");
        deals.add(deal2);
        Deal deal3 = new Deal(302.25f, "Opti' soin");
        deals.add(deal3);
        Deal deal4 = new Deal(7.85f, "Mac do");
        deals.add(deal4);
        return balance;
    }
    /**
     * Action to do when you have a card tapped.
     * Created on the main activity to have the context
     */
    private void tappedCard(int i)
    {
        Toast.makeText(this, "card tapped " + i, Toast.LENGTH_SHORT).show();
    }

    /**
     * Open the camera adapter
     */
    private void openCamera()
    {
        int PICTURE_RESULT = 0;
        this.startActivityForResult(camera, PICTURE_RESULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICTURE_RESULT && resultCode == RESULT_OK) {
            startActivity(new Intent(this, ListActivity.class));
        }
    }

    /**
     * Open the list and display it
     * Start List activity
     */
    private void openList(){
        Intent i = new Intent(this, ListActivity.class);
        i.putExtra("Balance", balance);
        startActivity(i);
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
