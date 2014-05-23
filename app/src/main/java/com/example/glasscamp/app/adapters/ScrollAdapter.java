package com.example.glasscamp.app.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;

import java.util.ArrayList;

/**
 * Adapter in charge of displaying cards.
 * @author SCA
 * @date 20/05/2014.
 */
public class ScrollAdapter extends com.google.android.glass.widget.CardScrollAdapter
{

    private ArrayList<Card> cards = null;

    public ScrollAdapter(final ArrayList<Card> cards)
    {
        this.cards = cards;
    }

    @Override
    public int getPosition(Object item)
    {
        return cards.indexOf(item);
    }

    @Override
    public int getCount()
    {
        if(cards == null)
            return 0;
        return cards.size();
    }

    @Override
    public Object getItem(int position)
    {
        return cards.get(position);
    }

    /**
     * Returns the amount of view types.
     */
    @Override
    public int getViewTypeCount()
    {
        return Card.getViewTypeCount();
    }

    /**
     * Returns the view type of this card so the system can figure out
     * if it can be recycled.
     */
    @Override
    public int getItemViewType(int position)
    {
        return cards.get(position).getItemViewType();
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent)
    {
        return  cards.get(position).getView(convertView, parent);
    }
}
