package es.luismars;

public class Main {

    public static void main(String[] args) {
        PJ a = new PJ("Luis");
        PJ b = new PJ("Carlos");

        System.out.println(a + "\n\n" + b + "\n\n");

        Combat c = new Combat(a, b);
        }
    }

