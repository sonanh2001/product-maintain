package productmt.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import productmt.dto.ProductDto;
import productmt.repository.ProductRepository;
import productmt.model.Product;
@Controller
@RequestMapping("products")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@GetMapping("create")
	public String create(Model model) {
		model.addAttribute("product",new ProductDto());
		return "product";
	}
	@GetMapping("")
	public String list(Model model) {
		List<Product> productsList=productRepository.findAll();
		model.addAttribute("products",productsList);
		return "list";
	}
	@PostMapping("saveOrUpdate")
	public String saveOrUpdate(@ModelAttribute("product") @Valid ProductDto dto,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "product";
		}
		if(!checkPrice(dto.getProductPrice())) {
			String messageString="Price is number";
			model.addAttribute("message",messageString);
			return "product";
		}
		Optional<Product> existed=productRepository.findByProductCode(dto.getProductCode());
		if(dto.getIsEdit()==false && existed.isPresent()) {
			model.addAttribute("error","Product is existed");
			return "product";
		}
		Product entity=new Product();
		BeanUtils.copyProperties(dto,entity);
		entity.setProductPrice(Double.parseDouble(dto.getProductPrice()));
		productRepository.save(entity);
		return "redirect:/products";
	}
	@GetMapping("edit/{productCode}")
	public String edit(@PathVariable("productCode")String productCode,Model model) {
		Optional<Product> existed=productRepository.findById(productCode);
		Product entity=existed.get();
		ProductDto dto=new ProductDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setIsEdit(true);
		dto.setProductPrice(Double.valueOf(entity.getProductPrice()).toString());
		model.addAttribute("product",dto);
		return "product";
	}
	@GetMapping("confirmDelete/{productCode}")
	public String confirmDelete(@PathVariable("productCode")String productCode,Model model) {
		Optional<Product> existed=productRepository.findById(productCode);
		Product entity=existed.get();
		model.addAttribute("product",entity);
		return "confirmDelete";
	}
	@GetMapping("delete/{productCode}")
	public String delete(@PathVariable("productCode")String productCode) {
		productRepository.deleteById(productCode);
		return "redirect:/products";
	}
	private boolean checkPrice(String price) {
		try {
			Double priceConvert=Double.parseDouble(price);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
