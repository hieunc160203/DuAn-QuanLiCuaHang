/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.quanly.sanpham;

import dao.DonViTinhDAO;
import dao.NhomHangDAO;
import dao.PhieuKiemChiTietDAO;
import dao.PhieuKiemDAO;
import dao.SanPhamDAO;
import helper.DateHelper;
import helper.DialogHelper;
import helper.ShareHelper;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.text.DecimalFormat;
import java.util.List;
import java.util.TreeMap;
import javax.swing.table.DefaultTableModel;
import model.DonViTinh;
import model.PhieuKiem;
import model.PhieuKiemChiTiet;
import model.SanPham;

/**
 *
 * @author Admin
 */
public class CapNhatPhieuKiemJFrame extends javax.swing.JFrame {

    private static PhieuKiem PK;
    
    /**
     * Creates new form CapNhatPhieuKiemJFrame
     * @param PhieuKiem - đối tượng phiếu kiểm kê
     */
    public CapNhatPhieuKiemJFrame(PhieuKiem PhieuKiem) {
        initComponents();
        this.PK = PhieuKiem;
        inIt();
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
        tab_ChiTietPhieu = new javax.swing.JTabbedPane();
        pnl_DonHang = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_ChiTietPhieuKiem = new javax.swing.JTable();
        btn_CapNhatDanhSach = new javax.swing.JButton();
        btn_XoaDanhSach = new javax.swing.JButton();
        pnl_DanhSachSanPham = new javax.swing.JPanel();
        cmb_NhomHang = new javax.swing.JComboBox<>();
        txt_TimKiemSanPham = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_DanhSachSanPham = new javax.swing.JTable();
        pnl_CotPhai = new javax.swing.JPanel();
        btn_CanBang = new javax.swing.JButton();
        btn_LuuTam = new javax.swing.JButton();
        lbl_MaChungTu = new javax.swing.JLabel();
        txt_MaChungTu = new javax.swing.JTextField();
        lbl_NgayTao = new javax.swing.JLabel();
        dat_NgayTao = new com.toedter.calendar.JDateChooser();
        lbl_NgayCanBang = new javax.swing.JLabel();
        dat_NgayCanBang = new com.toedter.calendar.JDateChooser();
        lbl_GhiChu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_GhiChu = new javax.swing.JTextArea();
        lbl_GiaTriLech = new javax.swing.JLabel();
        txt_GiaTriLech = new javax.swing.JTextField();
        lbl_MaNhanVien = new javax.swing.JLabel();
        txt_MaNhanVien = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CẬP NHẬT PHIẾU KIỂM");
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 768));

        pnl_CotTrai.setBackground(new java.awt.Color(255, 255, 255));

        tab_ChiTietPhieu.setBackground(new java.awt.Color(204, 255, 204));
        tab_ChiTietPhieu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        pnl_DonHang.setBackground(new java.awt.Color(204, 204, 255));
        pnl_DonHang.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(153, 153, 153)));

        tbl_ChiTietPhieuKiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_ChiTietPhieuKiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Mã SP", "Tên sản phẩm", "ĐVT", "Giá vốn", "Tồn kho", "Thực tế", "SL lệch", "Giá trị lệch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ChiTietPhieuKiem.setRowHeight(35);
        tbl_ChiTietPhieuKiem.setRowMargin(3);
        tbl_ChiTietPhieuKiem.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbl_ChiTietPhieuKiemPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_ChiTietPhieuKiem);

        btn_CapNhatDanhSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refreshGioHang.png"))); // NOI18N
        btn_CapNhatDanhSach.setToolTipText("Cập nhật lại phiếu kiểm");
        btn_CapNhatDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_CapNhatDanhSachMouseEntered(evt);
            }
        });
        btn_CapNhatDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatDanhSachActionPerformed(evt);
            }
        });

        btn_XoaDanhSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/removeGioHang.png"))); // NOI18N
        btn_XoaDanhSach.setToolTipText("Xoá các sản phẩm trong phiếu");
        btn_XoaDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_XoaDanhSachMouseEntered(evt);
            }
        });
        btn_XoaDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaDanhSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_DonHangLayout = new javax.swing.GroupLayout(pnl_DonHang);
        pnl_DonHang.setLayout(pnl_DonHangLayout);
        pnl_DonHangLayout.setHorizontalGroup(
            pnl_DonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_DonHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_DonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_DonHangLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_XoaDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_CapNhatDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl_DonHangLayout.setVerticalGroup(
            pnl_DonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_DonHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_DonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_CapNhatDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_XoaDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        tab_ChiTietPhieu.addTab("Chi tiết phiếu", pnl_DonHang);

        pnl_DanhSachSanPham.setBackground(new java.awt.Color(255, 255, 204));
        pnl_DanhSachSanPham.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 153, 153)));

        cmb_NhomHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmb_NhomHang.setMaximumRowCount(20);

        txt_TimKiemSanPham.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tbl_DanhSachSanPham.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_DanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Mã sản phẩm", "Tên sản phẩm", "Tồn kho", "Giá vốn", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_DanhSachSanPham.setRowHeight(35);
        tbl_DanhSachSanPham.setRowMargin(3);
        jScrollPane3.setViewportView(tbl_DanhSachSanPham);

        javax.swing.GroupLayout pnl_DanhSachSanPhamLayout = new javax.swing.GroupLayout(pnl_DanhSachSanPham);
        pnl_DanhSachSanPham.setLayout(pnl_DanhSachSanPhamLayout);
        pnl_DanhSachSanPhamLayout.setHorizontalGroup(
            pnl_DanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_DanhSachSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_DanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_DanhSachSanPhamLayout.createSequentialGroup()
                        .addComponent(cmb_NhomHang, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_TimKiemSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_DanhSachSanPhamLayout.setVerticalGroup(
            pnl_DanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_DanhSachSanPhamLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnl_DanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmb_NhomHang)
                    .addComponent(txt_TimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tab_ChiTietPhieu.addTab("Danh sách sản phẩm", pnl_DanhSachSanPham);

        javax.swing.GroupLayout pnl_CotTraiLayout = new javax.swing.GroupLayout(pnl_CotTrai);
        pnl_CotTrai.setLayout(pnl_CotTraiLayout);
        pnl_CotTraiLayout.setHorizontalGroup(
            pnl_CotTraiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CotTraiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab_ChiTietPhieu)
                .addContainerGap())
        );
        pnl_CotTraiLayout.setVerticalGroup(
            pnl_CotTraiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CotTraiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab_ChiTietPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_CanBang.setBackground(new java.awt.Color(255, 51, 0));
        btn_CanBang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_CanBang.setForeground(new java.awt.Color(255, 255, 255));
        btn_CanBang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconBalance.png"))); // NOI18N
        btn_CanBang.setText("CÂN BẰNG");
        btn_CanBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_CanBangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_CanBangMouseExited(evt);
            }
        });
        btn_CanBang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CanBangActionPerformed(evt);
            }
        });

        btn_LuuTam.setBackground(new java.awt.Color(51, 51, 255));
        btn_LuuTam.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_LuuTam.setForeground(new java.awt.Color(255, 255, 255));
        btn_LuuTam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconTemp.png"))); // NOI18N
        btn_LuuTam.setText("LƯU TẠM");
        btn_LuuTam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_LuuTamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_LuuTamMouseExited(evt);
            }
        });
        btn_LuuTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuTamActionPerformed(evt);
            }
        });

        lbl_MaChungTu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_MaChungTu.setText("Mã chứng từ");

        txt_MaChungTu.setEditable(false);
        txt_MaChungTu.setBackground(new java.awt.Color(255, 255, 204));
        txt_MaChungTu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_MaChungTu.setFocusable(false);
        txt_MaChungTu.setRequestFocusEnabled(false);

        lbl_NgayTao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_NgayTao.setText("Ngày tạo");

        dat_NgayTao.setDateFormatString("dd-MM-yyyy");
        dat_NgayTao.setEnabled(false);
        dat_NgayTao.setFocusable(false);
        dat_NgayTao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dat_NgayTao.setRequestFocusEnabled(false);

        lbl_NgayCanBang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_NgayCanBang.setText("Ngày cân bằng");

        dat_NgayCanBang.setDateFormatString("dd-MM-yyyy");
        dat_NgayCanBang.setEnabled(false);
        dat_NgayCanBang.setFocusable(false);
        dat_NgayCanBang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dat_NgayCanBang.setRequestFocusEnabled(false);

        lbl_GhiChu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_GhiChu.setText("Ghi chú");

        txa_GhiChu.setColumns(20);
        txa_GhiChu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txa_GhiChu.setRows(5);
        jScrollPane1.setViewportView(txa_GhiChu);

        lbl_GiaTriLech.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_GiaTriLech.setText("Giá trị lệch");

        txt_GiaTriLech.setEditable(false);
        txt_GiaTriLech.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_GiaTriLech.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_GiaTriLech.setText("0");

        lbl_MaNhanVien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_MaNhanVien.setText("Mã nhân viên");

        txt_MaNhanVien.setEditable(false);
        txt_MaNhanVien.setBackground(new java.awt.Color(255, 255, 204));
        txt_MaNhanVien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_MaNhanVien.setFocusable(false);
        txt_MaNhanVien.setRequestFocusEnabled(false);

        javax.swing.GroupLayout pnl_CotPhaiLayout = new javax.swing.GroupLayout(pnl_CotPhai);
        pnl_CotPhai.setLayout(pnl_CotPhaiLayout);
        pnl_CotPhaiLayout.setHorizontalGroup(
            pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CotPhaiLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_GiaTriLech, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dat_NgayTao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_MaChungTu, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dat_NgayCanBang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_MaNhanVien, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(lbl_MaNhanVien)
                    .addGroup(pnl_CotPhaiLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btn_LuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_CanBang, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_GiaTriLech)
                    .addComponent(lbl_GhiChu)
                    .addComponent(lbl_NgayCanBang)
                    .addComponent(lbl_NgayTao)
                    .addComponent(lbl_MaChungTu))
                .addGap(14, 14, 14))
        );
        pnl_CotPhaiLayout.setVerticalGroup(
            pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_CotPhaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_MaNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_MaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_MaChungTu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_MaChungTu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_NgayTao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dat_NgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_NgayCanBang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dat_NgayCanBang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_GiaTriLech)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_GiaTriLech, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_GhiChu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(pnl_CotPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_LuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_CanBang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnl_CotTrai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_CotPhai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_CotTrai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_CotPhai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LuuTamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LuuTamMouseEntered
        // TODO add your handling code here:
        btn_LuuTam.setBackground(Color.yellow);
        btn_LuuTam.setForeground(Color.blue);
        btn_LuuTam.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_LuuTamMouseEntered

    private void btn_LuuTamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LuuTamMouseExited
        // TODO add your handling code here:
        btn_LuuTam.setBackground(new Color(51, 51, 255));
        btn_LuuTam.setForeground(Color.white);
    }//GEN-LAST:event_btn_LuuTamMouseExited

    private void btn_LuuTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuTamActionPerformed
        // TODO add your handling code here:
        luuTam();
    }//GEN-LAST:event_btn_LuuTamActionPerformed

    private void btn_CanBangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CanBangMouseEntered
        // TODO add your handling code here:
        btn_CanBang.setBackground(Color.yellow);
        btn_CanBang.setForeground(Color.blue);
        btn_CanBang.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_CanBangMouseEntered

    private void btn_CanBangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CanBangMouseExited
        // TODO add your handling code here:
        btn_CanBang.setBackground(new Color(255, 51, 0));
        btn_CanBang.setForeground(Color.white);
    }//GEN-LAST:event_btn_CanBangMouseExited

    private void btn_CanBangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CanBangActionPerformed
        // TODO add your handling code here:
        capnhatPhieuCanBang();
    }//GEN-LAST:event_btn_CanBangActionPerformed

    private void tbl_ChiTietPhieuKiemPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbl_ChiTietPhieuKiemPropertyChange
        // TODO add your handling code here:
        try {
            nhapSoLuongThucTe();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tbl_ChiTietPhieuKiemPropertyChange

    private void btn_CapNhatDanhSachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CapNhatDanhSachMouseEntered
        // TODO add your handling code here:
        btn_CapNhatDanhSach.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_CapNhatDanhSachMouseEntered

    private void btn_XoaDanhSachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaDanhSachMouseEntered
        // TODO add your handling code here:
        btn_XoaDanhSach.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_XoaDanhSachMouseEntered

    private void btn_CapNhatDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatDanhSachActionPerformed
        // TODO add your handling code here:
        nhapSoLuongThucTe();
    }//GEN-LAST:event_btn_CapNhatDanhSachActionPerformed

    private void btn_XoaDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaDanhSachActionPerformed
        // TODO add your handling code here:
        xoaDanhSachKiemKe();
    }//GEN-LAST:event_btn_XoaDanhSachActionPerformed

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
            java.util.logging.Logger.getLogger(CapNhatPhieuKiemJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapNhatPhieuKiemJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapNhatPhieuKiemJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapNhatPhieuKiemJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CapNhatPhieuKiemJFrame(PK).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CanBang;
    private javax.swing.JButton btn_CapNhatDanhSach;
    private javax.swing.JButton btn_LuuTam;
    private javax.swing.JButton btn_XoaDanhSach;
    private javax.swing.JComboBox<String> cmb_NhomHang;
    private com.toedter.calendar.JDateChooser dat_NgayCanBang;
    private com.toedter.calendar.JDateChooser dat_NgayTao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_GhiChu;
    private javax.swing.JLabel lbl_GiaTriLech;
    private javax.swing.JLabel lbl_MaChungTu;
    private javax.swing.JLabel lbl_MaNhanVien;
    private javax.swing.JLabel lbl_NgayCanBang;
    private javax.swing.JLabel lbl_NgayTao;
    private javax.swing.JPanel pnl_CotPhai;
    private javax.swing.JPanel pnl_CotTrai;
    private javax.swing.JPanel pnl_DanhSachSanPham;
    private javax.swing.JPanel pnl_DonHang;
    private javax.swing.JTabbedPane tab_ChiTietPhieu;
    private javax.swing.JTable tbl_ChiTietPhieuKiem;
    private javax.swing.JTable tbl_DanhSachSanPham;
    private javax.swing.JTextArea txa_GhiChu;
    private javax.swing.JTextField txt_GiaTriLech;
    private javax.swing.JTextField txt_MaChungTu;
    private javax.swing.JTextField txt_MaNhanVien;
    private javax.swing.JTextField txt_TimKiemSanPham;
    // End of variables declaration//GEN-END:variables

    NhomHangDAO NhomHangDAO = new NhomHangDAO();
    SanPhamDAO SanPhamDAO = new SanPhamDAO();
    DonViTinhDAO DVTDAO = new DonViTinhDAO();
    PhieuKiemDAO PhieuKiemDAO = new PhieuKiemDAO();
    PhieuKiemChiTietDAO PKCTDAO = new PhieuKiemChiTietDAO();
    
    // Định dạng hiển thị số tiền:
    DecimalFormat dcf = new DecimalFormat("###,###,###.###");
    
    // Tạo treemap chứa sản phẩm và số lượng kiểm đếm thực tế
    static TreeMap<SanPham, Integer> DSSP = new TreeMap<>();
    
    /*
     * Hàm khởi tạo các giá trị ban đầu cho JFrame
     */
    void inIt() {
        setTitle("Cập nhật phiếu kiểm");
        setResizable(false);
        setLocationRelativeTo(null);
        tab_ChiTietPhieu.setEnabledAt(1, false);
        xetTrangThai();
        doThongTin();
    }
    
    /*
     * Hàm xét trạng thái của phiếu kiểm:
          - nếu là phiếu TẠM (0): cho phép cập nhật số lượng thực tế
          - nếu là phiếu ĐÃ CÂN BẰNG (1): chỉ được xem, disable hết mọi chức năng
          - nếu là phiếu HUỶ (2): giống phiếu ĐÃ CÂN BẰNG
     */
    void xetTrangThai() {
        btn_XoaDanhSach.setEnabled(false);
        int TrangThai = PK.getTrangThai();
        if (TrangThai == 1 || TrangThai == 2) {
            btn_CanBang.setEnabled(false);
            btn_LuuTam.setEnabled(false);
            btn_CapNhatDanhSach.setEnabled(false);
            txa_GhiChu.setEnabled(false);
            tbl_ChiTietPhieuKiem.setEnabled(false);
        }
    }
    
    /*
     * Hàm đổ các thông tin mặc định 
     */
    void doThongTin() {
        try {
            // đổ mã nhân viên
            txt_MaNhanVien.setText(PK.getMaNhanVien());
            // mã phiếu kiểm
            txt_MaChungTu.setText(PK.getMaPhieuKiem());
            // ngày tạo phiếu
            dat_NgayTao.setDate(PK.getNgayTao());
            // ngày cân bằng
            if (PK.getTrangThai() == 1) {
                dat_NgayCanBang.setDate(PK.getNgayCanBang());
            }
            // giá trị lệch
            txt_GiaTriLech.setText(PK.getGiaTriLech()+"");
            // ghi chú
            txa_GhiChu.setText(PK.getGhiChu());
            // đổ thông tin dssp vào treemap
            List<PhieuKiemChiTiet> listPKCT = PKCTDAO.timDanhSachPKCT(PK.getMaPhieuKiem());
            for (PhieuKiemChiTiet PKCT : listPKCT) {
                SanPham SP = SanPhamDAO.timTheoMaSP(PKCT.getMaSanPham());
                DSSP.put(SP, PKCT.getThucTe());
            }
            capnhatDanhSachKiemKe();
        } catch (Exception e) {
            DialogHelper.alert(this, "Có lỗi: " + e.toString());
        }
    }
    
    /*
     * Hàm cập nhật danh sách kiểm kê
     */
    void capnhatDanhSachKiemKe() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_ChiTietPhieuKiem.getModel();
        dtm.setRowCount(0);
        int STT = 1;
        for (SanPham SP : DSSP.keySet()) {
            DonViTinh DVT = DVTDAO.timTheoMa(SP.getMaDVT());
            Object[] row = {STT++,
                            SP.getMaSanPham(),
                            SP.getTenSanPham(),
                            DVT.getMoTa(),
                            dcf.format(SP.getGiaVon()),
                            SP.getTonKho(),
                            DSSP.get(SP),
                            DSSP.get(SP) > -1 ? (DSSP.get(SP) - SP.getTonKho()) : -1,
                            DSSP.get(SP) > -1 ? dcf.format((DSSP.get(SP) - SP.getTonKho())*SP.getGiaVon()) : -1
                            };
            dtm.addRow(row);
        }
    }
    
    /*
     * Hàm nhập số lượng thực tế kiểm kê được vào bảng
           sau khi nhập thì cập nhật lại bảng
     */
    void nhapSoLuongThucTe() {
        try {
            int index = tbl_ChiTietPhieuKiem.getEditingRow();
            if (index >= 0) {
                String MaSP = tbl_ChiTietPhieuKiem.getValueAt(index, 1).toString();
                SanPham SP = SanPhamDAO.timTheoMaSP(MaSP);
                int SLThucTe = Integer.parseInt(tbl_ChiTietPhieuKiem.getValueAt(index, 6)+"");
                DSSP.put(SP, SLThucTe);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi nhập liệu");
        }
        finally {
            capnhatDanhSachKiemKe();
            tinhTongGiaTriLech();
        }
    }
    
    /*
     * Hàm cập nhật tổng giá trị lệch
     */
    void tinhTongGiaTriLech() {
        float TongGiaTriLech = 0;
        for (SanPham SP : DSSP.keySet()) {
            if (DSSP.get(SP) > -1)
                TongGiaTriLech += (DSSP.get(SP) - SP.getTonKho())*SP.getGiaVon();
        }
        txt_GiaTriLech.setText(TongGiaTriLech+"");
    }
    
    /*
     * Hàm xoá hết sản phẩm trong danh sách kiểm kê
     */ 
    void xoaDanhSachKiemKe() {
        DSSP.clear();
        capnhatDanhSachKiemKe();
        tinhTongGiaTriLech();
    }
    
    /*
     * Hàm check ghi chú: không được để trống, tối thiểu phải đủ 3 ký tự
     */
    boolean kiemGhiChu() {
        if(txa_GhiChu.getText().length() < 3)
            return false;
        return true;
    }
    
    /*
     * Hàm kiểm tra dssp có null hay không, null thì không được phép lưu tạm/cân bằng
     */
    boolean kiemDSSP() {
        if (DSSP.isEmpty())
            return false;
        return true;
    }
    
    /*
     * Hàm lưu tạm phiếu kiểm
           không thực hiện sửa tồn kho
     */
    void luuTam() {
        if (xetDangNhap() && kiemGhiChu() && kiemDSSP()) {
            PhieuKiem PK = taoPhieuKiem();
            PK.setTrangThai(0);
            try {
                int rs = PhieuKiemDAO.capnhatPhieuKiem(PK);
                capnhatPKCT(PK);
                if (rs > 0) {
                    DialogHelper.alert(this, "Cập nhật thành công");
                    if (capnhatFrameKiemKeSP()) {
                        this.dispose();
                        new KiemKeSanPhamJFrame().setVisible(true);
                    }
                }
                else
                    DialogHelper.alert(this, "Cập nhật thất bại");
            } catch (Exception e) {
                DialogHelper.alert(this, "Có lỗi: " + e.toString());
            }
        }
        else {
            DialogHelper.alert(this, "Kiểm tra lại các thông tin");
        }
    }
    
    /*
     * Hàm lưu phiếu kiểm và cân bằng kho
          nếu SL thực < 0 thì không cho cân bằng
     */
    void capnhatPhieuCanBang() {
        if (xetDangNhap() && kiemGhiChu() && kiemDSSP() && kiemSoLuongThucTe()) {
            PhieuKiem PK = taoPhieuKiem();
            PK.setTrangThai(1);
            PK.setNgayCanBang(DateHelper.now());
            try {
                int rs = PhieuKiemDAO.capnhatPhieuKiem(PK);
                if (rs > 0) {
                    capnhatPKCT(PK);
                    canbangTonKho();
                    DialogHelper.alert(this, "Đã thêm phiếu kiểm và cân bằng kho");
                    xoaDanhSachKiemKe();
                    if (capnhatFrameKiemKeSP()) {
                        this.dispose();
                        new KiemKeSanPhamJFrame().setVisible(true);
                    }
                }
                else
                    DialogHelper.alert(this, "Cân bằng thất bại");
            } catch (Exception e) {
                DialogHelper.alert(this, "Có lỗi: " + e.toString());
            }
        }
        else {
            DialogHelper.alert(this, "Kiểm tra lại các thông tin");
        }
    }
    
    /*
     * Hàm kiểm tra số lượng thực tế của SP trước khi cân bằng
           nếu có SP có SL '-1' (tức chưa kiểm kê) thì trả về false
     */
    boolean kiemSoLuongThucTe() {
        for (SanPham SP : DSSP.keySet()) {
            if (DSSP.get(SP) == -1)
                return false;
        }
        return true;
    }
    
    /*
     * Hàm cập nhật lại tồn kho của SP (cân bằng kho hàng)
     */
    void canbangTonKho() {
        for (SanPham SP : DSSP.keySet()) {
            SanPhamDAO.capnhatTonKho(SP.getMaSanPham(), DSSP.get(SP));
        }
    }

    /*
     * Hàm cập nhật PKCT
     */
    void capnhatPKCT(PhieuKiem PK) {
        for (SanPham SP : DSSP.keySet()) {
            DonViTinh DVT = DVTDAO.timTheoMa(SP.getMaDVT());
            PhieuKiemChiTiet PKCT = new PhieuKiemChiTiet();
            PKCT.setMaPhieuKiem(PK.getMaPhieuKiem());
            PKCT.setMaSanPham(SP.getMaSanPham());
            PKCT.setDonGia(SP.getGiaVon());
            PKCT.setDVT(DVT.getMoTa());
            PKCT.setTonKho(SP.getTonKho());
            PKCT.setThucTe(DSSP.get(SP));
            if (DSSP.get(SP) > -1) {
                PKCT.setSoLuongLech(DSSP.get(SP) - SP.getTonKho());
                PKCT.setGiaTriLech((DSSP.get(SP) - SP.getTonKho()) * SP.getGiaVon());
            } else {
                PKCT.setSoLuongLech(-1);
                PKCT.setGiaTriLech(-1);
            }
            PKCTDAO.themPKCT(PKCT);
        }
    }

    /*
     * Hàm kiểm tra đăng nhập
     */
    boolean xetDangNhap() {
        if (ShareHelper.NguoiDung != null)
            return true;
        return false;
    }
    
    /*
     * Hàm tạo model Phiếu Kiểm Kê
     */
    PhieuKiem taoPhieuKiem() {
        PhieuKiem PK = new PhieuKiem();
        PK.setMaPhieuKiem(txt_MaChungTu.getText().trim());
        PK.setMaNhanVien(txt_MaNhanVien.getText().trim());
        PK.setNgayTao(dat_NgayTao.getDate());
        PK.setGiaTriLech(Double.parseDouble(txt_GiaTriLech.getText()));
        PK.setGhiChu(txa_GhiChu.getText());
        PK.setDSSP(DSSP);
        return PK;
    }
    
    /*
     * Hàm thoát frame thêm mới và cập nhật lại frame kiểm kê sản phẩm
     */
    boolean capnhatFrameKiemKeSP(){
        Frame[] listFrames = Frame.getFrames();
        for (Frame fr : listFrames) {
            String tenFrame = fr.getClass().getName();
            if (tenFrame.equalsIgnoreCase("ui.quanly.sanpham.kiemke.KiemKeSanPhamJFrame")) {
                fr.dispose();
                return true;
            }
        }
        return false;
    }
    
}
