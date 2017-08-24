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
package com.leodroidcoder.genericadapter.view.activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.leodroidcoder.genericadapter.App;
import com.leodroidcoder.genericadapter.R;
import com.leodroidcoder.genericadapter.contract.UsersListContract;
import com.leodroidcoder.genericadapter.presenter.UsersListPresenter;
import com.leodroidcoder.genericadapter.view.adapter.UsersAdapter;
import com.leodroidcoder.genericadapter.view.adapter.listener.OnRecyclerObjectClickListener;
import com.leodroidcoder.genericadapter.view.entity.User;

import java.util.List;

import javax.inject.Inject;

public class UsersListActivity extends BaseActivity implements UsersListContract.View, OnRecyclerObjectClickListener<User> {

    @Inject
    UsersListPresenter presenter;
    private UsersAdapter adapter;
    private ProgressBar progressBar;
    private Button btnRetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        injectDependencies();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        setupViews();
        presenter.onAttach();
        presenter.setView(this);
        // load the users
        presenter.loadUsers();
    }

    private void setupViews() {
        progressBar = findViewById(R.id.progress);
        btnRetry = findViewById(R.id.btn_retry);
        // setup adapter
        RecyclerView recycler = findViewById(R.id.recycler);
        adapter = new UsersAdapter(this);
        adapter.setListener(this);
        recycler.setAdapter(adapter);
        recycler.setHasFixedSize(true);
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void injectDependencies() {
        ((App) getApplication()).getApplicationComponent().inject(this);
    }

    /**
     * Called when users were successfully loaded.
     *
     * @param users List of Users
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 0.1.0
     */
    @Override
    public void onUsersLoaded(List<User> users) {
        adapter.setItems(users);
    }

    /**
     * Presenter failed to provide users.
     *
     * @param errorCode error code {@link com.leodroidcoder.genericadapter.common.ErrorFactory}
     */
    @Override
    public void onUsersLoadError(int errorCode) {
        handleError(errorCode);
    }

    /**
     * Show/hide retry button
     *
     * @param show pass in `true` to show progress and `false` to hide
     */
    @Override
    public void showRetry(boolean show) {
        btnRetry.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    /**
     * Shows or hides the progress bar
     *
     * @param show pass in true to show the progress bar and false to hide it
     */
    @Override
    public void showProgress(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    /**
     * User item has been clicked.
     *
     * @param item {@link User} object associated with the clicked item.
     * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
     * @since 0.1.0
     */
    @Override
    public void onItemClicked(User item) {
        showToast(String.format(getString(R.string.clicked_user_format), item.getLogin()));
    }
}
