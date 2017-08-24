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

import com.leodroidcoder.genericadapter.common.ErrorFactory;
import com.leodroidcoder.genericadapter.contract.UsersListContract;
import com.leodroidcoder.genericadapter.model.Repository;
import com.leodroidcoder.genericadapter.model.mapper.UserDataModelMapper;

import javax.inject.Inject;

import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Users list Presenter
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 0.1.0
 */
public class UsersListPresenter extends BasePresenter<UsersListContract.View> implements UsersListContract.Presenter {

    private final Repository repository;
    private UsersListContract.View view;
    private UserDataModelMapper mapper;

    @Inject
    public UsersListPresenter(Repository repository, UserDataModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Set view
     *
     * @param view view {@link UsersListContract.View}
     */
    @Override
    public void setView(@NonNull UsersListContract.View view) {
        this.view = view;
    }

    /**
     * Load users
     */
    @Override
    public void loadUsers() {
        view.showProgress(true);
        view.showRetry(false);
        unsubscribeOnDetach(
                Single.fromCallable(repository::getUsers)
                        .subscribeOn(Schedulers.io())
                        .map(dataUsers -> mapper.map(dataUsers))
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(users -> {
                            if (users != null) {
                                view.onUsersLoaded(users);
                            } else {
                                view.onUsersLoadError(ErrorFactory.ERROR_LOAD_USERS);
                            }
                            view.showProgress(false);
                        }, error -> {
                            view.onUsersLoadError(ErrorFactory.ERROR_LOAD_USERS);
                            view.showProgress(false);
                            view.showRetry(true);
                        }));
    }


}
