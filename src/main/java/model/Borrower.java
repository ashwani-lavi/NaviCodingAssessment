package model;

public class Borrower {

    private String borrowerName;

    public Borrower(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
}
