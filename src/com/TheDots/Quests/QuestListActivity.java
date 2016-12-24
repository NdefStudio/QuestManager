package com.TheDots.Quests;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.TheDots.Quests.base.*;
import com.TheDots.Quests.io.*;
import com.TheDots.Quests.util.*;
import java.io.*;
import java.util.*;

public class QuestListActivity extends Activity
{
 	private String questdir,Sdir,Adir,Bdir,Cdir,Ddir;
	private FileUtils fileutils;
    private  List<Character> ranklst=new ArrayList<Character>();
	private Map<Character,List<Quest>> questmap =new HashMap<Character,List<Quest>>();
	private List<Quest> templ;
	private QuestReader qr;
	private QuestWriter qw;
	private MyAdapter adapter;

	private  ExpandableListView elstv;

    @Override
    public void onCreate(Bundle savedInstanceState){
        // TODO: Implement this method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quest_list_layout);

		elstv=(ExpandableListView)findViewById(R.id.mainListView1);


		questdir=getFilesDir().toString()+"/Quests";
		System.out.println(questdir);
		Sdir=questdir+"/S";
		Adir=questdir+"/A";
		Bdir=questdir+"/B";
		Cdir=questdir+"/C";
		Ddir=questdir+"/D";
		fileutils=new FileUtils(this);

		qr=new QuestReader();
		qw=new QuestWriter();

		fileutils.creatFolder(Sdir);
		fileutils.creatFolder(Adir);
		fileutils.creatFolder(Bdir);
		fileutils.creatFolder(Cdir);
		fileutils.creatFolder(Ddir);

		ranklst.add('S');ranklst.add('A');ranklst.add('B');
		ranklst.add('C');ranklst.add('D');

		qw.setQuest(new Quest());
		qw.setSource(Ddir+"/01.qst");
		try{
			qw.writeQuest();
		}
		catch(IOException e){e.printStackTrace();}
		
		adapter=new MyAdapter();
        elstv.setAdapter(adapter);


    }

    @Override
    public void onResume(){
        // TODO: Implement this method
        super.onResume();


		try{
			templ=fileutils.getQuestsInFolder(Sdir);
			questmap.put('S', templ);
			templ=fileutils.getQuestsInFolder(Adir);
			questmap.put('A', templ);
			templ=fileutils.getQuestsInFolder(Bdir);
			questmap.put('B', templ);
			templ=fileutils.getQuestsInFolder(Cdir);
			questmap.put('C', templ);
			templ=fileutils.getQuestsInFolder(Ddir);
			questmap.put('D', templ);
		}
        catch(IOException e){e.printStackTrace();}
		catch(ClassNotFoundException e){e.printStackTrace();}
		
    }

    /** Called when the activity is first created. */

	public class MyAdapter extends BaseExpandableListAdapter
	{

		@Override
		public int getGroupCount(){
			// TODO: Implement this method
			return questmap.size();
		}


		@Override
		public int getChildrenCount(int p1){
			// TODO: Implement this method
			return questmap.get(ranklst.get(p1)).size();
		}

		@Override
		public long getGroupId(int p1){
			// TODO: Implement this method
			return p1;
		}

		@Override
		public boolean hasStableIds(){
			// TODO: Implement this method
			return false;
		}

		@Override
		public View getGroupView(int p1, boolean p2, View p3, ViewGroup p4){
			// TODO: Implement this method
			LayoutInflater inflater=(LayoutInflater)QuestListActivity.this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			p3=inflater.inflate(R.layout.parentlayout, null);
			TextView tv=(TextView) p3.findViewById(R.id.parentlayoutTextView);
			tv.setText(QuestListActivity.this.ranklst.get(p1).toString());
			return p3;
		}

		@Override
		public View getChildView(int p1, int p2, boolean p3, View p4, ViewGroup p5){
			// TODO: Implement this method
			Quest quest=(Quest)getChild(p1, p2);
			LayoutInflater inflater=(LayoutInflater)QuestListActivity.this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			p4=inflater.inflate(R.layout.questlayout, null);
			TextView textview=(TextView)p4.findViewById(R.id.questlayoutTextView1);
			ImageView ImageView=(ImageView)p4.findViewById(R.id.rankView);
			textview.setText(quest.getTitle());
			ImageView.setImageResource(R.drawable.rank_d);
			return p4;
		}

		@Override
		public boolean isChildSelectable(int p1, int p2){
			// TODO: Implement this method
			return true;
		}


		@Override
		public Object getChild(int p1, int p2){
			// TODO: Implement this method
			Character rank=ranklst.get(p1);
			Quest quest=questmap.get(rank).get(p2);
			return quest;

		}

		@Override
		public int getChildType(int groupPosition, int childPosition){
			// TODO: Implement this method
			return super.getChildType(groupPosition, childPosition);
		}

		@Override
		public long getChildId(int p1, int p2){
			// TODO: Implement this method
			return p2;
		}

		@Override
		public Object getGroup(int p1){
			// TODO: Implement this method
			return ranklst.get(p1);
		}
	}
}
