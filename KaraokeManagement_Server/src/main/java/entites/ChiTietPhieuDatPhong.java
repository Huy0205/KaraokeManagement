package entites;

import java.io.Serializable;

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
@Table(name = "CHITIETPHIEUDATPHONG")
public class ChiTietPhieuDatPhong implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "MAPHIEUDAT", referencedColumnName = "MAPHIEUDAT")
	private PhieuDat phieuDat;
	@Id
	@ManyToOne
	@JoinColumn(name = "MAPHONG", referencedColumnName = "MAPHONG")
	private Phong phong;
}
