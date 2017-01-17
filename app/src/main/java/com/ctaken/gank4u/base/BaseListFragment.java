package com.ctaken.gank4u.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;

import com.ctaken.gank4u.R;

import butterknife.BindView;

/**
 * Created by chentaikang on 2017/1/16 15:25.
 */

public abstract class BaseListFragment extends LazyFragment {


    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
    @BindView(R.id.swipeRefreshView)
    SwipeRefreshLayout mSwipeRefreshView;
    @BindView(R.id.emptyView)
    ViewStub emptyView;

    protected RecyclerView.Adapter mAdapter;

    /**
     * @return 设置显示的Adapter
     */
    protected abstract RecyclerView.Adapter getAdapter();

    /**
     * 下拉刷新,加载数据
     */
    protected abstract void loadData();

    /**
     * 上啦加载,加载数据
     */
    protected abstract void addData();

    /**
     * 加载完成,取消加载状态
     */
    public void loadFinish() {
        mAdapter.notifyDataSetChanged();
        mSwipeRefreshView.setRefreshing(false);
    }

    @Override
    protected void onInitView(View v) {
        mSwipeRefreshView.setColorSchemeColors(
                getResources().getColor(android.R.color.holo_red_light),
                getResources().getColor(android.R.color.holo_green_light),
                getResources().getColor(android.R.color.holo_orange_light),
                getResources().getColor(android.R.color.holo_blue_light)
                );
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        mRecycleView.addItemDecoration(decoration);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = getAdapter();
        if(mAdapter!=null)
            mRecycleView.setAdapter(mAdapter);
            mSwipeRefreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    loadData();
                }
            });

            mRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                int lastVisibleItem;
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if(newState == RecyclerView.SCROLL_STATE_IDLE&&
                            lastVisibleItem+1==mAdapter.getItemCount()){
                        //滑动到底部,加载新的数据
                        if(!mSwipeRefreshView.isRefreshing()){
                            mSwipeRefreshView.setRefreshing(true);
                            addData();
                        }
                    }
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if(layoutManager instanceof LinearLayoutManager){
                        int last = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                        if(last!=-1){
                            lastVisibleItem = last;
                        }
                    }
                }
            });
            mSwipeRefreshView.setRefreshing(true);
            loadData();

    }



    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_classify_item;
    }

    @Override
    protected void onInitData() {

    }


}
