# btlthdt2
public class AccountList {
    private Account[] accList;
    private int count;
    
    // Constructor mặc định
    public AccountList() {
        this.accList = new Account[10];
        this.count = 0;
    }
    
    // Constructor có tham số
    public AccountList(int n) {
        if (n > 0) {
            this.accList = new Account[n];
        } else {
            this.accList = new Account[10];
        }
        this.count = 0;
    }
    
    // Phương thức thêm tài khoản vào danh sách
    public boolean addAccount(Account acc) {
        if (this.count == this.accList.length) {
            return false; // danh sách đã đầy, không thể thêm được
        }
        this.accList[count++] = acc;
        return true;
    }
    
    // Phương thức tìm tài khoản theo số TK
    public Account findAccountByNumber(int accNumber) {
        for (int i = 0; i < this.count; i++) {
            if (this.accList[i].getAccountNumber() == accNumber) {
                return this.accList[i];
            }
        }
        return null; // không tìm thấy tài khoản
    }
    
    // Phương thức xóa tài khoản theo số TK
    public boolean removeAccountByNumber(int accNumber) {
        for (int i = 0; i < this.count; i++) {
            if (this.accList[i].getAccountNumber() == accNumber) {
                // Di chuyển tất cả các phần tử bên phải của mảng lên 1 vị trí
                for (int j = i; j < this.count - 1; j++) {
                    this.accList[j] = this.accList[j+1];
                }
                this.accList[--count] = null; // giảm số lượng tài khoản và gán giá trị null cho phần tử cuối cùng
                return true;
            }
        }
        return false; // không tìm thấy tài khoản
    }
    
    // Phương thức tính số lượng tài khoản trong danh sách
    public int getNumberOfAccounts() {
        return this.count;
    }
    
    // Phương thức in thông tin toàn bộ tài khoản trong danh sách
    public void printAllAccounts() {
        for (int i = 0; i < this.count; i++) {
            System.out.println(this.accList[i].toString());
        }
    }

    public Account findAccount(String accNum) {
        for (int i = 0; i < count; i++) {
            if (accList[i].getAccNum().equals(accNum)) {
                return accList[i];
            }
        }
        return null;
    }

    public boolean removeAccount(String accNum) {
        for (int i = 0; i < count; i++) {
            if (accList[i].getAccNum().equals(accNum)) {
                accList[i] = accList[count - 1];
                count--;
                return true;
            }
        }
        return false;
    }

    public int countAccounts() {
        return count;
    }

    public boolean transfer(String sourceAccNum, String destAccNum, double amount) {
        Account sourceAcc = findAccount(sourceAccNum);
        Account destAcc = findAccount(destAccNum);
        return sourceAcc != null && destAcc != null && sourceAcc.withdraw(amount) && destAcc.deposit(amount);
    }

    public boolean withdraw(String accNum, double amount) {
        Account acc = findAccount(accNum);
        if (acc != null && acc.withdraw(amount)) {
            return true;
        }
        return false;
    }

    public boolean deposit(String accNum, double amount) {
        Account acc = findAccount(accNum);
        if (acc != null && acc.deposit(amount)) {
            return true;
        }
        return false;
    }
}
