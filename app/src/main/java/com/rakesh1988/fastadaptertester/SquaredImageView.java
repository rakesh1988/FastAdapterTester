package com.rakesh1988.fastadaptertester;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by rakesh on 01-Jan-17.
 */

public final class SquaredImageView extends ImageView
{
    public SquaredImageView(Context context)
    {
        super(context);
    }

    public SquaredImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}