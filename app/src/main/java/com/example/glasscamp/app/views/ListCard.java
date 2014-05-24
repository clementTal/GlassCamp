package com.example.glasscamp.app.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.example.glasscamp.app.R;
import com.example.glasscamp.app.objects.Deal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clem on 23/05/14.
 */
public class ListCard extends FrameLayout
{
    public ListCard(Context context)
    {
        super(context);
    }

    /**
     * list card creator
     * @param context
     * @param BalanceValue the ballance value
     * @param elements the elements (Deal) to display
     */
    public ListCard(final Context context, String BalanceValue, List<Deal> elements){
        super(context);
        initView(context, BalanceValue, elements);

    }

    /**
     * Init the custom view
     */
    private void initView(final Context context, String BalanceValue, List<Deal> elements)
    {

        View view = LayoutInflater.from(context).inflate(R.layout.list_card, null);
        List<Integer> idList = new ArrayList<Integer>(6);
        idList.add(R.id.row1_content);
        idList.add(R.id.row2_content);
        idList.add(R.id.row3_content);
        idList.add(R.id.row4_content);
        idList.add(R.id.row5_content);
        idList.add(R.id.row6_content);

        // TODO set content on card
        ((TextView)view.findViewById(R.id.title_left_col_txt)).setText(context.getString(R.string.balance));
        ((TextView)view.findViewById(R.id.data_left_col_txt)).setText(BalanceValue);

        for (int i = 0; i < elements.size(); i++)
        {
            Deal deal = elements.get(i);
            ((TextView)view.findViewById(idList.get(i))).setText(deal.getDateString() + ", " + deal.getAmount() + " €, @:"+ deal.getShop());
        }
        this.addView(view);
    }
}
