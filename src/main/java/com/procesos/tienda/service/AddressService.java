package com.procesos.tienda.service;

import com.procesos.tienda.model.Address;
import com.procesos.tienda.model.User;
import com.procesos.tienda.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserService userService;

    public Address createAddress(Address addressReq, Long idUser){
        User user = userService.getUserById(idUser);
        if (user == null){
            throw new RuntimeException("User not found");
        }
        addressReq.setUser(user);
        return addressRepository.save(addressReq);
    }
    public Address getAddressById(Long idAddress){
        Optional<Address> address = addressRepository.findById(idAddress);
        if(address.isEmpty()){
            throw new RuntimeException("Address not found");
        }
        return address.get();
    }
    public Address updateStatusAddress(Long idAddress){
        Optional<Address> address = addressRepository.findById(idAddress);
        if(address.isEmpty()){
            throw new RuntimeException("Address not found");
        }
        address.get().setStatus(Boolean.FALSE);
        return addressRepository.save(address.get());
    }

    public List<Address> findAllAddress(){
        return (List<Address>) addressRepository.findAll();
    }
}
