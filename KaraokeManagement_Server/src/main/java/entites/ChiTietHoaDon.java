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
@Table(name = "CHITIETHOADON")
public class ChiTietHoaDon implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "MAHOADON", referencedColumnName = "MAHOADON")
	private HoaDon hoaDon;
	@Id
	@ManyToOne
	@JoinColumn(name = "MAPHONG", referencedColumnName = "MAPHONG")
	private Phong phong;
	@Column(name = "THOILUONG", columnDefinition = "int")
	private int thoiLuong;
}
