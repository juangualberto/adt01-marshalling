package com.iesvdc.acceso.modelos;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LocalidadesTest {

	@Test
	public void testGetLocalidades() throws Exception {
		Localidad loc1, loc2; 
		loc1 = new Localidad("JAEN", 23002, "JAEN");
		Localidades locs = new Localidades();
		locs.add(loc1);
		loc2 = new Localidad("JAEN", 23005, "JAEN");
		locs.add(loc2);
		if (locs.getLocalidades().size()==2) {
			Localidad loc3, loc4;
			loc3 = locs.getLocalidades().get(0);
			loc4 = locs.getLocalidades().get(1);
			if ( loc1.equals(loc3) && loc2.equals(loc4) )
				assertTrue(true);
			else 
				assertTrue(false);
		} else 
			assertTrue(false);
	}

	@Test
	public void testLoad() throws Exception {
		Localidades locs = new Localidades();
		Localidades locs2 = new Localidades();
		locs.load();
		locs2.load();
		if (locs.equals(locs2)) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}



}
