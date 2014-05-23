package com.example.glasscamp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.example.glasscamp.app.adapters.MyCardScrollAdapter;
import com.example.glasscamp.app.objects.Balance;
import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;


public class GlassCamp extends Activity {

    private ArrayList<Card> cards;
    private CardScrollView cardScrollView;
    Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createFirstLevelCards();

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

        Card card = new Card(this);
        card.setText("Solde : 30 €");
        card.setImageLayout(Card.ImageLayout.FULL);

        cards.add(card);

        // Balance has both real (from account) and estimated (calculated by the app)
        Balance balance = new Balance();
        balance.setEstimatedBalance(50);
        balance.setRealBalance(90);

        card = new Card(this);
        card.setText(balance.getEstimatedBalance() + "€");
        card.setFootnote("Real balance : " + balance.getRealBalance() + "€");
        card.setImageLayout(Card.ImageLayout.FULL);
        card.addImage(R.drawable.cat);
        cards.add(card);

        card.setText("Last Card?");
        card.setFootnote("do not swipt again");
        card.setImageLayout(Card.ImageLayout.FULL);
        card.addImage(R.drawable.dog);
        cards.add(card);

    }

    public void init(){
        new Balance();
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

    /**
     *
     */
    private void openList(){

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
