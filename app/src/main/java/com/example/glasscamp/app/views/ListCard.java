package com.example.glasscamp.app.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.glasscamp.app.R;
import com.example.glasscamp.app.objects.Deal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by clem on 23/05/14.
 */
public class ListCard extends FrameLayout
{
    public ListCard(Context context)
    {
        super(context);
    }

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
        idList.add(R.id.row1_date);idList.add(R.id.row1_value);idList.add(R.id.row1_seller);
        idList.add(R.id.row2_date);idList.add(R.id.row2_value);idList.add(R.id.row2_seller);
        idList.add(R.id.row3_date);idList.add(R.id.row3_value);idList.add(R.id.row3_seller);
        idList.add(R.id.row4_date);idList.add(R.id.row4_value);idList.add(R.id.row4_seller);
        idList.add(R.id.row5_date);idList.add(R.id.row5_value);idList.add(R.id.row5_seller);
        idList.add(R.id.row6_date);idList.add(R.id.row6_value);idList.add(R.id.row6_seller);

        // TODO set content on card
        ((TextView)view.findViewById(R.id.title_left_col_txt)).setText(context.getString(R.string.balance));
        ((TextView)view.findViewById(R.id.data_left_col_txt)).setText(BalanceValue);

        for (int i = 0; i < elements.size(); i++)
        {
            Deal deal = elements.get(i);
            ((TextView)view.findViewById(idList.get(i))).setText(deal.getDateString());
            ((TextView)view.findViewById(idList.get(i+1))).setText(deal.getAmount() + " €");
            ((TextView)view.findViewById(idList.get(i+2))).setText(deal.getShop());
        }
        this.addView(view);
    }
}
