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
@Table(name = "DICHVU")
public class DichVu implements Serializable {
	@Id
	@Column(name = "MADV", columnDefinition = "varchar(10)")
	private String maDV;
	@Column(name = "TENDV", columnDefinition = "nvarchar(50)", nullable = false)
	private String tenDichVu;
	@Column(name = "DONGIA", columnDefinition = "double", nullable = false)
	private double donGia;
	@Column(name = "DONVI", columnDefinition = "nvarchar(20)")
	private String donVi;
	@Column(name = "SOLUONGTONKHO", columnDefinition = "int")
	private int soLuongTonKho;
}
