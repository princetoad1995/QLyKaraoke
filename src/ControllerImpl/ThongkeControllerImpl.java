package ControllerImpl;

import Controller.ThongkeController;
import DAO.HoadonDAO;
import DAOImpl.HoadonDAOImpl;
import Model.Hoadon;
import Model.MathangDung;
import java.util.List;

public class ThongkeControllerImpl implements ThongkeController{

    @Override
    public List<Hoadon> getListHoadon() {
        HoadonDAO hdDAO = new HoadonDAOImpl();
        return hdDAO.getListHoadon();
    }

    @Override
    public List<MathangDung> getListMathangDung() {
        HoadonDAO hdDAO = new HoadonDAOImpl();
        return hdDAO.getListMathangDung();
    }
    
}
