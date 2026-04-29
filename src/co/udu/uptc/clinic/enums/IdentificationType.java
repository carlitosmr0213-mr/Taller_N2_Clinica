package co.udu.uptc.clinic.enums;

public enum IdentificationType {
	
	CC("Cédula de ciudadanía"), TI("Tarjeta de identidad"), CE("Cédula de extranjería"), PA("Pasaporte");
	
	private String nameType;

	private IdentificationType(String nameType) {
		this.nameType = nameType;
	}

	public String getIdType() {
		return nameType;
	}
	

}
