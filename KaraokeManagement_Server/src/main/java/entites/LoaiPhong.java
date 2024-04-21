package entites;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "LOAIPHONG")
@NamedQueries({ @NamedQuery(name = "LoaiPhong.findAll", query = "SELECT lp FROM LoaiPhong lp"),
		@NamedQuery(name = "LoaiPhong.findByID", query = "SELECT lp FROM LoaiPhong lp WHERE lp.maLoaiPhong = :maLoaiPhong") })
public class LoaiPhong implements Serializable {
	@Id
	@Column(name = "MALOAIPHONG", columnDefinition = "varchar(10)")
	private String maLoaiPhong;
	@Column(name = "TENLOAIPHONG", columnDefinition = "nvarchar(50)", nullable = false)
	private String tenLoaiPhong;

	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}

	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}

	public LoaiPhong() {
	}

	public LoaiPhong(String maLoaiPhong, String tenLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
	}

	@Override
	public String toString() {
		return "LoaiPhong [maLoaiPhong=" + maLoaiPhong + ", tenLoaiPhong=" + tenLoaiPhong + "]";
	}

}
