package ru.sereske.geonames;

import java.time.LocalDate;
import java.util.Arrays;

public class City {
	
	// integer id of record in geonames database
	private int id;
	
	// name of geographical point (utf8) varchar(200)
	private String name;
	
	// name of geographical point in plain ascii characters, varchar(200)
	private String asciiName;
	
	// alternatenames, comma separated, ascii names automatically transliterated, convenience attribute from alternatename table, varchar(10000)
	private String[] alternateNames;
	
	// latitude in decimal degrees (wgs84)
	private double latitude;
	
	// longitude in decimal degrees (wgs84)
	private double longitude;
	
	// see http://www.geonames.org/export/codes.html, char(1)
	private String featureClass;
	
	// see http://www.geonames.org/export/codes.html, varchar(10)
	private String featureCode;
	
	// ISO-3166 2-letter country code, 2 characters
	private String countryCode;
	
	// alternate country codes, comma separated, ISO-3166 2-letter country code, 200 characters
	private String cc2;
	
	// fipscode (subject to change to iso code), see exceptions below, see file admin1Codes.txt for display names of this code; varchar(20)
	private String admin1Code;
	
	// code for the second administrative division, a county in the US, see file admin2Codes.txt; varchar(80) 
	private String admin2Code;
	
	// code for third level administrative division, varchar(20)
	private String admin3Code;
	
	// code for fourth level administrative division, varchar(20)
	private String admin4Code;
	
	// bigint (8 byte int) 
	private long population;
	
	// in meters, integer
	private int elevation;
	
	// digital elevation model, srtm3 or gtopo30, average elevation of 3''x3'' (ca 90mx90m) or 30''x30'' (ca 900mx900m) area in meters, integer. srtm processed by cgiar/ciat.
	private int dem;
	
	// the iana timezone id (see file timeZone.txt) varchar(40)
	private String timeZone;
	
	// date of last modification in yyyy-MM-dd format
	private LocalDate modificationDate;

	public City() {}
	
	public City(int id, String name, String asciiName, String[] alternateNames, double latitude, double longitude,
			String featureClass, String featureCode, String countryCode, String cc2, String admin1Code,
			String admin2Code, String admin3Code, String admin4Code, long population, int elevation, int dem,
			String timeZone, LocalDate modificationDate) {
		super();
		this.id = id;
		this.name = name;
		this.asciiName = asciiName;
		this.alternateNames = alternateNames;
		this.latitude = latitude;
		this.longitude = longitude;
		this.featureClass = featureClass;
		this.featureCode = featureCode;
		this.countryCode = countryCode;
		this.cc2 = cc2;
		this.admin1Code = admin1Code;
		this.admin2Code = admin2Code;
		this.admin3Code = admin3Code;
		this.admin4Code = admin4Code;
		this.population = population;
		this.elevation = elevation;
		this.dem = dem;
		this.timeZone = timeZone;
		this.modificationDate = modificationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAsciiName() {
		return asciiName;
	}

	public void setAsciiName(String asciiName) {
		this.asciiName = asciiName;
	}

	public String[] getAlternateNames() {
		return alternateNames;
	}

	public void setAlternateNames(String[] alternateNames) {
		this.alternateNames = alternateNames;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getFeatureClass() {
		return featureClass;
	}

	public void setFeatureClass(String featureClass) {
		this.featureClass = featureClass;
	}

	public String getFeatureCode() {
		return featureCode;
	}

	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCc2() {
		return cc2;
	}

	public void setCc2(String cc2) {
		this.cc2 = cc2;
	}

	public String getAdmin1Code() {
		return admin1Code;
	}

	public void setAdmin1Code(String admin1Code) {
		this.admin1Code = admin1Code;
	}

	public String getAdmin2Code() {
		return admin2Code;
	}

	public void setAdmin2Code(String admin2Code) {
		this.admin2Code = admin2Code;
	}

	public String getAdmin3Code() {
		return admin3Code;
	}

	public void setAdmin3Code(String admin3Code) {
		this.admin3Code = admin3Code;
	}

	public String getAdmin4Code() {
		return admin4Code;
	}

	public void setAdmin4Code(String admin4Code) {
		this.admin4Code = admin4Code;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public int getElevation() {
		return elevation;
	}

	public void setElevation(int elevation) {
		this.elevation = elevation;
	}

	public int getDem() {
		return dem;
	}

	public void setDem(int dem) {
		this.dem = dem;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public LocalDate getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(LocalDate modificationDate) {
		this.modificationDate = modificationDate;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", asciiName=" + asciiName + ", alternateNames="
				+ Arrays.toString(alternateNames) + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", featureClass=" + featureClass + ", featureCode=" + featureCode + ", countryCode=" + countryCode
				+ ", cc2=" + cc2 + ", admin1Code=" + admin1Code + ", admin2Code=" + admin2Code + ", admin3Code="
				+ admin3Code + ", admin4Code=" + admin4Code + ", population=" + population + ", elevation=" + elevation
				+ ", dem=" + dem + ", timeZone=" + timeZone + ", modificationDate=" + modificationDate + "]";
	}
	
}
