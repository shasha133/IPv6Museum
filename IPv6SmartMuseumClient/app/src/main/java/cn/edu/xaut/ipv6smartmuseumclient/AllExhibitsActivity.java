package cn.edu.xaut.ipv6smartmuseumclient;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.Toast;

/**
 * 用于查看所有展品的Activity
 * 首先解析展品信息，然后将其填充至Adapter中，进而进行显示
 * 未来优化方向：展品信息的储存方式（如使用SQLite）
 */

public class AllExhibitsActivity extends AppCompatActivity {

    private ExhibitInfoAdapter exhibitInfoAdapter;
    //显示展品的GridView的适配器
    private GridView gvAllExhibit;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getBaseContext();
        setContentView(R.layout.activity_all_exhibits);
        gvAllExhibit = (GridView) findViewById(R.id.gvAllExhibit);
        InitExhibits();
    }

    private void InitExhibits() {
        //先确定展品信息是否解析完毕，否则解析展品信息
        //可以将这个判断内置倒解析Json的函数中，进一步简化代码
        if (!SharedData.isExhibitInfoReady()) {
            SharedData.parseExhibitInfoJson(Jsons.ExhibitInfo);
        }
        //设置展品列表的Adapter
        exhibitInfoAdapter = new ExhibitInfoAdapter(context, SharedData.exhibit_name, R.layout.exhibit_grid, new String[]{"exhibit_name"}, new int[]{R.id.tvExhibitGrid});
        exhibitInfoAdapter.setExhibit_no(SharedData.exhibit_no);
        exhibitInfoAdapter.setExhibit_imgpath(SharedData.exhibit_imgpath);
        Toast.makeText(context, "img_path" + SharedData.exhibit_imgpath, Toast.LENGTH_SHORT).show();
        gvAllExhibit.setAdapter(exhibitInfoAdapter);
        exhibitInfoAdapter.notifyDataSetChanged();
    }

}
