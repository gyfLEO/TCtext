import java.awt.image.VolatileImage;
interface Speak {
    public void speaking();
}

class Monkey implements Speak{
    private String voice;
    Monkey(String str){
        this.voice = str;
    }

    @Override
    public void speaking() {
        System.out.println("猩猩叫：" + voice);
    }
}

class People implements Speak{
    private String voice;
    People(String str){
        this.voice = str;
    }

    @Override
    public void speaking() {
        System.out.println("人叫：" + voice);
    }
}

class Dog implements Speak{
    private String voice;
    Dog(String str){
        this.voice = str;
    }

    @Override
    public void speaking() {
        System.out.println("狗叫：" + voice);
    }
}

class StaticFactory{
    public static Speak monkeyInit(String str) {
        return new Monkey(str);
    }

    public static Speak peopleInit(String str) {
        return new People(str);
    }

    public static Speak dogInit(String str) {
        return new Dog(str);
    }
}

public class SpeakTest {
    public static void main(String[] args) throws Exception {
//        OnlineBank online = new OnlineBank();
//        online.onlineDrawMoney();
//        ATMBank atm = new ATMBank();
//        atm.atmDrawMoney();
//        CounterBank counter = new CounterBank();
//        counter.counterDrawMoney();
        StaticFactory.monkeyInit("吼吼!").speaking();
        StaticFactory.peopleInit("你好!").speaking();
        StaticFactory.dogInit("汪汪!").speaking();
    }

}