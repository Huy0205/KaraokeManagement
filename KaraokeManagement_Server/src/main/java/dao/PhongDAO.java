package dao;

import entites.Phong;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PhongDAO extends Remote {
    public List<Phong> getALLPhong() throws RemoteException;
    public List<Phong> getDSTimKiemPhong1(String keyword) throws RemoteException;
    public boolean themPhong(Phong phong) throws RemoteException;
    public Phong timPhongTheoMaPhong(String maPhong) throws RemoteException;
    public List<Phong> getTrangThai() throws RemoteException;
    public boolean capNhapPhong(Phong x) throws RemoteException;
    public boolean capNhapTrangThaiPhong(String maPhong, String trangThai) throws RemoteException;

}
