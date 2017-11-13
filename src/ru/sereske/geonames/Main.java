package ru.sereske.geonames;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	
	private static final String CITY_FILE_NAME = "c:\\cities15000.txt";
	private static final String COUNTRY_FILE_NAME = "c:\\countryInfo.txt";
	
	private static final int EARTH_RADIUS = 6400;
	
	public static void main(String[] args) {
		List<Country> countries = new ArrayList<>();
		List<City> cities = new ArrayList<>();
		List<City> megaCities = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(COUNTRY_FILE_NAME)))) {
			
			String s = null;
			while ((s = reader.readLine()) != null) {
				if (!s.startsWith("#")) {
					String[] parameters = s.split("\t");
					String iso = parameters[0];
					String iso3 = parameters[1];
					String isoNumeric = parameters[2];
					String countryName = parameters[4];
					String capital = parameters[5];
					double area = Double.parseDouble(parameters[6]);
					int population = Integer.parseInt(parameters[7]);
					String continent = parameters[8];
					String languages = parameters[15];
					
					Country country = new Country();
					country.setIso(iso);
					country.setIso3(iso3);
					country.setIsoNumeric(isoNumeric);
					country.setName(countryName);
					country.setCapital(capital);
					country.setArea(area);
					country.setPopulation(population);
					country.setContinent(continent);
					country.setLanguages(languages);
					countries.add(country);
					//System.out.println(country);
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(CITY_FILE_NAME)))) {
			
			String s = null;
			while ((s = reader.readLine()) != null) {
				String[] parameters = s.split("\t");
				int id = Integer.parseInt(parameters[0]);
				String name = parameters[1];
				double latitude = Double.parseDouble(parameters[4]);
				double longitude = Double.parseDouble(parameters[5]);
				String admin1Code = parameters[8];
				long population = Long.parseLong(parameters[14]); 
				
				City city = new City();
				city.setId(id);
				city.setName(name);
				city.setLatitude(latitude);
				city.setLongitude(longitude);
				city.setAdmin1Code(admin1Code);
				city.setPopulation(population);
				//System.out.println("id: " + id + ", name: " + name + ", latitude: " + latitude + ", longitude: " + longitude + ", population: " + population);
				if (city.getPopulation() < 500000 && city.getPopulation() > 100000) {
					cities.add(city);
				}
				if (city.getPopulation() > 1000000) {
					megaCities.add(city);
				}
			}
			System.out.println(cities.size());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		Map<String, Integer> result = new HashMap<>();
		for (Country country : countries) {
			result.put(country.getName(), 0);
			for (City city : cities) {
				if (city.getAdmin1Code().equals(country.getIso())) {
					int amount = result.get(country.getName());
					result.put(country.getName(), ++amount);
				}
			}
		}
		result = sortByValue(result);
		for (Map.Entry<String, Integer> pair : result.entrySet()) {
			if (pair.getValue() != 0) {
				System.out.println(pair.getKey() + ": " + pair.getValue());
			}
		}
		Collections.sort(cities, new Comparator<City>() {

			@Override
			public int compare(City c1, City c2) {
				return c1.getName().compareTo(c2.getName());
			}
		});
		
		for (City city : cities) {
			for (City megaCity : megaCities) {
				double distance = getDistance(city, megaCity);
				if (!city.equals(megaCity) && distance < 100 && city.getAdmin1Code().equals("IN")) {
					System.out.println(city.getName() + " - " + megaCity.getName() + ": " + distance);
				}
			}
		}
		
		for (City city : cities) {
			if (city.getAdmin1Code().equals("IN")) {
				boolean hasBigBrother = false;
				for (City megaCity : megaCities) {
					double distance = getDistance(city, megaCity);
					if (!city.equals(megaCity) && distance < 100 && city.getAdmin1Code().equals("IN")) {
						hasBigBrother = true;
						break;
					}
				}
				if (!hasBigBrother) {
					System.out.println("У этого города нет большого брата: " + city.getName());
				}
			}
		}
		/*
		City cityGhandinagar = null;
		City cityAhmedabad = null;
		for (City city : cities) {
			if (city.getName().equals("Ghandinagar")) {
				cityGhandinagar = city;
				break;
			}
		}
		for (City city : cities) {
			if (city.getName().equals("Ahmedabad")) {
				cityAhmedabad = city;
				break;
			}
		}
		System.out.println(cityGhandinagar.getName() + " - " + cityAhmedabad.getName() + ": " + getDistance(cityAhmedabad, cityGhandinagar));
		*/
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
	    return map.entrySet()
	              .stream()
	              .sorted(Map.Entry.comparingByValue(/*Collections.reverseOrder()*/))
	              .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                Map.Entry::getValue, 
	                (e1, e2) -> e1, 
	                LinkedHashMap::new
	              ));
	}
	
	public static double getDistance (City myCity, City otherCity) {
		double fi1 = myCity.getLatitude();
		double lmb1 = myCity.getLongitude();
		double fi2 = otherCity.getLatitude();
		double lmb2 = otherCity.getLongitude();
		double between = EARTH_RADIUS * Math.acos(
				Math.sin(fi1 * Math.PI / 180) * Math.sin(fi2 * Math.PI / 180) + Math.cos(fi1 * Math.PI / 180) * Math.cos(fi2 * Math.PI / 180) * Math.cos((lmb2 - lmb1) * Math.PI / 180)
				);
		return Math.abs(between);
	}
}
