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
		@NamedQuery(name = "ChiTietPhieuDatPhong.findAll", query = "select d from ChiTietPhieuDatPhong d"),
		// tìm chi tiết phiếu đặt thêm theo mã phiếu đặt
		@NamedQuery(name = "ChiTietPhieuDatPhong.findByMaPhieuDat", query = "select d from ChiTietPhieuDatPhong d where d.phieuDat.maPhieuDat = :maPhieuDat"),
		// tìm chi tiết phiếu đặt theo mã phòng
		@NamedQuery(name = "ChiTietPhieuDatPhong.findByMaPhong", query = "select d from ChiTietPhieuDatPhong d where d.phong.maPhong = :maPhong"),
		// xóa chi tiết phiếu đặt phòng theo mã phiếu đặt
		@NamedQuery(name = "ChiTietPhieuDatPhong.deleteByMaPhieuDat", query = "delete from ChiTietPhieuDatPhong d where d.phieuDat.maPhieuDat = :maPhieuDat"),
		// xóa chi tiết phiếu đặt phòng theo mã phòng
		@NamedQuery(name = "ChiTietPhieuDatPhong.deleteByMaPhong", query = "delete from ChiTietPhieuDatPhong d where d.phong.maPhong = :maPhong"),
		// cập nhật chi tiết phiếu đặt phòng theo mã phiếu đặt
		@NamedQuery(name = "ChiTietPhieuDatPhong.updateByMaPhieuDat", query = "update ChiTietPhieuDatPhong d set d.phong.maPhong = :maPhong where d.phieuDat.maPhieuDat = :maPhieuDat"),

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

	public PhieuDat getPhieuDat() {
		return phieuDat;
	}

	public void setPhieuDat(PhieuDat phieuDat) {
		this.phieuDat = phieuDat;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public ChiTietPhieuDatPhong() {
	}

	public ChiTietPhieuDatPhong(PhieuDat phieuDat, Phong phong) {
		this.phieuDat = phieuDat;
		this.phong = phong;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuDatPhong [phieuDat=" + phieuDat + ", phong=" + phong + "]";
	}

}
