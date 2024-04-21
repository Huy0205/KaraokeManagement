package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entites.ChiTietPhieuDatDichVu;



public interface ChiTietPhieuDatDichVuDAO extends Remote {

	public List<ChiTietPhieuDatDichVu> timTatCaChiTietDatDichVu() throws RemoteException;

	public boolean themChiTietPhieuDatDichVu(ChiTietPhieuDatDichVu ct) throws RemoteException;

	public List<ChiTietPhieuDatDichVu> timChiTietDichVuTheoMaPhieuDat(String maPhieuDat) throws RemoteException;

	public List<ChiTietPhieuDatDichVu> timPhieuĐatichVuTheoTenKhachHang(String tenKhachHang) throws RemoteException;

	
	// tìm theo ma khach hang
	public List<ChiTietPhieuDatDichVu> timTheoMaKhachHang(String maKhachHang) throws RemoteException;
	
	public boolean xoaChiTietPhieuDatDichVuTheoMaPhieuDat(String maPhieuDat) throws RemoteException;
	
}


