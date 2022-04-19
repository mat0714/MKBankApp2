import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SecondaryTable(name = "interest_rates", pkJoinColumns = @PrimaryKeyJoinColumn(name = "type"))
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    private String type;
    private double balance;
    @Column(table = "interest_rates")
    @JoinColumn(name = "type")
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
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
