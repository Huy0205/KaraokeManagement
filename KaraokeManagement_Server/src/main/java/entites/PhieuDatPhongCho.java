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

	public PhieuDatPhongCho(String maPhieuDatPhongCho, KhachHang khachHang, NhanVien nhanVien, LocalDateTime ngayDangKi,
			LocalDateTime ngayNhanPhong, boolean tinhtrang) {
		this.maPhieuDatPhongCho = maPhieuDatPhongCho;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayDangKi = ngayDangKi;
		this.ngayNhanPhong = ngayNhanPhong;
		this.tinhtrang = tinhtrang;
	}
}
