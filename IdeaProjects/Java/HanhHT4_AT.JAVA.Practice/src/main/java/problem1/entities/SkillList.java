package problem1.entities;

import java.util.ArrayList;
import java.util.Arrays;

public class SkillList {

    private ArrayList<String> list = new ArrayList<String>();

    public SkillList() {
        this.list.add("Java");
        this.list.add(".Net");
        this.list.add("Android");
        this.list.add("NodeJS");
        this.list.add("Angular");
        this.list.add("AI");
    }

    public void display() {
        for (String string : list) {
            System.out.println(string);
        }
    }

    public String getHead(int position){
        if (position < 0 || position > list.size() -1 || list.size() == 0){
            return null;
        }
        return list.get(position);
    }

    public boolean remove(String skill){
        for (String string : list) {
            if (skill.equals(string)){
                int index = list.indexOf(skill);
                list.remove(index);
                return true;
            }
        }
        return false;
    }

    public void update(int index, String skillNew){
        list.set(index, skillNew);
    }

}
