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
      
}