package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entites.ChiTietPhieuDatPhong;

public interface ChiTietPhieuDatPhongDAO extends Remote {
	
	public boolean xoaChiTietPhieuDatPhongTheoMaPhieuDat(String maPhieuDat) throws Exception;
	public boolean themChiTietPhieuDatPhong(ChiTietPhieuDatPhong ct) throws Exception;
	public List<ChiTietPhieuDatPhong> timChiTietPhieuDatPhongTheoMaKH(String maPhieuDat) throws Exception;
	public List<ChiTietPhieuDatPhong> timTatCaChiTietPhieuDatPhong() throws Exception;
	public List<ChiTietPhieuDatPhong> timChiTietPhieuDatPhongTheoMaPhong(String maPhong) throws Exception;
	public boolean xoaChiTietPhieuDatPhongTheoMaPhong(String maPhong) throws RemoteException;
   
}
