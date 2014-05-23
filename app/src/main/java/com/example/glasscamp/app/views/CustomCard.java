package com.example.glasscamp.app.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.glasscamp.app.R;

/**
 * Created by clem on 23/05/14.
 */
public class CustomCard extends FrameLayout
{
    public CustomCard(Context context)
    {
        super(context);
    }

    public CustomCard(final Context context, int img, int text){
        super(context);
        initView(context, img, text);

    }

    /**
     * Init the custom view
     * @param context
     * @param img
     * @param text
     */
    private void initView(final Context context, int img, int text){
        View view = LayoutInflater.from(context).inflate(R.layout.view_main_card, null);

        // TODO set content on card
        //((ImageView)view.findViewById(R.id.image)).setImageResource(img);
        //((TextView)view.findViewById(R.id.name)).setText(context.getString(text));
        this.addView(view);
    }
}
