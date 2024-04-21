package dao;

import entites.LoaiPhong;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LoaiPhongDAO extends Remote {
    public List<LoaiPhong> getALLLoaiPhong() throws RemoteException;
    public LoaiPhong getLoaiPhongByID(String maLoaiPhong) throws RemoteException;
}
