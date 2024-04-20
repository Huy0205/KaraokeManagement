package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ChiTietDichVuDAO;
import entites.ChiTietDichVu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietDichVuDaoImpl extends UnicastRemoteObject implements ChiTietDichVuDAO {
	private final EntityManager em;

	public ChiTietDichVuDaoImpl(String persistenceUnit) throws RemoteException {
		this.em = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
	}

	@Override
	public List<ChiTietDichVu> getALLChiTietDVTheoMaHD(String maHD) throws RemoteException {
		return em.createNamedQuery("ChiTietDichVu.findByMaHoaDon", ChiTietDichVu.class).setParameter("maHD", maHD)
				.getResultList();
	}

	@Override
	public boolean themChiTietDichVu(ChiTietDichVu chiTietDichVu) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(chiTietDichVu);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

}
