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
package com.leodroidcoder.genericadapter;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * Abstract diff util calback {@link DiffUtil.Callback}
 * which simplifies concrete implementation by doing some basics.
 * Just extend it with specifying a Type and implement remaining abstract methods,
 * such as {@link DiffUtil.Callback#areItemsTheSame(int, int)} and
 * {@link DiffUtil.Callback#areContentsTheSame(int, int)}
 *
 * @param <T> type of objects used in the adapter's datasetzx
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public abstract class BaseDiffCallback<T> extends DiffUtil.Callback {

    private List<T> oldItems;
    private List<T> newItems;

    public BaseDiffCallback(List<T> oldItems, List<T> newItems) {
        this.oldItems = oldItems;
        this.newItems = newItems;
    }

    @Override
    public int getOldListSize() {
        return oldItems.size();
    }

    @Override
    public int getNewListSize() {
        return newItems.size();
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }

    public List<T> getOldItems() {
        return oldItems;
    }

    public List<T> getNewItems() {
        return newItems;
    }
}
