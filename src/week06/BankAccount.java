package week06;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class BankAccount implements Serializable {
    private final String m_id;

    private String m_firstName;
    private String m_lastName;

    private LocalDate m_birthdate;

    private BigDecimal m_balance;
    private double m_interest;
    private String m_interestType;

    private String[] m_history;

    private void setFirstName(String firstName) throws NameCannotBeEmptyException {
        if (firstName.length() == 0) {
            throw new NameCannotBeEmptyException();
        }
        m_firstName = firstName;
    }

    private void setLastName(String lastName) throws NameCannotBeEmptyException {
        if (lastName.length() == 0) {
            throw new NameCannotBeEmptyException();
        }
        m_lastName = lastName;
    }

    private void setBirthdate(String birthdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        m_birthdate = LocalDate.parse(birthdate, formatter);
    }

    private void setBalance(String balance) throws NumberFormatException {
        double balanceValue = Double.parseDouble(balance);
        m_balance = new BigDecimal(balanceValue);
        m_balance.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    private void setInterest(String interest) throws NumberFormatException {
        double interestValue = Double.parseDouble(interest);
        m_interest = interestValue;
    }

    private void setInterestType(String interestType) throws NoSuchInterestTypeException {
        if (!(interestType.equals("simple") || interestType.equals("complex"))) {
            throw new NoSuchInterestTypeException(interestType);
        }
        m_interestType = interestType;
    }

    private void setHistory(int size) {
        m_history = new String[size];
    }

    public String getId() {
        return m_id;
    }

    public String getFirstName() {
        return m_firstName;
    }

    public String getLastName() {
        return m_lastName;
    }

    public int getOwnerAge() {
        LocalDate today = LocalDate.now();
        Period p = Period.between(m_birthdate, today);
        return p.getYears();
    }

    public double getBalance() {
        return m_balance.doubleValue();
    }

    public double getInterest() {
        return m_interest;
    }

    public String getInterestType() {
        return m_interestType;
    }

    public BankAccount(String firstName, String lastName, String birthdate,
                       String balance, String interest, String interestType)
            throws NumberFormatException, NoSuchInterestTypeException, NameCannotBeEmptyException {

        m_id = UUID.randomUUID().toString();

        setFirstName(firstName);
        setLastName(lastName);
        setBirthdate(birthdate);
        setBalance(balance);
        setInterest(interest);
        setInterestType(interestType);
        setHistory(5);
    }

    private void shiftLog() {
        for (int i = m_history.length - 1; i > 0; i--) {
            m_history[i] = m_history[i - 1];
        }
    }

    private void logOperation(String message) {
        shiftLog();
        m_history[0] = message;
    }

    public String[] getHistory() {
        return m_history;
    }

    public void add(String amount) {
        BigDecimal amountValue = new BigDecimal(amount);
        m_balance = m_balance.add(amountValue);

        logOperation(String.format("Added %s. New balance: %f", amount, m_balance));
    }

    public void withdraw(String amount) throws InsufficientFundsException {
        BigDecimal amountValue = new BigDecimal(amount);
        if (m_balance.compareTo(amountValue) < 0) {
            throw new InsufficientFundsException();
        }

        m_balance = m_balance.subtract(amountValue);

        logOperation(String.format("Withdrew %s. New balance: %f", amount, m_balance));
    }

    public double calculateAmount(String months) throws NumberFormatException {
        int monthsValue = Integer.parseInt(months);
        double amount = m_balance.doubleValue();

        if (m_interestType == "simple") {
            double interestValue = amount * m_interest;
            for (int i = 0; i < monthsValue; i++) {
                amount += interestValue;
            }
        } else {
            for (int i = 0; i < monthsValue; i++) {
                double interestValue = amount * m_interest;
                amount += interestValue;
            }
        }

        return amount;
    }
}

class NoSuchInterestTypeException extends Exception {
    public NoSuchInterestTypeException() {
        super();
    }

    public NoSuchInterestTypeException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super();
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}

class NameCannotBeEmptyException extends Exception {
    public NameCannotBeEmptyException() {
        super();
    }

    public NameCannotBeEmptyException(String message) {
        super(message);
    }
}


