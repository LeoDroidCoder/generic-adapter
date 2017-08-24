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
package com.leodroidcoder.genericadapter.contract;

import com.leodroidcoder.genericadapter.view.entity.User;

import java.util.List;

/**
 * Users list screen contract.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 0.1.0
 */
public interface UsersListContract {

    interface View extends BaseContract.View {

        /**
         * Called when users were successfully loaded.
         *
         * @param users List of Users
         * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
         * @since 0.1.0
         */
        void onUsersLoaded(List<User> users);

        /**
         * Presenter failed to provide users.
         *
         * @param errorCode error code {@link com.leodroidcoder.genericadapter.common.ErrorFactory}
         */
        void onUsersLoadError(int errorCode);

        /**
         * Show/hide retry button
         *
         * @param show pass in `true` to show progress and `false` to hide
         * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
         * @since 0.1.0
         */
        void showRetry(boolean show);

    }

    interface Presenter extends BaseContract.Presenter {

        /**
         * Load users
         *
         * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
         * @since 0.1.0
         */
        void loadUsers();
    }
}
