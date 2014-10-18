package es.luismars;
/**
 * Created by Luis on 03/08/2014.
 */
public class PJ extends Dice {

    int ST = 10;
    int DX = 10;
    int IQ = 10;
    int HT = 10;


    int HP = 10;
    int WILL = 10;
    int PER = 10;
    int FP = 10;

    int CP;
    int AP;

    String name;

    public PJ(String n) {
        AP = CP = characterPoints();
        generate();
        name = n;
    }
    public PJ(String n, int cp) {
        CP = cp;
        generate();
        name = n;
    }
    private void generate() {

        while (AP >= 10) {
            if(AP >= 10) {
                ST++;
                AP -= 10;
            }
            if(AP >= 10) {
                HT++;
                AP -= 10;
            }
            if(AP >= 20) {
                DX++;
                AP -= 20;
            }
            if(AP >= 20) {
                IQ++;
                AP -= 20;
            }
        }
        HP = ST;
        PER = IQ;
        FP = HT;
        WILL = IQ;
    }
    public double basicSpeed() {
        return (HT+DX)/4;
    }

    public int dmg(boolean thr) {
        return dmg(thr, false);
    }

    public int dmg(boolean thr, boolean crit) {
        int d;
        int n;
        if(thr) {
            d = 1 + (ST + 1) / 20;
            n = (ST + 1) / 2 - 7;
            if (d >= 2)
                n = -1;
        }
        else {
            d = 3;
            if(ST/13 == 0)
                d = 1;
            else if (ST/17 == 0)
                d = 2;
            n = (ST+1)/2-6;
            if (ST > 8)
                n = ((ST+3)%4)-1;
        }
        return roll(d, n, crit);

    }

    public String toString() {
        return name + ":\t\t\tCP: " + AP + "/" + CP +
                "\n\t ST: " + ST + "\t HP:   " + HP +
                "\n\t DX: " + DX + "\t WILL: " + WILL +
                "\n\t IQ: " + IQ + "\t PER:  " + PER +
                "\n\t HT: " + ST + "\t FP:   " + FP;

    }
}
