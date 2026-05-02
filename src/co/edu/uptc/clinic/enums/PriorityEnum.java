package co.edu.uptc.clinic.enums;

public enum PriorityEnum {
	
	LOW(0, "Baja"), MEDIUM(1, "Media"),HIGH(2, "Alta"),CRITICAL(3, "Crítica");
	
	private int level;
	private String priorityName;
	
	private PriorityEnum(int level, String priorityName) {
		this.level = level;
		this.priorityName = priorityName;
	}

	public int getLevel() {
		return level;
	}

	public String getPriorityName() {
		return priorityName;
	}
	
	
	
}
