package com.example.peoplecomments.splash;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.example.peoplecomments.MainActivity;
import com.example.peoplecomments.R;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class WelcomeGuildeActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<View> mListViews;
    private Button btn_Enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_guilde);
        mViewPager=findViewById(R.id.vp_splash);
        btn_Enter=(Button)findViewById(R.id.btn_enter);
        //初始化数据
        initImageView();
        ImagesAdapter adapter = new ImagesAdapter();
        //设置适配器
        mViewPager.setAdapter(adapter);
        //添加页面监听器
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //当前选中的页面是最后一个时 显示出按钮
                if(position==2){
                    btn_Enter.setVisibility(View.VISIBLE);
                }else{
                    btn_Enter.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //按钮点击事件
        btn_Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转界面
                Intent intent=new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //初始化页面事件
    void initImageView(){
        mListViews=new ArrayList<>();
        {
            View view = View.inflate(this, R.layout.images_item, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_image_item);
            imageView.setImageResource(R.mipmap.guide_01);
            mListViews.add(imageView);
        }
        {
            View view = View.inflate(this, R.layout.images_item, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_image_item);
            imageView.setImageResource(R.mipmap.guide_02);
            mListViews.add(imageView);
        }
        {
            View view = View.inflate(this, R.layout.images_item, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_image_item);
            imageView.setImageResource(R.mipmap.guide_03);
            mListViews.add(imageView);
        }
    }

    //页面适配器
    class ImagesAdapter extends PagerAdapter {

        //获得多少条页面数据
        @Override
        public int getCount() {
            return mListViews.size();

        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        //渲染每页视图
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mListViews.get(position));
            return mListViews.get(position);
        }

        //删除页图
        @Override
        public void destroyItem(ViewGroup container, int position,Object object) {
            container.removeView(mListViews.get(position));
        }
    }
}
