package com.example.glasscamp.app.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.example.glasscamp.app.R;
import com.example.glasscamp.app.objects.Deal;

/**
 * Created by clem on 23/05/14.
 */
public class DetailCard extends FrameLayout {
    public DetailCard(Context context) {
        super(context);
    }

    public DetailCard(final Context context, Deal deal)
    {
        super(context);
        initView(context, deal);

    }

    /**
     * Init the custom view
     * @param context
     */
    private void initView(final Context context, Deal deal){
        View view = LayoutInflater.from(context).inflate(R.layout.activity_detail_deal, this);
        ((TextView)view.findViewById(R.id.deal_date)).setText(deal.getDateString());
        ((TextView)view.findViewById(R.id.deal_value)).setText(deal.getAmount() + " €");
        ((TextView)view.findViewById(R.id.deal_shop)).setText(deal.getShop());
        view.setVisibility(view.VISIBLE);
        this.addView(view);
    }
}
