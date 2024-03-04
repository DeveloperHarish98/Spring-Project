package org.jsp.hospital.adress.service;

import java.util.List;
import java.util.Optional;
import org.jsp.hospital.adress.dao.AdressDao;
import org.jsp.hospital.adress.dto.Adress;
import org.jsp.hospital.adress.dto.ResponseStructure;
import org.jsp.hospital.adress.exception.IdNotFoundException;
import org.jsp.hospital.adress.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdressService {
	@Autowired
	private AdressDao adressDao;
	
	public ResponseEntity<ResponseStructure<Adress>> saveAdress(Adress adress) {
		adress = adressDao.saveAdress(adress);
		ResponseStructure<Adress> structure = new ResponseStructure<>();
		structure.setData(adressDao.saveAdress(adress));
		structure.setMessage("address saved");
		structure.setStatuscode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Adress>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Adress>>> findById(int id) {
		Optional<Adress> recAdress = adressDao.findById(id);
		ResponseStructure<Adress> structure = new ResponseStructure<>();
		if(recAdress.isPresent()) {
			Adress adress = recAdress.get();
			adress.setId(id);
			structure.setData(adressDao.saveAdress(adress));
			structure.setMessage("Id Found");
			structure.setStatuscode(HttpStatus.CREATED.value());
			
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Adress>>> findByCountry(String country) {
		List<Adress> recAdress = adressDao.findAdressByCountry(country);
		ResponseStructure<List<Adress>> structure = new ResponseStructure<>();
		if (recAdress.size() > 0) {
			structure.setMessage("Adress Found through Country");
			structure.setData(recAdress);
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Adress>>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException("Invalid Country");
	}


	public ResponseEntity<ResponseStructure<List<Adress>>> findByPincode(long pincode) {
		List<Adress> recAdress = adressDao.findByPincode(pincode);
		ResponseStructure<List<Adress>> structure = new ResponseStructure<>();
		if (recAdress.size() > 0) {
			structure.setMessage("Adress Found");
			structure.setData(recAdress);
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Adress>>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException("Invalid Pincode");
	
	}
	
	
	public ResponseEntity<ResponseStructure<List<Adress>>> findBybuilding_Name(String building_Name) {
		List<Adress> recAdress = adressDao.findBybuilding_Name(building_Name);
		ResponseStructure<List<Adress>> structure = new ResponseStructure<>();
		if (recAdress.size() > 0) {
			structure.setMessage("building Name Found");
			structure.setData(recAdress);
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Adress>>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException("Invalid Building Name");
	
	}
}
