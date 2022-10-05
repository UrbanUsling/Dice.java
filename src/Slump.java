import java.util.Random;

public class Slump {
    public static void main(String[] args) {
        int i = (int) (6.0*Math.random()+1);
        System.out.println(i);
        Random random = new Random();
        System.out.println(random.nextInt(6)+1);
    }
}
