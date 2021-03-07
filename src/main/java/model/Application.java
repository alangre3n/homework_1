package model;

public class Application {
    public static void compareMeow(String firstMeow, String secondMeow) {
        if (firstMeow.equals(secondMeow)) {
            System.out.println("Meow match");
        } else {
            System.out.println("Meow don't match");
        }
    }

    public static void main(String[] args) {

        Kotik barsik = new Kotik(3, "Barsik", 3000, "meow");
        barsik.liveAnotherDay();
        System.out.println(barsik.getName() + " has weight " + barsik.getWeight());

        Kotik persik = new Kotik();
        persik.setKotik(5, "Persik", 1500, "maw");

        compareMeow(barsik.getMeow(), persik.getMeow());
        Kotik.InstanceCount();
    }
}
