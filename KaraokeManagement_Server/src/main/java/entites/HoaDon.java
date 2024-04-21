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
@Table(name = "HOADON")

@NamedQueries({ @NamedQuery(name = "HoaDon.findAll", query = "SELECT hd FROM HoaDon hd"),
		@NamedQuery(name = "HoaDon.findById", query = "SELECT hd FROM HoaDon hd WHERE hd.maHoaDon = :maHD"),
		@NamedQuery(name = "HoaDon.findByYear", query = "SELECT hd FROM HoaDon hd WHERE YEAR(hd.ngayTao) = :nam"),
		@NamedQuery(name = "HoaDon.findByMonth", query = "SELECT hd FROM HoaDon hd WHERE MONTH(hd.ngayTao) = :thang AND YEAR(hd.ngayTao) = :nam"),
		@NamedQuery(name = "HoaDon.findByDay", query = "SELECT hd FROM HoaDon hd WHERE DAY(hd.ngayTao) = :ngay AND MONTH(hd.ngayTao) = :thang AND YEAR(hd.ngayTao) = :nam"),
		@NamedQuery(name = "HoaDon.numberOfHoaDonByHour", query = "SELECT COUNT(hd) FROM HoaDon hd WHERE DAY(hd.ngayTao) = :ngay AND MONTH(hd.ngayTao) = :thang AND YEAR(hd.ngayTao) = :nam AND HOUR(hd.thoiGianBatDau) = :gio") })

public class HoaDon implements Serializable {
	@Id
	@Column(name = "MAHOADON", columnDefinition = "varchar(10)")
	private String maHoaDon;
	@Column(name = "THOIGIANBD", columnDefinition = "datetime", nullable = false)
	private LocalDateTime thoiGianBatDau;
	@Column(name = "THOIGIANKT", columnDefinition = "datetime", nullable = false)
	private LocalDateTime thoiGianKetThuc;
	@Column(name = "NGAYTAO", columnDefinition = "datetime", nullable = false)
	private LocalDateTime ngayTao;
	@ManyToOne
	@JoinColumn(name = "MANV", referencedColumnName = "MANV", nullable = false)
	private NhanVien nhanVien;
	@ManyToOne
	@JoinColumn(name = "MAKH", referencedColumnName = "MAKH", nullable = false)
	private KhachHang khachHang;
	@OneToMany(mappedBy = "hoaDon")
	private Set<ChiTietHoaDon> dsChiTietHoaDon;
	@OneToMany(mappedBy = "hoaDon")
	private Set<ChiTietDichVu> dsChiTietDichVu;

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public LocalDateTime getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(LocalDateTime thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public LocalDateTime getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(LocalDateTime thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public LocalDateTime getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(LocalDateTime ngayTao) {
		this.ngayTao = ngayTao;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Set<ChiTietHoaDon> getDsChiTietHoaDon() {
		return dsChiTietHoaDon;
	}

	public void setDsChiTietHoaDon(Set<ChiTietHoaDon> dsChiTietHoaDon) {
		this.dsChiTietHoaDon = dsChiTietHoaDon;
	}

	public Set<ChiTietDichVu> getDsChiTietDichVu() {
		return dsChiTietDichVu;
	}

	public void setDsChiTietDichVu(Set<ChiTietDichVu> dsChiTietDichVu) {
		this.dsChiTietDichVu = dsChiTietDichVu;
	}

	public HoaDon() {
		super();
	}

	public HoaDon(String maHoaDon, LocalDateTime thoiGianBatDau, LocalDateTime thoiGianKetThuc, LocalDateTime ngayTao,
			NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.maHoaDon = maHoaDon;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.ngayTao = ngayTao;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", thoiGianBatDau=" + thoiGianBatDau + ", thoiGianKetThuc="
				+ thoiGianKetThuc + ", ngayTao=" + ngayTao + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang
				+ "]";
	}

}
