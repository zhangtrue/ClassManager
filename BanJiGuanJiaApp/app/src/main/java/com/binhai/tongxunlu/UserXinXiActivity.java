package com.binhai.tongxunlu;

import android.graphics.Color;
import android.os.Bundle;

import com.binhai.beans.UserBean;
import com.binhai.main.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class UserXinXiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_xin_xi);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setTitle("联系人信息");
        //取传递的数据
        UserBean bean = (UserBean)getIntent().getSerializableExtra("bean");
        TextView name = findViewById(R.id.name);
        name.setText(bean.getName());
        TextView tel = findViewById(R.id.tel);
        tel.setText(bean.getTel());
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar =   Snackbar.make(view, "修改用户信息", Snackbar.LENGTH_LONG);
                snackbar.setTextColor(getResources().getColor(R.color.colorPrimary));
                snackbar.setAction("点击", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(UserXinXiActivity.this, "点击了snackbar", Toast.LENGTH_SHORT).show();
                    }
                });
//                snackbar.setActionTextColor(getResources().getColor(R.color.colorPrimaryDark));

//                snackbar.setBackgroundTint()//设置背景
                View snackbarView = snackbar.getView();//获取Snackbar显示的View对象
                //设置Snackbar显示的位置
                ViewGroup.LayoutParams params = snackbarView.getLayoutParams();
                CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(params.width-2, params.height);
                layoutParams.gravity = Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL;//垂直水平居中
                snackbarView.setLayoutParams(layoutParams);
                snackbarView.setBackgroundResource(R.drawable.shap_round_rect);//上面背景颜色将无效
                snackbar.show();
            }
        });
    }

}
