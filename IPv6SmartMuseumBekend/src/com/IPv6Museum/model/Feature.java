package com.IPv6Museum.model;

public class Feature {
	
	private int feature_years;
	private int classification_id;
	private int feature_value;
	private String exhibits_id;
	
	public int getFeature_years() {
		return feature_years;
	}
	public void setFeature_years(int feature_years) {
		this.feature_years = feature_years;
	}
	
	public int getClassification_id() {
		return classification_id;
	}
	public void setClassification_id(int classification_id) {
		this.classification_id = classification_id;
	}
	
	public int getFeature_value() {
		return feature_value;
	}
	public void setFeature_value(int feature_value) {
		this.feature_value = feature_value;
	}
	
	public String getExhibits_id() {
		return exhibits_id;
	}
	public void setExhibits_id(String exhibits_id) {
		this.exhibits_id = exhibits_id;
	}
	
}
