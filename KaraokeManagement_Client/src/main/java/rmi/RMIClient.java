package rmi;

import java.rmi.Naming;

public class RMIClient {
	// url của server
	private static final String SERVER_URL = "rmi://localhost:2024/";

	// Không cho phép khởi tạo đối tượng từ bên ngoài
	private RMIClient() {
	}

	/**
	 * Phương thức dùng để lookup đối tượng từ server
	 * 
	 * @param serviceName tên của của dao mà server đã bind
	 * @param clazz       kiểu dữ liệu của đối tượng (dao) cần lookup
	 * @return đối tượng đã lookup được
	 */
	public static <T> T lookup(String serviceName, Class<T> clazz) {
		try {
			return clazz.cast(Naming.lookup(SERVER_URL + serviceName));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
