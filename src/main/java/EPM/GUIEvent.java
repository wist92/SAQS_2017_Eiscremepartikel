package EPM;

import java.util.EventObject;

@SuppressWarnings("serial")
public class GUIEvent extends EventObject {

	private String message;

	public GUIEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
