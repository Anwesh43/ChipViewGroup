package com.anwesome.ui.chipviewgroup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 18/12/16.
 */
public class ChipViewGroup extends ViewGroup {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private List<ChipComponent> chipComponents = new ArrayList<>();
    private boolean measured = false,laidOut = false;
    private int midY = 0,widthBound;
    public ChipViewGroup(Context context) {
        super(context);
        paint.setTextSize(AppConstants.FONT_SIZE);
    }
    public void addChips(ChipComponent chipComponent) {
        chipComponent.setHeight();
        chipComponent.setWidth(paint);
        chipComponents.add(chipComponent);
    }
    public void onMeasure(int widthMeasureSpec,int heightMeasureSpec) {
        Display display = getDisplay();
        Point size = new Point();
        display.getRealSize(size);
        int screenWidth = size.x;
        int screenHeight = getChipGroupHeight(screenWidth);
        widthBound = screenWidth;
        midY = screenHeight/10;
        if(!measured) {
            for (ChipComponent chipComponent : chipComponents) {
                addView(new ChipView(getContext(), chipComponent), new ViewGroup.LayoutParams((int) chipComponent.getWidth(), (int) chipComponent.getHeight()));
            }
            for (int i = 0; i < getChildCount(); i++) {
                View view = getChildAt(i);
                measureChild(view,widthMeasureSpec, heightMeasureSpec);
            }
            measured = true;

        }
        setMeasuredDimension(screenWidth,screenHeight);
    }
    private int getChipGroupHeight(int screenWidth) {
        int x = 0,h = 0,i=0;
        for(ChipComponent chipComponent:chipComponents) {
            if(i==0) {
                h = h+(int)chipComponent.getHeight();
            }
            x = x+(int)chipComponent.getWidth();
            if(x+chipComponent.getWidth()>screenWidth) {
                h = h+(int)chipComponent.getHeight();
                x = 0;
            }
            i++;
        }
        return (3*h)/2;
    }
    public void onLayout(boolean changed,int w,int h,int a,int b) {
        int x = 0,y = midY-AppConstants.FONT_SIZE/2;
        if(!laidOut) {
            for (int i = 0; i < getChildCount(); i++) {

                View view = getChildAt(i);
                int viewWidth= view.getMeasuredWidth(),viewHeight = view.getMeasuredHeight();
                if(x+viewWidth>widthBound) {
                    y = y+viewHeight+AppConstants.FONT_SIZE;
                    x = 0;
                }
                view.layout(x,y,x+viewWidth,y+viewHeight);
                x = x+viewWidth+AppConstants.FONT_SIZE/4;

            }
            laidOut = true;
        }
    }
    private class ChipView extends View {
        private ChipComponent chipComponent;
        public ChipView(Context context,ChipComponent chipComponent) {
            super(context);
            this.chipComponent = chipComponent;
        }
        public void onDraw(Canvas canvas) {
            chipComponent.draw(canvas,paint);
        }
    }
}
