package com.example.nsc.recycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    RecyclerView recycleView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    List<MyData> myDataList;
    ImageView ivGlide;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstance();
    }

    private void initInstance() {

        recycleView = (RecyclerView) findViewById(R.id.recycleView);
        ivGlide = (ImageView) findViewById(R.id.ivGlide);
        recycleView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,2);
        recycleView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(this, init());
        recycleView.setAdapter(adapter);

    }

    private List<MyData> init() {

       /* MyData name1 = new MyData("New", "https://dummyimage.com/300.png/09f/fff");
        MyData name2 = new MyData("Test", "https://www.dreamhost.com/blog/wp-content/uploads/2015/10/DHC_blog-image-01-300x300.jpg");
        MyData name3 = new MyData("Nilecon", "https://i.vimeocdn.com/portrait/13975105_300x300");
        List<MyData> dataSet = new ArrayList<>();

        dataSet.add(name1);
        dataSet.add(name2);
        dataSet.add(name3);*/
        String[] names = getResources().getStringArray(R.array.nameList);
        String[] images = getResources().getStringArray(R.array.imageList);
        recycleView = (RecyclerView) findViewById(R.id.recycleView);

        myDataList = new ArrayList<MyData>();
        for (int i = 0; i < names.length; i++) {
            MyData mData = new MyData(names[i], images[i]);
            Log.d("ID", String.valueOf(images[i]));
            myDataList.add(mData);
        }

        return myDataList;
    }
}
