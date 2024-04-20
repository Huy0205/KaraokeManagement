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
@Table(name = "CHITIETPHIEUDATDICHVU")
public class ChiTietPhieuDatDichVu implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "MAPHIEUDAT", referencedColumnName = "MAPHIEUDAT")
	private PhieuDat phieuDat;
	@Id
	@ManyToOne
	@JoinColumn(name = "MADV", referencedColumnName = "MADV")
	private DichVu dichVu;
	@Column(name = "SOLUONG", columnDefinition = "int", nullable = false)
	private int soLuong;
}
