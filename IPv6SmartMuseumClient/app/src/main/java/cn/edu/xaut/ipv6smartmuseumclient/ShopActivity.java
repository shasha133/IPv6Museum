package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * 纪念品商城的Activity
 */

public class ShopActivity extends AppCompatActivity {

    private GridView list;
    private List<ShoppingCartBean> mdate = new ArrayList<>();
    private StoreAdapter storeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        list = (GridView) findViewById(R.id.store_list);

        int num = ShopDate.getList().size();
        for (int i = 0; i < num; i++) {
            ShoppingCartBean tmp = ShopDate.getList().get(i);
            mdate.add(tmp);
        }
        storeAdapter = new StoreAdapter(getLayoutInflater(), mdate);
        list.setAdapter(storeAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ShopActivity.this, GoodDetailActivity.class);
                intent.putExtra("id", position);
                startActivity(intent);
            }
        });
    }
}
