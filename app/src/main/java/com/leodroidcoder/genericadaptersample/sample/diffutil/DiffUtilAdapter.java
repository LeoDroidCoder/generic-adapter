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
package com.leodroidcoder.genericadaptersample.sample.diffutil;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.view.ViewGroup;

import com.leodroidcoder.genericadapter.GenericRecyclerViewAdapter;
import com.leodroidcoder.genericadapter.OnRecyclerItemClickListener;
import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.model.User;
import com.leodroidcoder.genericadaptersample.sample.common.UserViewHolder;

import java.util.List;

/**
 * Shows using {@link GenericRecyclerViewAdapter} with Diff Util {@link android.support.v7.util.DiffUtil}.
 * It makes your RecyclerView much more efficient.
 * In case one items is changed in the data set, it will make your recycler not only to redraw the changed item instead of all but also it may redraw only one view of the item (in case only one value is changed).
 * TODO for achieving of a full DiffUtil "magic" you should implement handling Payloads. In simple words it will let your recyclerView not to redraw a changed item, but redraw specifically changed view. @see <a href="https://developer.android.com/reference/android/support/v7/util/DiffUtil.Callback.html"></a>
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class DiffUtilAdapter extends GenericRecyclerViewAdapter<User, OnRecyclerItemClickListener, UserViewHolder> {

    public DiffUtilAdapter(Context context, OnRecyclerItemClickListener listener) {
        super(context, listener);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(inflate(R.layout.item_user, parent), getListener());
    }

    /**
     * Update items dataset.
     *
     * @param newItems new items
     */
    @Override
    public void updateItems(List<User> newItems) {
        // initialise users diff callback
        DiffUtil.Callback diffCallback = new UserDiffCallback(getItems(), newItems);
        // pass to parent adapter to let it do all the remaining job
        super.updateItems(newItems, diffCallback);
    }
}
