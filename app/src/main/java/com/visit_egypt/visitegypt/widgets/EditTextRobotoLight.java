package com.visit_egypt.visitegypt.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Muhammad on 12/1/2016
 */
public class EditTextRobotoLight extends EditText {
    public EditTextRobotoLight(Context context) {
        super(context);
        if (!isInEditMode())
            setTypedFace(context);
    }

    public EditTextRobotoLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            setTypedFace(context);
    }

    public EditTextRobotoLight(Context context, AttributeSet attrs, int defStyleAttr) {
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
