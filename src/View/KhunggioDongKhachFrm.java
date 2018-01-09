package View;

import Controller.ThongkeController;
import ControllerImpl.ThongkeControllerImpl;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Model.ChitietHoadonTong;
import Model.HoadonTong;
import Model.Hoadon;
import Model.MathangDung;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KhunggioDongKhachFrm extends javax.swing.JFrame {

    private ThongkeController ctrl;
    private DefaultTableModel defaultTableModel;
    private List<ChitietHoadonTong> listChitietHDT;
    private List<Hoadon> listHD;
    private List<MathangDung> listMHD;
    private List<HoadonTong> listHoadonTong;

    public KhunggioDongKhachFrm() {
        initComponents();

        ctrl = new ThongkeControllerImpl();
        defaultTableModel = (DefaultTableModel) tblThongke.getModel();
        tblThongke.setModel(defaultTableModel);

        listChitietHDT = new ArrayList<>();
        listHD = new ArrayList<>();
        listMHD = new ArrayList<>();
        listHoadonTong = new ArrayList<>();

        getlistChitietHDTong();
        loadHDTong();
    }

    private void getlistChitietHDTong() {
        listHD = ctrl.getListHoadon();
        listMHD = ctrl.getListMathangDung();

        for (Hoadon hd : listHD) {
            int tongtien = hd.getThanhTien();
            ChitietHoadonTong hdTong = new ChitietHoadonTong();
            hdTong.setMaHoadon(hd.getMaHoadon());
            hdTong.setGioBatdau(hd.getGioBatdau());
            hdTong.setGioKetthuc(hd.getGioKetthuc());
            hdTong.setTenKH(hd.getTenKhachhang());
            hdTong.setNgayTaoHD(hd.getNgay());
            for (MathangDung mhDung : listMHD) {
                if (mhDung.getHoadon().getMaHoadon() == hd.getMaHoadon()) {
                    tongtien += mhDung.getThanhTien();
                }
            }
            hdTong.setTongtien(tongtien);
            listChitietHDT.add(hdTong);
        }
    }

    private void loadHDTong() {
        // i la gio, chay theo khung gio
        for (int i = 0; i < 24; i++) {
            int songuoi = 0;
            int tongtien = 0;
            for (ChitietHoadonTong chitietHdTong : listChitietHDT) {
                // neu van be hon 23h
                if (i < 23) {
                    // so sanh khung gio tu i -> i+1
                    // neu gio bat dau < gio ket thuc thi hat trong ngay
                    if (chitietHdTong.getGioBatdau().getHours()
                            <= chitietHdTong.getGioKetthuc().getHours()) {
                        if (chitietHdTong.getGioBatdau().getHours() <= i
                                && chitietHdTong.getGioKetthuc().getHours() >= i + 1) {
                            songuoi++;
                            tongtien += chitietHdTong.getTongtien();
                        }
                    } else {
                        if (chitietHdTong.getGioBatdau().getHours() <= i
                                && chitietHdTong.getGioKetthuc().getHours() <= i + 1) {
                            songuoi++;
                            tongtien += chitietHdTong.getTongtien();
                        } else if (chitietHdTong.getGioBatdau().getHours() >= i
                                && chitietHdTong.getGioKetthuc().getHours() >= i + 1) {
                            songuoi++;
                            tongtien += chitietHdTong.getTongtien();
                        }
                    }

                } else {
                    // tu 23h -> 0h
                    if (chitietHdTong.getGioBatdau().getHours()
                            <= chitietHdTong.getGioKetthuc().getHours()) {
                        if (chitietHdTong.getGioBatdau().getHours() <= i
                                && chitietHdTong.getGioKetthuc().getHours() == 0) {
                            songuoi++;
                            tongtien += chitietHdTong.getTongtien();
                        }
                    } else {
                        if (chitietHdTong.getGioBatdau().getHours() <= i
                                && chitietHdTong.getGioKetthuc().getHours() >= 0) {
                            songuoi++;
                            tongtien += chitietHdTong.getTongtien();
                        }
                    }
                }

            }
            HoadonTong hdTong = new HoadonTong();
            hdTong.setGio(i);
            hdTong.setSonguoi(songuoi);
            hdTong.setTongtien(tongtien);
            listHoadonTong.add(hdTong);
            
        }

        Collections.sort(listHoadonTong, new Comparator<HoadonTong>() {
            @Override
            public int compare(HoadonTong o1, HoadonTong o2) {
                if(o1.getSonguoi() < o2.getSonguoi())
                    return 1;
                else if(o1.getSonguoi() > o2.getSonguoi())
                    return -1;
                else {
                    if(o1.getTongtien() < o2.getTongtien())
                        return 1;
                    else if(o1.getTongtien() > o2.getTongtien())
                        return -1;
                    else
                        return 0;
                }
            }
        });
        int stt = 0;
        for(HoadonTong hdTong : listHoadonTong){
            defaultTableModel.addRow(new Object[]{
                ++stt,
                hdTong.getGio() + "h -> " + (hdTong.getGio()+1) + "h",
                hdTong.getSonguoi(),
                hdTong.getTongtien()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongke = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblThongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Khung giờ", "Tổng số lượt khách dùng phòng", "Tổng số tiền thu được"
            }
        ));
        tblThongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongkeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThongke);

        jButton1.setText("Quay về");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblThongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongkeMouseClicked
        // TODO add your handling code here:
        int row = tblThongke.rowAtPoint(evt.getPoint());
        String khunggio = (String) tblThongke.getValueAt(row, 1);
        
        // cat khung gio trong bang thanh gio
        int dem = 0;
        for(int i = 0; i < khunggio.length(); i++){
            if(khunggio.charAt(i) == 'h'){
                break;
            }
            dem++;
        }
        int gio = Integer.parseInt(khunggio.substring(0, dem));
        ChitietKhunggioFrm frm = new ChitietKhunggioFrm(gio, listChitietHDT);
        frm.setVisible(true);
    }//GEN-LAST:event_tblThongkeMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThongke;
    // End of variables declaration//GEN-END:variables
}
