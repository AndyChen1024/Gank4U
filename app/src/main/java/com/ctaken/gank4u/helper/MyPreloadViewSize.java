package com.ctaken.gank4u.helper;

import com.bumptech.glide.ListPreloader;
import com.ctaken.gank4u.ui.classify.ClassifyBean;

/**
 * Created by chentaikang on 2017/1/17 21:32.
 */

public class MyPreloadViewSize implements ListPreloader.PreloadSizeProvider<ClassifyBean>{
    @Override
    public int[] getPreloadSize(ClassifyBean item, int adapterPosition, int perItemPosition) {
        return new int[]{100,100};
    }
}
