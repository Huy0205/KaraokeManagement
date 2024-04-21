package entites;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "KHACHHANG")

@NamedQueries({ @NamedQuery(name = "KhachHang.findAll", query = "SELECT k FROM KhachHang k"),
		@NamedQuery(name = "KhachHang.findByMaKH", query = "SELECT k FROM KhachHang k WHERE k.maKH = :maKH"),
		@NamedQuery(name = "KhachHang.findBySDT", query = "SELECT k FROM KhachHang k WHERE k.sdt = :sdt") })

public class KhachHang implements Serializable {
	@Id
	@Column(name = "MAKH", columnDefinition = "varchar(10)")
	private String maKH;
	@Column(name = "TENKH", columnDefinition = "nvarchar(50)", nullable = false)
	private String tenKH;
	@Column(name = "SDT", columnDefinition = "varchar(15)", nullable = false)
	private String sdt;
	@Column(name = "DIACHI", columnDefinition = "nvarchar(200)")
	private String diaChi;

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public KhachHang() {
	}

	public KhachHang(String maKH, String tenKH, String sdt, String diaChi) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", diaChi=" + diaChi + "]";
	}

}
