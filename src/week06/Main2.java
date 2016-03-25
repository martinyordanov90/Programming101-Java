package week06;

import java.io.*;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main2 {
    static Scanner sc = new Scanner(System.in);
    static Bank bank = new Bank();

    public static void main(String[] args) {
        bank = loadAccounts(bank);

        try {
            BankAccount account;

            String command = sc.nextLine();
            while (!command.equals("exit")) {
                switch (command) {
                    case "create_account":
                        createAccount();
                        break;
                    case "list_accounts":
                        listAccounts();
                        break;
                    case "show_history":
                        account = getAccount();
                        showHistory(account);
                        saveAccount(account);
                        break;
                    case "add_money":
                        account = getAccount();
                        addMoney(account);
                        saveAccount(account);
                        break;
                    case "withdraw_money":
                        account = getAccount();
                        withdrawMoney(getAccount());
                        saveAccount(account);
                        break;
                    case "transfer_money":
                        account = getAccount();
                        transferMoney(getAccount());
                        saveAccount(account);
                        break;
                    case "calculate_amount":
                        account = getAccount();
                        calculateAmount(getAccount());
                        saveAccount(account);
                        break;
                    default:
                        throw new NoSuchCommandException();
                }

                command = sc.nextLine();
            }
        } catch (NoSuchCommandException e) {
            System.err.println("Error: Invalid command.");
        } catch (NoSuchAccountException e) {
            System.err.println("Error: Account with this ID doesn't exist.");
        } catch (IOException e) {
            System.err.println("Error: Unable to save account.");
        }
    }

    static private BankAccount getAccount() throws NoSuchAccountException {
        System.out.print("Account ID: ");
        String accountId = sc.nextLine();
        BankAccount account = bank.get(accountId);
        if (account == null) {
            throw new NoSuchAccountException();
        }
        return account;
    }

    static private void createAccount() {
        System.out.print("First name: ");
        String firstName = sc.nextLine();

        System.out.print("Last name: ");
        String lastName = sc.nextLine();

        System.out.print("Birthdate (dd.MM.yyyy): ");
        String birthdate = sc.nextLine();

        System.out.print("Starting balance: ");
        String balance = sc.nextLine();

        System.out.print("Interest (in percent): ");
        String interest = sc.nextLine();

        System.out.print("Interest type (simple or complex): ");
        String interestType = sc.nextLine();

        try {
            BankAccount account = new BankAccount(firstName, lastName, birthdate,
                    balance, interest, interestType);
            bank.set(account);
            saveAccount(account);
            System.out.println(String.format("Account ID %s successfully created!", account.getId()));
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid numeric value entered.");
        } catch (NameCannotBeEmptyException e) {
            System.err.println("Error: Empty name field.");
        } catch (NoSuchInterestTypeException e) {
            System.err.println("Error: Invalid interest type. Please use \"simple\" or \"complex\"");
        } catch (DateTimeParseException e) {
            System.err.println("Error: Invalid birthdate.");
        } catch (IOException e) {
            System.err.println("Error: Can't save account.");
        }
    }

    static void showHistory(BankAccount account) {
        String[] history = account.getHistory();

        for (int i = history.length - 1; i >= 0; i--) {
            if (history[i] == null) {
                continue;
            }
            System.out.println(history[i]);
        }
    }

    static void addMoney(BankAccount account) {
        System.out.print("Amount: ");
        String amount = sc.nextLine();

        try {
            account.add(amount);
            System.out.println(String.format("%s successfully added to account ID %s", amount, account.getId()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    static void withdrawMoney(BankAccount account) {
        System.out.print("Amount: ");
        String amount = sc.nextLine();

        try {
            account.withdraw(amount);
            System.out.println(String.format("%s successfully withdrawn from account ID %s", amount, account.getId()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (InsufficientFundsException e) {
            System.err.println(String.format("Error: Insufficient funds. Balance: %s", account.getBalance()));
        }
    }

    static void transferMoney(BankAccount origin) {
        System.out.print("Recipient ID: ");
        String destinationId = sc.nextLine();

        System.out.print("Amount: ");
        String amount = sc.nextLine();

        try {
            bank.transfer(origin.getId(), destinationId, amount);
            System.out.println(String.format("%s successfully transferred from account ID %s to account ID %s",
                                             amount, origin.getId(), destinationId));
        } catch (InsufficientFundsException e) {
            System.err.println(String.format("Error: Insufficient funds. Balance: %s", origin.getBalance()));
        }
    }

    static void calculateAmount(BankAccount account) {
        System.out.print("Months: ");
        String months = sc.nextLine();

        double amount = account.calculateAmount(months);
        System.out.println(String.format("Resulting amount: %d", amount));
    }

    static void printHorizontalRule() {
        for (int i = 0; i < 80; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    static void printAccount(BankAccount account) {
        System.out.println("Account ID: " + account.getId());
        System.out.println("First name: " + account.getFirstName());
        System.out.println("Last name: " + account.getLastName());
        System.out.println("Age: " + account.getOwnerAge());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Interest: " + account.getInterest() + "% (" + account.getInterestType() + ")");
    }

    static void listAccounts() {
        Iterator it = bank.m_accounts.entrySet().iterator();

        if (it.hasNext()) {
            printHorizontalRule();
        } else {
            System.out.println("No accounts.");
        }

        while (it.hasNext()) {
            Map.Entry<String, BankAccount> pair = (Map.Entry) it.next();
            BankAccount account = pair.getValue();

            printAccount(account);

            printHorizontalRule();
        }
    }

    static void saveAccount(BankAccount account) throws IOException {
        File dataDir = new File("data/");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }

        BufferedOutputStream out = null;
        ObjectOutputStream objOut = null;

        try {
            out = new BufferedOutputStream(new FileOutputStream("data/" + account.getId() + ".ser"));
            objOut = new ObjectOutputStream(out);
            objOut.writeObject(account);
        } finally {
            if (objOut != null) {
                objOut.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    static Bank loadAccounts(Bank bank) {
        File dataDir = new File("data/");
        if (!dataDir.exists()) {
            return bank;
        }

        String[] accountPaths = dataDir.list();
        try {
            for (String accountPath : accountPaths) {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream("data/" + accountPath));
                ObjectInputStream objIn = new ObjectInputStream(in);
                BankAccount account = (BankAccount) objIn.readObject();
                bank.set(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bank;
    }
}

class NoSuchCommandException extends Exception {
    public NoSuchCommandException() {
        super();
    }

    public NoSuchCommandException(String message) {
        super(message);
    }
}

class NoSuchAccountException extends Exception {
    public NoSuchAccountException() {
        super();
    }

    public NoSuchAccountException(String message) {
        super(message);
    }
}
