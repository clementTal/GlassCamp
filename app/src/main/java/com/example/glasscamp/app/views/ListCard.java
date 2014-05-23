package com.example.glasscamp.app.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.glasscamp.app.R;

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

    public ListCard(final Context context, List<String> elements){
        super(context);
        initView(context, elements);

    }

    /**
     * Init the custom view
     */
    private void initView(final Context context, List<String> elements){
        View view = LayoutInflater.from(context).inflate(R.layout.list_card, null);

        // TODO set content on card
        //((ImageView)view.findViewById(R.id.image)).setImageResource(img);
        //((TextView)view.findViewById(R.id.name)).setText(context.getString(text));
        this.addView(view);
    }
}
