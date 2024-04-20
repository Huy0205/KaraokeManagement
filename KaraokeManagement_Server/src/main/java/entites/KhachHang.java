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
@Table(name = "KHACHHANG")
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
}
