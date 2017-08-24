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
package com.leodroidcoder.genericadapter.common;

import android.content.Context;
import android.support.annotation.IntDef;

import com.leodroidcoder.genericadapter.R;
import com.leodroidcoder.genericadapter.contract.BaseContract;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Error factory.
 * Used to get localized string message by error code.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 0.1.0
 */
public class ErrorFactory {

    /**
     * Error code used in presenters {@link BaseContract.Presenter}
     * and to be passed to the view {@link BaseContract.View}
     * where appropriate localized error message can be retrieved in order to describe the error in human-readable format,
     * what is done with help of {@link #getMessage(int, Context)}
     */
    public static final int ERROR_GENERIC = 0;
    public static final int ERROR_LOAD_USERS = 100;
    public static final int ERROR_INTERNET_CONNECTION = 101;


    @IntDef({ERROR_GENERIC, ERROR_LOAD_USERS, ERROR_INTERNET_CONNECTION
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
    }

    /**
     * Get human-readable error message from resources by error code
     *
     * @param errorCode error code{@link ErrorCode}
     * @param context   Context needed to retrieve string resource
     * @return error message
     */
    public static String getMessage(@ErrorCode int errorCode, Context context) {
        int messageRes;
        switch (errorCode) {
            case ERROR_GENERIC:
                messageRes = R.string.error_message_generic;
                break;

            case ERROR_LOAD_USERS:
                messageRes = R.string.error_load_users;
                break;
            case ERROR_INTERNET_CONNECTION:
                messageRes = R.string.error_internet_connection;
                break;

            default:
                messageRes = R.string.error_message_generic;
                break;
        }
        return context.getString(messageRes);
    }


    /**
     * Converts int into error code type
     *
     * @param val int value of calendar type
     * @return {@link ErrorCode}
     */
    public static
    @ErrorCode
    int codeFromInt(int val) {
        return val;
    }

}
