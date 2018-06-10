package com.visit_egypt.visitegypt.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Abanoub on 9/14/2015
 */
public class ButtonRobotoRegular extends Button {

    public ButtonRobotoRegular(Context context) {
        super(context);
        setTypedFace(context);
    }

    public ButtonRobotoRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypedFace(context);
    }

    public ButtonRobotoRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypedFace(context);
    }

    private void setTypedFace(Context context) {

        String englishFont = "Roboto-Light.ttf";

        Typeface type = Typeface.createFromAsset(context.getAssets(), englishFont);

        setTypeface(type);
    }

}
