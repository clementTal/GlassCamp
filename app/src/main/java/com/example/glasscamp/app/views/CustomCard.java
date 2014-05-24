package com.example.glasscamp.app.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.glasscamp.app.R;

import java.util.List;
import java.util.Map;

/**
 * Created by clem on 23/05/14.
 */
public class CustomCard extends FrameLayout
{
    public CustomCard(Context context)
    {
        super(context);
    }

    public CustomCard(final Context context, int layout, Map<Integer, String> values, Map<Integer, Integer> picture){
        super(context);
        initView(context, layout, values, picture);

    }


    /**
     * Init the custom view
     * @param context
     */
    private void initView(final Context context, int layout, Map<Integer, String> values, Map<Integer, Integer> picture){
        View view = LayoutInflater.from(context).inflate(layout, null);

        // TODO set content on card
        for (Map.Entry<Integer, String> e : values.entrySet())
        {
            if(e != null)
            {
                ((TextView) view.findViewById(e.getKey())).setText(e.getValue());
            }
        }
        for (Map.Entry<Integer, Integer> e : picture.entrySet())
        {
            if(e != null)
            {
                ((ImageView) view.findViewById(e.getKey())).setImageResource(e.getValue());
            }
        }
        this.addView(view);
    }
}
