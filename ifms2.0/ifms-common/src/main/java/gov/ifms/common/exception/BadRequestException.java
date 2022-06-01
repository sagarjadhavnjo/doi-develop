package gov.ifms.common.exception;


public class BadRequestException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public BadRequestException() {
        super();
    }
    public BadRequestException(String message) {
        super(message);
    }

}
