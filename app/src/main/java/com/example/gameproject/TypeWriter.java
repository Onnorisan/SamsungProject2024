package com.example.gameproject;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class TypeWriter extends AppCompatTextView {
    private CharSequence mText;
    private int mIndex;
    public boolean isAnimating=false;
    private long mDelay = 90;
    public TypeWriter(Context context) {
        super(context);
    }
    public TypeWriter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    private Handler mHandler = new Handler();

    //анимация
    public void skipAnim() {
        mHandler.removeCallbacks(characterAdder);
        isAnimating = false;
        setText(mText);
        isTextFullyDisplayed=true;
    }

    private boolean isTextFullyDisplayed = false;

    public boolean isTextFullyDisplayed() {
        return isTextFullyDisplayed;
    }

    private void setIsTextFullDisplayed(boolean value) {
        isTextFullyDisplayed = value;
    }

    //анимация

    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            isAnimating=true;
            setText(mText.subSequence(0, mIndex++));
            if (mIndex <= mText.length()) {
                mHandler.postDelayed(characterAdder, mDelay);
            } else {
                setIsTextFullDisplayed(true);
                isAnimating = false;
            }
        }
    };
    public void animateText(CharSequence text) {
        mText = text;
        mIndex = 0;
        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);
        setIsTextFullDisplayed(true);
    }
    public void setCharacterDelay(long delay) {
        mDelay = delay;
    }
}
