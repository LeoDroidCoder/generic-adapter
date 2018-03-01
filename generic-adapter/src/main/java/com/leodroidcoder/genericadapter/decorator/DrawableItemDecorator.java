/*
 * Copyright (C) 2017 Leonid Ustenko Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.leodroidcoder.genericadapter.decorator;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Item decorator {@link RecyclerView.ItemDecoration} which allows using
 * a custom drawable as a source.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class DrawableItemDecorator extends RecyclerView.ItemDecoration {

    private Drawable dividerDrawable;

    public DrawableItemDecorator(Drawable dividerDrawable) {
        validateDrawableOrThrow(dividerDrawable);
        this.dividerDrawable = dividerDrawable;
    }

    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter == null) {
            return;
        }
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        for (int i = 0; i < adapter.getItemCount() - 2; i++) {
            View child = parent.getChildAt(i);
            if (child == null) {
                continue;
            }
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + dividerDrawable.getIntrinsicHeight();
            dividerDrawable.setBounds(left, top, right, bottom);
            dividerDrawable.draw(canvas);
        }
    }

    /**
     * Validates a divider drawable.
     *
     * @param drawable which has to be used as a divider between {@link RecyclerView} items
     * @throws IllegalArgumentException in case drawable is <code>null</code> or has illegal size.
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 1.0.0
     */
    private void validateDrawableOrThrow(Drawable drawable) throws IllegalArgumentException {
        if (drawable == null) {
            throw new IllegalArgumentException("Divider cannot be null");
        } else if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            throw new IllegalArgumentException("Illegal divider drawable. Wrong size: width = " + drawable.getIntrinsicWidth() + ", height = " + drawable.getIntrinsicHeight());
        }
    }
}
