package admin.service;

import admin.model.Address;
import admin.repository.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(String caseNumberId) {
        return addressRepository.findById(caseNumberId).orElse(null);
    }

    @Transactional
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Transactional
    public List<Address> saveAllAddresses(List<Address> addresses) {
        return addressRepository.saveAll(addresses);
    }

    @Transactional
    public boolean deleteAddress(String caseNumberId) {
        if (addressRepository.existsById(caseNumberId)) {
            addressRepository.deleteById(caseNumberId);
            return true;
        }
        return false;
    }
}
