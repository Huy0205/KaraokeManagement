package dao.impl;

import dao.LoaiPhongDAO;
import entites.LoaiPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class LoaiPhongIml extends UnicastRemoteObject implements LoaiPhongDAO {
    private static final long serialVersionUID = 1L;
    private final EntityManager em;
    public LoaiPhongIml(String persistenceUnit) throws RemoteException {
        this.em = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
    }
    @Override
    public List<LoaiPhong> getALLLoaiPhong() throws RemoteException {
        return em.createNamedQuery("LoaiPhong.findAll").getResultList();
    }
    @Override
    public LoaiPhong getLoaiPhongByID(String maLoaiPhong) throws RemoteException {
        return em.createNamedQuery("LoaiPhong.findByID", LoaiPhong.class).setParameter("maLoaiPhong", maLoaiPhong).getSingleResult();
    }
}
