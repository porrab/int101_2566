package work03;

import work01.Utilitor;
import work02.Person;

import java.util.Objects;

public class Account{
    private static long nextNo = 100000000;
    private final long no;
    private Person owner;
    private double balance;
    public Account(Person owner){
        if (owner == null){
            throw new NullPointerException();
        }
        this.owner = owner;
        this.balance = 0.0;
        int result = Utilitor.computeIsbn10(nextNo);
        while (result == 10){
             nextNo++;
             result = Utilitor.computeIsbn10(nextNo);
        }
        this.no = 10*nextNo+result;
        nextNo++;
    }
    public Person getOwner(Person owner){
        return owner;
    }
    public long getNo() {
        return no;
    }
    public double getBalance() {
        return balance;
    }
    public double deposit(double amount){
        return balance += Utilitor.testPositive(amount);
    }
    public double withdraw(double amount){
        Utilitor.testPositive(amount);
        if (amount > this.balance){
            throw new IllegalArgumentException("cant withdraw");
        }
        double newBalance = this.balance -= Utilitor.testPositive(amount);
        this.balance = Utilitor.testPositive(newBalance);
        return balance;
    }
    public void transfer(double amount,Account account){
        if (account == null ||balance <= withdraw(amount)){
            throw new IllegalArgumentException();
        }this.balance -= withdraw(amount);
        account.deposit(amount);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("no=").append(no);
        sb.append(", owner=").append(owner);
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return no == account.no && Double.compare(balance, account.balance) == 0 && Objects.equals(owner, account.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, owner, balance);
    }
}
       /*
       
       3.7 public getters for "no", "owner", and "balance".
       3.8 a public method named "deposit" that receives a "double" parameter
           named "amount". This method throws IllegalArgumentException
           if "amount" cannot pass "Utilitor.testPositive" method.
           Otherwise, the method adds the "amount" to "balance"
           and then returns the new "balance".
       3.9 a public method named "withdraw" that receives a "double" parameter
           named "amount". This method throws IllegalArgumentException
           if "amount" does not pass "Utilitor.testPositive" method.
           Otherwise, the method subtracts the "amount" from "balance"
           and then returns the new "balance".  However, this method will not
           do so if the new "balance" cannot pass "Utilitor.testPositive" method.
       3.10 a public method named "transfer" that recieves a "double" parameter
            named "amount" and an "Account" parameter named "account".
            This method throws IllegalArgumentException if "account" is null,
            or it cannot "withdraw" the "amount" from this object. Otherwise,
            this method "withdraw" the "amount" from this object and "deposit"
            the "amount" to the "account" object.  This method returns nothing.
       3.11 @Override a public "toString" method that returns
            "Account(no,balance)" where "no" and "balance" are
            the "no" and "balance" fields of this object.
       3.12 @Override a public "equals" method that returns true
            if this object is the same as the object in the parameter
            (i.e., the same reference). Otherwise, it returns false.
       3.13 Show in this "work03Account" method how to
            use 3.6-3.12 and check their correctness. */