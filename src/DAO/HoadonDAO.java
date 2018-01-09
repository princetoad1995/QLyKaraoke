/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Hoadon;
import Model.MathangDung;
import java.util.List;

/**
 *
 * @author PRINCE D. TOAD
 */
public interface HoadonDAO {
    public void themHoadon(Hoadon hd);
    
    public List<Hoadon> getListHoadon();
    
    public List<MathangDung> getListMathangDung();
}
