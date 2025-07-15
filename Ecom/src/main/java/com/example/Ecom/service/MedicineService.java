package com.example.Ecom.service;

import com.example.Ecom.model.Medicine;
import com.example.Ecom.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository repo;

    public List<Medicine> getAllMedicines() {
        return repo.findAll();
    }

    public Medicine addMedicine(Medicine med) {
        return repo.save(med);
    }

    public Medicine getMedicineById(int id) {
        return repo.findById(id).orElse(null);
    }

    public String deleteMedicine(int id) {
        repo.deleteById(id);
        return "Deleted medicine with ID: " + id;
    }

    public Medicine updateMedicine(int id, Medicine updatedMed) {
        Medicine existing = repo.findById(id).orElse(null);
        if (existing != null) {
            updatedMed.setId(id);
            return repo.save(updatedMed);
        }
        return null;
    }
}
