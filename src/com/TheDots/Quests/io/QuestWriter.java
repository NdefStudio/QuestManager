package com.TheDots.Quests.io;
import java.io.*;
import android.widget.*;
import android.content.*;
import com.TheDots.Quests.base.Quest;

public class QuestWriter
{
	private Quest thisQuest;
	private ObjectOutputStream objout;
	public QuestWriter(){}
	public QuestWriter(Quest q,String f)throws IOException{
		thisQuest=q;
		try{
			objout=new ObjectOutputStream(new FileOutputStream(f));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void setQuest(Quest thisQuest){
		this.thisQuest=thisQuest;
	}

	public void setSource(String s){
		try{
			objout=new ObjectOutputStream(new FileOutputStream(s));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void writeQuest()throws IOException{
		try{
			objout.writeObject(thisQuest);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void close(){try{
			objout.close();
		}
		catch(IOException e){e.printStackTrace();}}
}
