package com.dev.recipeapp.controllers;

import com.dev.recipeapp.domain.Category;
import com.dev.recipeapp.repositories.CategoryRepository;
import com.dev.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage(Model model) {
        Optional<Category> category = categoryRepository.findByDescription("American");
//        System.out.println(category.get().getDescription());
        model.addAttribute("category", category.get());
//        model.addAttribute("category", category);
        return "index";
    }
}
