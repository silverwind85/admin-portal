package com.adminportal.controller;


import com.adminportal.controller.message.FlashMessage;
import com.adminportal.domain.Category;
import com.adminportal.repository.CategoryRepository;
import com.adminportal.utility.FileSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class CategoryController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FileSave fileSave;

    @PostMapping("categories/add")
    public String add( @Valid  Category category, BindingResult result ,RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.category",result);
            redirectAttrs.addFlashAttribute("category",category);
            return "redirect:/products/add";
        } else {
            categoryRepository.save(category);

            redirectAttrs.addFlashAttribute("flash",new FlashMessage(messageSource.getMessage("category.result.success",null,null),FlashMessage.Status.SUCCESS));
            try {
                fileSave.save(category.getImage().getBytes(), category.getName() + ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "redirect:/products/add";
        }


    }

}
