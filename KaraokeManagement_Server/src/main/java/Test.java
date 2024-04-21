import java.rmi.RemoteException;

import dao.ChiTietDichVuDAO;
import dao.ChiTietHoaDonDAO;
import dao.LoaiPhongDAO;
import dao.PhongDAO;
import dao.impl.ChiTietDichVuDaoImpl;
import dao.impl.ChiTietHoaDonDaoImpl;
import dao.impl.LoaiPhongIml;
import dao.impl.PhongIml;

public class Test {
	public static void main(String[] args) {
		try {
			LoaiPhongDAO loaiphongDAO = new LoaiPhongIml("MyMariaDB");
			System.out.println(loaiphongDAO.getALLLoaiPhong().size());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
