package dao.impl;

import dao.PhieuDatDAO;
import entites.PhieuDat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class PhieuDatIml extends UnicastRemoteObject implements PhieuDatDAO {
    private static final long serialVersionUID = 1L;
    private final EntityManager em;
    public PhieuDatIml(String persistenceUnit) throws RemoteException {
        this.em = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
    }
    public List<PhieuDat> getALLPhieuDat() throws RemoteException {
        return em.createNamedQuery("PhieuDat.findAll").getResultList();
    }
    public PhieuDat getPhieuDatByID(String maPhieuDat) throws RemoteException {
        return em.createNamedQuery("PhieuDat.findById", PhieuDat.class).setParameter("maPhieuDat", maPhieuDat).getSingleResult();
    }
    public boolean themPhieuDat(PhieuDat phieuDat) throws RemoteException {
        try {
            em.getTransaction().begin();
            em.persist(phieuDat);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
    public boolean capNhapPhieuDat(PhieuDat x) throws RemoteException {
        try {
            em.getTransaction().begin();
            em.merge(x);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }
}
