package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * 调整选中展品的Activity
 * 整体上跟查看展品的Activity相似，区别是使用了不同的Adapter
 * 未来优化方向：切换倒BuildRouteActivity的方法
 */

public class ChangeExhibitsActivity extends AppCompatActivity {

    private ChangeExhibitsAdapter changeExhibitsAdapter;
    private GridView gvChangeExhibits;
    private Context context;
    private ArrayList<Integer> exhibits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_exhibits);
        context = getBaseContext();
        String intent = getIntent().getStringExtra("exhibits");
        if ((intent != null) && (!intent.equals(""))) {
            exhibits = IntentUtil.stringToNum(intent);
        } else {
            exhibits = null;
        }
        gvChangeExhibits = (GridView) findViewById(R.id.gvChangeExhibit);
        Button btnGetRoute = (Button) findViewById(R.id.btnGetRoute);
        InitExhibits();
        btnGetRoute.setOnClickListener(onClickListenerGetRoute);
    }

    //路线生成后跳转倒规划路线和计算所需时间的Activity
    View.OnClickListener onClickListenerGetRoute = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(ChangeExhibitsActivity.this, BuildRouteActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            intent.putExtra("exhibits", IntentUtil.numToString(changeExhibitsAdapter.getExhibit_selected()));
            startActivity(intent);
        }
    };

    private void InitExhibits() {
        if (!SharedData.isExhibitInfoReady()) {
            SharedData.parseExhibitInfoJson(Jsons.ExhibitInfo);
        }
        //设置展品列表的Adapter
        changeExhibitsAdapter = new ChangeExhibitsAdapter(context, SharedData.exhibit_name, R.layout.exhibit_grid_with_mark, new String[]{"exhibit_name"}, new int[]{R.id.tvExhibitGrid});
        changeExhibitsAdapter.setExhibit_no(SharedData.exhibit_no);
        changeExhibitsAdapter.setExhibit_imgpath(SharedData.exhibit_imgpath);
        if (exhibits != null) {
            changeExhibitsAdapter.setExhibit_selected(exhibits);
        }
        gvChangeExhibits.setAdapter(changeExhibitsAdapter);
        changeExhibitsAdapter.notifyDataSetChanged();
    }

}
