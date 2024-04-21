package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ChiTietPhieuDatDichVuDAO;
import entites.ChiTietPhieuDatDichVu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietPhieuDatDichVuDaoImpl extends UnicastRemoteObject implements ChiTietPhieuDatDichVuDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final EntityManager em;

	public ChiTietPhieuDatDichVuDaoImpl(String persistenceUnit) throws RemoteException {
		this.em = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
	}

	@Override
	public boolean themChiTietDichVu(ChiTietPhieuDatDichVu ctdv) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(ctdv);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean xoaChiTietPhieuDatDichVuTheoMaPhieuDat(String maPhieuDat) throws RemoteException {
		// xóa cj tiết phiếu đặt dịch vụ theo mã phiếu đặt
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.createNamedQuery("ChiTietPhieuDatDichVu.xoaChiTietPhieuDatDichVuTheoMaPhieuDat")
					.setParameter("maPhieuDat", maPhieuDat).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean xoaChiTietPhieuDatDichVuTheoTenKhachHang(String tenKhachHang) throws RemoteException {
		// xóa chi tiết phiếu đặt dịch vụ theo tên khách hàng
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.createNamedQuery("ChiTietPhieuDatDichVu.xoaChiTietPhieuDatDichVuTheoTenKhachHang")
					.setParameter("tenKhachHang", tenKhachHang).executeUpdate();
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public ChiTietPhieuDatDichVu timChiTietPhieuDatDichVuTheoMaPhieuDat(String maPhieuDat) throws RemoteException {
		// tìm chi tiết phiếu đặt dịch vụ theo mã phiếu đặt
		return em.createNamedQuery("ChiTietPhieuDatDichVu.timChiTietPhieuDatDichVuTheoMaPhieuDat",
				ChiTietPhieuDatDichVu.class).setParameter("maPhieuDat", maPhieuDat).getSingleResult();

	}

	@Override
	public List<ChiTietPhieuDatDichVu> timTatCaChiTietPhieuDatDichVu() throws RemoteException {
		// tìm tất cả chi tiết phiếu đặt dịch vụ
		return em.createNamedQuery("ChiTietPhieuDatDichVu.timTatCaChiTietPhieuDatDichVu", ChiTietPhieuDatDichVu.class)
				.getResultList();
	}

	@Override
	public List<ChiTietPhieuDatDichVu> timPhieuĐatichVuTheoTenKhachHang(String tenKhachHang) throws RemoteException {

		// tìm chi tiết phiếu đặt dịch vụ theo tên khách hàng
		return em
				.createNamedQuery("ChiTietPhieuDatDichVu.timPhieuĐatichVuTheoTenKhachHang", ChiTietPhieuDatDichVu.class)
				.setParameter("tenKhachHang", tenKhachHang).getResultList();

	}

	@Override
	public List<ChiTietPhieuDatDichVu> timPhieuĐatichVuTheoMaKhachHang(String maKH) throws RemoteException {
		// tìm chi tiết phiếu đặt dịch vụ theo mã khách hàng
		return em.createNamedQuery("ChiTietPhieuDatDichVu.timPhieuĐatichVuTheoMaKhachHang", ChiTietPhieuDatDichVu.class)
				.setParameter("maKH", maKH).getResultList();
	}

	@Override
	public ChiTietPhieuDatDichVu timchiTietPhieuDatDichVuTheoMaPhieuDat(String maPhieuDat) throws RemoteException {
		// tìm chi tiết phiếu đặt dịch vụ theo mã phiếu đặt
		return em.createNamedQuery("ChiTietPhieuDatDichVu.timchiTietPhieuDatDichVuTheoMaPhieuDat",
				ChiTietPhieuDatDichVu.class).setParameter("maPhieuDat", maPhieuDat).getSingleResult();
	}

}
