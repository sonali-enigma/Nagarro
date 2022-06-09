package com.service;

import java.io.*;

import com.entity.Tshirt;
import com.opencsv.*;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;


@Controller
public class SearchTshirt {

	
	// inserting data in database

	public void insertingInDB(List<String> FileName) throws NumberFormatException, IOException {

		SessionFactory factory = new Configuration().configure("hibernateC.cfg.xml").addAnnotatedClass(Tshirt.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();

		for (String filename : FileName) {
			FileReader filereader = new FileReader(filename);
			CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).withCSVParser(parser).build();
			List<String[]> allData = csvReader.readAll();

			for (String[] record : allData) {
				Tshirt tshirt = new Tshirt();
				tshirt.setID(record[0].toUpperCase());
				tshirt.setName(record[1].toUpperCase());
				tshirt.setColour(record[2].toUpperCase());
				tshirt.setGender(record[3].toUpperCase());
				tshirt.setSize(record[4].toUpperCase());
				tshirt.setPrice(Float.parseFloat(record[5]));
				tshirt.setRating(Float.parseFloat(record[6]));
				tshirt.setAvailability(record[7].toUpperCase());

				session.save(tshirt);
			}

		}

		session.getTransaction().commit();

	}

	public List<Tshirt> sortTshirts(String colour, String size, String gender, String outputPreference) {
		SessionFactory factory = new Configuration().configure("hibernateV.cfg.xml").addAnnotatedClass(Tshirt.class)
				.buildSessionFactory();
		Session session = factory.openSession();
		Query query;
		
		// if outputpreference is price
		if (outputPreference.equals("1")) {
			query = session
					.createQuery("from Tshirt where COLOUR=:colour AND  SIZE=:size AND GENDER=:gender order by PRICE");
		}

		// if outputpreference is rate
		else if (outputPreference.equals("2")) {
			query = session.createQuery(
					"from Tshirt where COLOUR=:colour AND  SIZE=:size AND GENDER=:gender order by RATING DESC");
		}

		// if outputpreference is price and rate both
		else {
			query = session.createQuery(
					"from Tshirt where COLOUR=:colour AND  SIZE=:size AND GENDER=:gender order by PRICE,RATING DESC");
		}

		query.setParameter("colour", colour);
		query.setParameter("size", size);
		query.setParameter("gender", gender);
		List<Tshirt> tshirtlist = (List<Tshirt>) query.list();

		
		
		return tshirtlist;
	}

	
	}
