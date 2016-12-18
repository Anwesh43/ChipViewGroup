package com.anwesome.ui.chipviewgroup;
import android.graphics.*;


/**
 * Created by anweshmishra on 18/12/16.
 */
public class ChipComponent {
    private String title;
    private Bitmap bitmap;
    private float width,height;
    public void setHeight() {
        this.height = 2*AppConstants.FONT_SIZE;
    }
    public void setWidth(Paint paint) {
        this.width = 2*paint.measureText(title)+4+height;
    }
    public ChipComponent(String title,Bitmap bitmap) {
        this.bitmap = bitmap;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.GRAY);
        float radius = width/5;
        canvas.drawRoundRect(new RectF(0,0,width,height),radius,radius,paint);
        canvas.save();
        canvas.translate(AppConstants.FONT_SIZE/2,AppConstants.FONT_SIZE/10);
        canvas.save();
        Path path = new Path();
        path.addCircle(height/2,height/2,height/2, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap,new Rect(0,0,bitmap.getWidth(),bitmap.getHeight()),new RectF(0,0,height,height),paint);
        canvas.restore();
        paint.setColor(Color.WHITE);
        canvas.drawText(title,height+2,height/2+3*height/10,paint);
        canvas.restore();

    }
    public int hashCode() {
        return bitmap.hashCode()+(int)width+(int)height;
    }
}
