package Controller;

import Model.Hoadon;
import Model.MathangDung;
import java.util.List;

public interface ThongkeController {
    public List<Hoadon> getListHoadon();
    
    public List<MathangDung> getListMathangDung();
}
