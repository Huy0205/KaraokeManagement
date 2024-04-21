package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.*;
import dao.impl.*;

public class Server {
	private static final String URL = "rmi://localhost:2024/";
	private static final String PERSISTENCE_UNIT_NAME = "MyMariaDB";

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();

			HoaDonDAO hoaDonDAO = new HoaDonDaoIml(PERSISTENCE_UNIT_NAME);
			ChiTietDichVuDAO chiTietDichVuDAO = new ChiTietDichVuDaoImpl(PERSISTENCE_UNIT_NAME);
			ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDaoImpl(PERSISTENCE_UNIT_NAME);

			// Mấy ô điền tiếp mấy cái mình làm vào đây
			LoaiPhongDAO loaiPhongDAO = new LoaiPhongIml(PERSISTENCE_UNIT_NAME);
			PhieuDatDAO phieuDatDAO = new PhieuDatIml(PERSISTENCE_UNIT_NAME);
			PhongDAO phongDAO = new PhongIml(PERSISTENCE_UNIT_NAME);
			// Mấy ô điền tiếp mấy cái mình làm vào đây
			LocateRegistry.createRegistry(2024);

			context.bind(URL + "HoaDonDAO", hoaDonDAO);
			context.bind(URL + "ChiTietDichVuDAO", chiTietDichVuDAO);
			context.bind(URL + "ChiTietHoaDonDAO", chiTietHoaDonDAO);

			// Mấy ô điền tiếp mấy cái mình làm vào đây
			context.bind(URL + "LoaiPhongDAO", loaiPhongDAO);
			context.bind(URL + "PhieuDatDAO", phieuDatDAO);
			context.bind(URL + "PhongDAO", phongDAO);
			// Mấy ô điền tiếp mấy cái mình làm vào đây

			System.out.println("Server is running...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
