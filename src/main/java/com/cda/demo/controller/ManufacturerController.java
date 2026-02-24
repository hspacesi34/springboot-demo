package com.cda.demo.controller;

import com.cda.demo.entity.Manufacturer;
import com.cda.demo.service.ManufacturerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ManufacturerController extends AbstractController<Manufacturer> {
    private ManufacturerService manufacturerService;

    @PostMapping("/manufacturer")
    public ResponseEntity create(@RequestBody Manufacturer manufacturer) {
        try {
            Manufacturer manufacturerSaved = this.manufacturerService.create(manufacturer);
            return ResponseEntity.created(new URI("")).body(manufacturerSaved);
        } catch (Exception e) {
            if (e.getMessage().contains("Manufacturer already exists")) {
                Map<String, String> map = new HashMap<>();
                map.put("error", e.getMessage());
                return ResponseEntity.badRequest().body(map);
            }
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping("/manufacturer/{id}")
    public ResponseEntity<Manufacturer> findById(@PathVariable Integer id) {
        try {
            Manufacturer manufacturer = this.manufacturerService.findById(id);
            return ResponseEntity.ok().body(manufacturer);
        } catch (Exception e) {
            if (e.getMessage().contains("Manufacturer not found")) {
                return ResponseEntity.notFound().build();
            }
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping("/manufacturers")
    public ResponseEntity<Iterable<Manufacturer>> findAll() {
        try {
            Iterable<Manufacturer> manufacturers = this.manufacturerService.findAll();
            return ResponseEntity.ok().body(manufacturers);
        } catch (Exception e) {
            if (e.getMessage().contains("No manufacturers found")) {
                return ResponseEntity.notFound().build();
            }
            throw new RuntimeException(e.getMessage());
        }
    }
    @DeleteMapping("/manufacturer/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
        try {
            this.manufacturerService.delete(id);
            Map<String,String> map = new HashMap<>();
            map.put("message","Manufacturer deleted");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            if (e.getMessage().contains("Manufacturer not found")) {
                return ResponseEntity.notFound().build();
            }
            throw new RuntimeException(e.getMessage());
        }
    }
    @PutMapping("/manufacturer")
    public ResponseEntity update(@RequestBody Manufacturer manufacturer) {
        try {
            Manufacturer manufacturerUpdated = manufacturerService.update(manufacturer);
            return ResponseEntity.ok().body(manufacturerUpdated);
        } catch (Exception e) {
            if (e.getMessage().contains("Manufacturer not found")) {
                return ResponseEntity.notFound().build();
            }
            if (e.getMessage().contains("Manufacturer already exists")) {
                Map<String, String> map = new HashMap<>();
                map.put("error", e.getMessage());
                return ResponseEntity.badRequest().body(map);
            }
            throw new RuntimeException(e.getMessage());
        }
    }
}
