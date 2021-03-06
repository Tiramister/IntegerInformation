package net.tiramister.integer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import net.tiramister.integer.form.IntegerForm;
import net.tiramister.integer.form.ResultForm;

@Controller
public class MainController {
  @GetMapping()
  public String index(
      @ModelAttribute @Validated IntegerForm integerForm, BindingResult result, Model model) {
    long n = 0;
    if (!result.hasErrors() && integerForm.getInteger() != null) {
      n = integerForm.getInteger();
    }

    ResultForm resultForm = ResultForm.build(n);
    model.addAttribute("result", resultForm);

    return "index";
  }
}
