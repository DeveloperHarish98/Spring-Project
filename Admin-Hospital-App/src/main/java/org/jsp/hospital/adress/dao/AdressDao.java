package org.jsp.hospital.adress.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.hospital.adress.dto.Adress;
import org.jsp.hospital.adress.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdressDao {
	@Autowired
	private AdressRepository adressRepository;
	
	public Adress saveAdress(Adress adress) {
		return adressRepository.save(adress);
	}
	public Optional<Adress> findById(int id) {
		return adressRepository.findById(id);
	
	}
	public List<Adress> findAdressByCountry(String country) {
		return adressRepository.findByCountry(country);
	}
	public List<Adress> findByPincode(long pincode){
		return adressRepository.findByPincode(pincode);
	}
	
	public List<Adress> findBybuilding_Name(String building_Name){
		return adressRepository.findBybuilding_Name(building_Name);
	}
	
	
	
}
