package es.luismars;

/**
 * Created by Luis on 03/08/2014.
 */
public class Combat extends Dice {
    int secs = 0;
    public Combat (PJ a, PJ b) {
        while (a.HP > 0 && b.HP > 0) {
            attack(a,b);
            secs++;
            PJ c = a;
            a = b;
            b = c;
        }
        time();
        if(a.HP <= 0)
            System.out.println(a.name + " dies");
        else if (b.HP <= 0)
            System.out.println(b.name + " dies");
    }

    private void time() {
        System.out.printf("%02d:%02d\t",(secs/60),(secs%60));
    }

    private void attack(PJ a, PJ b) {
        int att = attackRoll(a);
        if( att == 2 || ( att == 1 && !defenseRoll(b) ) ) {

            int dmg = a.dmg(false);
            b.HP -= dmg;
            time();
            System.out.println(b.name + " takes " + dmg + " damage.");
        }
        else if (att == 3) {
            int dmg = a.dmg(false, true);
            b.HP -= dmg;
            time();
            System.out.println(b.name + " takes " + dmg + " damage.");
        }
    }

    private boolean defenseRoll(PJ a) {
        boolean res = roll(3) <= a.basicSpeed()+3;
        if(res) {
            time();
            System.out.println(a.name + " blocks.");
        }
        return res;
    }

    private int attackRoll(PJ a) {
        int roll = roll(3);
        if(roll >= 17) {
            //System.out.println(a.name + " fails to attack.");
            return 0;
        }
        else if (roll == 3) {
            time();
            System.out.println(a.name + " attacks with a powerful critical hit.");
            return 3;
        }
        else if(roll == 4) {
            time();
            System.out.println(a.name + " attacks with a critical hit.");
            return 2;
        }
        else if (roll <= 6) {
            if(a.DX-5 == 15) {
                if(roll(1) <= 5) {
                    time();
                    System.out.println(a.name + " attacks with a critical hit.");
                    return 2;
                }
            }
            else if (a.DX-5 >= 16) {
                time();
                System.out.println(a.name + " attacks with a critical hit.");
                return 2; //add modifiers!
            }
        }
        boolean res = roll <= a.DX -5;
        if(res) {
            time();
            System.out.println(a.name + " hits.");
        }
        //else
        //    System.out.println(a.name + " misses.");
        return res?1:0;
    }
}
