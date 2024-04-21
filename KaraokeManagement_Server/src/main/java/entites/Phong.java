package entites;

import java.io.Serializable;

import jakarta.persistence.*;
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
@Table(name = "PHONG")
@NamedQueries({
		@NamedQuery(name = "Phong.findAll", query = "SELECT p FROM Phong p JOIN p.loaiPhong lp"),
		@NamedQuery(name = "Phong.findById", query = "SELECT p FROM Phong p JOIN p.loaiPhong lp WHERE p.maPhong = :maPhong"),
		@NamedQuery(name = "Phong.findTrangThai", query = "SELECT p.trangThai FROM Phong p"),
})
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
	private double DonGia;
	public void setTrangThai(String trangThai) {
		// TODO Auto-generated method stub
		
	}
}
