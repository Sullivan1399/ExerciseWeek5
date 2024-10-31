package vn.ntkiet.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryId")
	private int categoryId;

	@Column(name = "categoryName", columnDefinition = "NVARCHAR(200) NOT NULL")
	@NotEmpty(message = "Không được để trống")
	private String categoryName;

	@Column(name = "images", columnDefinition = "NVARCHAR(500) NULL")
	private String images;
	// Không định nghĩa sẽ mặc định lấy tên đã được khai báo là statuss
	private int status;
}
