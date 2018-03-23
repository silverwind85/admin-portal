package com.adminportal.controller;

import com.adminportal.controller.message.FlashMessage;
import com.adminportal.domain.Category;
import com.adminportal.domain.Product;
import com.adminportal.domain.dto.CategoryDto;
import com.adminportal.domain.dto.ProductDto;
import com.adminportal.mapper.ProductMapper;
import com.adminportal.service.IProductService;
import com.adminportal.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MessageCodeFormatter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller()
public class ProductContoller {

    @Autowired
    private IProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductMapper mapper;
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/products/add")
    public String addForm(Model model) {
        if(!model.containsAttribute("category")){
            model.addAttribute("category",new Category());
        }
        if(!model.containsAttribute("product")){
            model.addAttribute("product", new Product());
        }
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("action","/products");
        model.addAttribute("heading","Nowy Produkt");
        model.addAttribute("submit","Dodaj");

        return "product/form/addForm";
    }

    @PostMapping("/products")
    public String addProduct(
            Model model,
            @ModelAttribute @Valid Product product,
            BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.product",result);
            redirectAttributes.addFlashAttribute("product",product);
            return "redirect:products/add";
        } else {
            ProductDto productDto = mapper.mapToProductDto(product);
            productService.add(productDto);
            redirectAttributes.addFlashAttribute("flash",new FlashMessage(messageSource.getMessage("product.result.success",null,null),FlashMessage.Status.SUCCESS));
            return "redirect:products";
        }
    }


    @GetMapping("/products")
    public String getPtoducts(Model model) {
        List<Product> product = productService.getProducts();
        model.addAttribute("products", product);
        return "product/products";
    }

    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable Long id,Model model){
               /*ProductDto productDto = productService.findById(id);*/
               Product product = productService.findById(id);
               model.addAttribute("product",product);
               return "product/product";


    }
    @GetMapping("/products/{id}/edit")
    public String updateForm(@PathVariable Long id,Model model){
        if(!model.containsAttribute("product")){
            model.addAttribute("product", productService.findById(id));
        }
        if(!model.containsAttribute("category")){
            model.addAttribute("category",new Category());
        }
        model.addAttribute("categoryList", categoryService.findAll());

        model.addAttribute("action",String.format("/products/%s",id));
        model.addAttribute("heading","Edytuj Produkt");
        model.addAttribute("submit","Edytuj");

        return "product/form/addForm";
    }
    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id , Model model,
                                @Valid Product product,
                                BindingResult result,
                                RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.product",result);
            redirectAttributes.addFlashAttribute("product",product);
            return String.format("redirect:/products/%s/edit",product.getId());
        } else {
            ProductDto productDto = mapper.mapToProductDto(product);
            productService.add(productDto);
            return "redirect:/products/"+product.getId();
        }

        }
    /*@GetMapping("products/{id}/delete")
    public String deleteProduct(@PathVariable Long id){

        productService.delete(id);

        return "forward:/products";*/









}
