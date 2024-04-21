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

@Entity
@DiscriminatorValue("CHITIETPHIEUDATDICHVU")
@NamedQueries({
//tìm tất cả chi tiết phiếu đặt dịch vụ
		@NamedQuery(name = "ChiTietPhieuDatDichVu.timTatCaChiTietDatDichVu", query = "select d from ChiTietPhieuDatDichVu d"),

		@NamedQuery(name = "ChiTietPhieuDatDichVu.timChiTietDichVuTheoMaPhieuDat", query = "select c from ChiTietPhieuDatDichVu c where c.phieuDat.maPhieuDat = :maPhieuDat"),
		
		@NamedQuery(name = "ChiTietPhieuDatDichVu.timTheoMaDichVu", query = "select c from ChiTietPhieuDatDichVu c where c.dichVu.maDV = :maDV") ,
		
		@NamedQuery(name = "ChiTietPhieuDatDichVu.timPhieuĐatichVuTheoTenKhachHang", query = "select d from ChiTietPhieuDatDichVu d where d.phieuDat.khachHang.tenKhachHang = :tenKhachHang")
		
		,@NamedQuery(name = "ChiTietPhieuDatDichVu.timTheoMaKhachHang", query = "select c from ChiTietPhieuDatDichVu c where c.phieuDat.khachHang.maKH = :maKH")
		// xóa chi tiết phiếu đặt dịch vụ theo mã phiếu đặt
		,@NamedQuery(name = "ChiTietPhieuDatDichVu.xoaChiTietPhieuDatDichVuTheoMaPhieuDat", query = "delete from ChiTietPhieuDatDichVu d where d.phieuDat.maPhieuDat = :maPhieuDat")
})

@Table(name = "CHITIETPHIEUDATDICHVU")

//@NamedQueries({
//		// tìm tất cả chi tiết phiếu đặt dịch vụ
//		@NamedQuery(name = "ChiTietPhieuDatDichVu.timTatCaChiTietPhieuDatDichVu", query = "select d from ChiTietPhieuDatDichVu d"),
//		// tìm chi tiết phiếu đặt dịch vụ theo mã phiếu đặt
//		@NamedQuery(name = "ChiTietPhieuDatDichVu.timChiTietPhieuDatDichVuTheoMaPhieuDat", query = "select d from ChiTietPhieuDatDichVu d where d.phieuDat.maPhieuDat = :maPhieuDat"),
//		// tìm danh sach dich vu theo ma phieu dat
//		@NamedQuery(name = "ChiTietPhieuDatDichVu.findDichVuByMaPhieuDat", query = "select d.dichVu from ChiTietPhieuDatDichVu d where d.phieuDat.maPhieuDat = :maPhieuDat"),
//		// xóa chi tiết phiếu đặt dịch vụ theo mã phiếu đặt
//		@NamedQuery(name = "ChiTietPhieuDatDichVu.xoaChiTietPhieuDatDichVuTheoMaPhieuDat", query = "delete from ChiTietPhieuDatDichVu d where d.phieuDat.maPhieuDat = :maPhieuDat"),
//		// xóa chi tiết phiếu đặt dịch vụ theo tên khách hàng
//		@NamedQuery(name = "ChiTietPhieuDatDichVu.xoaChiTietPhieuDatDichVuTheoTenKhachHang", query = "delete from ChiTietPhieuDatDichVu d where d.phieuDat.khachHang.tenKH = :tenKhachHang"),
//		// tìm chi tiết phiếu đặt theo khách hàng
//		@NamedQuery(name = "ChiTietPhieuDatDichVu.timPhieuĐatichVuTheoMaKhachHang", query = "select d from ChiTietPhieuDatDichVu d where d.phieuDat.khachHang.maKH = :maKH"),
//		// tìm chi tiết phiếu đặt theo tên khách hàng
//		@NamedQuery(name = "ChiTietPhieuDatDichVu.timPhieuĐatichVuTheoTenKhachHang", query = "select d from ChiTietPhieuDatDichVu d where d.phieuDat.khachHang.tenKH = :tenKhachHang"),
//})
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

	public PhieuDat getPhieuDat() {
		return phieuDat;
	}

	public void setPhieuDat(PhieuDat phieuDat) {
		this.phieuDat = phieuDat;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public ChiTietPhieuDatDichVu() {
	}

	public ChiTietPhieuDatDichVu(PhieuDat phieuDat, DichVu dichVu, int soLuong) {
		this.phieuDat = phieuDat;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuDatDichVu [phieuDat=" + phieuDat + ", dichVu=" + dichVu + ", soLuong=" + soLuong + "]";
	}

}
