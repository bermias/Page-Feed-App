package com.ermias.pagefeedsapp;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;

public class Help {

    SpannableString getSpannableString(String s, int size, int color){
        SpannableString ss = new SpannableString(s);
        ss.setSpan(new AbsoluteSizeSpan(size, true), 0, s.length(), 0);
        ss.setSpan(new ForegroundColorSpan(color),0,s.length(),0);
        return ss;
    }
}
