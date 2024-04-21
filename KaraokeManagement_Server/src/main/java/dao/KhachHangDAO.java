package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import entites.KhachHang;

public interface KhachHangDAO extends Remote {

	public List<KhachHang> getAllKhachHang() throws RemoteException;

	public boolean themKhachHang(KhachHang kh) throws RemoteException;

	public boolean xoaKhachHang(String maKH) throws RemoteException;

	public KhachHang timKhachHangTheoMa(String maKH) throws RemoteException;

	public KhachHang timKhachHangTheoSDT(String SDT) throws RemoteException;

	public boolean capNhapKhachHang(KhachHang kh) throws RemoteException;

	public List<KhachHang> timKiemDSKH(String maKH, String tenKH, String sdt, String diaChi) throws RemoteException;

}
