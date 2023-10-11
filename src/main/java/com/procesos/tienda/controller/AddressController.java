package com.procesos.tienda.controller;

import com.procesos.tienda.model.Address;
import com.procesos.tienda.model.User;
import com.procesos.tienda.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

public class AddressController {
    @Autowired
    private AddressService addressService;
    @GetMapping("address/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getAddressById(id));
    }
    @PostMapping("addresses")
    public ResponseEntity<Address> create(@Valid @RequestBody Address address, @PathVariable Long idUser){
        return new ResponseEntity<>(addressService.createAddress(address, idUser), HttpStatus.CREATED);
    }

    @GetMapping("address/disable/{id}")
    public ResponseEntity<Address> updateStatus(@PathVariable Long id){
        return ResponseEntity.ok(addressService.updateStatusAddress(id));
    }
    @GetMapping("address/{id}")
    public ResponseEntity<Address> getById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getAddressById(id));
    }
    @GetMapping("address")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(addressService.findAllAddress());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
