package Model;

import java.sql.Date;
import java.sql.Time;

public class Hoadon {

    private int maHoadon;
    private Phonghat phonghat;
    private Time gioBatdau;
    private Time gioKetthuc;
    private int thanhTien;
    private String tenKhachhang;
    private Date ngay;

    public Hoadon() {
    }

    public int getMaHoadon() {
        return maHoadon;
    }

    public void setMaHoadon(int maHoadon) {
        this.maHoadon = maHoadon;
    }

    public Phonghat getPhonghat() {
        return phonghat;
    }

    public void setPhonghat(Phonghat phonghat) {
        this.phonghat = phonghat;
    }

    public String getTenKhachhang() {
        return tenKhachhang;
    }

    public void setTenKhachhang(String tenKhachhang) {
        this.tenKhachhang = tenKhachhang;
    }

    public Time getGioBatdau() {
        return gioBatdau;
    }

    public void setGioBatdau(Time gioBatdau) {
        this.gioBatdau = gioBatdau;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Time getGioKetthuc() {
        return gioKetthuc;
    }

    public void setGioKetthuc(Time gioKetthuc) {
        this.gioKetthuc = gioKetthuc;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    
}
