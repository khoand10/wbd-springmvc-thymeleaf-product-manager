package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import service.ProductService;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String loadIndex(ModelMap model){
        model.addAttribute("list",productService.getAllProduct());
        return "index";
    }

    @GetMapping("/pruduct/create")
    public String createFrom(ModelMap model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/product/save")
    public String saveProduct(Product product){
        productService.addProduct(product);
        return "redirect:/";
    }
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id")int id){
        productService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/product/info/{id}")
    public String productInfo(@PathVariable("id")int id, ModelMap model){
        model.addAttribute("product",productService.getProduct(id));
        return "view";
    }
    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id")int id,ModelMap model){
        model.addAttribute("product",productService.getProduct(id));
        return "edit";
    }
    @PostMapping("/product/update")
    public String updateProduct(Product product){
        productService.updateProduct(product);
        return "redirect:/";
    }
}
