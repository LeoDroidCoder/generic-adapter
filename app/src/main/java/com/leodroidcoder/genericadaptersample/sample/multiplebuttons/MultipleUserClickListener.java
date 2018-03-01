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
package com.leodroidcoder.genericadaptersample.sample.multiplebuttons;

import com.leodroidcoder.genericadapter.BaseRecyclerListener;

/**
 * A sample implementation of custom item click listener.
 * The main thing here is to extend the base listener {@link BaseRecyclerListener}.
 * Then you can define as many callbacks as you need.
 * Note, that you will have to make use of it here:
 * - pass to the adapter implementation
 * - pass to ViewHolder implementation.
 * - implement it in a Fragment/Activity and set it onto adapter.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

interface MultipleUserClickListener extends BaseRecyclerListener {

    void onGetAgeClick(int position);

    void onGreetClick(int position);
}
