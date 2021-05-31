package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

public class InstructionActivity extends AppCompatActivity {

    ViewPager viewPager;
    TextView pagecounter;
    int total=3, count =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        viewPager = findViewById(R.id.viewpager);
        pagecounter = findViewById(R.id.pagecounter);

        pagecounter.setText(count + "/" + total);

        viewPager.setAdapter(new SliderAdapter(getSupportFragmentManager()));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                count = position + 1;
                pagecounter.setText(count + "/" + total);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}