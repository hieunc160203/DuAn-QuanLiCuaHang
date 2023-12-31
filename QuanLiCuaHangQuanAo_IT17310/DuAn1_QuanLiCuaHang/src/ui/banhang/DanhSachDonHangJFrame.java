/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.banhang;

import dao.HoaDonChiTietDAO;
import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.SanPhamDAO;
import helper.DateHelper;
import helper.ShareHelper;
import helper.jdbcHelper;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.KhachHang;
import model.SanPham;

/**
 *
 * @author Administrator
 */
public class DanhSachDonHangJFrame extends javax.swing.JFrame {

    /**
     * Creates new form DanhSachDonHangJFrame
     */
    public DanhSachDonHangJFrame() {
        initComponents();
        setTitle("Danh sách đơn hàng");
        setResizable(false);
        setLocationRelativeTo(null);
        hienThongTin();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_CotTrai = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_DanhSachHoaDon = new javax.swing.JTable();
        lbl_DanhSachDonHang = new javax.swing.JLabel();
        pnl_CotPhai = new javax.swing.JPanel();
        lbl_ThongTinChiTiet = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ChiTietDonHang = new javax.swing.JTable();
        lbl_TongCong = new javax.swing.JLabel();
        txt_TongCong = new javax.swing.JTextField();
        lbl_ChietKhau = new javax.swing.JLabel();
        txt_ChietKhau = new javax.swing.JTextField();
        lbl_VAT = new javax.swing.JLabel();
        txt_VAT = new javax.swing.JTextField();
        lbl_TongThanhToan = new javax.swing.JLabel();
        txt_TongThanhToan = new javax.swing.JTextField();
        btn_InHoaDon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DANH SÁCH ĐƠN HÀNG");
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 768));

        pnl_CotTrai.setBackground(new java.awt.Color(255, 255, 255));

        tbl_DanhSachHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_DanhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Mã hoá đơn", "Khách hàng", "Ngày bán", "Giá trị"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_DanhSachHoaDon.setRowHeight(35);
        tbl_DanhSachHoaDon.setRowMargin(3);
        tbl_DanhSachHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DanhSachHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_DanhSachHoaDon);

        lbl_DanhSachDonHang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_DanhSachDonHang.setForeground(new java.awt.Color(0, 0, 153));
        lbl_DanhSachDonHang.setText("DANH SÁCH ĐƠN HÀNG");

        pnl_CotPhai.setBackground(new java.awt.Color(204, 204, 255));

        lbl_ThongTinChiTiet.setBackground(new java.awt.Color(0, 0, 204));
        lbl_ThongTinChiTiet.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_ThongTinChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ThongTinChiTiet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ThongTinChiTiet.setText("   THÔNG TIN CHI TIẾT");
        lbl_ThongTinChiTiet.setOpaque(true);

        tbl_ChiTietDonHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_ChiTietDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ChiTietDonHang.setRowHeight(35);
        tbl_ChiTietDonHang.setRowMargin(3);
        jScrollPane1.setViewportView(tbl_ChiTietDonHang);

        lbl_TongCong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_TongCong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_TongCong.setText("Tổng cộng:");

        txt_TongCong.setEditable(false);
        txt_TongCong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_TongCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TongCongActionPerformed(evt);
            }
        });

        lbl_ChietKhau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_ChietKhau.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_ChietKhau.setText("Chiết khấu:");

        txt_ChietKhau.setEditable(false);
        txt_ChietKhau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbl_VAT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_VAT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_VAT.setText("VAT:");

        txt_VAT.setEditable(false);
        txt_VAT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lbl_TongThanhToan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_TongThanhToan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_TongThanhToan.setText("Tổng thanh toán:");

        txt_TongThanhToan.setEditable(false);
        txt_TongThanhToan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btn_InHoaDon.setBackground(new java.awt.Color(51, 51, 255));
        btn_InHoaDon.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn_InHoaDon.setForeground(new java.awt.Color(255, 51, 51));
        btn_InHoaDon.setText("IN HOÁ ĐƠN");
        btn_InHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_InHoaDonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_InHoaDonMouseExited(evt);
            }
        });
        btn_InHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_CotPhaiLayout = new javax.swing.GroupLayout(pnl_CotPhai);
        pnl_CotPhai.setLayout(pnl_CotPhaiLayout);
        pnl_CotPhaiLayout.setHorizontalGroup(
            pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CotPhaiLayout.createSequentialGroup()
                .addGroup(pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_CotPhaiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_CotPhaiLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_InHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnl_CotPhaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_ThongTinChiTiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_CotPhaiLayout.createSequentialGroup()
                        .addGroup(pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_VAT)
                            .addComponent(lbl_ChietKhau)
                            .addComponent(lbl_TongCong)
                            .addComponent(lbl_TongThanhToan))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ChietKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(txt_TongThanhToan)
                            .addComponent(txt_VAT)
                            .addComponent(txt_TongCong))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnl_CotPhaiLayout.setVerticalGroup(
            pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CotPhaiLayout.createSequentialGroup()
                .addComponent(lbl_ThongTinChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_TongCong)
                    .addComponent(txt_TongCong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ChietKhau)
                    .addComponent(txt_ChietKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_VAT)
                    .addComponent(txt_VAT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_TongThanhToan)
                    .addComponent(txt_TongThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_InHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_CotTraiLayout = new javax.swing.GroupLayout(pnl_CotTrai);
        pnl_CotTrai.setLayout(pnl_CotTraiLayout);
        pnl_CotTraiLayout.setHorizontalGroup(
            pnl_CotTraiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CotTraiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_CotTraiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                    .addGroup(pnl_CotTraiLayout.createSequentialGroup()
                        .addComponent(lbl_DanhSachDonHang)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_CotPhai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_CotTraiLayout.setVerticalGroup(
            pnl_CotTraiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CotTraiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_DanhSachDonHang)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnl_CotPhai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_CotTrai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_CotTrai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_InHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_InHoaDonMouseEntered
        // TODO add your handling code here:
        btn_InHoaDon.setBackground(Color.yellow);
        btn_InHoaDon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_InHoaDon.setForeground(Color.blue);
    }//GEN-LAST:event_btn_InHoaDonMouseEntered

    private void btn_InHoaDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_InHoaDonMouseExited
        // TODO add your handling code here:
        btn_InHoaDon.setBackground(new Color(51, 51, 255));
        btn_InHoaDon.setForeground(Color.red);
    }//GEN-LAST:event_btn_InHoaDonMouseExited

    private void tbl_DanhSachHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DanhSachHoaDonMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            timHoaDonChiTiet();
        }
    }//GEN-LAST:event_tbl_DanhSachHoaDonMouseClicked

    private void txt_TongCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TongCongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TongCongActionPerformed

    private void btn_InHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InHoaDonActionPerformed
        HashMap HoaDon = null;
        try {
            // TODO add your handling code here:
            jdbcHelper.inHoaDon(HoaDon);
        } catch (Exception ex) {
            Logger.getLogger(DanhSachDonHangJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_InHoaDonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DanhSachDonHangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachDonHangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachDonHangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachDonHangJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DanhSachDonHangJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_InHoaDon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_ChietKhau;
    private javax.swing.JLabel lbl_DanhSachDonHang;
    private javax.swing.JLabel lbl_ThongTinChiTiet;
    private javax.swing.JLabel lbl_TongCong;
    private javax.swing.JLabel lbl_TongThanhToan;
    private javax.swing.JLabel lbl_VAT;
    private javax.swing.JPanel pnl_CotPhai;
    private javax.swing.JPanel pnl_CotTrai;
    private javax.swing.JTable tbl_ChiTietDonHang;
    private javax.swing.JTable tbl_DanhSachHoaDon;
    private javax.swing.JTextField txt_ChietKhau;
    private javax.swing.JTextField txt_TongCong;
    private javax.swing.JTextField txt_TongThanhToan;
    private javax.swing.JTextField txt_VAT;
    // End of variables declaration//GEN-END:variables
    
    HoaDonDAO HoaDonDAO = new HoaDonDAO();
    HoaDonChiTietDAO HDCTDAO = new HoaDonChiTietDAO();
    KhachHangDAO KhachHangDAO = new KhachHangDAO();
    SanPhamDAO SanPhamDAO = new SanPhamDAO();
    public static List<HoaDon> listHD = null;
    
    /*
     * Hàm hiện thông tin hoá đơn đã xuất trong ngày
     */
    void hienThongTin(){
        try {
            listHD = HoaDonDAO.timDonHangTrongNgay(ShareHelper.NguoiDung.getTenDangNhap());
            doDanhSachHoaDon(listHD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có lỗi: " + e.toString());
        }
        
    }

    /*
     * Hàm đổ dữ liệu vào tbl_DanhSachHoaDon 
     */
    void doDanhSachHoaDon(List<HoaDon> listHD) throws SQLException{
        DefaultTableModel dtm = (DefaultTableModel) tbl_DanhSachHoaDon.getModel();
        dtm.setRowCount(0);
        int STT = 1;
        for (int i = 0; i < listHD.size(); i++) {
            KhachHang KH = KhachHangDAO.timKhachHangTheoMa(listHD.get(i).getMaKhachHang());
            Object[] row = {
                STT,
                listHD.get(i).getMaHoaDon(),
                KH.getHoTen(),
                DateHelper.toString(listHD.get(i).getNgayBan(), "dd-MM-yyyy"),
                listHD.get(i).getThanhTien()};
            dtm.addRow(row);
            STT++;
        }
    }
    
    /*
     * Hàm tìm hoá đơn chi tiết theo mã hoá đơn chọn từ tbl_DanhSachHoaDon
           sau đó đổ thông tin vào tbl_ChiTietHoaDon
           và đổ các thông tin chi tiết của hoá đơn vào textfield
     */
    void timHoaDonChiTiet() {
        try {
            int index = tbl_DanhSachHoaDon.getSelectedRow();
            String MaHoaDon = tbl_DanhSachHoaDon.getValueAt(index, 1).toString();
            for (HoaDon HD : listHD) {
                if (HD.getMaHoaDon().equals(MaHoaDon)) {
                    txt_ChietKhau.setText(HD.getChietKhau() + "");
                    txt_VAT.setText(HD.getVAT() + "");
                    txt_TongThanhToan.setText(HD.getThanhTien() + "");
                    break;
                }
            }
            List<HoaDonChiTiet> ListHDCT = HDCTDAO.timDanhSachHDCT(MaHoaDon);
            DefaultTableModel dtm = (DefaultTableModel) tbl_ChiTietDonHang.getModel();
            dtm.setRowCount(0);
            int STT = 1;
            float TongThanhTien = 0;
            for(HoaDonChiTiet HDCT : ListHDCT){
                SanPham SP = SanPhamDAO.timTheoMaSP(HDCT.getMaSanPham());
                Object[] row = {STT,
                                HDCT.getMaSanPham(),
                                SP.getTenSanPham(),
                                HDCT.getSoLuong(),
                                HDCT.getDonGia(),
                                HDCT.getThanhTien()};
                TongThanhTien += HDCT.getThanhTien();
                dtm.addRow(row);
                STT++;
            }
            txt_TongCong.setText(TongThanhTien + "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có lỗi: " + e.toString());
        }
    }
}

