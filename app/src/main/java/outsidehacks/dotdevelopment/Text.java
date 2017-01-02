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
/**
 * Created by varunjain on 11/26/16.
 */

public class Text {
        public String text;
        public int x;
        public int y;
        public boolean bold;
        public boolean italics;
        public boolean underline;
        public int size;
        public String font;
        public String color;
        public int show;
        public int hide;
        public Parametric translate;
        public Paint paint;


        public Text()    {

        }
        public Text(String text, int x, int y, boolean bold, boolean italics, boolean underline, int size, String font, String color, int show, int hide) {
            this.text = text;
            this.x = x;
            this.y = y;
            this.bold = bold;
            this.italics = italics;
            this.underline = underline;
            this.size = size;
            this.font = font;
            this.color = color;
            this.show = show;
            this.hide = hide;
            this.translate = null;
            paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setTypeface(Typeface.create(font, Typeface.NORMAL));
            if (underline)
                paint.setUnderlineText(true);
            if (italics)
                paint.setTypeface(Typeface.create(font, Typeface.ITALIC));
            if (bold)
                paint.setFakeBoldText(true);
            paint.setTextSize(size);
            paint.setColor(Color.parseColor(color));

    }

        public Text(String text, int x, int y, boolean bold, boolean italics, boolean underline, int size, String font, String color, int show, int hide, int[] translatex, int[] translatey, int[] translatet) {
            this(text, x, y, bold, italics, underline, size, font, color, show, hide);
            this.translate = new Parametric(translatex, translatey, translatet, show);
        }

        void handleText(Canvas canvas)    {
            if (MyView.elapsed >= hide)
                return;
            if (MyView.elapsed >= show) {

                float translatex = 0;
                float translatey = 0;
                if (translate != null)  {
                    translate.updateCurrent();
                    translatex = translate.lastx;
                    translatey = translate.lasty;
                }
                canvas.drawText(text, x + translatex, y + translatey, paint);
            }
        }

}
