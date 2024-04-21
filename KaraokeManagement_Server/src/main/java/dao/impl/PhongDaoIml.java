package dao.impl;

import dao.PhongDAO;
import entites.HoaDon;
import entites.Phong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class PhongDaoIml extends UnicastRemoteObject implements PhongDAO {
    private static final long serialVersionUID = 1L;
    private final EntityManager em;
    public PhongDaoIml(String persistenceUnit) throws RemoteException {
        this.em = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
    }
    @Override
    public List<Phong> getALLPhong() throws RemoteException {
        return em.createNamedQuery("Phong.findAll").getResultList();
    }
    @Override
    public List<Phong> getDSTimKiemPhong1(String keyword) throws RemoteException {
        String jpql = "SELECT p FROM Phong p JOIN LoaiPhong lp ON p.loaiPhong.maLoaiPhong = lp.maLoaiPhong "
                + "WHERE p.maPhong LIKE :keyword OR lp.tenLoaiPhong LIKE :keyword";
        return em.createQuery(jpql, Phong.class).setParameter("keyword", "%" + keyword + "%").getResultList();
    }
    @Override
    public boolean themPhong(Phong phong) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(phong);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Phong timPhongTheoMaPhong(String maPhong) throws RemoteException {
        return em.createNamedQuery("Phong.findById", Phong.class).setParameter("maPhong", maPhong).getSingleResult();
    }
    @Override
    public List<Phong> getTrangThai() throws RemoteException {
        return em.createNamedQuery("Phong.findTrangThai").getResultList();
    }
    @Override
    public boolean capNhapPhong(Phong x) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(x);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean capNhapTrangThaiPhong(String maPhong, String trangThai) throws RemoteException {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Phong x = em.find(Phong.class, maPhong);
            x.setTrangThai(trangThai);
            em.merge(x);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
            return false;
        }
    }

}
