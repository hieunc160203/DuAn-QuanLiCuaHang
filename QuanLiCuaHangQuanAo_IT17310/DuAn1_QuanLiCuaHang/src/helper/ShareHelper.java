/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import model.HoaDon;
import model.KhachHang;
import model.NguoiDung;
import model.SanPham;

/**
 *
 * @author Administrator
 */
public class ShareHelper {
        
    /**
     * Đối tượng này chứa thông tin khách hàng đang giao dịch tại quầy
     * Sử dụng đối tượng để lấy các thông tin cho frame banhang, timkhachhang, chietkhau
     * Sau khi click THANH TOÁN thì đối tượng này được set null
     */
    public static KhachHang KhachGiaoDich = null;
    
    /**
     * Đối tượng này chứa thông tin hoá đơn đang giao dịch
     * Sử dụng đối tượng để lưu các thông tin của hoá đơn và tính chiết khấu
     * Sau khi click THANH TOÁN thì đối tượng này được set null
     */
    public static HoaDon HoaDonGiaoDich = null;
    
    /**
     * Đối tượng này chứa điểm thưởng tạm tính của khách đang giao dịch
     * sử dụng để cập nhật điểm thưởng giữa frame bán hàng và chiết khấu
     */
    public static int DiemThuongMoi = 0;
    
    /**
     * Đối tượng này chứa thông tin người dùng đăng nhập
     */
    public static NguoiDung NguoiDung = null;
    
    /**
     * Đối tượng này chứa thông tin các sản phẩm đề nghị xuất huỷ khi hết HSD
     */
    public static List<SanPham> listDeNghiHuy = new ArrayList<>();
    
    /**
     * Sao chép file ảnh sản phẩm vào thư mục images/products
     * @param file là đối tượng file ảnh
     * @param filename là tên file ảnh
     * @return chép được hay không
     */
    public static boolean luuAnh(File file, String filename) {
        File dir = null;
        dir = new File("images/products/");
        if(!dir.exists()){
            dir.mkdirs();
        }
        File newFile = new File(dir, filename);
        try {
            // Copy vào thư mục (đè nếu đã tồn tại)
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    /**
     * Đọc hình ảnh sản phẩm
     * @param fileName là tên file
     * @return ảnh đọc được
     */
    public static ImageIcon docAnh(String fileName) {
        File path = new File("images/products/", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
}
