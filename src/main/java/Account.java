import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    private String type;
    private double balance;
    private double interestRate;

    public Account() {
    }

    public Account(int number, double balance, double interestRate) {
        this.number = number;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "\n\t\t  " +
                "Number: " + this.getNumber() +
                ", Type: " + this.getType() +
                ", Balance: " + this.getBalance() + " $" +
                ", Interest: " + this.getInterestRate() + " %";
    }
}
