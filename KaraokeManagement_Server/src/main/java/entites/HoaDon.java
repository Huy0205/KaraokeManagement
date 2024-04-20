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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "HOADON")

@NamedQueries({
	    @NamedQuery(name = "HoaDon.findAll", query = "SELECT hd FROM HoaDon hd"),
	    @NamedQuery(name = "HoaDon.findById", query = "SELECT hd FROM HoaDon hd WHERE hd.maHoaDon = :maHD"),	    
	    @NamedQuery(name = "HoaDon.findByYear", query = "SELECT hd FROM HoaDon hd WHERE YEAR(hd.NgayTao) = :nam"),
	    @NamedQuery(name = "HoaDon.findByMonth", query = "SELECT hd FROM HoaDon hd WHERE MONTH(hd.NgayTao) = :thang AND YEAR(hd.NgayTao) = :nam"),
	    @NamedQuery(name = "HoaDon.findByDay", query = "SELECT hd FROM HoaDon hd WHERE DAY(hd.NgayTao) = :ngay AND MONTH(hd.NgayTao) = :thang AND YEAR(hd.NgayTao) = :nam"),
	    @NamedQuery(name = "HoaDon.numberOfHoaDonByHour", query = "SELECT COUNT(hd) FROM HoaDon hd WHERE DAY(hd.NgayTao) = :ngay AND MONTH(hd.NgayTao) = :thang AND YEAR(hd.NgayTao) = :nam AND HOUR(hd.thoiGianBatDau) = :gio")
})

public class HoaDon implements Serializable {
	@Id
	@Column(name = "MAHOADON", columnDefinition = "varchar(10)")
	private String maHoaDon;
	@Column(name = "THOIGIANBD", columnDefinition = "datetime", nullable = false)
	private LocalDateTime thoiGianBatDau;
	@Column(name = "THOIGIANKT", columnDefinition = "datetime", nullable = false)
	private LocalDateTime thoiGianKetThuc;
	@Column(name = "NGAYTAO", columnDefinition = "datetime", nullable = false)
	private LocalDateTime NgayTao;
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

	public HoaDon(String maHoaDon, LocalDateTime thoiGianBatDau, LocalDateTime thoiGianKetThuc, LocalDateTime ngayTao,
			NhanVien nhanVien, KhachHang khachHang) {
		this.maHoaDon = maHoaDon;
		this.thoiGianBatDau = thoiGianBatDau;
		this.thoiGianKetThuc = thoiGianKetThuc;
		NgayTao = ngayTao;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}

}
