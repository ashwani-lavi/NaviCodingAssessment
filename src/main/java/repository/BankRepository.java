package repository;

import exceptions.AbsentBankException;
import exceptions.AbsentBorrowerException;
import model.Bank;
import model.Borrower;

import java.util.HashMap;
import java.util.Map;

public class BankRepository {
    private Map<String, Borrower> borrowerMap = new HashMap<>();
    private Map<String, Bank> bankMap = new HashMap<>();

    public BankRepository() {

    }
    public Bank getBank(String bankName) {
        if(!bankMap.containsKey(bankName)){
            bankMap.put(bankName, new Bank(bankName));
        }
        return bankMap.get(bankName);
    }
    public Borrower getBorrower(String borrowerName) {
        if(!borrowerMap.containsKey(borrowerName)) {
            borrowerMap.put(borrowerName, new Borrower(borrowerName));
        }
        return borrowerMap.get(borrowerName);
    }
    public void validateBankExist(String bankName) throws AbsentBankException {
        if(!bankMap.containsKey(bankName)) {
            throw new AbsentBankException("Bank is not added before");
        }
    }

    public void validateBorrowerExist(String borrowerName) throws AbsentBorrowerException {
        if(!borrowerMap.containsKey(borrowerName)) {
            throw new AbsentBorrowerException("Borrower is not added before");
        }
    }
}