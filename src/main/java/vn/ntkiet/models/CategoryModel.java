package vn.ntkiet.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryModel {

	@Id
	private int categoryId;

	@NotEmpty(message = "Không được để trống")
	private String categoryName;

	private String images;

	private int status;
	
	private Boolean isEdit = false;
}
