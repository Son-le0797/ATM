package prsentation;


import data.CustomerData;
import data.ExchangementData;
import model.Customer;
import model.Exchangement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String PATH = "DataExchangement.csv";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Customer customer = new Customer("Nguyen Van A", 1200000);


        List<Exchangement> exchangements = new ArrayList<>();
        exchangements.add(new Exchangement("rut tien", 100000));
        String line = null;

        int choice = -1;
        while (choice != 0) {


            for (int i = exchangements.size() - 1; i >= 0 && i >= exchangements.size() - 4; i--) {
//                    for(Exchangement exchangement : exchangements){
                line = String.format("%d. %s %d vnd", i, exchangements.get(i).getExchangementName(), exchangements.get(i).getAmount());
//                        line = exchangement.getExchangementName() + "," + exchangement.getAmount();
                CustomerData.writefile(PATH, line);

                System.out.println("Ngan hang ABC kinh chao Quy khach Nguyen Van A");
                System.out.println("Menu:");

                System.out.println("\n\t1. Nhan phim A de kiem tra tai khoan");
                System.out.println("\t2. Nhan phim D de nap tien");
                System.out.println("\t3. Nhan phim W de rut tien");
                System.out.println("\t4. Nhan phim H de kiem tra lich su 3 lan giao dich gan nhat");
                System.out.println("\t5. Nhan phim X de thoat");
                System.out.println("=======================================================================");
                System.out.print("Nhap lua chon cua ban: ");

                char select = sc.next().charAt(0);

                switch (select) {
                    case 'A':
                        System.out.printf("So du tai khoan cua quy khach la: %.0f vnd", customer.getBalance());

                        System.out.println("\nBam nut theo menu de tiep tuc giao dich");
                        System.out.println("=======================================================================");
                        break;
                    case 'D':
                        System.out.println("Giao dich nap tien");
                        System.out.print("Vui long nhap so tien muon nap: ");

                        int recharge = sc.nextInt();

                        System.out.printf("\nGiao dich thanh cong. Ban vua nap <%d vnd> vao tai khoan", recharge);
                        customer.setBalance(customer.getBalance() + recharge);
                        System.out.printf("\nSo du tai khoan cua khach hang la: %.0f vnd", customer.getBalance());
                        System.out.println("\nBam nut theo menu de tiep tuc giao dich");
                        System.out.println("=======================================================================");
                        exchangements.add(new Exchangement("nap tien", recharge));

                        break;
                    case 'W':
                        System.out.println("Giao dich rut tien");
                        System.out.print("Vui long nhap so tien ban muon rut: ");
                        int Withdrawal = sc.nextInt();

                        if (customer.getBalance() >= Withdrawal) {
                            customer.setBalance(customer.getBalance() - Withdrawal);
                            System.out.printf("\nGiao dich thanh cong. Ban vua rut <%d vnd> ra khoi tai khoan", Withdrawal);
                            System.out.printf("\nSo du tai khoan cua ban la: %.0f vnd", customer.getBalance());
                            System.out.println("\nBam nut theo menu de tiep tuc giao dich");
                            exchangements.add(new Exchangement("rut tien", Withdrawal));

                        } else {
                            System.out.println("\nGiao dich khong thanh cong.");
                            System.out.println("So du trong tai khoan cua ban khong du de thuc hien chuc nang nay");
                            System.out.printf("So du tai khoan cua ban la: %.0f", customer.getBalance());
                            System.out.println("\nBam nut theo menu de tiep tuc giao dich");
                            System.out.println("=======================================================================");
                        }

                        break;
                    case 'H':
                        List<String> listLine = ExchangementData.readFile(PATH);
                        System.out.println(listLine);
                        break;
                    case 'X':
                        System.out.print("Cam on ban da su dung cac dich vu ATM");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nBan da nhap sai chuc nang");
                        System.out.println("Bam nut theo menu de tiep tuc giao dich");
                        System.out.println("=======================================================================");
                }
            }
        }
    }
}
