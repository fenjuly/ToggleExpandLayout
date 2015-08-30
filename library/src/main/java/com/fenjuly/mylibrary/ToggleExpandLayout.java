package com.fenjuly.mylibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

import java.util.ArrayList;

/**
 * Created by fenjuly with love on 15/8/27.
 */
public class ToggleExpandLayout extends FrameLayout {

    private boolean isOpen = false;
    private int mPosY;
    private int mTop;

    private ArrayList<OnToggleTouchListener> listeners = new ArrayList<>();

    public ToggleExpandLayout(Context context) {
        this(context, null);
    }

    public ToggleExpandLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ToggleExpandLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        mPosY = 0;
        mTop = 0;
        int curY = top;
        View rootChild = getChildAt(getChildCount() -1);
        int rootHeight = rootChild.getMeasuredHeight();
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            int width = child.getMeasuredWidth();
            int height = child.getMeasuredHeight();
            float ratio = (float)height / rootHeight;
            child.setTag(ratio);
            child.layout(left, curY, left + width, curY + height);
        }
        for (int i = 0; i < getChildCount() - 1; i++) {
            View child = getChildAt(i);
            child.setVisibility(INVISIBLE);
        }
    }

    public void open() {
        if (!isOpen) {
            isOpen = true;
            for (int i = 0; i < getChildCount() - 1; i++) {
                View child = getChildAt(i);
                child.setVisibility(VISIBLE);
            }
            mPosY = 0;
            for (OnToggleTouchListener l : listeners) {
                l.onStartOpen();
            }
            int childCount = getChildCount();
            for (int i = childCount - 2; i > -1; i--) {
                View child = getChildAt(i);
                View preChild = getChildAt(i + 1);
                int preHeight = preChild.getMeasuredHeight();
                float ratio = (float)child.getTag();
                OpenViewAnimator animator = new OpenViewAnimator(mTop, mPosY + preHeight, i);
                animator.animate(child);
                if (i == 0) {
                    animator.addAnimatorListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            for (OnToggleTouchListener l : listeners) {
                                l.onOpen();
                            }
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                }
                mPosY = mPosY + preHeight;
            }
        }
    }

    public void close() {
        if (isOpen) {
            isOpen = false;
            for (OnToggleTouchListener l : listeners) {
                l.onStartClose();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount - 1; i++) {
                View child = getChildAt(i);
                View preChild = getChildAt(i + 1);
                CloseViewAnimator animator = new CloseViewAnimator(mPosY, mTop, i);
                animator.animate(child);
                if (i == 0) {
                    animator.addAnimatorListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            for (int i = 0; i < getChildCount() - 1; i++) {
                                View child = getChildAt(i);
                                child.setVisibility(INVISIBLE);
                            }
                            for (OnToggleTouchListener l : listeners) {
                                l.onClosed();
                            }

                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                }
                mPosY = mPosY - preChild.getMeasuredHeight();
            }
        }
    }

    public void setOnToggleTouchListener(OnToggleTouchListener listener) {
        listeners.add(listener);
    }

    private class OpenViewAnimator extends BaseAnimator {
        private float oriY;
        private float curY;
        private int position;

        private OpenViewAnimator(float oriY, float curY, int position) {
            this.oriY = oriY;
            this.curY = curY;
            this.position = position;
        }

        @Override
        protected void prepare(View target) {
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(target, "translationY", oriY, curY),
                    ObjectAnimator.ofFloat(target, "scaleX", 0.8f - 0.1f*(getChildCount()- 2 - position), 1)
            );
        }
    }

    private class CloseViewAnimator extends BaseAnimator {
        private float oriY;
        private float curY;
        private int position;

        private CloseViewAnimator(float oriY, float curY, int position) {
            this.oriY = oriY;
            this.curY = curY;
            this.position = position;
        }

        @Override
        protected void prepare(View target) {
            getAnimatorSet().playTogether(
                    ObjectAnimator.ofFloat(target, "translationY", oriY, curY),
                    ObjectAnimator.ofFloat(target, "scaleX", 1, 0.8f - 0.1f * (getChildCount() - 2 - position))
            );
        }
    }

    public interface OnToggleTouchListener {
        public void onStartOpen();
        public void onOpen();
        public void onStartClose();
        public void onClosed();
    }

}
