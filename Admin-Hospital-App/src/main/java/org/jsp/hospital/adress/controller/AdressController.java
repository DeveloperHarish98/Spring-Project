package org.jsp.hospital.adress.controller;

import java.util.List;

import org.jsp.hospital.adress.dto.Adress;
import org.jsp.hospital.adress.dto.ResponseStructure;
import org.jsp.hospital.adress.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adress")
public class AdressController {
	@Autowired
	private AdressService adressService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ResponseStructure<Adress>> saveAdress(@RequestBody Adress adress){
		return adressService.saveAdress(adress);
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ResponseStructure<List<Adress>>> findById(@PathVariable(name = "id") int id) {
		return adressService.findById(id);
	}

	@GetMapping("/by-country/{country}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ResponseStructure<List<Adress>>> findByCountry(
			@PathVariable(name = "country") String category) {
		return adressService.findByCountry(category);
	}

	@GetMapping("/by-pincode/{pincode}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ResponseStructure<List<Adress>>> findByPincode(@PathVariable(name = "pincode") long pincode) {
		return adressService.findByPincode(pincode);
	}
}
