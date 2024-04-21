package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.KhachHangDAO;
import entites.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class KhachHangDaoImpl extends UnicastRemoteObject implements KhachHangDAO {

	private static final long serialVersionUID = 5435564738130132888L;
	private EntityManager em;

	public KhachHangDaoImpl(String persistenceUnit) throws RemoteException {
		em = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
	}

	@Override
	public List<KhachHang> getAllKhachHang() throws RemoteException {
		return em.createNamedQuery("KhachHang.findAll", KhachHang.class).getResultList();
	}

	@Override
	public boolean themKhachHang(KhachHang kh) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(kh);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean xoaKhachHang(String maKH) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			KhachHang kh = em.find(KhachHang.class, maKH);
			if (kh != null) {
				em.remove(kh);
				tx.commit();
				return true;
			}
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public KhachHang timKhachHangTheoMa(String maKH) throws RemoteException {
		Query query = em.createNamedQuery("KhachHang.findByMaKH", KhachHang.class);
		query.setParameter("maKH", maKH);
		return (KhachHang) query.getSingleResult();
	}

	@Override
	public KhachHang timKhachHangTheoSDT(String sdt) throws RemoteException {
		Query query = em.createNamedQuery("KhachHang.findBySDT", KhachHang.class);
		query.setParameter("sdt", sdt);
		return (KhachHang) query.getSingleResult();
	}

	@Override
	public boolean capNhapKhachHang(KhachHang kh) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(kh);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<KhachHang> timKiemDSKH(String maKH, String tenKH, String sdt, String diaChi) throws RemoteException{
		String jpql = "SELECT k FROM KhachHang k WHERE k.maKH LIKE :maKH AND k.tenKH LIKE :tenKH AND k.sdt LIKE :sdt AND k.diaChi LIKE :diaChi";
		Query query = em.createQuery(jpql, KhachHang.class);
		query.setParameter("maKH", "%" + maKH + "%");
		query.setParameter("tenKH", "%" + tenKH + "%");
		query.setParameter("sdt", "%" + sdt + "%");
		query.setParameter("diaChi", "%" + diaChi + "%");
		return query.getResultList();
	}

}
