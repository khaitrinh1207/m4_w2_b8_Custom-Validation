package com_codegym_m4_w2_b8.controller;

import com_codegym_m4_w2_b8.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/")
    public ModelAndView showForm() {
        return new ModelAndView("index", "phonemunber", new PhoneNumber());
    }

    @PostMapping("/")
    public ModelAndView checkValidation(@Validated @ModelAttribute("phonemunber") PhoneNumber phoneNumber, BindingResult bindingResult) {
        ModelAndView modelAndView;
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return modelAndView = new ModelAndView("index");
        } else {
            return modelAndView = new ModelAndView("result", "phoneNumber", phoneNumber.getNumber());
        }
    }
}