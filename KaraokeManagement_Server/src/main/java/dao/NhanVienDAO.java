package dao;

import java.rmi.Remote;
import java.util.List;
import entites.NhanVien;
import java.rmi.RemoteException;

public interface NhanVienDAO extends Remote {

	public List<NhanVien> getAllNhanVien() throws RemoteException;

	public NhanVien timKiemNhanVienTheoTaiKhoan(String taiKhoan, String matKhau) throws RemoteException;

	public boolean themNhanVien(NhanVien nv) throws RemoteException;

	public NhanVien timNhanVienTheoMaNV(String maNV) throws RemoteException;

	public boolean capNhatTaiKhoanMatKhauChoNhanVien(String maNV, String taiKhoan, String matKhau)
			throws RemoteException;

	public List<NhanVien> timKiemDSNV(String maNV, String tenNV, String sdt, String cmnd, String gt, String diaChi,
			String chucVu) throws RemoteException;

	public boolean capNhapNhanVien(NhanVien nv) throws RemoteException;

	public boolean xoaTaiKhoanCuaNhanVien(String maNV) throws RemoteException;
	
	public NhanVien	getNhanVienTheoTaiKhoanVaSDT(String tk, String sdt) throws RemoteException;
	
	public boolean capNhapMatKhau(String maukhau, String maNV) throws RemoteException;
}
