package server;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

import dao.ChiTietDichVuDAO;
import dao.ChiTietHoaDonDAO;
import dao.DichVuDAO;
import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.LoaiPhongDAO;
import dao.NhanVienDAO;
import dao.PhieuDatDAO;
import dao.PhongDAO;
import dao.impl.ChiTietDichVuDaoImpl;
import dao.impl.ChiTietHoaDonDaoImpl;
import dao.impl.DichVuDaoImpl;
import dao.impl.HoaDonDaoIml;
import dao.impl.KhachHangDaoImpl;
import dao.impl.LoaiPhongDaoIml;
import dao.impl.NhanVienDaoImpl;
import dao.impl.PhieuDatDaoIml;
import dao.impl.PhongDaoIml;

public class Server {
	private static final String URL = "rmi://localhost:2024/";
	private static final String PERSISTENCE_UNIT_NAME = "MyMariaDB";

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			HoaDonDAO hoaDonDAO = new HoaDonDaoIml(PERSISTENCE_UNIT_NAME);
			ChiTietDichVuDAO chiTietDichVuDAO = new ChiTietDichVuDaoImpl(PERSISTENCE_UNIT_NAME);
			ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDaoImpl(PERSISTENCE_UNIT_NAME);

			LoaiPhongDAO loaiPhongDAO = new LoaiPhongDaoIml(PERSISTENCE_UNIT_NAME);
			PhieuDatDAO phieuDatDAO = new PhieuDatDaoIml(PERSISTENCE_UNIT_NAME);
			PhongDAO phongDAO = new PhongDaoIml(PERSISTENCE_UNIT_NAME);

			NhanVienDAO nhanVienDAO = new NhanVienDaoImpl(PERSISTENCE_UNIT_NAME);
			KhachHangDAO khachHangDAO = new KhachHangDaoImpl(PERSISTENCE_UNIT_NAME);
			DichVuDAO dichVuDAO = new DichVuDaoImpl(PERSISTENCE_UNIT_NAME);

//			ChiTietPhieuDatDichVuDAO chiTietPhieuDatDichVuDAO = new ChiTietPhieuDatDichVuDaoImpl(PERSISTENCE_UNIT_NAME);

			LocateRegistry.createRegistry(2024);

			context.bind(URL + "HoaDonDAO", hoaDonDAO);
			context.bind(URL + "ChiTietDichVuDAO", chiTietDichVuDAO);
			context.bind(URL + "ChiTietHoaDonDAO", chiTietHoaDonDAO);

			context.bind(URL + "LoaiPhongDAO", loaiPhongDAO);
			context.bind(URL + "PhieuDatDAO", phieuDatDAO);
			context.bind(URL + "PhongDAO", phongDAO);

			context.bind(URL + "NhanVienDAO", nhanVienDAO);
			context.bind(URL + "KhachHangDAO", khachHangDAO);
			context.bind(URL + "DichVuDAO", dichVuDAO);

//			context.bind(URL + "ChiTietPhieuDatDichVuDAO", chiTietPhieuDatDichVuDAO);

			System.out.println("Server is running...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
