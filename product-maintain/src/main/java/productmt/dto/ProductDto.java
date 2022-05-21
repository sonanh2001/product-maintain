package productmt.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable{
	@NotEmpty
	private String productCode;
	@NotEmpty
	private String productDescription;
	@NotEmpty
	private String productPrice;
	private Boolean isEdit=false;
}
