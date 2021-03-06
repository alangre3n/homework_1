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

    public void setKotik(int prettiness, String name, int weight, String meow) {
        this.prettiness = prettiness;
        this.name = name;
        this.weight = weight;
        this.meow = meow;
    }

    public Kotik() {
        instanceCount++;
    }

    private boolean checkHunger(String message, int satiety) {
        if (this.satiety <= 0) {
            System.out.println("Котейка отказывается выполнять действие, он хочет кушать, покорми его");
            return true;
        } else {
            System.out.println(message);
            this.satiety -= satiety;
            return false;
        }
    }

    public void defecate() {
        checkHunger("Котейка справил нужду", 0);
    }

    public void goOut() {
        checkHunger("Котейка погулял", 2);
    }

    public void play() {
        checkHunger("Котейка поиграл", 1);
    }

    public void sleep() {
        checkHunger("Котейка поспал", 2);
    }

    public void chaseMouse() {
        if (!checkHunger("Котейка погнался за мышкой и....", 2)) {
            String[] res = {"поймал ее", "мышке удалось удрать"};
            Random random = new Random();
            System.out.println(res[random.nextInt(res.length)]);
        }
    }

    public void eat(int satietyCount) {
        System.out.println("Котейка покушал");
        this.satiety += satietyCount;
    }

    public void eat(String food, int satietyCount) {
        System.out.println("Котейка покушал " + food);
        this.satiety += satietyCount;
    }

    public void eat() {
        Scanner in = new Scanner(System.in);
        System.out.println("Чем будем кормить котейку?");
        String food = in.nextLine();
        System.out.println("Сколько еды будем давать?");
        int foodCount = in.nextInt();
        eat(food, foodCount);
        in.close();
    }

    public void liveAnotherDay() {
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
        System.out.println(instanceCount);
    }
}
