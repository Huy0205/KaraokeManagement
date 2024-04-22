package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import jakarta.persistence.Query;

import dao.NhanVienDAO;
import entites.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class NhanVienDaoImpl extends UnicastRemoteObject implements NhanVienDAO {

	private static final long serialVersionUID = 5435564738130132888L;
	private EntityManager em;

	public NhanVienDaoImpl(String persistenceUnit) throws RemoteException {
		em = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
	}

	@Override
	public List<NhanVien> getAllNhanVien() throws RemoteException {
		return em.createNamedQuery("NhanVien.findAll", NhanVien.class).getResultList();
	}

	/**
	 * @param taiKhoan
	 * @param matKhau
	 * @return NhanVien, null if not found
	 */
	public NhanVien timKiemTheoDanhSachNhanVien(String ma, String ten, String sdt, String cccd, String diachi,
			String chucVu) throws RemoteException {
		// TODO Auto-generated method stub
		return em.createNamedQuery("NhanVien.findByAll", NhanVien.class).setParameter("maNV", ma)
				.setParameter("tenNV", ten).setParameter("sdt", sdt).setParameter("cmnd", cccd)
				.setParameter("diaChi", diachi).setParameter("chucVu", chucVu).getSingleResult();
	}
	@Override
	public NhanVien timKiemNhanVienTheoTaiKhoan(String taiKhoan, String matKhau) throws RemoteException {
		try {
			return em.createNamedQuery("NhanVien.findByTaiKhoanMatKhau", NhanVien.class)
					.setParameter("taiKhoan", taiKhoan).setParameter("matKhau", matKhau).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean themNhanVien(NhanVien nv) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(nv);
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
	public boolean capNhapNhanVien(NhanVien nv) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(nv);
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
	public boolean capNhatTaiKhoanMatKhauChoNhanVien(String maNV, String taiKhoan, String matKhau)
			throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			NhanVien nv = em.find(NhanVien.class, maNV);
			if (nv != null) {
				nv.setTaiKhoan(taiKhoan);
				nv.setMatKhau(matKhau);
				em.merge(nv);
				tx.commit();
				return true;
			}
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public NhanVien timNhanVienTheoMaNV(String maNV) throws RemoteException {
		return em.find(NhanVien.class, maNV);
	}

	@Override
	public List<NhanVien> timKiemDSNV(String maNV, String tenNV, String sdt, String cmnd, String gt, String diaChi,
			String chucVu) throws RemoteException {
		String jpql = "SELECT nv FROM NhanVien nv WHERE nv.maNV LIKE :maNV AND nv.tenNV LIKE :tenNV "
				+ "AND nv.sdt LIKE :sdt AND nv.cmnd LIKE :cmnd AND nv.gioiTinh LIKE :gt "
				+ "AND nv.diaChi LIKE :diaChi AND nv.chucVu LIKE :chucVu";
		Query query = em.createQuery(jpql);
		query.setParameter("maNV", "%" + maNV + "%");
		query.setParameter("tenNV", "%" + tenNV + "%");
		query.setParameter("sdt", "%" + sdt + "%");
		query.setParameter("cmnd", "%" + cmnd + "%");
		query.setParameter("gt", "%" + gt + "%");
		query.setParameter("diaChi", "%" + diaChi + "%");
		query.setParameter("chucVu", "%" + chucVu + "%");
		return query.getResultList();
	}

	@Override
	public boolean xoaTaiKhoanCuaNhanVien(String maNV) throws RemoteException {
		String jpql = "UPDATE NhanVien nv SET nv.taiKhoan = NULL, nv.matKhau = NULL WHERE nv.maNV = :maNV";
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			Query query = em.createQuery(jpql);
			query.setParameter("maNV", maNV);
			int updatedCount = query.executeUpdate();
			tr.commit();
			return updatedCount > 0;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public NhanVien getNhanVienTheoTaiKhoanVaSDT(String tk, String sdt) throws RemoteException {
		return em.createNamedQuery("NhanVien.findByTaiKhoanAndSDT", NhanVien.class).setParameter("taiKhoan", tk)
				.setParameter("sdt", sdt).getSingleResult();
	}

	@Override
	public boolean capNhapMatKhau(String maukhau, String maNV) throws RemoteException {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			NhanVien nv = em.find(NhanVien.class, maNV);
			if (nv != null) {
				nv.setMatKhau(maukhau);
				em.merge(nv);
				tr.commit();
				return true;
			}
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public NhanVien timKiemTheoDanhSachNhanVien(String ma, String ten, String sdt, String cccd, String diachi,
			String chucVu, String chucVu2) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
