package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entites.DichVu;

public interface DichVuDAO extends Remote {

	boolean themDichVu(DichVu x) throws RemoteException;

	boolean updateDichVu(DichVu x) throws RemoteException;

	DichVu timDVTheoMaDV(String maDV) throws RemoteException;

	boolean capNhapSoLuongTonDV(String maDV, int slMoi) throws RemoteException;

	List<DichVu> search(String giaTriTimKiem) throws RemoteException;

	boolean xoaDichVu(String maDV) throws RemoteException;

}
