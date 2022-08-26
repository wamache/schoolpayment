package com.schoolfeespayment.dependants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DependantController {

    @Autowired
    private DependantService dependantService;

    @GetMapping("/dependants")
    public String listDependants(Model model) {
        List<Dependant> listDependants = dependantService.getAllDependants();
        model.addAttribute("listDependants", listDependants );
        return "dependants";

    }
    @GetMapping("/dependants/new")
    public String createDependantForm(Model model) {

        //Student student=new Student();
        model.addAttribute("dependant", new Dependant());

        return "create_dependant";
    }
    @PostMapping("/dependants")
    public String saveDependant(@ModelAttribute("dependant") Dependant dependant) {

        dependantService.saveDependant(dependant);
        return "succesfully added";

    }

    @GetMapping("/dependants/edit/{id}")
    public String editDependantForm(@PathVariable Long id, Model model) {

        model.addAttribute("dependant", dependantService.getDependantById(id));
        return "edit_dependants";

    }

    @PostMapping("/dependants/{id}")
    public String updateDependant (@PathVariable Long id,
                                 @ModelAttribute("student") Dependant dependant,
                                 Model model) {
        Dependant existingDependant = dependantService.getDependantById(id);
        existingDependant.setId(id);
        existingDependant.setDependantName(dependant.getDependantName());
        existingDependant.setRegNumber (dependant.getRegNumber ());
        existingDependant.setSchoolName (dependant.getSchoolName ());

        dependantService.updateDependant(existingDependant);
        return "updated";

    }

    @GetMapping("/dependants/{id}")
    public String deleteDependant(@PathVariable Long id) {
        dependantService.deleteDependantById(id);
        return "redirect:/dependants";
    }
}
