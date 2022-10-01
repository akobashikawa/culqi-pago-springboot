package me.rulokoba.culqi.models;

import java.util.HashMap;

public class CulqiChargeData {
	private int amount;
	private String currency_code;
	private String email;
	private String source_id;
	private HashMap<String, String> metadata = new HashMap<String, String>();
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCurrency_code() {
		return currency_code;
	}
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSource_id() {
		return source_id;
	}
	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}
	public HashMap<String, String> getMetadata() {
		return metadata;
	}
	public void setMetadata(HashMap<String, String> metadata) {
		this.metadata = metadata;
	}
	
	
}
