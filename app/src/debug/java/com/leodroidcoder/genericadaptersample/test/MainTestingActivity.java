package com.leodroidcoder.genericadaptersample.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.leodroidcoder.genericadaptersample.R;
import com.leodroidcoder.genericadaptersample.sample.home.HomeFragment;


/**
 * Used for encapsulated instrumentation testing of Fragments.
 *
 * @author Leonid Ustenko (Leo.Droidcoder@gmail.com)
 * @since 1.0.0
 */

@VisibleForTesting
public class MainTestingActivity extends AppCompatActivity implements HomeFragment.HomeFragmentListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(R.id.fl_container);
        setContentView(frameLayout);
    }

    @Override
    public void onSimpleClick() {
        // not implemented
    }

    @Override
    public void onMultipleViewTypesClick() {
        // not implemented
    }

    @Override
    public void onMultipleButtonsClick() {
        // not implemented
    }

    @Override
    public void onDiffUtilClick() {
        // not implemented
    }
}
