import java.util.*;
public class ATM{
    
      private int balance;
      private int pin;

      public ATM(int balance, int pin)
      {
        this.balance=balance;
        this.pin=pin;
      }

      // To display the menu
      public void displayMenu()
      {
        System.out.println("1. Check Balance ");
        System.out.println("2. Deposit ");
        System.out.println("3. Withdraw ");
        System.out.println("4. Change Pin ");
        System.out.println("5. Exit ");
      }
      
      // For deposit transaction
      public void deposit(int amount)
      {
        balance+=amount;
        System.out.println(" Amount Deposited Successfully!");
      }

      // For withdraw transaction
      public void Withdraw(int amount)
      {
        if(balance<amount)
        {
          System.out.println(" Insufficient Balance");
          return;
        }
        balance-=amount;
        System.out.println(" Cash Withdrawn Successfully!");
      }

      // To check the balance
      public int getBalance()
      {
        return balance;
      }

      // To validate the pin
      public boolean validatePin(int pin)
      {
        return this.pin==pin;
      }

      // To change the pin
      public void changePin(int newPin)
      {
        pin =newPin;
        System.out.println("Pin changed");
      }



      // Main function
      public static void main(String[] args) 
      {
        Scanner sc =new Scanner(System.in);
        ATM atm = new ATM(1000,1234);
        System.out.println("Enter the Pin");
        int pin=sc.nextInt();
        if(atm.validatePin(pin))
        {
          int option =0;
          while(option<5)
          {
            atm.displayMenu();
            option=sc.nextInt();
            switch (option) { // Use of switch statment for transactions
              case 1:
                      System.out.println("Balance: " + atm.getBalance());
              break;

              case 2:
                    System.out.println("Enter Amount: ");
                    int amount=sc.nextInt();
                    atm.deposit(amount);
                
              break;
                
              case 3:
              System.out.println("Enter Amount: ");
              amount=sc.nextInt();
              atm.Withdraw(amount);
              break;
                
              case 4:
                System.out.print("Enter New Pin: ");
                int newPin =sc.nextInt();
                atm.changePin(newPin);
              break;
                
              case 5:
                    System.out.println(" Please Collect Your Card.");
                    System.out.println("Thank You for using ATM!");
              break;
                
              default:
              System.out.println("Invalid Option\nPlease Try Again.");
              option = 6;
              break;
            }
          }
        }
        else
        {
          System.out.println("You have entered Invalid Pin");
        }
      }  
}
