package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entites.ChiTietHoaDon;

public interface ChiTietHoaDonDAO extends Remote{
	
	public List<ChiTietHoaDon> layDSTheoMaHD(String maHD) throws RemoteException;
	
	public boolean themChitietHoaDon(ChiTietHoaDon ct) throws RemoteException;
	
	public ChiTietHoaDon getChiTietHDTheoMaPhong(String maPhong) throws RemoteException;
	
	public List<ChiTietHoaDon> getDSChiTietHoaDonTheoKh(String maKH) throws RemoteException;
}
