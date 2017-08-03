package com.lunger.projecttemplet.ui.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.lunger.projecttemplet.R;
import com.lunger.projecttemplet.SwitchTask;
import com.lunger.projecttemplet.ui.activity.MainActivity;
import com.lunger.projecttemplet.util.DensityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lunger on 2017/8/3 0003.
 */

public class GoodsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private final int VIEW_TYPE_1 = 1;
    private final int VIEW_TYPE_2 = 2;

    private List<View> mBannerViews;
    private List<ImageView> mBannerDots;
    private SwitchTask mSwitchTask;

    //模拟网络拿到的banner轮播图
    private String[] imageUrls = {"http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg",
            "http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",
            "http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",
            "http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",
            "http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg"};

    public GoodsAdapter(Context context) {
        mContext = context;
        mBannerViews = new ArrayList<>();
        mBannerDots = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_1){
            return new BannerHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recy_banner, null));
        }else {
            return new GoodsHolder(LayoutInflater.from(mContext).inflate(R.layout.item_goods, null));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position == 0){
            BannerHolder holder1 = (BannerHolder) holder;
            initBanner((holder1).view_pager, holder1.ll_dot_container);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? VIEW_TYPE_1 : VIEW_TYPE_2;
    }


    @Override
    public int getItemCount() {
        return 1;
    }


    /**
     * 初始化顶部banner数据
     * @param view_pager
     * @param ll_dot_container
     */
    private void initBanner(ViewPager view_pager, LinearLayout ll_dot_container) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        ImageView iv_dot;
        for (int i = 0; i < imageUrls.length; i++) {
            View view = layoutInflater.inflate(R.layout.view_banner, null);
            ImageView iv_banner = (ImageView) view.findViewById(R.id.iv_banner);
            Glide.with(mContext)
                    .load(imageUrls[i])
                    .asBitmap()
                    .into(iv_banner);
            mBannerViews.add(view);

            //初始化圆点
            iv_dot = new ImageView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DensityUtils.dp2px(mContext, 8), DensityUtils.dp2px(mContext, 8));
            if (i != 0) {
                params.setMargins(10, 0, 0, 0);
                iv_dot.setImageResource(R.drawable.shape_white_dot);
            } else {
                iv_dot.setImageResource(R.drawable.shape_red_dot);
            }
            iv_dot.setLayoutParams(params);
            ll_dot_container.addView(iv_dot);
            mBannerDots.add(iv_dot);
        }

        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mBannerDots.size(); i++) {
                    mBannerDots.get(i).setImageResource(i == position ? R.drawable.shape_red_dot : R.drawable.shape_white_dot);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        view_pager.setAdapter(new BannerPagerAdapter(mBannerViews));
        mSwitchTask = new SwitchTask(view_pager);
        mSwitchTask.start();
    }

    public class BannerHolder extends RecyclerView.ViewHolder {
        ViewPager view_pager;
        LinearLayout ll_dot_container;
        public BannerHolder(View itemView) {
            super(itemView);
            view_pager = (ViewPager) itemView.findViewById(R.id.view_pager);
            ll_dot_container = (LinearLayout) itemView.findViewById(R.id.ll_dot_container);
        }
    }

    public class GoodsHolder extends RecyclerView.ViewHolder {
        ImageView iv;

        public GoodsHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
