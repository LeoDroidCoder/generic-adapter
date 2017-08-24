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
package com.leodroidcoder.genericadapter.model.remote;

import android.support.annotation.Nullable;
import android.util.Log;

import com.leodroidcoder.genericadapter.BuildConfig;
import com.leodroidcoder.genericadapter.model.remote.pojo.UserDataModel;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Remote storage.
 * Used to fetch data from the server.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 0.1.0
 */
public class RemoteStorage {

    private static final String API_BASE_URL = "https://api.github.com/";
    private static final String LOG_TAG = RemoteStorage.class.getSimpleName();
    private ServerApi mApi;

    public RemoteStorage() {
        mApi = getServerApi();
    }

    private ServerApi getServerApi() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        Retrofit mRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(API_BASE_URL)
                .build();
        return mRetrofit.create(ServerApi.class);
    }

    /**
     * Executes get users request
     *
     * @return list of {@link UserDataModel}
     */
    public List<UserDataModel> getUsers() {
        return executeRequest(mApi.getUsersList());
    }

    /**
     * Helper method for executing requests.
     *
     * @param endPoint endpoint
     * @return list of objects or null
     */
    @Nullable
    private <T> List<T> executeRequest(Call<List<T>> endPoint) {
        try {
            Response<List<T>> response = endPoint.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                return null;
            }
        } catch (Exception e) {
            if (BuildConfig.DEBUG) {
                Log.e(LOG_TAG, "request error: " + e);
            }
            return null;
        }
    }

}
