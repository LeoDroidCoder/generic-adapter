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

import com.leodroidcoder.genericadapter.BaseDiffCallback;
import com.leodroidcoder.genericadaptersample.model.User;

import java.util.List;

/**
 * Implementation of {@link BaseDiffCallback} for a {@link User} entity.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

public class UserDiffCallback extends BaseDiffCallback<User> {

    public UserDiffCallback(List<User> oldItems, List<User> newItems) {
        super(oldItems, newItems);
    }

    /**
     * Here you should figure out whether items are same.
     * For instance, In typical situation it should return <code>true</code> in case item ids (unique identifiers) are equal, even though some parameters might have changed.
     * On the contrary it should return <code>false</code> for items with different ids.
     *
     * @param oldItemPosition position of old item
     * @param newItemPosition position of new item
     * @return `true` if items are the same, even though some parameters may vary.
     */
    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return getOldItems().get(oldItemPosition) == getNewItems().get(newItemPosition);
    }

    /**
     * Here you should check whether content (parameters which are used on the items) is the same on the old and new items.
     *
     * @param oldItemPosition position of old item
     * @param newItemPosition position of new item
     * @return `true` if items contents are identical(parameters which are used on the items)
     */
    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        User oldUser = getOldItems().get(oldItemPosition);
        User newUser = getNewItems().get(newItemPosition);
        return oldUser.getName().equals(newUser.getName())
                && oldUser.getAge() == newUser.getAge();
    }
}
