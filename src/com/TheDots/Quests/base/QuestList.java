package com.TheDots.Quests.base;

/*等级区分使用内部类，包含Quest数组和实用方法*/
public final class QuestList
{
    private Quest[] quests=new Quest[5];
    private int count=0;         //当前指针位置
    private char rank;

    public QuestList(){}        //一般不会用吧
    public QuestList(Quest[] que , char r){
        quests=que;
        rank=r;
        count=que.length;
    }

	public Quest[] getQuests(){
		return quests;
	}

    public int getCount(){
        return count;
    }

    public char getRank(){
        return rank;
    }
    public void add(Quest q){
        quests[count]=q;
        count++;
    }
    public void addToPosition(Quest q,int position){
        int pposition=position;
        while(position<=count){
            int temposition =pposition+1;
            quests[temposition]=quests[pposition];
            pposition++;
        }
        quests[position]=q;
    };
    public void delete(int i){
        while(i<count){
            quests[i]=quests[i+1];
            i++;
        }
    }
    /*值得注意的是，在代码里没有检查全部Quest
     是否属于同一等级的方法，必须靠自己规范代码www*/
}
