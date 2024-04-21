package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ChiTietPhieuDatDichVuDAO;
import dao.ChiTietPhieuDatPhongChoDAO;
import entites.ChiTietPhieuDatDichVu;
import entites.ChiTietPhieuDatPhongCho;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ChiTietPhieuDatPhongChoDaoImpl extends UnicastRemoteObject implements ChiTietPhieuDatPhongChoDAO{

	public ChiTietPhieuDatPhongChoDaoImpl(String persistenceUnitName) throws RemoteException {
		em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private final EntityManager em;
	private static final long serialVersionUID = 1L;

	@Override
	public boolean themChiTietPhieuDatPhongCho(ChiTietPhieuDatPhongCho ct) throws RemoteException {
		// TODO Auto-generated method stub
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
	public boolean xoaChiTietPhieuDatPhongCho(String maPhieuDatPhongCho) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ChiTietPhieuDatPhongCho> timTatCacPhieuDatPhongCho() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChiTietPhieuDatPhongCho> findByMaPhieuDatPhongCho(String maPhieuDatPhongCho) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChiTietPhieuDatPhongCho findByMaPhong(String maPhong) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
  
	

}
