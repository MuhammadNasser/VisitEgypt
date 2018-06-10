package com.visit_egypt.visitegypt.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Abanoub on 9/14/2015
 */
public class TextViewRobotoBold extends TextView {
    public TextViewRobotoBold(Context context) {
        super(context);
        if (!isInEditMode())
            setTypedFace(context);
    }

    public TextViewRobotoBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            setTypedFace(context);
    }

    public TextViewRobotoBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode())
            setTypedFace(context);
    }

    private void setTypedFace(Context context) {

        String englishFont = "Roboto-Bold.ttf";

        Typeface type = Typeface.createFromAsset(context.getAssets(), englishFont);

        setTypeface(type);
    }
}
