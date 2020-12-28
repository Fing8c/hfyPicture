package com.hfy.matisse.internal.entity;


import android.content.pm.ActivityInfo;
import android.support.annotation.StyleRes;

import com.hfy.matisse.MimeType;
import com.hfy.matisse.R;
import com.hfy.matisse.engine.ImageEngine;
import com.hfy.matisse.engine.impl.GlideEngine;
import com.hfy.matisse.filter.Filter;
import com.hfy.matisse.internal.ui.widget.CropImageView;


import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * @author hfy
 * @description
 * @time 2020/7/17
 */

public final class SelectionSpec {

    public Set<MimeType> mimeTypeSet;
    public boolean mediaTypeExclusive;
    public boolean showSingleMediaType;
    @StyleRes
    public int themeId;
    public int orientation;
    public boolean countable;
    public int maxSelectable;
    public int maxImageSelectable;
    public int maxVideoSelectable;
    public List<Filter> filters;
    public boolean capture;
    public CaptureStrategy captureStrategy;
    public int spanCount;
    public int gridExpectedSize;
    public float thumbnailScale;
    public ImageEngine imageEngine;

    public int requestCode;

    public boolean isCrop;                 // 裁剪
    public boolean isCropSaveRectangle;    // 裁剪后的图片是否是矩形，否则跟随裁剪框的形状，只适用于圆形裁剪
    public int cropOutPutX;                // 裁剪保存宽度
    public int cropOutPutY;                // 裁剪保存高度
    public int cropFocusWidth;             // 焦点框的宽度
    public int cropFocusHeight;            // 焦点框的高度
    public CropImageView.Style cropStyle;  // 裁剪框的形状
    public File cropCacheFolder;           // 裁剪后文件保存路径

    private SelectionSpec() {
    }

    public static SelectionSpec getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public static SelectionSpec getCleanInstance() {
        SelectionSpec selectionSpec = getInstance();
        selectionSpec.reset();
        return selectionSpec;
    }

    private void reset() {
        mimeTypeSet = null;
        mediaTypeExclusive = true;
        showSingleMediaType = false;
        themeId = R.style.Matisse_Zhihu;
        orientation = 0;
        countable = false;
        maxSelectable = 1;
        maxImageSelectable = 0;
        maxVideoSelectable = 0;
        filters = null;
        capture = false;
        captureStrategy = null;
        spanCount = 3;
        gridExpectedSize = 0;
        thumbnailScale = 0.5f;
        imageEngine = new GlideEngine();
        isCrop = true;
        isCropSaveRectangle = false;
        cropOutPutX = 300;
        cropOutPutY = 300;
        cropFocusWidth = 0;
        cropFocusHeight = 0;
        cropStyle = CropImageView.Style.RECTANGLE;
    }

    public boolean singleSelectionModeEnabled() {
        return !countable && (maxSelectable == 1 || (maxImageSelectable == 1 && maxVideoSelectable == 1));
    }

    public boolean needOrientationRestriction() {
        return orientation != ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
    }

    public boolean onlyShowImages() {
        return showSingleMediaType && MimeType.ofImage().containsAll(mimeTypeSet);
    }

    public boolean onlyShowVideos() {
        return showSingleMediaType && MimeType.ofVideo().containsAll(mimeTypeSet);
    }

    private static final class InstanceHolder {
        private static final SelectionSpec INSTANCE = new SelectionSpec();
    }
}

