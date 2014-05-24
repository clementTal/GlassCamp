package com.example.glasscamp.app;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.example.glasscamp.app.adapters.CustomScrollAdapter;
import com.example.glasscamp.app.objects.Balance;
import com.example.glasscamp.app.views.CustomCard;
import com.google.android.glass.app.Card;
import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GlassCamp extends Activity {

    private static int PICTURE_RESULT = 0;
    private ArrayList<CustomCard> cards;
    private CardScrollView cardScrollView;
    private Balance balance;
    Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createFirstLevelCards();
        mGestureDetector = createGestureDetector(this);

        cardScrollView = new CardScrollView(this);
        CustomScrollAdapter adapter = new CustomScrollAdapter(cards);
        cardScrollView.setAdapter(adapter);
        cardScrollView.activate();
        cardScrollView.setSelection(1);
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
                        case 1:
                            openCamera();
                            break;
                        case 3:
                            openList();
                            break;
                    }

                }
            }
        });
    }

    /**
     * Launch a notif when double tap is detected
     * @param context
     * @return
     */
    private GestureDetector createGestureDetector(Context context) {
        GestureDetector gestureDetector = new GestureDetector(context);
        //Create a base listener for generic gestures
        gestureDetector.setBaseListener( new GestureDetector.BaseListener() {
            @Override
            public boolean onGesture(Gesture gesture) {
                if (gesture == Gesture.TWO_TAP) {
                    launchNotif();
                    return true;
                }
                return false;
            }
        });
        return gestureDetector;
    }
    /*
    * Send generic motion events to the gesture detector
    */
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        return mGestureDetector != null && mGestureDetector.onMotionEvent(event);
    }


    /**
         * Create a list of cards
         */
    public void createFirstLevelCards()
    {
        cards = new ArrayList<CustomCard>();
        balance = initAccount();

        //options card.
        CustomCard card = new CustomCard(this, R.layout.main_activity, new HashMap<Integer, String>(), new HashMap<Integer, Integer>());
        cards.add(card);

        //Main card.
        Map<Integer, String> values = new HashMap<Integer, String>();
        values.put(R.id.balance, balance.getEstimatedBalance() + " €");
        values.put(R.id.footnote, "Click to take a picture");
        values.put(R.id.timestamp, balance.getRealBalance() + " €");
        card = new CustomCard(this, R.layout.view_main_card, values, new HashMap<Integer, Integer>());
        cards.add(card);

        // jauge card
        card = new CustomCard(this, R.layout.list_card, new HashMap<Integer, String>(), new HashMap<Integer, Integer>());
        cards.add(card);

        // list card
        values = new HashMap<Integer, String>();
        values.put(R.id.title_left_col_txt, this.getString(R.string.balance));
        values.put(R.id.data_left_col_txt, balance.getEstimatedBalance() + " €");
        values.put(R.id.row1_content, balance.getDeals().get(0).getDateString() + ", " + balance.getDeals().get(0).getAmount() + " €, @:"+ balance.getDeals().get(0).getShop());
        values.put(R.id.row2_content, balance.getDeals().get(1).getDateString() + ", " + balance.getDeals().get(1).getAmount() + " €, @:"+ balance.getDeals().get(1).getShop());
        values.put(R.id.row3_content, balance.getDeals().get(2).getDateString() + ", " + balance.getDeals().get(2).getAmount() + " €, @:"+ balance.getDeals().get(2).getShop());
        values.put(R.id.row4_content, balance.getDeals().get(3).getDateString() + ", " + balance.getDeals().get(3).getAmount() + " €, @:"+ balance.getDeals().get(3).getShop());
        values.put(R.id.row5_content, balance.getDeals().get(4).getDateString() + ", " + balance.getDeals().get(4).getAmount() + " €, @:"+ balance.getDeals().get(4).getShop());
        card = new CustomCard(this, R.layout.list_card, values, new HashMap<Integer, Integer>());
        cards.add(card);
    }

    /**
     * Create an account and his previous deals
     */
    public Balance initAccount(){
        Balance balance = new Balance();
        return balance;
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
     * On camera return
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICTURE_RESULT && resultCode == RESULT_OK) {
            balance.addRandomDeal();
            Toast.makeText(getApplicationContext(), "Dépense ajoutée.", Toast.LENGTH_SHORT).show();
            cardScrollView.setSelection(3);
        }
    }

    /**
     * Open the list and display it
     * Start List activity
     */
    private void openList(){
        Intent i = new Intent(this, DetailDealActivity.class);
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

    public void launchNotif(){
        Intent i = new Intent(this, LiveCardService.class);
        startService(i);
    }

}
