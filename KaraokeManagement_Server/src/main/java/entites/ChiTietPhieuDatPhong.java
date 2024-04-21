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

@Entity

@DiscriminatorValue("CHITIETPHIEUDATPHONG")

@NamedQueries({
		// tim tat ca chi tiet phieu dat phong
		@NamedQuery(name = "ChiTietPhieuDatPhong.timTatCaChiTietPhieuThuePhong", query = "select d from ChiTietPhieuDatPhong d"),
		// tim chi tiet phieu dat phong theo ma phieu dat
		@NamedQuery(name = "ChiTietPhieuDatPhong.timChiTietPhieuDatPhongTheoMaKH", query = "select d from ChiTietPhieuDatPhong d where d.phieuDat.maPhieuDat = :maPhieuDat"),
		// tìm chi tiết phiếu đặt theo mã phòng
		@NamedQuery(name = "ChiTietPhieuDatPhong.timChiTietPhieuDatPhongTheoMaPhong", query = "select d from ChiTietPhieuDatPhong d where d.phong.maPhong = :maPhong"),
		// xoa chi tiet phieu dat phong theo ma phieu dat
		@NamedQuery(name = "ChiTietPhieuDatPhong.xoaChiTietPhieuDatPhongTheoMaPhieuDat", query = "delete from ChiTietPhieuDatPhong d where d.phieuDat.maPhieuDat = :maPhieuDat"),
               // xoa chi tiet phieu dat phong theo ma phong
		@NamedQuery(name = "ChiTietPhieuDatPhong.xoaChiTietPhieuDatPhongTheoMaPhong", query = "delete from ChiTietPhieuDatPhong d where d.phong.maPhong = :maPhong"),
})
       




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
