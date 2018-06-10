package com.visit_egypt.visitegypt.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Muhammad on 12/1/2016
 */
public class TextViewRobotoLight extends TextView {
    public TextViewRobotoLight(Context context) {
        super(context);
        if (!isInEditMode())
            setTypedFace(context);
    }

    public TextViewRobotoLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            setTypedFace(context);
    }

    public TextViewRobotoLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode())
            setTypedFace(context);
    }

    private void setTypedFace(Context context) {

        String englishFont = "Roboto-Light.ttf";

        Typeface type = Typeface.createFromAsset(context.getAssets(), englishFont);

        setTypeface(type);
    }
}
