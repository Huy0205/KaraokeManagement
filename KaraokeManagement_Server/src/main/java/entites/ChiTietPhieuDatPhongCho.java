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

@DiscriminatorValue("CHITIETPHIEUDATPHONGCHO")
  
@NamedQueries({
	// tìm tất cả chi tiết phiếu đặt phòng cho
	@NamedQuery(name = "ChiTietPhieuDatPhongCho.timTatCacPhieuDatPhongCho", query = "select d from ChiTietPhieuDatPhongCho d"),
	// tìm chi tiết phiếu đặt phòng cho theo mã phiếu đặt
	@NamedQuery(name = "ChiTietPhieuDatPhongCho.findByMaPhieuDatPhongCho", query = "select d from ChiTietPhieuDatPhongCho d where d.phieuDatPhongCho.maPhieuDatPhongCho = :maPhieuDatPhongCho"),
	// tìm chi tiết phiếu đặt phòng cho theo mã phòng
	@NamedQuery(name = "ChiTietPhieuDatPhongCho.findByMaPhong", query = "select d from ChiTietPhieuDatPhongCho d where d.phong.maPhong = :maPhong"),
})
 
@Table(name = "CHITIETPHIEUDATPHONGCHO")
public class ChiTietPhieuDatPhongCho implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "MAPHIEUDATPHONGCHO", referencedColumnName = "MAPHIEUDATPHONGCHO")
	private PhieuDatPhongCho phieuDatPhongCho;
	@Id
	@ManyToOne
	@JoinColumn(name = "MAPHONG", referencedColumnName = "MAPHONG")
	private Phong phong;
}
