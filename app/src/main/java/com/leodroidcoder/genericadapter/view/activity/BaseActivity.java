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

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.leodroidcoder.genericadapter.common.ErrorFactory;

/**
 * Base activity class
 * <p>
 * Created by leonid on 3/14/17.
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * Shows a message in the Toast
     *
     * @param message message
     */
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Handle errors which took place during communication with server.
     * Otherwise shows error message
     *
     * @param errorCode error code
     */
    public void handleError(@ErrorFactory.ErrorCode int errorCode) {
        String errorMessage = ErrorFactory.getMessage(isNetworkAvailable(this) ? errorCode : ErrorFactory.ERROR_INTERNET_CONNECTION, this);
        showToast(errorMessage);
    }

    /**
     * Returns true if network is available or about to become available
     *
     * @param context Context used to get ConnectivityManager
     * @return true if device is online
     */
    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm != null ? cm.getActiveNetworkInfo() : null;
        return (networkInfo != null && networkInfo.isConnectedOrConnecting());
    }

}
