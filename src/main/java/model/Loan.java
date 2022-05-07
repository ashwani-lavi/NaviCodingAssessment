package model;

import java.util.HashMap;
import java.util.Map;

public class Loan {

    private String bankName;
    private String borrowerName;
    private Integer numberOfYears;
    private Integer rateOfInterest;
    private Integer principleAmount;
    private Map<Integer, Integer> emiLumpSumMap = new HashMap<>();

    public Loan(String bankName, String borrowerName, Integer numberOfYears, Integer rateOfInterest,
                Integer principleAmount) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.numberOfYears = numberOfYears;
        this.rateOfInterest = rateOfInterest;
        this.principleAmount = principleAmount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(Integer numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public Integer getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(Integer rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public Map<Integer, Integer> getEmiLumpSumMap() {
        return emiLumpSumMap;
    }

    public void setEmiLumpSumMap(Map<Integer, Integer> emiLumpSumMap) {
        this.emiLumpSumMap = emiLumpSumMap;
    }

    public void addEmiLumpSumMap(Integer emi, Integer amount) {
        if(emiLumpSumMap.containsKey(emi)) {
            amount += this.emiLumpSumMap.get(emi);
        }
        emiLumpSumMap.put(emi,amount);
    }

    public Integer getPrincipleAmount() {
        return principleAmount;
    }

    public void setPrincipleAmount(Integer principleAmount) {
        this.principleAmount = principleAmount;
    }
}
