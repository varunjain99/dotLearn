package outsidehacks.dotdevelopment;

import android.animation.ValueAnimator;
import android.view.View;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.animation.ValueAnimator;

/**
 * Created by vishal on 11/25/16.
 */
public class MyView extends View implements ValueAnimator.AnimatorUpdateListener{

    Paint paint;
    Text t;
    Text t2;
    Text t3;
    Text t4;
    Text t5;
    PathDraw p;
    PathDraw p2;
    PathDraw p3;
    LineDraw l;
    LineDraw l2;
    LineDraw l3;
    public static int videoLength;
    public static float elapsed;
    public static int counter;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        videoLength = 24000;
        ValueAnimator mAnimator = ValueAnimator.ofInt(0, 1);
        mAnimator.setDuration(videoLength);
        mAnimator.addUpdateListener(this);
        mAnimator.start();
        t = new Text("Pythagorean Theorem", 130, 700, true, false, true, 50, "Arial", "red", 13000, 20000);
        t5 = new Text("a² + b² = c²", 290, 900, false, false, false, 30, "Arial", "blue", 13000, 20000);

        p = new PathDraw(new int[]{60, 70, 100, 175, 220, 260, 295, 320, 335, 340, 305, 215, 215, 305, 340, 335, 320, 295, 260, 220, 175, 100, 70, 60},
                new int[]{110, 80, 50, 80, 110, 140, 170, 200, 230, 260, 290, 320, 320, 350, 380, 410, 440, 470, 500, 530, 560, 590, 560, 530},
                new int[]{0, 120, 240, 360, 480, 600, 720, 840, 960, 1080, 1200, 1280, 1360, 1460, 1600, 1720, 1850, 1950, 2080, 2200, 2240, 2360, 2480, 2600},
                10, "#FCA015", 0, 20000, 6000);
        p2 = new PathDraw(new int[]{450, 400, 600}, new int[]{100, 450, 450}, new int[]{100, 500, 900}, 10, "#FCA015", 0, 20000, 9000);
        p3 = new PathDraw(new int[]{550, 560}, new int[]{100, 650}, new int[]{100, 1000}, 10, "#FCA015", 0, 20000, 10000);

        l = new LineDraw(100, 750, 220, 840, "blue", 3, "solid", 13000, 0, 20000, new int[]{0, 400}, new int[]{0, 0}, new int[]{0, 6000});
        l2 = new LineDraw(100, 750, 100, 840, "blue", 3, "solid", 13000, 0, 20000, new int[]{0, 400}, new int[]{0, 0}, new int[]{0, 6000});
        l3 = new LineDraw(100, 840, 220, 840, "blue", 3, "solid", 13000, 0, 20000, new int[]{0, 400}, new int[]{0, 0}, new int[]{0, 6000});
        t2 = new Text("a", 80, 810, false, false, false, 25, "Arial", "blue", 13000, 20000, new int[]{0, 400}, new int[]{0, 0}, new int[]{0, 6000});
        t3 = new Text("b", 160, 870, false, false, false, 25, "Arial", "blue", 13000, 20000, new int[]{0, 400}, new int[]{0, 0}, new int[]{0, 6000});
        t4 = new Text("c", 160, 790, false, false, false, 25, "Arial", "blue", 13000, 20000, new int[]{0, 400}, new int[]{0, 0}, new int[]{0, 6000});



    }



    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        t.handleText(canvas);
        p.handlePathDraw(canvas);
        l.handleLine(canvas);
        p2.handlePathDraw(canvas);
        p3.handlePathDraw(canvas);
        l2.handleLine(canvas);
        l3.handleLine(canvas);
        t2.handleText(canvas);
        t3.handleText(canvas);
        t4.handleText(canvas);
        t5.handleText(canvas);



    }

    public void onAnimationUpdate(ValueAnimator animator) {

            elapsed = animator.getAnimatedFraction()*videoLength;
            counter++;
            counter %= 5;
            invalidate();
    }

}


