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
@Table(name = "PHONG")
@NamedQueries({ @NamedQuery(name = "Phong.findAll", query = "SELECT p FROM Phong p JOIN p.loaiPhong lp"),
		@NamedQuery(name = "Phong.findById", query = "SELECT p FROM Phong p JOIN p.loaiPhong lp WHERE p.maPhong = :maPhong"),
		@NamedQuery(name = "Phong.findTrangThai", query = "SELECT p.trangThai FROM Phong p"), })
public class Phong implements Serializable {
	@Id
	@Column(name = "MAPHONG", columnDefinition = "varchar(10)")
	private String maPhong;
	@Column(name = "TENPHONG", columnDefinition = "nvarchar(50)", nullable = false)
	private String tenPhong;
	@Column(name = "TRANGTHAI", columnDefinition = "nvarchar(50)", nullable = false)
	private String trangThai;
	@ManyToOne
	@JoinColumn(name = "MALOAIPHONG", referencedColumnName = "MALOAIPHONG", nullable = false)
	private LoaiPhong loaiPhong;
	@Column(name = "SUCCHUA", columnDefinition = "int", nullable = false)
	private int sucChua;
	@Column(name = "DONGIA", columnDefinition = "double", nullable = false)
	private double donGia;

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public Phong() {
		super();
	}

	public Phong(String maPhong, String tenPhong, String trangThai, LoaiPhong loaiPhong, int sucChua, double donGia) {
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.trangThai = trangThai;
		this.loaiPhong = loaiPhong;
		this.sucChua = sucChua;
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", trangThai=" + trangThai + ", loaiPhong="
				+ loaiPhong + ", sucChua=" + sucChua + ", DonGia=" + donGia + "]";
	}

}
