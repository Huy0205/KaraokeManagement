package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entites.ChiTietPhieuDatPhongCho;

public interface ChiTietPhieuDatPhongChoDAO extends Remote {
	public boolean themChiTietPhieuDatPhongCho(ChiTietPhieuDatPhongCho ct) throws RemoteException;
    public boolean xoaChiTietPhieuDatPhongCho(String maPhieuDatPhongCho) throws RemoteException;
    public List<ChiTietPhieuDatPhongCho> timTatCacPhieuDatPhongCho() throws RemoteException;
    public List<ChiTietPhieuDatPhongCho> findByMaPhieuDatPhongCho(String maPhieuDatPhongCho) throws RemoteException;
    public ChiTietPhieuDatPhongCho findByMaPhong(String maPhong) throws RemoteException;
}

