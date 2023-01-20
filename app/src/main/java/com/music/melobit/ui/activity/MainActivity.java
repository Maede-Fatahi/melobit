package com.music.melobit.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.music.melobit.R;
import com.music.melobit.ui.fragment.HomeFragment;
import com.music.melobit.ui.fragment.SearchFragment;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    public static ExoPlayer exoPlayerAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomNavigationView();
        exoPlayerAudio = new ExoPlayer.Builder(this).setMediaSourceFactory(new DefaultMediaSourceFactory(this).setLiveTargetOffsetMs(5000))
                .build();
    }

    private void initBottomNavigationView() {
        HomeFragment firstFragment = new HomeFragment();
        SearchFragment secondFragment = new SearchFragment();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, firstFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, firstFragment).commit();
                    return true;
                case R.id.search:
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, secondFragment).commit();
                    return true;
            }
            return false;
        });
    }
}