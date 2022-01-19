package com.nazirov.recyclerview10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.icu.util.Measure;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.nazirov.recyclerview10.adapter.CustomAdapter;
import com.nazirov.recyclerview10.model.Member;

import java.util.ArrayList;
import java.util.List;
        import android.provider.Settings.Secure;
        import android.provider.Settings.Secure;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int c = BuildConfig.VERSION_CODE;
        Log.d("versionCode", "onCreate: ");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        Log.d(android_id, "onCreate: "+ android_id);


        List<Member> members = prapareMemerList();
        refreshAdapter(members);
    }


    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));

    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(this, members);
        recyclerView.setAdapter(adapter);
    }

    public void openitemDetails(Member member) {
        Toast.makeText(context, "Ha nima chiqishi keregidi bosorasanmi hadeb ", Toast.LENGTH_SHORT).show();
    }

    private List<Member> prapareMemerList() {
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            members.add(new Member("Nazirov", "Elmurod"));
        }
        return members;
    }

}