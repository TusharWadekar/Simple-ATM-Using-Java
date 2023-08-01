package OOPs;

import javax.management.StringValueExp;
import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
ATMop obj = new ATMop();
    }
}

class Data{
    float balance;
}

class ATMop{

    Scanner sc = new Scanner(System.in);
    HashMap<Integer , Data>map=new HashMap<>();

    ATMop(){
        System.out.println("***********************************************");
        System.out.println(" WELCOME TO OUR ATM MACHINE");
        op();
    }

    public void op(){
        System.out.println("***********************************************");
   System.out.println(" enter your pin code ");
   int pincode = sc.nextInt();

    if(map.containsKey(pincode) ){
        Data obj = map.get(pincode);
        menu(obj);
    }else {
        System.out.println("***********************************************");
        System.out.println("please create account first");
        System.out.println("set your pin code ");
        int pin = sc.nextInt();
        Data obj = new Data();
        map.put(pin,obj);
        menu(obj);
    }

    }

    public void menu(Data obj){

        System.out.println("please Enter vaild Number ");
        System.out.println(" 1. check balance ");
        System.out.println(" 2. deposit money ");
        System.out.println(" 3. withdraw money ");
        System.out.println(" 4. check another acount ");
        System.out.println(" 5. Exit  ");

        int x = sc.nextInt();

        if(x==1){
            check_balance(obj);
        }else if (x==2){
            deposit(obj);
        } else if (x==3) {
            withdraw(obj);
        } else if (x==4) {
            op();
        } else if (x==5) {
            System.out.println(" Thank You !");
        } else  {
            System.out.println(" please Enter vaild number ");
            menu(obj);
        }
    }

    public void check_balance(Data obj){
        System.out.println("***********************************************");
        System.out.println(" *** YOUR BALANCE : "+ obj.balance + " ***");
        System.out.println("***********************************************");
        menu(obj);
    }

    public void deposit(Data obj){
        System.out.println(" enter your amount ");
        float a = sc.nextInt();

        obj.balance+=obj.balance +a;
        System.out.println(" ***** AMOUNT DEPOSIT SUCCESSFULLY ***** " );
        System.out.println("***********************************************");
        menu(obj);
    }
    public void withdraw(Data obj){
        System.out.println(" enter your amount");
        float a = sc.nextInt();

        if(obj.balance>=a){
            obj.balance = obj.balance - a;
            System.out.println("  ***** AMOUNT WITHDREW SUCCESSFULLY ***** ");
        }else {
            System.out.println(" Insufficent balance");
        }

        System.out.println("***********************************************");
        menu(obj);
    }



}