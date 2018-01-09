package Model;

import java.sql.Date;
import java.sql.Time;

public class ChitietHoadonTong {
    private int maHoadon;
    private Time gioBatdau;
    private Time gioKetthuc;
    private int tongtien;
    private String tenKH;
    private Date ngayTaoHD;

    public ChitietHoadonTong() {
    }

    public int getMaHoadon() {
        return maHoadon;
    }

    public void setMaHoadon(int maHoadon) {
        this.maHoadon = maHoadon;
    }

    public Time getGioBatdau() {
        return gioBatdau;
    }

    public void setGioBatdau(Time gioBatdau) {
        this.gioBatdau = gioBatdau;
    }

    public Time getGioKetthuc() {
        return gioKetthuc;
    }

    public void setGioKetthuc(Time gioKetthuc) {
        this.gioKetthuc = gioKetthuc;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Date getNgayTaoHD() {
        return ngayTaoHD;
    }

    public void setNgayTaoHD(Date ngayTaoHD) {
        this.ngayTaoHD = ngayTaoHD;
    }
    
    
}
