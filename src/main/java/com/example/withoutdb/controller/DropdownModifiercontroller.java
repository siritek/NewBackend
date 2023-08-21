package com.example.withoutdb.controller;

import com.example.withoutdb.model.DropdownModifier;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/modifyDropdown")
public class DropdownModifiercontroller {


    @PostMapping("/modify")
    public String modify(@RequestBody DropdownModifier dropdownModifier ) {
        System.out.println("connection reached DropdownModifiercontroller");

        try {
            DropdownModifier modifier = new DropdownModifier();
            System.out.println("dropdownModifiers: fg g" + dropdownModifier.getId());
            modifier.modify(dropdownModifier);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "dropdown modified";
    }
}
