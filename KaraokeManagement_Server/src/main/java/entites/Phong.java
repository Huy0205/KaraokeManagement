package entites;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "PHONG")
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
}
