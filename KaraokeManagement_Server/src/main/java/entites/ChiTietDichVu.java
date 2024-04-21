package entites;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "CHITIETDICHVU")

@NamedQueries({
		@NamedQuery(name = "ChiTietDichVu.findByMaHoaDon", query = "SELECT ct FROM ChiTietDichVu ct WHERE ct.hoaDon.maHoaDon = :maHD") })

public class ChiTietDichVu implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "MAHOADON", referencedColumnName = "MAHOADON")
	private HoaDon hoaDon;
	@Id
	@ManyToOne
	@JoinColumn(name = "MADV", referencedColumnName = "MADV")
	private DichVu dichVu;
	@Column(name = "SOLUONG", columnDefinition = "int")
	private int soLuong;

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
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

	public ChiTietDichVu() {
	}

	public ChiTietDichVu(HoaDon hoaDon, DichVu dichVu, int soLuong) {
		this.hoaDon = hoaDon;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietDichVu [hoaDon=" + hoaDon + ", dichVu=" + dichVu + ", soLuong=" + soLuong + "]";
	}

}
