package com.hfy.matisse.internal.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hfy.matisse.internal.entity.Item;
import com.hfy.matisse.internal.model.SelectedItemCollection;

import java.util.List;

/**
 * @author hfy
 * @description
 * @time 2020/7/17
 */

public class SelectedPreviewActivity extends BasePreviewActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getBundleExtra(EXTRA_DEFAULT_BUNDLE);
        List<Item> selected = bundle.getParcelableArrayList(SelectedItemCollection.STATE_SELECTION);
        mAdapter.addAll(selected);
        mAdapter.notifyDataSetChanged();
        if (mSpec.countable) {
            mCheckView.setCheckedNum(1);
        } else {
            mCheckView.setChecked(true);
        }
        mPreviousPos = 0;
        updateSize(selected.get(0));
    }

}

