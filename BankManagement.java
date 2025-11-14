import java.util.*;
class BankManagementSystem {
    Scanner sc = new Scanner(System.in);
    String name;
    double CurrentBalance;
    int enteramouunt;

    void Setvalues(String Name, double balance) {
        this.name = Name;
        CurrentBalance = balance;
    }

    void getvalues() {
        System.out.println("CurrentBalance:" + CurrentBalance);
        int enterorexit;
        do{
            System.out.println("Press 1 for continue further process!!"+" Or press 5 to Exit!!");
            enterorexit=sc.nextInt();
                    if (enterorexit == 1) {
                        System.out.println("Press 2 for Withdraw");
                        System.out.println("Press 3 for Deposit");
                        System.out.println("press 4 for CheckBalance");
                        enterorexit = sc.nextInt();
                       if (enterorexit == 2) {
                            System.out.println("Enter your Withdrawal Amount:");
                            enteramouunt = sc.nextInt();
                            try {
                                if (enteramouunt > CurrentBalance) {
                                    throw new InsufficientFundsException("Insufficient Balance!!!");
                                } else if (enteramouunt < 0) {
                                    throw new IllegalArgumentException("Number should be positive!!");
                                } else {
                                    CurrentBalance = CurrentBalance - enteramouunt;
                                    System.out.println("Amount " + enteramouunt + " Debited!");
                                    System.out.println("FinalBalance:" + " " + CurrentBalance);

                                }
                            } catch (InsufficientFundsException e) {
                                System.out.println("Error:" + e.getMessage());
                            }
                        } else if (enterorexit == 3) {
                            System.out.println("Enter your amount to Deposit:");
                            int de = sc.nextInt();
                            CurrentBalance = CurrentBalance + de;
                            System.out.println("Amount " + de + " Credited!!");
                            System.out.println("FinalBalance:" + " " + CurrentBalance);
                        }
                       else if(enterorexit==4)
                           System.out.println("Your account Balance: "+CurrentBalance);
                    }
                    else if(enterorexit==5) break;
                    else {
                        System.out.println("Enter a valid number!!");
                        System.out.println();
                    }
                } while (enterorexit <=4);
            }
    }
class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message) {
        super(message);
    }
}
public class Task1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BankManagementSystem ba=new BankManagementSystem();
        System.out.print("Enter your name: ");
        String name=sc.nextLine();
        String orpass="8172";int c=3;
        String pass;
        do {
            System.out.print("Enter your Account password: ");
            pass= sc.next();
            if (!pass.equals(orpass)) {
                System.out.println("Wrong password!! Try again");
                System.out.println("You have only "+--c+" more attempts");
            }
            else break;
        }while(c>0);
        if(c!=0) {
            System.out.println("Welcome " + name);
            ba.Setvalues(name + "..", 200000);
            ba.getvalues();
        }
        else System.out.println("Your account locked");

    }
}
