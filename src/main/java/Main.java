import model.InputCommands;
import service.BankService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BankService bankService = new BankService();
        File file = new File(args[0]);
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()) {
            String[] line = scan.nextLine().split(" ");
            InputCommands command = InputCommands.valueOf(line[0]);
            String bankName,borrowerName;
            bankName = line[1];
            borrowerName = line[2];
            Integer amount, emiNumber;
            switch (command) {
                case LOAN:
                    amount = Integer.parseInt(line[3]);
                    Integer numberOfYears = Integer.parseInt(line[4]);
                    Integer rateOfInterest = Integer.parseInt(line[5]);
                    try {
                        bankService.addLoan(bankName, borrowerName, numberOfYears, rateOfInterest, amount);
                    } catch (Exception ex) {
                        System.out.println("Exception in adding Loan for bankName" + bankName + "and " + "borrowerName"
                                + borrowerName + " " + ex);
                    }
                    break;
                case PAYMENT:
                    amount = Integer.parseInt(line[3]);
                    emiNumber = Integer.parseInt(line[4]);
                    try {
                        bankService.addLumpSum(bankName, borrowerName, emiNumber, amount);
                    } catch (Exception ex) {
                        System.out.println("Exception found in adding lumpSum for bankName" + bankName + "and " +
                                "borrowerName" + borrowerName + " " + ex);
                    }

                    break;
                case BALANCE:
                    emiNumber = Integer.parseInt(line[3]);
                    try {
                        bankService.displayAmountPaidAndRemainingEMI(bankName, borrowerName, emiNumber);
                    } catch (Exception ex) {
                        System.out.println("Exception found in display remaining emi's for bankName" + bankName +
                                "and " + "borrowerName" + borrowerName + " "+ ex);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}