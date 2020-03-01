package io.github.mortuzahossain.recyclertest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";

    RecyclerView recyclerView;
    List<NavigationModel> navigationModels = NavigationModel.getData();
    NavigationAdapter navigationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        getSupportActionBar().setTitle("This is title.");
//        getSupportActionBar().setSubtitle("This is subtitle.");

        recyclerView = findViewById(R.id.recyclerView);

        navigationAdapter = new NavigationAdapter(this,navigationModels);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setHasFixedSize(true);
        layoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(navigationAdapter);

        final SnapHelper snapHelper = new GravitySnapHelper(Gravity.CENTER);
        snapHelper.attachToRecyclerView(recyclerView);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                RecyclerView.ViewHolder viewHolder =
                        recyclerView.findViewHolderForAdapterPosition(0);

                viewHolder.itemView.findViewById(R.id.tvTitle).setVisibility(View.VISIBLE);
            }
        },100);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    View view = snapHelper.findSnapView(layoutManager);
                    if (view != null) {
                        int position = layoutManager.getPosition(view);
                        Log.d(TAG, "onScrollStateChanged: " + position);
                        RecyclerView.ViewHolder viewHolder =
                                recyclerView.findViewHolderForAdapterPosition(position);

                        viewHolder.itemView.findViewById(R.id.tvTitle).setVisibility(View.VISIBLE);
                    }


                } else {
                    View view = snapHelper.findSnapView(layoutManager);
                    if (view != null) {
                        int position = layoutManager.getPosition(view);
                        Log.d(TAG, "onScrollStateChanged: " + position);
                        RecyclerView.ViewHolder viewHolder =
                                recyclerView.findViewHolderForAdapterPosition(position);

                        viewHolder.itemView.findViewById(R.id.tvTitle).setVisibility(View.GONE);
                    }
                }



            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

    }
}
