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

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Models mapper.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 0.1.0
 */
public abstract class Mapper<A, B> implements MapperContract<A, B> {

    @Override
    @Nullable
    public List<B> map(List<A> as) {
        if (null == as) {
            return null;
        }
        List<B> bs = new ArrayList<>();
        for (A a : as) {
            bs.add(map(a));
        }
        return bs;
    }

    @Override
    @Nullable
    public List<A> unMap(List<B> bs) {
        if (null == bs) {
            return null;
        }
        List<A> as = new ArrayList<>();
        for (B b : bs) {
            as.add(unMap(b));
        }
        return as;
    }
}
