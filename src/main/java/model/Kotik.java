package model;

import java.util.Random;
import java.util.Scanner;

public class Kotik {
    private int prettiness;
    private String name;
    private int weight;
    private String meow;
    private int satiety = 5;
    public static int instanceCount;

    public Kotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
        instanceCount++;
    }

    public Kotik() {
        instanceCount++;
    }

    public void setKotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
    }

    private void checkHunger(String message, int satiety) {
        if (this.satiety <= 0) {
            System.out.println(this.name + " wants to eat, feed him");
        } else {
            System.out.println(message);
            this.satiety -= satiety;
        }
    }

    public void defecate() {
        checkHunger(this.name + " defecates", 0);
    }

    public void goOut() {
        checkHunger(this.name + " is walking", 2);
    }

    public void play() {
        checkHunger(this.name + " is playing", 1);
    }

    public void sleep() {
        checkHunger(this.name + " is sleeping", 2);
    }

    public void chaseMouse() {
        String[] res = {"gotcha", "the mouse ran away"};
        Random random = new Random();
        checkHunger("Chases mouse..." + res[random.nextInt(res.length)], 2);
    }

    public void eat(int satietyCount) {
        System.out.println(this.name + " is eating");
        this.satiety += satietyCount;
    }

    public void eat(String food, int satietyCount) {
        System.out.println(this.name + " is eating " + food);
        this.satiety += satietyCount;
    }

    public void eat() {
        Scanner in = new Scanner(System.in);
        System.out.println("what to feed the " + this.name + "?");
        String food = in.nextLine();
        System.out.println("How much food?");
        int foodCount = in.nextInt();
        eat(food, foodCount);
        in.close();
    }

    public void liveAnotherDay() {
        int pick;
        Event current;

        for (int i = 0; i < 24; i++) {
            pick = new Random().nextInt(Event.values().length);
            current = Event.values()[pick];
            if (satiety < 1) {
                eat(3);
            } else {
                switch (current) {
                    case DEFECATE:
                        defecate();
                        break;
                    case GOOUT:
                        goOut();
                        break;
                    case PLAY:
                        play();
                        break;
                    case SLEEP:
                        sleep();
                        break;
                    case CHASEMOUSE:
                        chaseMouse();
                        break;
                }
            }
        }
    }

    public int getPrettiness() {
        return prettiness;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getMeow() {
        return meow;
    }

    public int getSatiety() {
        return satiety;
    }

    public static void InstanceCount() {
        System.out.println("Number of objects = " + instanceCount);
    }
}
