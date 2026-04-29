package co.edu.uptc.clinic.enums;

public enum Priority {
	
	LOW(0, "Baja"), MEDIUM(1, "Media"),HIGH(2, "Alta"),CRITICAL(3, "Crítica");
	
	private int level;
	private String PriorityName;
	
	private Priority(int level, String priorityName) {
		this.level = level;
		this.PriorityName = priorityName;
	}

	public int getLevel() {
		return level;
	}

	public String getPriorityName() {
		return PriorityName;
	}
	
	
	
}
