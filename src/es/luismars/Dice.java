package es.luismars;
import java.util.Random;



/**
 * Created by Luis on 04/08/2014.
 */
public class Dice {

    public int roll (int d, int m) {
        return roll(d,m,false);
    }

    public int roll(int d, int m, boolean crit) {
        if (crit) {
            return (6*d)+m;
        }
        else {
            int res = 0;
            for (int i = 0; i < d; i++)
                res += (int) (Math.random() * 6) + 1;
            return res + m;
        }
    }

    public int roll(int d) {
        return roll(d,0, false);
    }

    public int characterPoints() {
        double r = Math.random()*100;
        if (r > 99.99)
            return rand (300, 500);
        else if (r > 99.9)
            return rand(200, 300);
        else if (r > 97.7)
            return rand(100, 200);
        else if (r > 84.1)
            return rand(75, 100);
        else if (r > 15.9)
            return  rand(50, 75);
        else if (r > 2.3)
            return rand(25, 50);
        else
            return rand(0, 25);

    }

    public int rand(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
