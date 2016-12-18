package com.anwesome.ui.chipviewgroupdemo;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.chipviewgroup.ChipComponent;
import com.anwesome.ui.chipviewgroup.ChipViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChipViewGroup chipViewGroup = new ChipViewGroup(this);
        chipViewGroup.addChips(new ChipComponent("Title 1", BitmapFactory.decodeResource(getResources(),R.drawable.ca)));
        chipViewGroup.addChips(new ChipComponent("Title 2", BitmapFactory.decodeResource(getResources(),R.drawable.ca)));
        chipViewGroup.addChips(new ChipComponent("Title 3", BitmapFactory.decodeResource(getResources(),R.drawable.ca)));
        chipViewGroup.addChips(new ChipComponent("Title 4", BitmapFactory.decodeResource(getResources(),R.drawable.ca)));
        chipViewGroup.addChips(new ChipComponent("Title 5", BitmapFactory.decodeResource(getResources(),R.drawable.ca)));
        chipViewGroup.addChips(new ChipComponent("Title 6", BitmapFactory.decodeResource(getResources(),R.drawable.ca)));
        chipViewGroup.addChips(new ChipComponent("Title 7", BitmapFactory.decodeResource(getResources(),R.drawable.ca)));
        setContentView(chipViewGroup);
    }
}
