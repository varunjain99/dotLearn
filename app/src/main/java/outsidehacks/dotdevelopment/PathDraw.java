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
import java.util.Random;
/**
 * Created by varunjain on 11/26/16.
 */

public class PathDraw {
    public Parametric pathDescription;
    public int width;
    public String color;
    public int show;
    public int hide;
    public Parametric translate;
    public int draw;
    public Path path;
    public Paint paint;


    public PathDraw()    {

    }
    public PathDraw(int[] x, int[] y, int[] t, int width, String color, int show, int hide,  int draw) {
        pathDescription = new Parametric(x, y, t, draw);
        this.width = width;
        this.color = color;
        this.show = show;
        this.hide = hide;
        this.draw = draw;
        this.translate = null;
        this.path = new Path();
        path.moveTo(x[0], y[0]);
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(width);
        paint.setColor(Color.parseColor(color));

    }
    public PathDraw(int[] x, int[] y, int[] t, int width, String color, int show, int hide, int draw, int[] translatex, int[] translatey, int[] translatet) {
        this(x, y, t, width, color, show, hide,  draw);
        this.translate = new Parametric(translatex, translatey, translatet, draw);

    }


    void updatePath()   {
        int oldIndex = pathDescription.nextIndex;
        pathDescription.updateCurrent();
        for (int i = oldIndex; i < pathDescription.nextIndex; i++)  {
            path.lineTo(pathDescription.x[i], pathDescription.y[i]);
        }
        if (pathDescription.newVal)
          path.lineTo(pathDescription.lastx, pathDescription.lasty);
    }

    void handlePathDraw(Canvas canvas)    {
        if (MyView.elapsed >= hide)
            return;

        if (MyView.elapsed < draw)  {
            return;
        }
        updatePath();

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
