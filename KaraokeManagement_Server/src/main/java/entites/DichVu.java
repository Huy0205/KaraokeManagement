package entites;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "DICHVU")

@NamedQueries({ @NamedQuery(name = "DichVu.findAll", query = "SELECT dv FROM DichVu dv"),
		@NamedQuery(name = "DichVu.search", query = "SELECT dv FROM DichVu dv " + "WHERE dv.maDV LIKE :maDV "
				+ "OR dv.tenDichVu LIKE :tenDichVu " + "OR dv.donGia = :donGia " + "OR dv.donVi LIKE :donVi "
				+ "OR dv.soLuongTonKho = :soLuongTonKho"),
		@NamedQuery(name = "DichVu.deleteByMaDV", query = "DELETE FROM DichVu dv WHERE dv.maDV = :maDV"),
		@NamedQuery(name = "DichVu.updateDichVu", query = "UPDATE DichVu dv SET dv.tenDichVu = :tenDichVu, dv.donGia = :donGia, dv.donVi = :donVi, dv.soLuongTonKho = :soLuongTonKho "
				+ "WHERE dv.maDV = :maDV"),
		@NamedQuery(name = "DichVu.themDichVu", query = "INSERT INTO DichVu (maDV, tenDichVu, donGia, donVi, soLuongTonKho) "
				+ "VALUES (:maDV, :tenDichVu, :donGia, :donVi, :soLuongTonKho)"),
		@NamedQuery(name = "DichVu.updateSoLuongTonDV", query = "UPDATE DichVu dv SET dv.soLuongTonKho = :soLuongTonKho "
				+ "WHERE dv.maDV = :maDV") })

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

	public void setSoLuongTonKho(int slMoi) {
		// TODO Auto-generated method stub

	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public String getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public int getSoLuongTonKho() {
		return soLuongTonKho;
	}

	public DichVu() {
	}

	public DichVu(String maDV, String tenDichVu, double donGia, String donVi, int soLuongTonKho) {
		this.maDV = maDV;
		this.tenDichVu = tenDichVu;
		this.donGia = donGia;
		this.donVi = donVi;
		this.soLuongTonKho = soLuongTonKho;
	}

	@Override
	public String toString() {
		return "DichVu [maDV=" + maDV + ", tenDichVu=" + tenDichVu + ", donGia=" + donGia + ", donVi=" + donVi
				+ ", soLuongTonKho=" + soLuongTonKho + "]";
	}

}
