package com.ashokit.ies.dc.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CaseNumberGenerator implements IdentifierGenerator {

	private int applicationSequence = 10000;
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {


		//String prefix = "AR";
		String suffix = "";

		try {

			Connection con = session.connection();
			Statement stmt = con.createStatement();
			String sql = "SELECT MAX(case_number) from dc_cases";
			ResultSet rs = stmt.executeQuery(sql);
			try {
			if (rs.next()) {
				String maxNumber = rs.getString(1);
				int lastNumber = Integer.parseInt(maxNumber);
				suffix = (lastNumber + 1) + "";
				
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
		
		return suffix;
		
	}

}
