package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ChiTietPhieuDatPhongDAO;
import entites.ChiTietPhieuDatPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietPhieuDatPhongDaoImpl extends UnicastRemoteObject implements ChiTietPhieuDatPhongDAO{

	public ChiTietPhieuDatPhongDaoImpl(String persistenceUnitName) throws RemoteException {
		 this.em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private final EntityManager em;
	private static final long serialVersionUID = 1L;

	@Override
	public boolean xoaChiTietPhieuDatPhongTheoMaPhieuDat(String maPhieuDat) throws Exception {
		// TODO Auto-generated method stub
		return em.createNamedQuery("ChiTietPhieuDatPhong.xoaChiTietPhieuDatPhongTheoPhieuDat").setParameter("maPhieuDat", maPhieuDat).executeUpdate() > 0;
	}

	@Override
	public boolean themChiTietPhieuDatPhong(ChiTietPhieuDatPhong ct) throws Exception {
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
	public List<ChiTietPhieuDatPhong> timChiTietPhieuDatPhongTheoMaKH(String maKH) throws Exception {
		// TODO Auto-generated method stub
		return em.createNamedQuery("ChiTietPhieuDatPhong.timChiTietPhieuDatPhongTheoMaKH", ChiTietPhieuDatPhong.class).setParameter("maKhachHang", maKH).getResultList();
	}

	@Override
	public List<ChiTietPhieuDatPhong> timTatCaChiTietPhieuDatPhong() throws Exception {
		// TODO Auto-generated method stub
		return em.createNamedQuery("ChiTietPhieuDatPhong.timTatCaChiTietPhieuDatPhong", ChiTietPhieuDatPhong.class).getResultList();
	}

	@Override
	public List<ChiTietPhieuDatPhong> timChiTietPhieuDatPhongTheoMaPhong(String maPhong) throws Exception {
		// TODO Auto-generated method stub
		return em.createNamedQuery("ChiTietPhieuDatPhong.timChiTietPhieuDatPhongTheoMaPhong", ChiTietPhieuDatPhong.class).setParameter("maPhong", maPhong).getResultList()
;	}

	@Override
	public boolean xoaChiTietPhieuDatPhongTheoMaPhong(String maPhong) throws RemoteException {
		// TODO Auto-generated method stub
		return em.createNamedQuery("ChiTietPhieuDatPhong.xoaChiTietPhieuDatPhongTheoMaPhong").setParameter("maPhong", maPhong).executeUpdate() > 0;
	}

}
