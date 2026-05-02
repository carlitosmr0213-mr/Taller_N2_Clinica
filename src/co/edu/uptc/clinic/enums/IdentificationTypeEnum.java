package co.edu.uptc.clinic.enums;

public enum IdentificationTypeEnum {
	
	CC("Cédula de ciudadanía"), TI("Tarjeta de identidad"), CE("Cédula de extranjería"), PA("Pasaporte");
	
	private String nameType;

	private IdentificationTypeEnum(String nameType) {
		this.nameType = nameType;
	}

	public String getIdType() {
		return nameType;
	}
	

}
