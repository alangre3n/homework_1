package model;

import model.Kotik;

public class Application
{
    public static void main( String[] args ) {
        Kotik barsik = new Kotik(3,"Барсик",3000, "мау");
        barsik.play();
        barsik.sleep();
        barsik.chaseMouse();
        barsik.eat(3);
        barsik.chaseMouse();

        Kotik persik = new Kotik();
        persik.setKotik(5,"Персик", 1500, "мяв");
        Kotik.InstanceCount();
    }
}
