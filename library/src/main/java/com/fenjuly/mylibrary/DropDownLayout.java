package com.fenjuly.mylibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.nineoldandroids.animation.ObjectAnimator;


/**
 * Created by fenjuly with love on 15/9/1.
 */
public class DropDownLayout extends FrameLayout {

    private int curY;
    private boolean isFirstOnLayout = true;

    public DropDownLayout(Context context) {
        this(context, null);
    }

    public DropDownLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DropDownLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        Log.e("onLayout", "invoked");
        curY = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            int width = child.getMeasuredWidth();
            int height = child.getMeasuredHeight();
            int layoutHeight = height;
            if (child instanceof ToggleExpandLayout) {
                layoutHeight = 0;
                View grandson = ((ToggleExpandLayout) child).getChildAt(0);
                if (grandson != null) {
                    width = grandson.getMeasuredWidth();
                    height = grandson.getMeasuredHeight();
                }
                ToggleExpandLayout tl = (ToggleExpandLayout)child;
                for (int j = 0; j < tl.getChildCount(); j++) {
                    layoutHeight = layoutHeight + tl.getChildAt(j).getMeasuredHeight();
                }
            }
            child.layout(left, curY, left + width, curY + layoutHeight);
            curY = curY + height;
            if (!isFirstOnLayout) {
                init(child, i, getChildCount());
            }
        }
        isFirstOnLayout = false;
    }

    private void init(View child, final int position, final int childCount) {
        if (child instanceof ToggleExpandLayout) {
            ToggleExpandLayout layout = (ToggleExpandLayout) child;
            layout.setOnToggleTouchListener(new ToggleExpandLayout.OnToggleTouchListener() {
                @Override
                public void onStartOpen(int height, int originalHeight) {
                    Log.e("startOpen", "invoked");
                    if (position != childCount - 1) {
                        for (int i = position + 1; i < childCount; i++) {
                            int top = 0;
                            View v = getChildAt(i);
                            if (v.getTag() != null) {
                                Log.e("getTag", "invoke");
                                top = (int)v.getTag();
                                Log.e("top", String.valueOf(top));
                            }
                            DropViewAnimator animator = new DropViewAnimator(top, top + height);
                            v.setTag(top + height);
                            animator.prepare(v);
                            animator.start();
                        }
                    }

                }

                @Override
                public void onOpen() {

                }

                @Override
                public void onStartClose(int height, int originalHeight) {
                    Log.e("startClose", "invoked");
                    if (position != childCount - 1) {
                        for (int i = position + 1; i < childCount; i++) {
                            int top = 0;
                            View v = getChildAt(i);
                            if (v.getTag() != null) {
                                Log.e("getTag", "invoke");
                                top = (int)v.getTag();
                                Log.e("top", String.valueOf(top));
                            }
                            RiseViewAnimator animator = new RiseViewAnimator(top, top - height);
                            v.setTag(top - height);
                            animator.prepare(v);
                            animator.start();
                        }
                    }
                }

                @Override
                public void onClosed() {

                }
            });
        }
    }

    private class DropViewAnimator extends BaseAnimator {
        private float oriY;
        private float curY;

        private DropViewAnimator(float oriY, float curY) {
            this.oriY = oriY;
            this.curY = curY;
        }

        @Override
        protected void prepare(View target) {
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(target, "translationY", oriY, curY)
            );
        }
    }

    private class RiseViewAnimator extends BaseAnimator {
        private float oriY;
        private float curY;

        private RiseViewAnimator(float oriY, float curY) {
            this.oriY = oriY;
            this.curY = curY;
        }

        @Override
        protected void prepare(View target) {
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(target, "translationY", oriY, curY)
            );
        }
    }

}
