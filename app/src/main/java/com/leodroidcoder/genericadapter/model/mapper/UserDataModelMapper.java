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
package com.leodroidcoder.genericadapter.model.mapper;

import com.leodroidcoder.genericadapter.common.Mapper;
import com.leodroidcoder.genericadapter.model.remote.pojo.UserDataModel;
import com.leodroidcoder.genericadapter.view.entity.User;

import javax.inject.Inject;

/**
 * Mapper used to convert data-level user model {@link UserDataModel}
 * into presentation-level user {@link User} and vice-versa.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 0.1.0
 */
public class UserDataModelMapper extends Mapper<UserDataModel, User> {

    @Inject
    public UserDataModelMapper() {
    }

    @Override
    public User map(UserDataModel userDataModel) {
        if (userDataModel == null) {
            return null;
        }
        User user = new User();
        user.setLogin(userDataModel.getLogin());
        user.setUrl(userDataModel.getUrl());
        user.setImageUrl(userDataModel.getAvatarUrl());
        return user;
    }

    @Override
    public UserDataModel unMap(User user) {
        if (user == null) {
            return null;
        }
        UserDataModel userDataModel = new UserDataModel();
        userDataModel.setLogin(user.getLogin());
        userDataModel.setAvatarUrl(user.getUrl());
        userDataModel.setUrl(user.getUrl());
        return userDataModel;
    }
}
