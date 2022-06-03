package problem1.management;

import problem1.entities.SkillList;

public class SkillManagment {
    public static void main(String[] args) {
        SkillList skillList = new SkillList();

        skillList.display();

        System.out.println("Before update position 3: " + skillList.getHead(3));
        skillList.update(3, "ReactJS");
        System.out.println("After update position 3: " + skillList.getHead(3));

        System.out.println("Position = 1: " + skillList.getHead(1));
        System.out.println("Position = -1: " + skillList.getHead(-1));
        System.out.println("Position = 10: " + skillList.getHead(10));

        skillList.remove("Java");
        skillList.remove(".Net");
        skillList.remove("Android");
        skillList.remove("NodeJS");
        skillList.remove("Angular");
        skillList.remove("AI");

        System.out.println("Position = 1 after remove all: " + skillList.getHead(1));

    }
}
