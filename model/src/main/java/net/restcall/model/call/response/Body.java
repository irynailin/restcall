package net.restcall.model.call.response;

public class Body {
	private String payload;
	

	public Body(String payload) {
		super();
		this.payload = payload;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
}
