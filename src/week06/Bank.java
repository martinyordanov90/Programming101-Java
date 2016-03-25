package week06;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    protected Map<String, BankAccount> m_accounts;

    public Bank() {
        m_accounts = new HashMap<>();
    }

    protected void set(BankAccount account) {
        m_accounts.put(account.getId(), account);
    }

    public BankAccount get(String accountId) {
        return m_accounts.get(accountId);
    }

    public void transfer(String originId, String destinationId, String amount)
            throws NumberFormatException, InsufficientFundsException {
        BankAccount origin = m_accounts.get(originId);
        BankAccount destination = m_accounts.get(destinationId);

        origin.withdraw(amount);
        destination.add(amount);

        m_accounts.put(originId, origin);
        m_accounts.put(destinationId, destination);
    }
}
