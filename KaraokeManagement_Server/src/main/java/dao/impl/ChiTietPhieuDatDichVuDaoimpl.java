package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ChiTietPhieuDatDichVuDAO;

import entites.ChiTietPhieuDatDichVu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public   class ChiTietPhieuDatDichVuDaoImpl extends UnicastRemoteObject implements ChiTietPhieuDatDichVuDAO {

	public ChiTietPhieuDatDichVuDaoImpl(String persistenceUnitName) throws RemoteException {
		em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final EntityManager em;

	@Override
	public List<ChiTietPhieuDatDichVu> timTatCaChiTietDatDichVu() throws RemoteException {
		// TODO Auto-generated method stub
		  return em.createNamedQuery("ChiTietPhieuDatDichVu.timTatCaChiTietDatDichVu", ChiTietPhieuDatDichVu.class).getResultList();
	}
	@Override
	public boolean themChiTietPhieuDatDichVu(ChiTietPhieuDatDichVu ct) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(ct);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}
	

	@Override
	public List<ChiTietPhieuDatDichVu> timChiTietDichVuTheoMaPhieuDat(String maPhieuDat) throws RemoteException {
		// TODO Auto-generated method stub
		//timChiTietDichVuTheoMaPhieuDat
		return em.createNamedQuery("ChiTietPhieuDatDichVu.timChiTietDichVuTheoMaPhieuDat", ChiTietPhieuDatDichVu.class).setParameter("maPhieuDat", maPhieuDat).getResultList();
	}

	@Override
	public List<ChiTietPhieuDatDichVu> timPhieuĐatichVuTheoTenKhachHang(String tenKhachHang) throws RemoteException {
		// TODO Auto-generated method stub
		return em.createNamedQuery("ChiTietPhieuDatDichVu.timPhieuĐatichVuTheoTenKhachHang", ChiTietPhieuDatDichVu.class).setParameter("tenKhachHang", tenKhachHang).getResultList();
	}


	@Override
	public List<ChiTietPhieuDatDichVu> timTheoMaKhachHang(String maKhachHang) throws RemoteException {
		// TODO Auto-generated method stub
		return em.createNamedQuery("ChiTietPhieuDatDichVu.timTheoMaKhachHang", ChiTietPhieuDatDichVu.class).setParameter("maKhachHang", maKhachHang).getResultList();
	}
	
	

	@Override
	public boolean xoaChiTietPhieuDatDichVuTheoMaPhieuDat(String maPhieuDat) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.createNamedQuery("ChiTietPhieuDatDichVu.xoaChiTietPhieuDatDichVuTheoMaPhieuDat")
					.setParameter("maPhieuDat", maPhieuDat).executeUpdate();
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}
	
	
	
	

}
