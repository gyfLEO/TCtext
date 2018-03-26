import java.util.Scanner;

abstract class AbstractBank {
    public abstract void bankInfo();

    public void infoFill(){
        String str1, str2;
        do{
            Scanner input = new Scanner(System.in);
            System.out.println("请输入银行卡帐号：");
            str1 = input.nextLine();
            System.out.println("请输入帐号密码：");
            str2 = input.nextLine();
        }while (infoCheck(str1, str2));
    }

    public boolean infoCheck(String accountNo, String password){
        System.out.println("银行卡帐号：" + accountNo);
        System.out.println("帐号密码：" + password);
        if(accountNo.equals("123456") && password.equals("123456")){
            System.out.println("信息正确,请取款！");
            System.out.println();
            return true;
        }else{
            System.out.println("重新输入！");
            System.out.println();
            return false;
        }
    }

    public void drawMoney(){
        bankInfo();
        infoFill();
    }
}

//网银
class OnlineBank extends AbstractBank{
    public void bankInfo(){
        System.out.println("欢迎来到网上银行取款~");
    }
}

//ATM提款机
class ATMBank extends AbstractBank{
    public void bankInfo(){
        System.out.println("欢迎来到ATM提款机取款~");
    }
}

//线下柜台
class CounterBank extends AbstractBank{
    public void bankInfo(){
        System.out.println("欢迎来到线下柜台银行取款~");
    }
}

class Factory{
    public static AbstractBank onlineBankInit(){
        return new OnlineBank();
    }

    public static AbstractBank atmBankInit(){
        return new ATMBank();
    }

    public static AbstractBank counterBankInit(){
        return new CounterBank();
    }
}

public class bankTest{
    public static void main(String[] args) {
        new OnlineBank().drawMoney();
//        AbstractBank bank2 = new ATMBank();
//        bank2.drawMoney();
//        AbstractBank bank3 = new CounterBank();
//        bank3.drawMoney();
        Factory.onlineBankInit().drawMoney();
        Factory.atmBankInit().drawMoney();
        Factory.counterBankInit().drawMoney();
    }
}