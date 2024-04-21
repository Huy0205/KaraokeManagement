package entites;

import java.io.Serializable;

import jakarta.persistence.*;
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
@Table(name = "LOAIPHONG")
@NamedQueries({
		@NamedQuery(name = "LoaiPhong.findAll", query = "SELECT lp FROM LoaiPhong lp"),
		@NamedQuery(name="LoaiPhong.findByID", query="SELECT lp FROM LoaiPhong lp WHERE lp.maLoaiPhong = :maLoaiPhong")
})
public class LoaiPhong implements Serializable {
	@Id
	@Column(name = "MALOAIPHONG", columnDefinition = "varchar(10)")
	private String maLoaiPhong;
	@Column(name = "TENLOAIPHONG", columnDefinition = "nvarchar(50)", nullable = false)
	private String tenLoaiPhong;
}
