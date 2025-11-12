import java.util.Scanner;
 class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankManagementSystem{
    Scanner sc=new Scanner(System.in);
    String name;
    double CurrentBalance;
    int enteramouunt;
    double FinalBalance;
    void Setvalues(String Name,double balance){
        name=Name;
        CurrentBalance=balance;

    }
    void getvalues(){
        System.out.println("welcome"+name);
        System.out.println("CurrentBalance:"+CurrentBalance);
        System.out.println("Enter your Withdrawal Amount:");
        enteramouunt=sc.nextInt();
            try {
                if (enteramouunt > CurrentBalance) {
                    throw new InsufficientFundsException("Entered amount is higher than CurrentBalance");
                }
                else {
                    FinalBalance = CurrentBalance - enteramouunt;
                    System.out.println("FinalBalance" + FinalBalance);
                }
            }catch(InsufficientFundsException e){
                    System.out.println("Error"+e.getMessage());
                }

        }

    }
public class Task1 {
    public static void main(String[] args) {
        BankManagementSystem ba=new BankManagementSystem();
        ba.Setvalues(" Harish..",20000);
        ba.getvalues();
    }
}
