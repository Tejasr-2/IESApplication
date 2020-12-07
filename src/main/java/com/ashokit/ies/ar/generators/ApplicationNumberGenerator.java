package com.ashokit.ies.ar.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ApplicationNumberGenerator implements IdentifierGenerator{

	private int applicationSequence = 1000;
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		String prefix = "AR";
		String suffix = "";

		try {

			Connection con = session.connection();
			Statement stmt = con.createStatement();
			String sql = "SELECT MAX(application_id) from applications";
			ResultSet rs = stmt.executeQuery(sql);
			try {
			if (rs.next()) {
				String maxNumber = rs.getString(1);
				int lastFour = Integer.parseInt(maxNumber.substring(maxNumber.length() - 4));
				suffix = (lastFour + 1) + "";
				//System.out.println(suffix);
			}

			}catch (Exception e) {
				
				suffix += applicationSequence;
				System.out.println(suffix);
				applicationSequence += 1;
				System.out.println(applicationSequence);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prefix + suffix;
	}

}
