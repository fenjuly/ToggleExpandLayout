package com.fenjuly.mylibrary;

import android.view.View;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;

/**
 * Created by fenjuly with love on 15/8/27.
 */
public abstract class BaseAnimator {

    public static final long DURATION = 200;

    private AnimatorSet animatorSet = new AnimatorSet();
    private long duration = DURATION;

    public AnimatorSet getAnimatorSet() {
        return animatorSet;
    }

    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.animatorSet = animatorSet;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    protected abstract void prepare(View target);

    public void animate(View target) {
        prepare(target);
        start();
    }

    public void start() {
        animatorSet.setDuration(duration);
        animatorSet.start();
    }

    public void addAnimatorListener(Animator.AnimatorListener l) {
        animatorSet.addListener(l);
    }



}
