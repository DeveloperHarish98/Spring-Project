package org.jsp.hospital.adress.exception;


public class IdNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Invalid Id";

	}
}
