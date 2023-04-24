
import java.text.NumberFormat;

public class Account        
        {
    private String accNum;
    private double balance;
    private long STK;
    private String tenTK;
    private double soTienTrongTK;
    private String trangThai;
    java.util.Scanner sc = new java.util.Scanner(System.in);
    
    public Account(long STK, String tenTK, double soTienTrongTK, String trangThai) 
    {
        this(tenTK, trangThai, soTienTrongTK);
    }

    public Account(String tenTK, String trangThai, double soTienTrongTK) {
        this.STK = STK;
        this.tenTK = tenTK;
        this.soTienTrongTK = soTienTrongTK;
        this.trangThai = trangThai;
         this.accNum = accNum;
        this.balance = balance;
    }
       public Account() {
        this(999999, "chưa xác định", 50,"chưa xác định");
    }

    public long getSTK() {
        return STK;
    }

    public void setSTK(int STK) {
        if (STK > 0 && STK <= 999999) {
            this.STK = STK;
        } else {
            this.STK = 999999;
            setTrangThai("Số tài khoản phải nằm trong khoảng từ 1 đến 999999. Đặt giá trị mặc định.");
        }
    }

    public String gettenTK() {
        return tenTK;
    }

    public final void settenTK(String tenTK) {
        if ( tenTK.isEmpty()) {
            this.tenTK = tenTK;
        } else {
            this.tenTK = "chưa xác định";
            setTrangThai("Tên tài khoản rỗng. Đặt giá trị mặc định.");
        }
    }

    public double getSoTienTrongTK() {
        return 0;
    }

    /**
     *
     * @param i
     * @param soTienTrongTK
     */
    public void setsoTienTrongTK(int i,double soTienTrongTK) { 
        setsoTienTrongTK(soTienTrongTK);
    }

    /**
     *
     * @param soTienTrongTK
     */
    public void setsoTienTrongTK(double soTienTrongTK) {
        if (50 < soTienTrongTK) {
            this.soTienTrongTK = soTienTrongTK;
        } else {
            this.soTienTrongTK = 50;
            setTrangThai("Số dư phải lớn hơn hoặc bằng 50. Đặt giá trị mặc định.");
        }
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    

    public String gettrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
@Override
    public String toString() 
    {
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        return STK + "-" + tenTK + "-" + str1 + "-" + trangThai;
    }
 
    public double napTien() 
    {
        double nap;
        System.out.print("Nhap So Tien Can Nap: ");
        nap = sc.nextDouble();
        if (nap >= 0) 
        {
            soTienTrongTK = nap + soTienTrongTK;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(nap);
            System.out.println("Da Nap " + str1 + " Vao Tai Khoan");
        } 
        else 
        {
            System.out.println("So Tien Can Nap Khong Hop Ly!");
        }
        return nap;
    }
 
    public double rutTien() 
    {
        double rut;
        System.out.print("Nhap So Tien Can Rut Ra: ");
        rut = sc.nextDouble();
        if (rut <= soTienTrongTK) 
        {
            soTienTrongTK = soTienTrongTK - rut;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(rut);
            System.out.println("Da Rut " + str1 + "Đ Tu Tai Khoan "+ STK);
        } 
        else 
        {
            System.out.println("So Tien Muon Rut Khong Hop Ly!");
            return rutTien();
        }
        return rut;
    }
 
    public double daoHan() 
    {
        double laiSuat = 0.035;
        soTienTrongTK = soTienTrongTK + soTienTrongTK * laiSuat;
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        System.out.println("Da Duoc " + str1 + " Tu Dao Han 1 Thang");
        return soTienTrongTK;
    }

void inTK() 
    {
NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        System.out.printf("%-10d %-20s %-20s \n", STK, tenTK, str1);
    }


    public int getAccountNumber() {
        return Integer.parseInt(accNum);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    public Object getAccNum() {
        return accNum;
    }
}
