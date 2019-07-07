package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;


import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

public class StoreActivity extends AppCompatActivity {
    private GridView list;
    private List<ShoppingCartBean> mdate = new ArrayList<>();
    private StoreAdapter storeAdapter;
    private ImageView btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //状态栏设置
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.xlg2));
        }
        setContentView(R.layout.activity_store);

        list = (GridView)findViewById(R.id.store_list);
        btn_back =(ImageView)findViewById(R.id.back);

        int num = ShopDate.getList().size();
        for(int i = 0;i < num; i++){
             ShoppingCartBean tmp = ShopDate.getList().get(i);
             mdate.add(tmp);
        }
        storeAdapter = new StoreAdapter(getLayoutInflater(),mdate);
        list.setAdapter(storeAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(StoreActivity.this,GoodDetailActivity.class);
            intent.putExtra("id",position);
            startActivity(intent);
            }
        });
        ImageLoader imageLoader= ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}

