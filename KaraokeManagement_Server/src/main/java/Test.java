import java.rmi.RemoteException;

import dao.ChiTietDichVuDAO;
import dao.ChiTietHoaDonDAO;
import dao.impl.ChiTietDichVuDaoImpl;
import dao.impl.ChiTietHoaDonDaoImpl;

public class Test {
	public static void main(String[] args) {
		try {
			ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDaoImpl("MyMariaDB");
			System.out.println(chiTietHoaDonDAO.layDSTheoMaHD("HD001").size());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
