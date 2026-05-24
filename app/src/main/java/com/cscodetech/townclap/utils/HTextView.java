package com.cscodetech.townclap.utils;

import android.content.Context;
import android.util.AttributeSet;

public abstract class HTextView extends androidx.appcompat.widget.AppCompatTextView {
    protected HTextView(Context context) {
        this(context, null);
    }

    protected HTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    protected HTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public abstract void setAnimationListener(AnimationListener listener);

    public abstract void setProgress(float progress);

    public abstract void animateText(CharSequence text);
}