package entites;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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

@NamedQueries({
		@NamedQuery(name = "ChiTietHoaDon.findByMaHoaDon", query = "SELECT c FROM ChiTietHoaDon c WHERE c.hoaDon.maHoaDon = :maHD"),
		@NamedQuery(name = "ChiTietHoaDon.findByMaPhong", query = "SELECT c FROM ChiTietHoaDon c WHERE c.phong.maPhong = :maPhong")
})

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
