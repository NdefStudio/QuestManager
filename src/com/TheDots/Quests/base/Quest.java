package com.TheDots.Quests.base;
import java.util.*;
import java.io.*;

public class Quest implements Serializable
{
    private static final long serialVersionUID =1L;
	private String title;
	private String context;
	private boolean isFinished=false;
	private char rank;
	public Quest(){
		title="未命名";
		context="喂喂，你还什么也没写吧！\n(｀へ´)=3";
		rank='D';
	}
	public Quest(String _title){
		title=_title;
		context="喂喂，你还什么也没写吧！\n(｀へ´)=3";
	    rank='D';
	}
	public Quest(String _title,String _context){
		title=_title;
		context=_context;
		rank='D';
	}
	public Quest(String _title,String _context, char c){
		title=_title;
		context=_context;
		rank=c;
	}

    public void setRank(char rank)
    {
        this.rank = rank;
    }

    public char getRank()
    {
        return rank;
    }

    public void setIsFinished(boolean isFinished)
    {
        this.isFinished = isFinished;
    }

    public boolean isFinished()
    {
        return isFinished;
    }

    public void setContext(String context)
    {
        this.context = context;
    }

    public String getContext()
    {
        return context;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    
    public String toXML(){
        StringBuffer sb=new StringBuffer();
        sb.append("<Quest>");
        sb.append("<Title>");
        sb.append(this.getTitle());
        sb.append("</Title>");
        sb.append("<Context>");
        sb.append(this.getContext());
        sb.append("</Context>");
        sb.append("<Rank>");
        sb.append(this.getRank());
        sb.append("</Rank>");
        sb.append("<IsFinished>");
        sb.append(this.isFinished());
        sb.append("</IsFinished>");
        sb.append("</Quest>");
        return sb.toString();
    }
}
