package dao;

import entites.PhieuDat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PhieuDatDAO extends Remote {
    public List<PhieuDat> getALLPhieuDat() throws RemoteException;
    public PhieuDat getPhieuDatByID(String maPhieuDat) throws RemoteException;
    public boolean themPhieuDat(PhieuDat phieuDat) throws RemoteException;
    public boolean capNhapPhieuDat(PhieuDat x) throws RemoteException;
}
