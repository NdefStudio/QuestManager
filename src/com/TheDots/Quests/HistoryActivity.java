package com.TheDots.Quests;
import com.TheDots.Quests.base.*;
import android.app.*;
import android.os.*;
import android.widget.*;

public class HistoryActivity extends Activity
{
    private  QuestList[] sQuests=new QuestList[5];

    @Override
    public void onCreate(Bundle savedInstanceState){
        // TODO: Implement this method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historylayout);
    }


    @Override
    protected void onResume(){
        // TODO: Implement this method
        super.onResume();
        
    }
}
