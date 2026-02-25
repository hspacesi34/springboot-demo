package com.cda.demo.controller;

import com.cda.demo.entity.Manufacturer;
import com.cda.demo.service.ManufacturerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ManufacturerController extends AbstractController<Manufacturer> {
    private ManufacturerService manufacturerService;

    @PostMapping("/manufacturer")
    @ResponseStatus(HttpStatus.CREATED)
    public Manufacturer create(@RequestBody Manufacturer manufacturer) throws URISyntaxException {
        return this.manufacturerService.create(manufacturer);
    }
    @GetMapping("/manufacturer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Manufacturer findById(@PathVariable Integer id) {
        return this.manufacturerService.findById(id);
    }
    @GetMapping("/manufacturers")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Manufacturer> findAll() {
        return this.manufacturerService.findAll();
    }
    @DeleteMapping("/manufacturer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> delete(@PathVariable Integer id) {
        this.manufacturerService.delete(id);
        Map<String,String> map = new HashMap<>();
        map.put("message","Manufacturer deleted");
        return map;
    }
    @PutMapping("/manufacturer")
    @ResponseStatus(HttpStatus.OK)
    public Manufacturer update(@RequestBody Manufacturer manufacturer) {
        return manufacturerService.update(manufacturer);
    }
}
