package com.TheDots.Quests;
import android.app.*;
import android.widget.*;
import android.os.*;
import android.content.*;
import android.content.res.*;

public class MainActivity extends TabActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState){
       //  TODO: Implement this method
        super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlayout);
        
        TabHost tabhost=getTabHost();
        Resources res=getResources();
        Intent quintent=new Intent();
        quintent.setClass(this,QuestListActivity.class);
        TabHost.TabSpec quspec =tabhost.newTabSpec("quests");
        quspec.setIndicator("quests",res.getDrawable(android.R.drawable.stat_sys_download));
        quspec.setContent(quintent);
        tabhost.addTab(quspec);
        
        Intent hisintent=new Intent();
        hisintent.setClass(this,HistoryActivity.class);    
        TabHost.TabSpec hisspec=tabhost.newTabSpec("history");
        hisspec.setContent(hisintent);
        hisspec.setIndicator("history",res.getDrawable(android.R.drawable.ic_search_category_default));
        tabhost.addTab(hisspec);
		
    }
}
