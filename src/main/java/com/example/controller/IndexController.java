package com.example.controller;

import com.example.dto.CategoryDto;
import com.example.dto.ToyDto;
import com.example.model.Mail;
import com.example.service.CategoryService;
import com.example.service.EmailService;
import com.example.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.annotation.PostConstruct;
import java.util.List;


@Controller
public class IndexController {

    @Autowired
    ToyService toyService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/index")
    public String getIndex() {
        return "index";
    }

    @PostConstruct
    private void loadtoys() {
    }

    @GetMapping("/toys")
    public String showtoys(Model model) {
        model.addAttribute("toys", toyService.getToysList());
        model.addAttribute("categories", categoryService.getCategoriesList());
        return "toys";
    }

    @GetMapping("/toys-view")
    public String showtoyscl(Model model) {
        model.addAttribute("toys", toyService.getToysList());
        model.addAttribute("categories", categoryService.getCategoriesList());
        return "toys-view";
    }

    @GetMapping("/categories")
    public String showcategories(Model model) {
        model.addAttribute("categories", categoryService.getCategoriesList());
        return "categories";
    }

    @GetMapping("/categories-view")
    public String showcategoriescl(Model model) {
        model.addAttribute("categories", categoryService.getCategoriesList());
        return "categories-view";
    }

    @PostMapping("/categories/addCategory")
    public String addNewCategory(@ModelAttribute CategoryDto categoryDto){
        categoryService.saveCategory(categoryDto);
        return "redirect:/categories";
    }

    @PostMapping("/categories/editCategory")
    public String editCategory(@ModelAttribute CategoryDto categoryDto){
        categoryService.saveCategory(categoryDto);
        return "redirect:/categories";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

/*
    @PostMapping("/toys/addToy")
    public String addNewToy(@ModelAttribute("toy") ToyDto toyDto, Model model){
        toyDto.setCategory(categoryService.getCategoriesList().get(toyDto.getCategory().getId()-1));
        toyService.saveToys(toyDto);
        return "redirect:/toys";
    }
*/

    @PostMapping("/toys/addToy")
    public String addNewToy(@ModelAttribute("toy") ToyDto toyDto, Model model){
        List<CategoryDto> listCategories = categoryService.getCategoriesList();
        toyDto.setCategory(categoryService.getCategoriesList().get(toyDto.getCategory().getId()-1));

        toyService.saveToys(toyDto);
        return "redirect:/toys";
    }

/*    @GetMapping(value={"/addT"})
    public String adaugaJcuarii(final Model model) {
        model.addAttribute("toy", new Toy());
        return "employees/employees-add";
    }

    @PostMapping(value = {"/addT"})
    public String adaugaJcuarii(@ModelAttribute("toy") final ToyDto toyDto, final BindingResult error, final Model model) {

        if (error.hasErrors()) {
            System.err.println(error);
            return "redirect:/index";
        }
        final Toy toy = this.toyService.saveToys(toyDto);
        System.err.println(toy);
        return "toys";
    }*/




    @PostMapping("/toys/editToy")
    public String editToy(@ModelAttribute ToyDto toyDto){
        toyService.saveToys(toyDto);
        return "redirect:/toys";
    }

    @GetMapping("/gallery")
    public String showGallery(){
        return "gallery";
    }

    @GetMapping(value = "/contact")
    public String showContact() {
        return "contact";
    }

    @GetMapping(value="/register")
    public String showRegister(){return "register";};

    @RequestMapping(path="/categories/deleteCategory/{id}")
    public String deleteCategoryById(@PathVariable("id") int id)
    {
        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }

    @RequestMapping(path="/deleteToy/{id}")
    public String deleteToyById(@PathVariable("id") int id)
    {
        toyService.deleteToysById(id);
        return "redirect:/toys";
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value="/sendMail", method = RequestMethod.POST)
    @ResponseBody
    public String sendMail(@ModelAttribute Mail mail) {
        String done = this.emailService.sendMail(mail);
        return done;
    }


}
