package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entites.ChiTietPhieuDatDichVu;

public interface ChiTietPhieuDatDichVuDAO extends Remote {

	public boolean themChiTietDichVu(ChiTietPhieuDatDichVu dv) throws RemoteException;

	public boolean xoaChiTietPhieuDatDichVuTheoMaPhieuDat(String maPhieuDat) throws RemoteException;

	public boolean xoaChiTietPhieuDatDichVuTheoTenKhachHang(String tenKhachHang) throws RemoteException;

	public ChiTietPhieuDatDichVu timChiTietPhieuDatDichVuTheoMaPhieuDat(String maPhieuDat) throws RemoteException;

	public List<ChiTietPhieuDatDichVu> timTatCaChiTietPhieuDatDichVu() throws RemoteException;

	public List<ChiTietPhieuDatDichVu> timPhieuĐatichVuTheoTenKhachHang(String tenKhachHang) throws RemoteException;

	public List<ChiTietPhieuDatDichVu> timPhieuĐatichVuTheoMaKhachHang(String maKH) throws RemoteException;

	public ChiTietPhieuDatDichVu timchiTietPhieuDatDichVuTheoMaPhieuDat(String maPhieuDat) throws RemoteException;
}
