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
@Table(name = "PHIEUDAT")
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

	public PhieuDat(String maPhieuDat, KhachHang khachHang, NhanVien nhanVien, LocalDateTime ngayDat,
			boolean trangThai) {
		this.maPhieuDat = maPhieuDat;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayDat = ngayDat;
		this.trangThai = trangThai;
	}
}
