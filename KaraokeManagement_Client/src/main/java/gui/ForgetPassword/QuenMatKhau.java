package gui.ForgetPassword;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.security.SecureRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dao.NhanVienDAO;
import entites.NhanVien;
import gui.ForgetPassword.util.Session;
import gui.ForgetPassword.util.Xmail;

public class QuenMatKhau extends JFrame implements ActionListener {

	private static final String URL = "rmi://localhost:2024/";

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JTextField txtEmail;
	private JButton btnXacNhan;
	private NhanVienDAO nhanVienDAO;
	private Session ss = Session.getInstance();
	private Xmail email = new Xmail();
	private JTextField txtSDT;

	/**
	 * Create the frame.
	 */
	public QuenMatKhau() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quên Mật Khẩu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(213, 10, 183, 42);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tài Khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(42, 73, 160, 20);
		contentPane.add(lblNewLabel_1);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTaiKhoan.setBounds(42, 103, 501, 29);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Email nhận mật khẩu");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(42, 212, 160, 20);
		contentPane.add(lblNewLabel_1_1);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(42, 246, 501, 29);
		contentPane.add(txtEmail);

		btnXacNhan = new JButton("Lấy Mật Khẩu Mới");
		btnXacNhan.setForeground(Color.WHITE);
		btnXacNhan.setBackground(new Color(37, 113, 177));
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXacNhan.setBounds(414, 285, 129, 37);
		contentPane.add(btnXacNhan);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSDT.setColumns(10);
		txtSDT.setBounds(42, 173, 501, 29);
		contentPane.add(txtSDT);

		JLabel lblNewLabel_1_1_1 = new JLabel("Số Điện Thoại");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(42, 139, 160, 20);
		contentPane.add(lblNewLabel_1_1_1);

		// Lấy dữ liệu từ server
		try {
			nhanVienDAO = (NhanVienDAO) Naming.lookup(URL + "NhanVienDAO");
		} catch (Exception e) {
			e.printStackTrace();
		}

		btnXacNhan.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXacNhan)) {
			if (valiData()) {
				String emailToAddress = txtEmail.getText();
				String taiKhoan = txtTaiKhoan.getText();
				String sdt = txtSDT.getText();
				NhanVien nv;
				try {
					nv = nhanVienDAO.getNhanVienTheoTaiKhoanVaSDT(taiKhoan, sdt);
					String NewPassWord = taoMKNgauNhien();
					email.sendMail(emailToAddress, NewPassWord);
					ss.set("content", NewPassWord);
					ss.set("email", emailToAddress);
					nhanVienDAO.capNhatTaiKhoanMatKhauChoNhanVien(emailToAddress, taiKhoan, sdt);
					this.dispose();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}

		}

	}

	public String taoMKNgauNhien() {
		String kiTu = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
		int PASSWORD_LENGTH = 8;// đô dài mật khẩu mới là 8 kí tự bao gồm các kí tự trên kia
		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder();
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			int randomIndex = random.nextInt(kiTu.length());
			char randomChar = kiTu.charAt(randomIndex);
			password.append(randomChar);
		}
		return password.toString();

	}

	private boolean valiData() {
		String emailToAddress = txtEmail.getText();
		String taiKhoan = txtTaiKhoan.getText();
		String sdt = txtSDT.getText();
		if (emailToAddress.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Nhập Email!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtEmail.requestFocus();
			return false;
		}
		if (!emailToAddress.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			JOptionPane.showMessageDialog(this, "email theo định dạng: exampleemail@domain.com", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtEmail.setText("");
			txtEmail.requestFocus();
			return false;
		}
		if (taiKhoan.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Nhập tài khoản!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtTaiKhoan.requestFocus();
			return false;
		}
		// tên đăng nhập chỉ chứa số và chữ va không có ký tự đặc biệt
		// độ dài tên đăng nhập từ 5-30
		if (!taiKhoan.matches("[a-zA-z0-9 ]{5,30}")) {
			JOptionPane.showMessageDialog(this,
					"Tên tài khoản chỉ chứa kí tự số và chữ không bao gồm kí tự đặt biệt, độ dài tên từ 5-30 kí tự",
					"Lỗi", JOptionPane.ERROR_MESSAGE);
			txtTaiKhoan.setText("");
			txtTaiKhoan.requestFocus();
			return false;
		}
		if (sdt.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Nhập số điện thoại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			txtSDT.requestFocus();
			return false;
		}
		if (!sdt.matches("^0\\d{9}$")) {
			JOptionPane.showMessageDialog(this, "Số điện thoại là số nguyên (10 số, số đầu tiên là số 0)", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			txtSDT.requestFocus();
			return false;
		}
		try {
			NhanVien nv = nhanVienDAO.getNhanVienTheoTaiKhoanVaSDT(taiKhoan, sdt);
			if (nv == null) {
				JOptionPane.showMessageDialog(this, "sai thông tin tài khoản hoặc số điện thoại", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return true;
	}
}
