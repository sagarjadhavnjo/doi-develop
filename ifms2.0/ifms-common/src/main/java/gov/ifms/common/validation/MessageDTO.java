package gov.ifms.common.validation;

import gov.ifms.common.util.EnumUtils.MessageType;

public class MessageDTO {

	private String message;
	private MessageType type;

	public MessageDTO(MessageType type, String message) {
		super();
		this.message = message;
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		boolean isEqual = false;
		if (obj instanceof MessageDTO) {
			MessageType toCompare = ((MessageDTO) obj).getType();
			isEqual = (toCompare == this.type) ? Boolean.TRUE : Boolean.FALSE;
		}
		return isEqual;
	}

	@Override
	public int hashCode() {
		return type.hashCode();
	}
}
