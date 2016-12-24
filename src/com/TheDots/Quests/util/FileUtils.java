package com.TheDots.Quests.util;
import android.content.*;
import com.TheDots.Quests.base.*;
import com.TheDots.Quests.io.*;
import java.io.*;
import java.util.*;

public class FileUtils
{
	private File file;
	private Context c;

	public FileUtils(Context p){c=p;}

	public void creatFolder(String s){
		file=new File(s);
		if(!file.exists()){file.mkdirs();}
	}

	public File getFile(String s){
		file=new File(s);
		try{
			if(!file.exists()){file.createNewFile();}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return file;
	}

	public boolean exists(String s){return new File(s).exists();}

	public void deleteFile(String s){
		file=new File(s);
		if(file.exists()){
			file.delete();
		}
	}

	public List<Quest> getQuestsInFolder(String s) throws IOException, ClassNotFoundException{
		List<Quest> ql=new ArrayList<Quest>();
		QuestReader qr=new QuestReader();
		String[] files =new File(s).list();
		int count=0;

		try{
			if(files.length>0){
				while(count<files.length){
					qr.setSource(s+"/"+files[count]);
					ql.add(qr.readQuest());
					count++;
				}
			}
		}
		catch(IOException e){e.printStackTrace();}
		catch(ClassNotFoundException e){e.printStackTrace();}
		return ql;
	}

	public void writeQuestsToFolder(List<Quest> ql, String s){
		QuestWriter qw=new QuestWriter();
		Integer count =0;
		try{
			while(count<ql.size()){
				qw.setSource(s+"/"+count.toString()+".qst");
				qw.setQuest(ql.get(count));
				qw.writeQuest();
				count++;
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
