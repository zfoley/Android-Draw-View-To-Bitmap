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
import android.widget.ImageView;

public class DrawViewExampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //1. Make a bitmap to draw to.
        Bitmap bmp = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);
        //2. We need a Canvas to handle drawing to the bitmap. Bitmap has no draw methods of its own.
        Canvas canvas = new Canvas(bmp);
        //3. Get a reference to the LayoutInflater.
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //4. Inflate the layout we want to draw.
        View layout = inflater.inflate(R.layout.layout_to_draw, null);
        //5. Call setDrawingCacheEnabled to true, since the default is false. 
        layout.setDrawingCacheEnabled(true);
        //6. Tell the layout how big it should be. In this case we are using the full size of the canvas.
        layout.measure(MeasureSpec.makeMeasureSpec(canvas.getWidth(), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(canvas.getHeight(), MeasureSpec.EXACTLY));
        //7. Now we apply the measures so that it embiggens to the correct size before drawing.
        layout.layout(0, 0, layout.getMeasuredWidth(), layout.getMeasuredHeight());
        //8. The canvas requires a paint. So make one.
        // You can use the paint to draw and fill other stuff, but that's not part of this tutorial.
        Paint paint = new Paint();
        //9. Finally, we draw the bitmap. Mission accomplished. But of course we still can't see the bitmap. So...
        canvas.drawBitmap(layout.getDrawingCache(), 0, 0, paint);
        //10. Get reference to an ImageView that you want to hold your bitmap. 
        ImageView view = (ImageView) findViewById(R.id.image_to_show);
        //11. Set the bitmap as the ImageView's Image Bitmap.
        view.setImageBitmap(bmp);
        
        // BONUS: Add it to a dynamically created ImageView.
        // Uncomment the following lines to add the bitmap to a dynamically created ImageView.
        
//        ImageView bitmapHolder = new ImageView(getApplicationContext());
//        bitmapHolder.setImageBitmap(bmp);
//        this.addContentView(bitmapHolder,  new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
    }
}