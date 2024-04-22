package entites;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "NHANVIEN")

@NamedQueries({ @NamedQuery(name = "NhanVien.findAll", query = "SELECT nv FROM NhanVien nv"),
		@NamedQuery(name = "NhanVien.findByTaiKhoanMatKhau", query = "SELECT nv FROM NhanVien nv WHERE nv.taiKhoan = :taiKhoan AND nv.matKhau = :matKhau"),
		@NamedQuery(name = "NhanVien.findByMaNV", query = "SELECT nv FROM NhanVien nv WHERE nv.maNV = :maNV"),
		@NamedQuery(name = "NhanVien.findByTenNV", query = "SELECT nv FROM NhanVien nv WHERE nv.tenNV LIKE :tenNV"),
		@NamedQuery(name = "NhanVien.findBySDT", query = "SELECT nv FROM NhanVien nv WHERE nv.sdt = :sdt"),
		@NamedQuery(name = "NhanVien.findByChucVu", query = "SELECT nv FROM NhanVien nv WHERE nv.chucVu = :chucVu"),
		@NamedQuery(name = "NhanVien.findByTaiKhoanAndSDT", query = "SELECT nv FROM NhanVien nv WHERE nv.taiKhoan = :taiKhoan AND nv.sdt = :sdt"),
        //tìm kiếm nhân viên  với tất cả thông tin còn chức vụ chỉ mã chức vụ thôi
		@NamedQuery(name = "NhanVien.findByAll", query = "SELECT nv FROM NhanVien nv WHERE nv.maNV LIKE :maNV AND nv.tenNV LIKE :tenNV AND nv.sdt LIKE :sdt AND nv.cmnd LIKE :cmnd AND nv.gioiTinh LIKE :gt AND nv.diaChi LIKE :diaChi AND nv.chucVu LIKE :chucVu") })

public class NhanVien implements Serializable {
	@Id
	@Column(name = "MANV", columnDefinition = "varchar(10)")
	private String maNV;
	@Column(name = "TENNV", columnDefinition = "nvarchar(50)", nullable = false)
	private String tenNV;
	@Column(name = "CMND", columnDefinition = "varchar(10)")
	private String cmnd;
	@Column(name = "SDT", columnDefinition = "varchar(12)", nullable = false)
	private String sdt;
	@Column(name = "DIACHI", columnDefinition = "nvarchar(200)")
	private String diaChi;
	@Column(name = "GIOITINH", columnDefinition = "bit")
	private boolean gioiTinh;
	@Column(name = "TAIKHOAN", columnDefinition = "varchar(50)", nullable = false)
	private String taiKhoan;
	@Column(name = "MATKHAU", columnDefinition = "varchar(50)", nullable = false)
	private String matKhau;
	@Column(name = "CHUCVU", columnDefinition = "nvarchar(4)", nullable = false)
	private String chucVu;

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public NhanVien() {
	}

	public NhanVien(String maNV, String tenNV, String cmnd, String sdt, String diaChi, boolean gioiTinh,
			String taiKhoan, String matKhau, String chucVu) {
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.cmnd = cmnd;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.chucVu = chucVu;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", cmnd=" + cmnd + ", sdt=" + sdt + ", diaChi=" + diaChi
				+ ", gioiTinh=" + gioiTinh + ", taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", chucVu=" + chucVu
				+ "]";
	}

}
