package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entites.HoaDon;

public interface HoaDonDAO extends Remote {
	
	public List<HoaDon> getALLHoaDon() throws RemoteException;
	
	public boolean themHoaDon(HoaDon hoaDon) throws RemoteException;
	
	public HoaDon timHoaDonTheoMaHD(String maHD) throws RemoteException;
	
	public List<HoaDon> getDSTimKiemHoaDon(String keyword) throws RemoteException;
	
	public List<HoaDon> getDSHoaDonTheoNam(int nam) throws RemoteException;
	
	public List<HoaDon> getDSHoaDonTheoThang(int thang, int nam) throws RemoteException;
	
	public List<HoaDon> getDSHoaDonTheoNgay(int ngay, int thang, int nam) throws RemoteException;
	
	public int getSoluongHoaDonTheoGioTrongNgay(int ngay, int thang, int nam, int gio) throws RemoteException;
}
