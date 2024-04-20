package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.HoaDonDAO;
import entites.HoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HoaDonDaoIml extends UnicastRemoteObject implements HoaDonDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final EntityManager em;

	public HoaDonDaoIml(String persistenceUnit) throws RemoteException {
		this.em = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
	}

	@Override
	public List<HoaDon> getALLHoaDon() throws RemoteException {
		return em.createNamedQuery("HoaDon.findAll").getResultList();
	}

	@Override
	public boolean themHoaDon(HoaDon hoaDon) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(hoaDon);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public HoaDon timHoaDonTheoMaHD(String maHD) throws RemoteException {
		return em.createNamedQuery("HoaDon.findById", HoaDon.class).setParameter("maHD", maHD).getSingleResult();
	}

	@Override
	public List<HoaDon> getDSTimKiemHoaDon(String keyword) throws RemoteException {
		String jpql = "SELECT hd FROM HoaDon hd JOIN KhachHang kh ON hd.khachHang.maKH = kh.maKH "
				+ "WHERE hd.maHoaDon LIKE :keyword OR kh.tenKH LIKE :keyword OR kh.sdt LIKE :keyword";
		return em.createQuery(jpql, HoaDon.class).setParameter("keyword", "%" + keyword + "%").getResultList();
	}

	@Override
	public List<HoaDon> getDSHoaDonTheoNam(int nam) throws RemoteException {
		return em.createNamedQuery("HoaDon.findByYear", HoaDon.class).setParameter("nam", nam).getResultList();
	}

	@Override
	public List<HoaDon> getDSHoaDonTheoThang(int thang, int nam) throws RemoteException {
		return em.createNamedQuery("HoaDon.findByMonth", HoaDon.class).setParameter("thang", thang)
				.setParameter("nam", nam).getResultList();
	}

	@Override
	public List<HoaDon> getDSHoaDonTheoNgay(int ngay, int thang, int nam) throws RemoteException {
		return em.createNamedQuery("HoaDon.findByDay", HoaDon.class).setParameter("ngay", ngay)
				.setParameter("thang", thang).setParameter("nam", nam).getResultList();
	}

	@Override
	public int getSoluongHoaDonTheoGioTrongNgay(int ngay, int thang, int nam, int gio) throws RemoteException {
		return Integer.parseInt(em.createNamedQuery("HoaDon.numberOfHoaDonByHour").setParameter("ngay", ngay)
				.setParameter("thang", thang).setParameter("nam", nam).setParameter("gio", gio).getSingleResult()
				.toString());
	}
}
