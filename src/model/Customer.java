package model;

import java.io.IOException;
import java.util.ArrayList;

public class Customer {
    private String customerName ;
    private double balance;
    ArrayList<Exchangement> history;

    public Customer(){
        history = new ArrayList<>();
    }

    public Customer(String customerName, double balance) {
        this.customerName = customerName;
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Exchangement> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Exchangement> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String historyToStringCSV(){
        String result = "";
        for (Exchangement exchangement : history) {
            result += exchangement.toStringCSV();
        }
        return result;
    }

    public void printHistory(String customerName){
        ArrayList<Exchangement> exchangements = history;
        if (exchangements.size() == 0){
            System.out.println("History empty!!");
        } else {

            for (int i = exchangements.size()-1; i >= 0 && i >= exchangements.size() - 4; i--) {
                System.out.printf("%d. %s:  %d vnd\n", i, exchangements.get(i).getExchangementName(), exchangements.get(i).getAmount());
            }
        }
    }



}
