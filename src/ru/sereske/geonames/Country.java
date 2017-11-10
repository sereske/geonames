package ru.sereske.geonames;

public class Country {
	
	private String iso;
	private String iso3;
	private String isoNumeric;
	private String name;
	private String capital;
	private double area;
	private int population;
	private String continent;
	private String languages;
	
	public Country() {}

	public Country(String iso, String iso3, String isoNumeric, String country, String capital, double area, int population,
			String continent, String languages) {
		super();
		this.iso = iso;
		this.iso3 = iso3;
		this.isoNumeric = isoNumeric;
		this.name = country;
		this.capital = capital;
		this.area = area;
		this.population = population;
		this.continent = continent;
		this.languages = languages;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getIsoNumeric() {
		return isoNumeric;
	}

	public void setIsoNumeric(String isoNumeric) {
		this.isoNumeric = isoNumeric;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "Country [iso=" + iso + ", iso3=" + iso3 + ", isoNumeric=" + isoNumeric + ", name=" + name + ", capital="
				+ capital + ", area=" + area + ", population=" + population + ", continent=" + continent
				+ ", languages=" + languages + "]";
	}
	
}
