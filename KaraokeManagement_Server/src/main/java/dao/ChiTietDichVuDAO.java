package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entites.ChiTietDichVu;

public interface ChiTietDichVuDAO extends Remote{
	
	public List<ChiTietDichVu> getALLChiTietDVTheoMaHD(String maHD) throws RemoteException;
	
	public boolean themChiTietDichVu(ChiTietDichVu chiTietDichVu) throws RemoteException;
}
