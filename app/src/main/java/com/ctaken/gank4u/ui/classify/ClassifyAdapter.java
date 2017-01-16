package com.ctaken.gank4u.ui.classify;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.ctaken.gank4u.R;
import com.ctaken.gank4u.base.BaseRecycleAdapter;
import com.ctaken.gank4u.base.BaseViewHolder;
import com.ctaken.gank4u.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chentaikang on 2017/1/16 20:50.
 */
public class ClassifyAdapter extends BaseRecycleAdapter<ClassifyBean> {

    public RequestManager requestManager;

    public static final int TYPE_ICON = 0;
    public static final int TYPR_NO_ICON = 1;

    public ClassifyAdapter(Context context, ArrayList<ClassifyBean> data, RequestManager requestManager) {
        super(context, data);
        this.requestManager = requestManager;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case TYPE_ICON:
                view = inflater.inflate(R.layout.item_classify_icon, parent, false);
                return new ClassifyIconHolder(view, requestManager);
            case TYPR_NO_ICON:
                view = inflater.inflate(R.layout.item_classify,parent,false);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        List<String> images = data.get(position).getImages();
        if(images!=null && images.size()>0){
            return TYPE_ICON;
        }else {
            return TYPR_NO_ICON;
        }
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        ClassifyBean clsBean = data.get(position);
        holder.fillData(clsBean);
    }

    static class ClassifyHolder extends BaseViewHolder<ClassifyBean> {
        @BindView(R.id.classify_title)
        TextView classifyTitle;
        @BindView(R.id.classify_author)
        TextView classifyAuthor;
        @BindView(R.id.classify_time)
        TextView classifyTime;

        ClassifyHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }

        @Override
        public void fillData(ClassifyBean clsBean) {
            classifyTitle.setText(clsBean.getDesc());
            classifyAuthor.setText(clsBean.getWho());
            String date = clsBean.getPublishedAt().replace('T', ' ').replace('Z', ' ');
            classifyTime.setText(DateUtils.friendlyTime(date));
        }
    }
    static class  ClassifyIconHolder extends BaseViewHolder<ClassifyBean>{

        @BindView(R.id.classify_icon)
        ImageView classifyIcon;
        @BindView(R.id.classify_title)
        TextView classifyTitle;
        @BindView(R.id.classify_author)
        TextView classifyAuthor;
        @BindView(R.id.classify_time)
        TextView classifyTime;
        private RequestManager requestManager;
        public ClassifyIconHolder(View itemView,RequestManager requestManager) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            this.requestManager=requestManager;
        }

        @Override
        public void fillData(ClassifyBean clsBean) {
            //唯一标示
            classifyTitle.setText(clsBean.getDesc());
            classifyAuthor.setText(clsBean.getWho());
            String date = clsBean.getPublishedAt().replace('T', ' ').replace('Z', ' ');
            classifyTime.setText(DateUtils.friendlyTime(date));
            String url = clsBean.getImages().get(0);
            requestManager.load(url).centerCrop().into(classifyIcon);
        }
    }
}
