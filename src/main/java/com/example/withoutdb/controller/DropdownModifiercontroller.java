package com.example.withoutdb.controller;

import com.example.withoutdb.model.DropdownModifier;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/modifyDropdown")
public class DropdownModifiercontroller {

    @PostMapping("/add")
    public String add(@RequestBody DropdownModifier dropdownModifier ) {
        System.out.println("connection reached DropdownModifiercontroller");

        try {
            System.out.println("dropdownModifiers: fg g" + dropdownModifier.getId());
            dropdownModifier.modify();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "dropdown modified";
    }
}
