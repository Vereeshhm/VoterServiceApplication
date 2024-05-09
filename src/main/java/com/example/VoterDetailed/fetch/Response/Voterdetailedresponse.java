package com.example.VoterDetailed.fetch.Response;

import java.util.List;

public class Voterdetailedresponse {

	private Result result;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public static class Result {

		private String name;

		private String nameInRegionalLang;

		private int age;

		private String relationType;

		private String relationName;

		private String relationNameInRegionalLang;

		private String fatherName;

		private String dob;

		private String gender;

		private String address;

		private SplitAddress splitAddress;

		private String epicNumber;

		private String state;

		private String assemblyConstituencyNo;

		private String assemblyConstituency;

		private int parliamentaryConstituencyNo;

		private int partNo;

		private String partName;

		private int serialNo;

		private String pollingStation;

		private String photo;

		private String parliamentaryConstituency;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNameInRegionalLang() {
			return nameInRegionalLang;
		}

		public void setNameInRegionalLang(String nameInRegionalLang) {
			this.nameInRegionalLang = nameInRegionalLang;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getRelationType() {
			return relationType;
		}

		public void setRelationType(String relationType) {
			this.relationType = relationType;
		}

		public String getRelationName() {
			return relationName;
		}

		public void setRelationName(String relationName) {
			this.relationName = relationName;
		}

		public String getRelationNameInRegionalLang() {
			return relationNameInRegionalLang;
		}

		public void setRelationNameInRegionalLang(String relationNameInRegionalLang) {
			this.relationNameInRegionalLang = relationNameInRegionalLang;
		}

		public String getFatherName() {
			return fatherName;
		}

		public void setFatherName(String fatherName) {
			this.fatherName = fatherName;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public SplitAddress getSplitAddress() {
			return splitAddress;
		}

		public void setSplitAddress(SplitAddress splitAddress) {
			this.splitAddress = splitAddress;
		}

		public String getEpicNumber() {
			return epicNumber;
		}

		public void setEpicNumber(String epicNumber) {
			this.epicNumber = epicNumber;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getAssemblyConstituencyNo() {
			return assemblyConstituencyNo;
		}

		public void setAssemblyConstituencyNo(String assemblyConstituencyNo) {
			this.assemblyConstituencyNo = assemblyConstituencyNo;
		}

		public String getAssemblyConstituency() {
			return assemblyConstituency;
		}

		public void setAssemblyConstituency(String assemblyConstituency) {
			this.assemblyConstituency = assemblyConstituency;
		}

		public int getParliamentaryConstituencyNo() {
			return parliamentaryConstituencyNo;
		}

		public void setParliamentaryConstituencyNo(int parliamentaryConstituencyNo) {
			this.parliamentaryConstituencyNo = parliamentaryConstituencyNo;
		}

		public int getPartNo() {
			return partNo;
		}

		public void setPartNo(int partNo) {
			this.partNo = partNo;
		}

		public String getPartName() {
			return partName;
		}

		public void setPartName(String partName) {
			this.partName = partName;
		}

		public int getSerialNo() {
			return serialNo;
		}

		public void setSerialNo(int serialNo) {
			this.serialNo = serialNo;
		}

		public String getPollingStation() {
			return pollingStation;
		}

		public void setPollingStation(String pollingStation) {
			this.pollingStation = pollingStation;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public String getParliamentaryConstituency() {
			return parliamentaryConstituency;
		}

		public void setParliamentaryConstituency(String parliamentaryConstituency) {
			this.parliamentaryConstituency = parliamentaryConstituency;
		}

	}

	public static class SplitAddress {

		private List<String> district;

		private List<List<String>> state;

		private List<String> city;

		private String pincode;

		private List<String> country;

		private String addressLine;

		public List<String> getDistrict() {
			return district;
		}

		public void setDistrict(List<String> district) {
			this.district = district;
		}

		public List<List<String>> getState() {
			return state;
		}

		public void setState(List<List<String>> state) {
			this.state = state;
		}

		public List<String> getCity() {
			return city;
		}

		public void setCity(List<String> city) {
			this.city = city;
		}

		public String getPincode() {
			return pincode;
		}

		public void setPincode(String pincode) {
			this.pincode = pincode;
		}

		public List<String> getCountry() {
			return country;
		}

		public void setCountry(List<String> country) {
			this.country = country;
		}

		public String getAddressLine() {
			return addressLine;
		}

		public void setAddressLine(String addressLine) {
			this.addressLine = addressLine;
		}

	}
	
//	@Override
//	public String toString() {
//	    return "Voterdetailedresponse{" +
//	            "result=" + result +
//	            '}';
//	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("{\n");
	    sb.append("\t\"result\": {\n");
	    sb.append("\t\t\"name\": \"" + result.getName() + "\",\n");
	    sb.append("\t\t\"nameInRegionalLang\": \"" + result.getNameInRegionalLang() + "\",\n");
	    sb.append("\t\t\"age\": " + result.getAge() + ",\n");
	    sb.append("\t\t\"relationType\": \"" + result.getRelationType() + "\",\n");
	    sb.append("\t\t\"relationName\": \"" + result.getRelationName() + "\",\n");
	    sb.append("\t\t\"relationNameInRegionalLang\": \"" + result.getRelationNameInRegionalLang() + "\",\n");
	    sb.append("\t\t\"fatherName\": \"" + result.getFatherName() + "\",\n");
	    sb.append("\t\t\"dob\": \"" + result.getDob() + "\",\n");
	    sb.append("\t\t\"gender\": \"" + result.getGender() + "\",\n");
	    sb.append("\t\t\"address\": \"" + result.getAddress() + "\",\n");
	    sb.append("\t\t\"splitAddress\": {\n");
	    sb.append("\t\t\t\"district\": " + result.getSplitAddress().getDistrict() + ",\n");
	    sb.append("\t\t\t\"state\": " + result.getSplitAddress().getState() + ",\n");
	    sb.append("\t\t\t\"city\": " + result.getSplitAddress().getCity() + ",\n");
	    sb.append("\t\t\t\"pincode\": \"" + result.getSplitAddress().getPincode() + "\",\n");
	    sb.append("\t\t\t\"country\": " + result.getSplitAddress().getCountry() + ",\n");
	    sb.append("\t\t\t\"addressLine\": \"" + result.getSplitAddress().getAddressLine() + "\"\n");
	    sb.append("\t\t},\n");
	    sb.append("\t\t\"epicNumber\": \"" + result.getEpicNumber() + "\",\n");
	    sb.append("\t\t\"state\": \"" + result.getState() + "\",\n");
	    sb.append("\t\t\"assemblyConstituencyNo\": \"" + result.getAssemblyConstituencyNo() + "\",\n");
	    sb.append("\t\t\"assemblyConstituency\": \"" + result.getAssemblyConstituency() + "\",\n");
	    sb.append("\t\t\"parliamentaryConstituencyNo\": " + result.getParliamentaryConstituencyNo() + ",\n");
	    sb.append("\t\t\"partNo\": " + result.getPartNo() + ",\n");
	    sb.append("\t\t\"partName\": \"" + result.getPartName() + "\",\n");
	    sb.append("\t\t\"serialNo\": " + result.getSerialNo() + ",\n");
	    sb.append("\t\t\"pollingStation\": \"" + result.getPollingStation() + "\",\n");
	    sb.append("\t\t\"photo\": \"" + result.getPhoto() + "\",\n");
	    sb.append("\t\t\"parliamentaryConstituency\": \"" + result.getParliamentaryConstituency() + "\"\n");
	    sb.append("\t}\n");
	    sb.append("}");
	    return sb.toString();
	}

	
}
