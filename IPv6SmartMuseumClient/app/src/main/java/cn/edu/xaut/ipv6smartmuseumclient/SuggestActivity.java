package cn.edu.xaut.ipv6smartmuseumclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class SuggestActivity extends AppCompatActivity {

    private SuggestAdapter suggestAdapter;
    private ListView lvSuggest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);
        lvSuggest = (ListView) findViewById(R.id.lvSuggest);
        InitSuggest();
    }

    private void InitSuggest() {
        if (!SharedData.isSuggestReady()) {
            SharedData.parseSuggestJson(Jsons.Suggests);
        }
        suggestAdapter = new SuggestAdapter(this, R.layout.suggest_list, R.id.tvSuggestName, SharedData.suggest_name);
        suggestAdapter.setSuggest_no(SharedData.suggest_no);
        lvSuggest.setAdapter(suggestAdapter);
        suggestAdapter.notifyDataSetChanged();
    }

}
