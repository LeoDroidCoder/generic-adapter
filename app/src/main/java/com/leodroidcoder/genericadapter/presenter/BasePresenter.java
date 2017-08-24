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
package com.leodroidcoder.genericadapter.presenter;

import android.support.annotation.NonNull;

import com.leodroidcoder.genericadapter.contract.BaseContract;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Base presenter class.
 *
 * @param <V> View, related to the presenter
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 0.1.0
 */
public abstract class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter {

    private CompositeSubscription subscription;

    protected BasePresenter() {
        this.subscription = new CompositeSubscription();
    }

    /**
     * Set view
     *
     * @param view view {@link BaseContract.View}
     */
    protected abstract void setView(@NonNull V view);

    /**
     * Called when Presenter is Attached to a View
     *
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 0.1.0
     */
    @Override
    public void onAttach() {
        // empty
    }

    /**
     * Called when Presenter is detached from a View.
     *
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 0.1.0
     */
    @Override
    public void onDetach() {
        this.subscription.clear();
    }

    /**
     * Unsubscribe all subscriptions on Presenter detach
     *
     * @param subscription
     */
    protected final void unsubscribeOnDetach(Subscription subscription) {
        this.subscription.add(subscription);
    }

}