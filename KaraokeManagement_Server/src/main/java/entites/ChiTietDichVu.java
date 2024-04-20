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
@Table(name = "CHITIETDICHVU")

@NamedQueries({
		@NamedQuery(name = "ChiTietDichVu.findByMaHoaDon", query = "SELECT ct FROM ChiTietDichVu ct WHERE ct.hoaDon.maHoaDon = :maHD") 
})

public class ChiTietDichVu implements Serializable{
	@Id
	@ManyToOne
	@JoinColumn(name = "MAHOADON", referencedColumnName = "MAHOADON")
	private HoaDon hoaDon;
	@Id
	@ManyToOne
	@JoinColumn(name = "MADV", referencedColumnName = "MADV")
	private DichVu dichVu;
	@Column(name = "SOLUONG", columnDefinition = "int")
	private int soLuong;
}
