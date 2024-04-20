package entites;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "NHANVIEN")
public class NhanVien implements Serializable {
	@Id
	@Column(name = "MANV", columnDefinition = "varchar(10)")
	private String maNV;
	@Column(name = "TENNV", columnDefinition = "nvarchar(50)", nullable = false)
	private String tenNV;
	@Column(name = "CMND", columnDefinition = "varchar(10)")
	private String cmnd;
	@Column(name = "SDT", columnDefinition = "varchar(12)", nullable = false)
	private String sdt;
	@Column(name = "DIACHI", columnDefinition = "nvarchar(200)")
	private String diaChi;
	@Column(name = "GIOITINH", columnDefinition = "bit")
	private boolean gioiTinh;
	@Column(name = "TAIKHOAN", columnDefinition = "varchar(50)", nullable = false)
	private String taiKhoan;
	@Column(name = "MATKHAU", columnDefinition = "varchar(50)", nullable = false)
	private String matKhau;
	@Column(name = "CHUCVU", columnDefinition = "nvarchar(4)", nullable = false)
	private String chucVu;
}
