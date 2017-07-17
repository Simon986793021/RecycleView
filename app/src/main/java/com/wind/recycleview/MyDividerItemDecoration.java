package com.wind.recycleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by zhangcong on 2017/7/17.
 */

public class MyDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable drawable;
    private final int[] ATTR=new int[]{android.R.attr.listDivider};
    public MyDividerItemDecoration (Context context){
        final TypedArray typedArray=context.obtainStyledAttributes(ATTR);
        drawable=typedArray.getDrawable(0);
        typedArray.recycle();
    }
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        drawVertical(c,parent);
    }
    /**
     * 绘制间隔
     */
    private void drawVertical(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();//获取一个页面的item的数量
        Log.i("<<<<<<<",childCount+"");
        for (int i = 0; i <childCount; i++) {
            final View child = parent.getChildAt(i);//获取子view在ViewGroup的确切位置
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin +
                    Math.round(ViewCompat.getTranslationY(child));
            final int bottom = top + drawable.getIntrinsicHeight();
            drawable.setBounds(left, top, right, bottom);
            drawable.draw(c);
        }
    }


}
