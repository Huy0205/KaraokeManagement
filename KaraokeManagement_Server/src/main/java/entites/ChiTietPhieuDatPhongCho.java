package entites;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
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

	public PhieuDatPhongCho getPhieuDatPhongCho() {
		return phieuDatPhongCho;
	}

	public void setPhieuDatPhongCho(PhieuDatPhongCho phieuDatPhongCho) {
		this.phieuDatPhongCho = phieuDatPhongCho;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public ChiTietPhieuDatPhongCho() {
	}

	public ChiTietPhieuDatPhongCho(PhieuDatPhongCho phieuDatPhongCho, Phong phong) {
		this.phieuDatPhongCho = phieuDatPhongCho;
		this.phong = phong;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuDatPhongCho [phieuDatPhongCho=" + phieuDatPhongCho + ", phong=" + phong + "]";
	}

}
