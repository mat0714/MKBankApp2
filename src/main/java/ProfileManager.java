import java.util.List;

public class ProfileManager {

    DBManager dbManager = new DBManager();

    public void addCustomer(Customer customer) {
        dbManager.addCustomer(customer);
        System.out.println("\n--- Customer profile was successfully created. ---");
    }

    public Customer getCustomer(int customerId) {
        Customer customer = dbManager.getCustomer(customerId);
        if (customer == null) {
            System.out.println("\n--- ID wasn't found in database. ---\n");
        }
        return customer;
    }

    public void showCustomerDetails(int customerId) {
        ProfileManager profileManager = new ProfileManager();
        Customer customer = profileManager.getCustomer(customerId);
        if (customer != null) {
            System.out.println("\n                        ACTUAL CUSTOMER DETAILS                       ");
            System.out.println(customer);
        }
    }

    public void addAccount(int customerId, AccountType accountType, double depositAmount) {
        ProfileManager profileManager = new ProfileManager();
        Checking checking = new Checking(1000, depositAmount, 0.05);
        Customer customer = profileManager.getCustomer(customerId);
        List<Account> accounts = customer.getAccounts();
        accounts.add(checking);
        dbManager.addChecking(customer, checking);
    }
//
//    public static Account getAccount(int customerId, int accountNumber) {
//        Customer customer = getCustomer(customerId);
//        Account customerAccount = null;
//        List<Account> accounts = customer.getAccountsList();
//        for (Account account : accounts) {
//            if (account.getNumber() == accountNumber) {
//                customerAccount = account;
//            }
//        }
//        if (customerAccount == null) {
//            System.out.println("\n--- Entered account is not owned by this customer. ---\n");
//        }
//        return customerAccount;
//    }
//
//    public static void deposit(Account account, double depositAmount) {
//        double balance = account.getBalance();
//        double newBalance = balance + depositAmount;
//        int accountNumber = account.getNumber();
//        boolean depositSucceed = DBManager.updateBalance(accountNumber, newBalance);
//        if (depositSucceed) {
//            System.out.println("\n--- Deposit was made. ---");
//        }
//    }
//
//    public static void withdraw(Account account, double withdrawAmount) {
//        double balance = account.getBalance();
//        if (withdrawAmount <= balance) {
//            double newBalance = balance - withdrawAmount;
//            int accountNumber = account.getNumber();
//            boolean withdrawSucceed = DBManager.updateBalance(accountNumber, newBalance);
//            if (withdrawSucceed) {
//                System.out.println("\n--- Withdraw was made. ---");
//            }
//        }
//        else {
//            System.out.println("\n--- Not enough funds on this account. ---");
//        }
//    }
}
