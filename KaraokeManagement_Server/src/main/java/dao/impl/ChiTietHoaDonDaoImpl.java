package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ChiTietHoaDonDAO;
import entites.ChiTietHoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietHoaDonDaoImpl extends UnicastRemoteObject implements ChiTietHoaDonDAO {
	private final EntityManager em;

	public ChiTietHoaDonDaoImpl(String persistenceUnitName) throws RemoteException {
		em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	}

	@Override
	public List<ChiTietHoaDon> layDSTheoMaHD(String maHD) throws RemoteException {
		return em.createNamedQuery("ChiTietHoaDon.findByMaHoaDon", ChiTietHoaDon.class).setParameter("maHD", maHD)
				.getResultList();
	}

	@Override
	public boolean themChitietHoaDon(ChiTietHoaDon chiTietHoaDon) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(chiTietHoaDon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ChiTietHoaDon getChiTietHDTheoMaPhong(String maPhong) throws RemoteException {
		return em.createNamedQuery("ChiTietHoaDon.findByMaPhong", ChiTietHoaDon.class).setParameter("maPhong", maPhong)
				.getSingleResult();
	}

	@Override
	public List<ChiTietHoaDon> getDSChiTietHoaDonTheoKh(String maKH) throws RemoteException {
		String jpql = "SELECT c FROM ChiTietHoaDon c WHERE c.hoaDon.khachHang.maKH = :maKH";
		return em.createQuery(jpql, ChiTietHoaDon.class).setParameter("maKH", maKH).getResultList();
	}
	
	public boolean xoaChiTietHoaDonTheoMaHD(String maHD) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.createNamedQuery("ChiTietHoaDon.deleteByMaHoaDon").setParameter("maHD", maHD).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}
}
