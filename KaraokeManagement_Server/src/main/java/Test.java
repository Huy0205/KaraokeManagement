import java.rmi.RemoteException;

import dao.HoaDonDAO;
import dao.impl.HoaDonDaoIml;

public class Test {
	public static void main(String[] args) {
		try {
			HoaDonDAO hoaDonDAO = new HoaDonDaoIml("MyMariaDB");
			System.out.println("sl: " + hoaDonDAO.getSoluongHoaDonTheoGioTrongNgay(1, 1, 2021, 1));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
