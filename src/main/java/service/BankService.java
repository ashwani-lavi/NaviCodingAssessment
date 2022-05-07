package service;

import exceptions.AbsentLoanException;
import exceptions.DuplicateLoanException;
import model.Bank;
import model.Borrower;
import model.Loan;
import repository.BankRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BankService {
    private static BankRepository bankRepository = new BankRepository();

    public void addLoan(String bankName, String borrowerName, Integer numberOfYears, Integer rateOfInterest,
                        Integer principleAmount) throws Exception{
        Bank bank = bankRepository.getBank(bankName);
        Borrower borrower = bankRepository.getBorrower(borrowerName);
        Loan loan = new Loan(bankName, borrowerName, numberOfYears, rateOfInterest, principleAmount);
        validateDuplicateLoan(loan);
        Map<Borrower, List<Loan> > borrowerLoanMap = bank.getBankLoans();
        borrowerLoanMap.putIfAbsent(borrower, new ArrayList<>());
        borrowerLoanMap.get(borrower).add(loan);
        bank.setBankLoans(borrowerLoanMap);
    }

    public void addLumpSum(String bankName, String borrowerName, Integer emiNo, Integer amount) throws Exception{
        validateBankAndBorrower(bankName, borrowerName);
        Bank bank = bankRepository.getBank(bankName);
        Borrower borrower = bankRepository.getBorrower(borrowerName);
        if(!validateLoanExist(bank,borrower)) {
            throw new AbsentLoanException("Loan doesn't exist");
        }
        Map<Borrower, List<Loan> > borrowerLoanMap = bank.getBankLoans();
        Loan loan = borrowerLoanMap.get(borrower).get(0);                    //because only 1 loan is supported for now
        loan.addEmiLumpSumMap(emiNo, amount);
    }

    public void displayAmountPaidAndRemainingEMI(String bankName, String borrowerName, Integer emiNo) throws Exception{
        validateBankAndBorrower(bankName, borrowerName);
        Bank bank = bankRepository.getBank(bankName);
        Borrower borrower = bankRepository.getBorrower(borrowerName);
        if(!validateLoanExist(bank, borrower)) {
            throw new AbsentLoanException("Loan doesn't exist");
        }
        Loan loan = bank.getBankLoans().get(borrower).get(0);           //because only 1 loan is supported for now
        int interestAmount = (int)Math.ceil((double)loan.getNumberOfYears()
                * loan.getRateOfInterest() * loan.getPrincipleAmount() / 100);
        int totalAmount = interestAmount + loan.getPrincipleAmount();
        int amountForEachMonth = (int)Math.ceil((double) totalAmount/(12*loan.getNumberOfYears()));
        int lumpSumAmount = 0;
        for(Integer emiNumber: loan.getEmiLumpSumMap().keySet()) {
            if(emiNumber <= emiNo) {
                lumpSumAmount += loan.getEmiLumpSumMap().get(emiNumber);
            }
        }
        lumpSumAmount += amountForEachMonth*emiNo;
        System.out.print(loan.getBankName() + " "+ loan.getBorrowerName() + " ");
        if(totalAmount>lumpSumAmount){
            int emiLeft = (int)Math.ceil((double) (totalAmount-lumpSumAmount)/amountForEachMonth);
            System.out.println(lumpSumAmount + " " + emiLeft);
        }else {
            System.out.println(totalAmount + " 0");
        }
    }

    private void validateBankAndBorrower(String bankName, String borrowerName) throws Exception{
        bankRepository.validateBankExist(bankName);
        bankRepository.validateBorrowerExist(borrowerName);
    }
    private void validateDuplicateLoan(Loan loan) throws Exception{
        if(validateLoanExist(bankRepository.getBank(loan.getBankName()),
                bankRepository.getBorrower(loan.getBorrowerName()))){
            throw new DuplicateLoanException("Loan exist twice not supported yet");
        }

    }
    private boolean validateLoanExist(Bank bank, Borrower borrower){
        Map<Borrower, List<Loan> > borrowerLoanMap = bank.getBankLoans();
        if(borrowerLoanMap.containsKey(borrower)) {
            return true;
        }
        return false;
    }

}
