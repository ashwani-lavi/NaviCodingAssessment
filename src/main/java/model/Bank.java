package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private String bankName;
    private Map<Borrower, List<Loan>> bankLoans = new HashMap<>();

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public Bank(String bankName, Map<Borrower, List<Loan>> bankLoans) {
        this.bankName = bankName;
        this.bankLoans = bankLoans;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Map<Borrower, List<Loan>> getBankLoans() {
        return bankLoans;
    }

    public void setBankLoans(Map<Borrower, List<Loan>> bankLoans) {
        this.bankLoans = bankLoans;
    }
}
