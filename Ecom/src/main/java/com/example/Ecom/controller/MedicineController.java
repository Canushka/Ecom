package com.example.Ecom.controller;

import com.example.Ecom.model.Medicine;
import com.example.Ecom.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines")
@CrossOrigin(origins = "*")
public class MedicineController {

    @Autowired
    private MedicineService service;

    @GetMapping
    public List<Medicine> getAll() {
        return service.getAllMedicines();
    }

    @PostMapping
    public Medicine add(@RequestBody Medicine med) {
        return service.addMedicine(med);
    }

    @GetMapping("/{id}")
    public Medicine getById(@PathVariable int id) {
        return service.getMedicineById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return service.deleteMedicine(id);
    }

    @PutMapping("/{id}")
    public Medicine update(@PathVariable int id, @RequestBody Medicine med) {
        return service.updateMedicine(id, med);
    }
}
