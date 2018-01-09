package Model;

import java.sql.Date;
import java.sql.Time;

public class Checkin {
    private Nhanvien nhanvien;
    private Date ngayCheck;
    private Time gioCheckin;
    private Time gioCheckout;
    private char trangthai;
    private int sogioPhucvu;

    public Checkin() {
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public Date getNgayCheck() {
        return ngayCheck;
    }

    public void setNgayCheck(Date ngayCheck) {
        this.ngayCheck = ngayCheck;
    }

    public Time getGioCheckin() {
        return gioCheckin;
    }

    public void setGioCheckin(Time gioCheckin) {
        this.gioCheckin = gioCheckin;
    }

    public Time getGioCheckout() {
        return gioCheckout;
    }

    public void setGioCheckout(Time gioCheckout) {
        this.gioCheckout = gioCheckout;
    }

    public char getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(char trangthai) {
        this.trangthai = trangthai;
    }

    public int getSogioPhucvu() {
        return sogioPhucvu;
    }

    public void setSogioPhucvu(int sogioPhucvu) {
        this.sogioPhucvu = sogioPhucvu;
    }
    
    
}
