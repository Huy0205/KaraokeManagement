package entites;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@DiscriminatorValue("CHITIETPHIEUDATDICHVU")
@NamedQueries({
//tìm tất cả chi tiết phiếu đặt dịch vụ
		@NamedQuery(name = "ChiTietPhieuDatDichVu.findAll", query = "select d from ChiTietPhieuDatDichVu d"),

		@NamedQuery(name = "ChiTietPhieuDatDichVu.findByMaPhieuDat", query = "select c from ChiTietPhieuDatDichVu c where c.phieuDat.maPhieuDat = :maPhieuDat"),
		
		@NamedQuery(name = "ChiTietPhieuDatDichVu.findByMaDichVu", query = "select c from ChiTietPhieuDatDichVu c where c.dichVu.maDV = :maDV") ,
		
		@NamedQuery(name = "ChiTietPhieuDatDichVu.timPhieuĐatichVuTheoTenKhachHang", query = "select d from ChiTietPhieuDatDichVu d where d.phieuDat.khachHang.tenKhachHang = :tenKhachHang")
})

@Table(name = "CHITIETPHIEUDATDICHVU")
public class ChiTietPhieuDatDichVu implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "MAPHIEUDAT", referencedColumnName = "MAPHIEUDAT")
	private PhieuDat phieuDat;
	@Id
	@ManyToOne
	@JoinColumn(name = "MADV", referencedColumnName = "MADV")
	private DichVu dichVu;
	@Column(name = "SOLUONG", columnDefinition = "int", nullable = false)
	private int soLuong;
}
