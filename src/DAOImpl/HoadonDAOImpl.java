package DAOImpl;

import DAO.HoadonDAO;
import Model.Hoadon;
import Model.Mathang;
import Model.MathangDung;
import Model.Phonghat;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoadonDAOImpl extends BaseDAO implements HoadonDAO{

    @Override
    public void themHoadon(Hoadon hd) {
        String sql = "INSERT INTO tblHoadon VALUES ("
                + hd.getPhonghat().getMaPhonghat() + ", "
                + "'" + hd.getGioBatdau() + "', "
                + "'" + hd.getGioKetthuc() + "', "
                + hd.getThanhTien() + ", "
                + "'" + hd.getTenKhachhang() + "', "
                + "'" + hd.getNgay() + "')";
        
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(HoadonDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Hoadon> getListHoadon() {
        List<Hoadon> listHD = new ArrayList<>();
        String sql = "SELECT * FROM tblHoadon";
        
        try {
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Hoadon hd = new Hoadon();
                hd.setMaHoadon(rs.getInt("maHoadon"));
                Phonghat ph = new Phonghat();
                ph.setMaPhonghat(rs.getInt("maPhonghat"));
                hd.setPhonghat(ph);
                hd.setGioBatdau(rs.getTime("gioBatdau"));
                hd.setGioKetthuc(rs.getTime("gioKetthuc"));
                hd.setThanhTien(rs.getInt("thanhTien"));
                hd.setTenKhachhang(rs.getString("tenKhachhang"));
                hd.setNgay(rs.getDate("ngayTaoHoadon"));
                
                listHD.add(hd);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoadonDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(HoadonDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listHD;
    }

    @Override
    public List<MathangDung> getListMathangDung() {
        List<MathangDung> listMathangDung = new ArrayList<>();
        String sql = "SELECT * FROM tblMathangDung";
        
        try {
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                MathangDung mhDung = new MathangDung();
                Hoadon hd = new Hoadon();
                hd.setMaHoadon(rs.getInt("maHoadon"));
                mhDung.setHoadon(hd);
                Mathang mh = new Mathang();
                mh.setMaMathang(rs.getInt("maMathang"));
                mhDung.setMathang(mh);
                mhDung.setSoluong(rs.getInt("soluong"));
                mhDung.setThanhTien(rs.getInt("thanhTien"));
                
                listMathangDung.add(mhDung);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoadonDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(HoadonDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listMathangDung;
    }
    
}
