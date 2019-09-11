package com.example.glidetest.java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.glidetest.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private List<MainAdapter.Type> lists = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        initData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mainAdapter = new MainAdapter(this, lists);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mainAdapter);

    }

    private void initData() {
        lists.add(MainAdapter.Type.Mask);
        lists.add(MainAdapter.Type.NinePatchMask);
        lists.add(MainAdapter.Type.RoundedCorners);
        lists.add(MainAdapter.Type.CropTop);
        lists.add(MainAdapter.Type.CropCenter);
        lists.add(MainAdapter.Type.CropBottom);
        lists.add(MainAdapter.Type.CropSquare);
        lists.add(MainAdapter.Type.CropCircle);
        lists.add(MainAdapter.Type.CropCircleWithBorder);
        lists.add(MainAdapter.Type.Grayscale);
        lists.add(MainAdapter.Type.Blur);
        lists.add(MainAdapter.Type.SupportRSBlur);
        lists.add(MainAdapter.Type.Toon);
        lists.add(MainAdapter.Type.Sepia);
        lists.add(MainAdapter.Type.Contrast);
        lists.add(MainAdapter.Type.Invert);
        lists.add(MainAdapter.Type.Pixel);
        lists.add(MainAdapter.Type.Sketch);
        lists.add(MainAdapter.Type.Swirl);
        lists.add(MainAdapter.Type.Brightness);
        lists.add(MainAdapter.Type.Kuawahara);
        lists.add(MainAdapter.Type.Vignette);
    }
}
