package org.jrue.spring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Statistics {
	@Value("#{cities.?[population ge 200]}")
	private List<City> bigCities;
	@Value("#{cities.?[population ge 200].![name + ' , ' + population]}")
	private List<String> bigCitiesInName;
	@Value("#{cities.^[population ge 200]}")
	private City firstBigCity;
	@Value("#{cities.$[population ge 200]}")
	private City lastBigCity;

	public List<City> getBigCities() {
		return bigCities;
	}

	public void setBigCities(List<City> bigCities) {
		this.bigCities = bigCities;
	}

	public City getFirstBigCity() {
		return firstBigCity;
	}

	public void setFirstBigCity(City firstBigCity) {
		this.firstBigCity = firstBigCity;
	}

	public City getLastBigCity() {
		return lastBigCity;
	}

	public void setLastBigCity(City lastBigCity) {
		this.lastBigCity = lastBigCity;
	}

	public List<String> getBigCitiesInName() {
		return bigCitiesInName;
	}

	public void setBigCitiesInName(List<String> bigCitiesInName) {
		this.bigCitiesInName = bigCitiesInName;
	}
	
}
