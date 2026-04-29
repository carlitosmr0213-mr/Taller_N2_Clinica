package co.udu.uptc.clinic.enums;

public enum IdentificationType {
	
	CC("Cédula de ciudadanía"), TI("Tarjeta de identidad"), CE("Cédula de extranjería"), PA("Pasaporte");
	
	private String IdType;

	private IdentificationType(String idType) {
		IdType = idType;
	}

	public String getIdType() {
		return IdType;
	}

}
