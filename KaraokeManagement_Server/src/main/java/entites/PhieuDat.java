package entites;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PHIEUDAT")
@NamedQueries({ @NamedQuery(name = "PhieuDat.findAll", query = "SELECT pd FROM PhieuDat pd"),
		@NamedQuery(name = "PhieuDat.findById", query = "SELECT pd FROM PhieuDat pd WHERE pd.maPhieuDat = :maPhieuDat") })
public class PhieuDat implements Serializable {
	@Id
	@Column(name = "MAPHIEUDAT", columnDefinition = "varchar(10)")
	private String maPhieuDat;
	@ManyToOne
	@JoinColumn(name = "MAKH", referencedColumnName = "MAKH", nullable = false)
	private KhachHang khachHang;
	@ManyToOne
	@JoinColumn(name = "MANV", referencedColumnName = "MANV", nullable = false)
	private NhanVien nhanVien;
	@Column(name = "NGAYDAT", columnDefinition = "datetime", nullable = false)
	private LocalDateTime ngayDat;
	@Column(name = "TRANGTHAI", columnDefinition = "bit", nullable = false)
	private boolean trangThai;

	@OneToMany(mappedBy = "phieuDat")
	private Set<ChiTietPhieuDatPhong> dsChiTietPhieuDatPhong;
	@OneToMany(mappedBy = "phieuDat")
	private Set<ChiTietPhieuDatDichVu> dsChiTietPhieuDatDichVu;

	public String getMaPhieuDat() {
		return maPhieuDat;
	}

	public void setMaPhieuDat(String maPhieuDat) {
		this.maPhieuDat = maPhieuDat;
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

	public LocalDateTime getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(LocalDateTime ngayDat) {
		this.ngayDat = ngayDat;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public Set<ChiTietPhieuDatPhong> getDsChiTietPhieuDatPhong() {
		return dsChiTietPhieuDatPhong;
	}

	public void setDsChiTietPhieuDatPhong(Set<ChiTietPhieuDatPhong> dsChiTietPhieuDatPhong) {
		this.dsChiTietPhieuDatPhong = dsChiTietPhieuDatPhong;
	}

	public Set<ChiTietPhieuDatDichVu> getDsChiTietPhieuDatDichVu() {
		return dsChiTietPhieuDatDichVu;
	}

	public void setDsChiTietPhieuDatDichVu(Set<ChiTietPhieuDatDichVu> dsChiTietPhieuDatDichVu) {
		this.dsChiTietPhieuDatDichVu = dsChiTietPhieuDatDichVu;
	}

	public PhieuDat() {
	}

	public PhieuDat(String maPhieuDat, KhachHang khachHang, NhanVien nhanVien, LocalDateTime ngayDat,
			boolean trangThai) {
		this.maPhieuDat = maPhieuDat;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayDat = ngayDat;
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "PhieuDat [maPhieuDat=" + maPhieuDat + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien
				+ ", ngayDat=" + ngayDat + ", trangThai=" + trangThai + "]";
	}

}
