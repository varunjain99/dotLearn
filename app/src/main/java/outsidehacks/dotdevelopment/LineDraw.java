package outsidehacks.dotdevelopment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Typeface;
import android.graphics.Path;
import android.graphics.DashPathEffect;
/**
 * Created by varunjain on 11/26/16.
 */

public class LineDraw {
    public int anchorx;
    public int anchory;
    public int destinationx;
    public int destinationy;
    public String color;
    public int width;
    public String style;
    public int show;
    public int hide;
    public int draw;
    public Parametric translate;
    public Path path;
    public Paint paint;


    public LineDraw()    {

    }
    public LineDraw(int anchorx, int anchory, int destinationx, int destinationy, String color, int width, String style, int show, int draw, int hide) {
        this.anchorx = anchorx;
        this.anchory = anchory;
        this.destinationx = destinationx;
        this.destinationy = destinationy;
        this.color = color;
        this.width = width;
        this.style = style;
        this.show = show;
        this.draw = draw;
        this.hide = hide;
        this.translate = null;
        path = new Path();
        path.moveTo(anchorx, anchory);
        path.lineTo(destinationx, destinationy);
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(width);
        paint.setColor(Color.parseColor(color));
        if (style.equals("dashed")) {
            paint.setPathEffect(new DashPathEffect(
                    new float[]{10.0f, 10.0f}, 0));
        }
    }

    public LineDraw(int anchorx, int anchory, int destinationx, int destinationy, String color, int width, String style, int show, int draw, int hide, int[] translatex, int[] translatey, int[] translatet) {
        this(anchorx, anchory, destinationx, destinationy, color, width, style, show, draw, hide);
        this.translate = new Parametric(translatex, translatey, translatet, show);

    }

    void handleLine(Canvas canvas)    {
        if (MyView.elapsed >= hide)
            return;
        if (MyView.elapsed >= show) {

            if (translate == null)  {
                canvas.drawPath(path, paint);
            }
            else {
                Path translatedPath = new Path();
                translate.updateCurrent();
                path.offset(translate.lastx, translate.lasty, translatedPath);
                canvas.drawPath(translatedPath, paint);
            }

        }
    }

}
