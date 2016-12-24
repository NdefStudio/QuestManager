package com.TheDots.Quests.io;
import java.io.*;
import android.widget.*;
import android.content.*;
import com.TheDots.Quests.base.Quest;

public class QuestReader
{
	private Quest thisQuest;
	private ObjectInputStream objin;
	public QuestReader(){}
	public  QuestReader(String f){
		try{
			objin=new ObjectInputStream(new FileInputStream(f));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void setSource(String f){
		try{
			objin=new ObjectInputStream(new FileInputStream(f));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public Quest getQuest(){
		return thisQuest;
	}
	public Quest readQuest()throws ClassNotFoundException, IOException{
		try{
			thisQuest=(Quest)objin.readObject();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
        catch(IOException e){
            e.printStackTrace();
		}
		return thisQuest;
	}
	public void close(){try{
			objin.close();
		}
		catch(IOException e){e.printStackTrace();}}
}
