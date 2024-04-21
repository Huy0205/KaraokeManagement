package entites;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PHIEUDATPHONGCHO")
public class PhieuDatPhongCho implements Serializable {
	@Id
	@Column(name = "MAPHIEUDATPHONGCHO", columnDefinition = "varchar(10)")
	private String maPhieuDatPhongCho;
	@ManyToOne
	@JoinColumn(name = "MAKH", referencedColumnName = "MAKH", nullable = false)
	private KhachHang khachHang;
	@ManyToOne
	@JoinColumn(name = "MANV", referencedColumnName = "MANV", nullable = false)
	private NhanVien nhanVien;
	@Column(name = "NGAYDANGKI", columnDefinition = "datetime", nullable = false)
	private LocalDateTime ngayDangKi;
	@Column(name = "NGAYNHANPHONG", columnDefinition = "datetime", nullable = false)
	private LocalDateTime ngayNhanPhong;
	@Column(name = "TRANGTHAI", columnDefinition = "bit", nullable = false)
	private boolean tinhtrang;

	@OneToMany(mappedBy = "phieuDatPhongCho")
	private Set<ChiTietPhieuDatPhongCho> dsChiTietPhieuDatPhongCho;

	public String getMaPhieuDatPhongCho() {
		return maPhieuDatPhongCho;
	}

	public void setMaPhieuDatPhongCho(String maPhieuDatPhongCho) {
		this.maPhieuDatPhongCho = maPhieuDatPhongCho;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public LocalDateTime getNgayDangKi() {
		return ngayDangKi;
	}

	public void setNgayDangKi(LocalDateTime ngayDangKi) {
		this.ngayDangKi = ngayDangKi;
	}

	public LocalDateTime getNgayNhanPhong() {
		return ngayNhanPhong;
	}

	public void setNgayNhanPhong(LocalDateTime ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
	}

	public boolean isTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(boolean tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public Set<ChiTietPhieuDatPhongCho> getDsChiTietPhieuDatPhongCho() {
		return dsChiTietPhieuDatPhongCho;
	}

	public void setDsChiTietPhieuDatPhongCho(Set<ChiTietPhieuDatPhongCho> dsChiTietPhieuDatPhongCho) {
		this.dsChiTietPhieuDatPhongCho = dsChiTietPhieuDatPhongCho;
	}

	public PhieuDatPhongCho() {
	}

	public PhieuDatPhongCho(String maPhieuDatPhongCho, KhachHang khachHang, NhanVien nhanVien, LocalDateTime ngayDangKi,
			LocalDateTime ngayNhanPhong, boolean tinhtrang) {
		this.maPhieuDatPhongCho = maPhieuDatPhongCho;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayDangKi = ngayDangKi;
		this.ngayNhanPhong = ngayNhanPhong;
		this.tinhtrang = tinhtrang;
	}

	@Override
	public String toString() {
		return "PhieuDatPhongCho [maPhieuDatPhongCho=" + maPhieuDatPhongCho + ", khachHang=" + khachHang + ", nhanVien="
				+ nhanVien + ", ngayDangKi=" + ngayDangKi + ", ngayNhanPhong=" + ngayNhanPhong + ", tinhtrang="
				+ tinhtrang + "]";
	}

}
