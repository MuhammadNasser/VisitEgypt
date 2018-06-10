package com.visit_egypt.visitegypt.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Abanoub on 9/14/2015
 */
public class TextViewRobotoRegular extends TextView {
    public TextViewRobotoRegular(Context context) {
        super(context);
        setTypedFace(context);
    }

    public TextViewRobotoRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypedFace(context);
    }

    public TextViewRobotoRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypedFace(context);
    }

    private void setTypedFace(Context context) {

        String englishFont = "Roboto-Regular.ttf";

        Typeface type = Typeface.createFromAsset(context.getAssets(), englishFont);

        setTypeface(type);
    }
}
