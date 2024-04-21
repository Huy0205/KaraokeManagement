package entites;

import java.io.Serializable;

import jakarta.persistence.DiscriminatorValue;
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
@DiscriminatorValue("CHITIETPHIEUDATPHONG")
@NamedQueries({
		// tim tat ca chi tiet phieu dat phong
		@NamedQuery(name = "ChiTietPhieuDatPhong.findAll", query = "select d from ChiTietPhieuDatPhong d"),
		// tim chi tiet phieu dat phong theo ma phieu dat
		@NamedQuery(name = "ChiTietPhieuDatPhong.findByMaPhieuDat", query = "select d from ChiTietPhieuDatPhong d where d.phieuDat.maPhieuDat = :maPhieuDat"),
		// tìm chi tiết phiếu đặt theo mã phòng
		@NamedQuery(name = "ChiTietPhieuDatPhong.findByMaPhong", query = "select d from ChiTietPhieuDatPhong d where d.phong.maPhong = :maPhong"), })
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
