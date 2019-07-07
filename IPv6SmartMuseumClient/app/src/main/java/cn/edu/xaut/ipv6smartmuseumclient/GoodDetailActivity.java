package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class GoodDetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView value;
    private TextView name;
    private TextView size;
    private TextView attribute;
    private TextView addCar;
    private ImageView btn_car;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_detail);
        imageView = (ImageView) findViewById(R.id.Goods_img);
        name = (TextView) findViewById(R.id.Goods_name);
        value = (TextView) findViewById(R.id.Goods_value);
        size = (TextView) findViewById(R.id.Goods_color);
        attribute = (TextView) findViewById(R.id.Goods_type);
        addCar = (TextView) findViewById(R.id.addCar);
        btn_car = (ImageView) findViewById(R.id.btn_car);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 1);
        Log.d("id ++++++++++++    ", id + "");
        try {
            Picasso.with(getApplication())
                    .load(ShopDate.getList().get(id).getImageUrl())
                    .resize(PixelUtil.dp2pixel(getApplication(), 100), PixelUtil.dp2pixel(getApplication(), 100))
                    .centerInside()
                    .placeholder(R.drawable.progress_animation)
                    .error(android.R.drawable.ic_menu_close_clear_cancel)
                    .into(imageView);
        } catch (Exception e) {
            Log.d("LoadPicError:", e + "");
            Toast.makeText(getApplication(), "缩略图加载失败", Toast.LENGTH_SHORT).show();
        }
        name.setText(ShopDate.getList().get(id).getShoppingName());
        value.setText("" + ShopDate.getList().get(id).getPrice());
        size.setText(ShopDate.getList().get(id).getSize());
        attribute.setText(ShopDate.getList().get(id).getAttribute());

        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "加入成功！ ", Toast.LENGTH_LONG).show();
                ShoppingOperate sql = new ShoppingOperate(GoodDetailActivity.this);
                sql.save(ShopDate.getList().get(id).getId());
            }
        });

        btn_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GoodDetailActivity.this, ShopCartActivity.class);
                startActivity(intent);
            }
        });
    }
}
