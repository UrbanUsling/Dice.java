import javax.swing.*;

public class Elevator {
    int level;

    public Elevator (int lvl){
        if (lvl >= -2 && lvl <= 10)
            level = lvl;
        else
            System.out.println("Denna våning finns inte");
    }
    public void goTo(int lvl){
        if (lvl >= -2 && lvl <= 10) {
            if (level == lvl)
                System.out.println("Hissen står redan på våning "+lvl);
            else if (level > lvl) {
                level = lvl;
                System.out.println("Hissen åker ner till våning "+level);
            }else if (level < lvl) {
                level = lvl;
                System.out.println("Hissen åker upp till våning "+level);
            }
        }else
            System.out.println("Denna våning finns inte");

    }
    public int where(){
        return level;
    }
}
