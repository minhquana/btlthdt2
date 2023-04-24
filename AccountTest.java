# btlthdt2

import java.util.Scanner;

public class AccountTest {
public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
        AccountList list = new AccountList();
        int choice;
        do {
            System.out.println("MENU:");
            System.out.println("1. Thêm tài khoản");
            System.out.println("2. Số TK hiện có");
            System.out.println("3. In thông tin tất cả TK");
            System.out.println("4. Nạp tiền vào TK");
            System.out.println("5. Rút tiền");
            System.out.println("6. Chuyển tiền");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> {
                    System.out.print("Nhập số TK: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Nhập tên TK: ");
                    String accName = scanner.nextLine();
                    System.out.print("Nhập số dư: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();
                    
                    if (list.addAccount(new Account(accNum, accName, balance))) {
                        System.out.println("Thêm tài khoản thành công");
                    } else {
                        System.out.println("Thêm tài khoản thất bại");
                    }
                }
                case 2 -> System.out.println("Số TK hiện có: " + list.countAccounts());
                case 3 -> list.printAllAccounts();
                case 4 -> {
                    System.out.print("Nhập số TK: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Nhập số tiền cần nạp: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (list.deposit(accNum, amount)) {
                        System.out.println("Nạp tiền thành công");
                    } else {
                        System.out.println("Nạp tiền thất bại");
                    }
                }
                case 5 -> {
                    System.out.print("Nhập số TK: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Nhập số tiền cần rút: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (list.withdraw(accNum, amount)) {
                        System.out.println("Rút tiền thành công");
                    } else {
                        System.out.println("Rút tiền thất bại");
                    }
                }
                case 6 -> {
                    System.out.print("Nhập số TK nguồn: ");
                    String sourceAccNum = scanner.nextLine();
                    System.out.print("Nhập số TK đích: ");
                    String destAccNum = scanner.nextLine();
                    System.out.print("Nhập số tiền cần chuyển: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (list.transfer(sourceAccNum, destAccNum, amount)) {
                        System.out.println("Chuyển tiền thành công");
                    } else {
                        System.out.println("Chuyển tiền thất bại");
                    }
                }
                case 0 -> System.out.println("Tạm biệt!");
                default -> System.out.println("Lựa chọn không hợp lệ");
            }
            System.out.println();
        } while (choice != 0);
    }
}
}
