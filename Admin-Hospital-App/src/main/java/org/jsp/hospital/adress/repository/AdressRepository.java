package org.jsp.hospital.adress.repository;

import java.util.List;
import java.util.Optional;
import org.jsp.hospital.adress.dto.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdressRepository extends JpaRepository<Adress, Integer> {
	
	@Query("select a from Adress a where a.id=?1")
	public Optional<Adress> findById(int id);
	
	@Query("select a from Adress a where a.country=?1")
	public List<Adress> findByCountry(String country);
	
	@Query("select a from Adress a where a.pincode=?1")
	public List<Adress> findByPincode(long pincode);
	
	@Query("select a from Adress a where a.building_Name=?1")
	public List<Adress> findBybuilding_Name(String building_Name);
}
