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
@Table(name = "CHITIETHOADON")

@NamedQueries({
		@NamedQuery(name = "ChiTietHoaDon.findByMaHoaDon", query = "SELECT c FROM ChiTietHoaDon c WHERE c.hoaDon.maHoaDon = :maHD"),
		@NamedQuery(name = "ChiTietHoaDon.findByMaPhong", query = "SELECT c FROM ChiTietHoaDon c WHERE c.phong.maPhong = :maPhong") })

public class ChiTietHoaDon implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "MAHOADON", referencedColumnName = "MAHOADON")
	private HoaDon hoaDon;
	@Id
	@ManyToOne
	@JoinColumn(name = "MAPHONG", referencedColumnName = "MAPHONG")
	private Phong phong;
	@Column(name = "THOILUONG", columnDefinition = "int")
	private int thoiLuong;

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public int getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	public ChiTietHoaDon() {
	}

	public ChiTietHoaDon(HoaDon hoaDon, Phong phong, int thoiLuong) {
		this.hoaDon = hoaDon;
		this.phong = phong;
		this.thoiLuong = thoiLuong;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [hoaDon=" + hoaDon + ", phong=" + phong + ", thoiLuong=" + thoiLuong + "]";
	}

}
