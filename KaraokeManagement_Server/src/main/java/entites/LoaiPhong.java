package entites;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "LOAIPHONG")
public class LoaiPhong implements Serializable {
	@Id
	@Column(name = "MALOAIPHONG", columnDefinition = "varchar(10)")
	private String maLoaiPhong;
	@Column(name = "TENLOAIPHONG", columnDefinition = "nvarchar(50)", nullable = false)
	private String tenLoaiPhong;
}
