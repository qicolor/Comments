package com.example.peoplecomments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.peoplecomments.Fragment.MainHomeFragment;
import com.example.peoplecomments.Fragment.MainMineFragment;
import com.example.peoplecomments.Fragment.MainSearchFragment;
import com.example.peoplecomments.Fragment.MainTuanFragment;
import static android.widget.RadioGroup.*;

public class MainActivity extends AppCompatActivity implements OnCheckedChangeListener {
    private RadioGroup mRadioGroup;
    private RadioButton main_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定控件的实例
        mRadioGroup=(RadioGroup)findViewById(R.id.main_bottom_tabs);
        main_home=(RadioButton)findViewById(R.id.main_home);
        //设置默认选中的按钮
        mRadioGroup.check(main_home.getId());
        //创建MainHome碎片
        createFragment(new MainHomeFragment(),false);
        //添加选择监听器
        mRadioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //根据选中情况重新加载Fragment
        switch (checkedId){
            case R.id.main_home:
                createFragment(new MainHomeFragment(),true);
                break;
            case R.id.main_tuan:
                createFragment(new MainTuanFragment(),true);
                break;
            case R.id.main_search:
                createFragment(new MainSearchFragment(),true);
                break;
            case R.id.main_mine:
                createFragment(new MainMineFragment(),true);
                break;
            default:
                    break;
        }
    }

    //创建Fragment
    public void createFragment(Fragment fragment,boolean isInit){
        //获得Fragment的管理
        FragmentManager manager=getSupportFragmentManager();
        //添加到碎片栈中
        FragmentTransaction transaction = manager.beginTransaction().replace(R.id.main_contain, fragment);
        if(!isInit){
            //把Fragment添加到返回栈中 便于恢复
            transaction.addToBackStack(null);
        }
        transaction.commit();

    }
}
