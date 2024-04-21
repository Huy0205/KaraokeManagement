package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import dao.DichVuDAO;
import entites.DichVu;

public class DichVuDaoImpl extends UnicastRemoteObject implements DichVuDAO {

	private static final long serialVersionUID = 5435564738130132888L;
	private EntityManager em;

	public DichVuDaoImpl(String persistenceUnit) throws RemoteException {
		em = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
	}

	public List<DichVu> getALLDichVu() {
		return em.createNamedQuery("DichVu.findAll", DichVu.class).getResultList();
	}

	@Override
	public boolean xoaDichVu(String maDV) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Query query = em.createNamedQuery("DichVu.deleteByMaDV");
			query.setParameter("maDV", maDV);
			int deletedCount = query.executeUpdate();
			tx.commit();
			return deletedCount > 0;
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean themDichVu(DichVu x) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Query query = em.createNamedQuery("DichVu.themDichVu");
			query.setParameter("maDV", x.getMaDV());
			query.setParameter("tenDichVu", x.getTenDichVu());
			query.setParameter("donGia", x.getDonGia());
			query.setParameter("donVi", x.getDonVi());
			query.setParameter("soLuongTonKho", x.getSoLuongTonKho());
			query.executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateDichVu(DichVu x) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Query query = em.createNamedQuery("DichVu.updateDichVu");
			query.setParameter("maDV", x.getMaDV());
			query.setParameter("tenDichVu", x.getTenDichVu());
			query.setParameter("donGia", x.getDonGia());
			query.setParameter("donVi", x.getDonVi());
			query.setParameter("soLuongTonKho", x.getSoLuongTonKho());
			int updatedCount = query.executeUpdate();
			tx.commit();
			return updatedCount > 0;
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public DichVu timDVTheoMaDV(String maDV) throws RemoteException {
		return em.find(DichVu.class, maDV);
	}

	@Override
	public boolean capNhapSoLuongTonDV(String maDV, int slMoi) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Query query = em.createNamedQuery("DichVu.updateSoLuongTonDV");
			query.setParameter("maDV", maDV);
			query.setParameter("soLuongTonKho", slMoi);
			int updatedCount = query.executeUpdate();
			tx.commit();
			return updatedCount > 0;
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<DichVu> search(String giaTriTimKiem) throws RemoteException {
		Query query = em.createNamedQuery("DichVu.search", DichVu.class);
		query.setParameter("maDV", "%" + giaTriTimKiem + "%");
		query.setParameter("tenDichVu", "%" + giaTriTimKiem + "%");
		try {
			double donGia = Double.parseDouble(giaTriTimKiem);
			query.setParameter("donGia", donGia);
		} catch (NumberFormatException e) {
			query.setParameter("donGia", -1); // Set to a value that won't match any real value
		}
		query.setParameter("donVi", "%" + giaTriTimKiem + "%");
		try {
			int soLuongTonKho = Integer.parseInt(giaTriTimKiem);
			query.setParameter("soLuongTonKho", soLuongTonKho);
		} catch (NumberFormatException e) {
			query.setParameter("soLuongTonKho", -1);
		}

		return query.getResultList();

	}

}
