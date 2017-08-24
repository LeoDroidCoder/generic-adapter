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
package com.leodroidcoder.genericadapter.di;

import android.content.Context;

import com.leodroidcoder.genericadapter.App;
import com.leodroidcoder.genericadapter.model.Repository;
import com.leodroidcoder.genericadapter.model.remote.RemoteStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Module that provides objects within application lifecycle.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 0.1.0
 */
@Module
public class ApplicationModule {
    private final App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    Repository provideRepository() {
        return getRepository();
    }


    private Repository getRepository() {
        return new Repository(new RemoteStorage());
    }
}
