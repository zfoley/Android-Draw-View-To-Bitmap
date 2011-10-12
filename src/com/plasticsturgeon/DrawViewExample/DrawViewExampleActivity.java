package com.plasticsturgeon.DrawViewExample;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DrawViewExampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Bitmap bmp = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.layout_to_draw, null);
        layout.setDrawingCacheEnabled(true);
        layout.measure(MeasureSpec.makeMeasureSpec(canvas.getWidth(), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(canvas.getHeight(), MeasureSpec.EXACTLY));
        layout.layout(0, 0, layout.getMeasuredWidth(), layout.getMeasuredHeight());
        Paint paint = new Paint();
        paint.setColor(Color.WHITE); 
        paint.setStyle(Style.FILL);
        canvas.drawBitmap(layout.getDrawingCache(), 0, 0, paint);
        ImageView view = (ImageView) findViewById(R.id.image_to_show);
        view.setImageBitmap(bmp);
//        ImageView bitmapHolder = new ImageView(getApplicationContext());
//        bitmapHolder.setImageBitmap(bmp);
//        this.addContentView(bitmapHolder,  new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
    }
}