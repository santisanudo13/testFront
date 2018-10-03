package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import model.Peticion;

public class Controlador {
	public String directorio;
	public int counterPeticion = 0;
	public int counterAplicacion = 0;
	public int counterUsuario = 0;
	public List<Peticion> listPeticiones= new ArrayList<Peticion>();

	public Controlador(String directorio) {
		super();
		this.directorio = directorio;
	}

	public void readAllPeticiones() {
		File dir = new File(directorio);

		if(dir.isDirectory()) {
			if(dir.listFiles().length > 0)
				for(File file : dir.listFiles())
					if(getFileExtension(file).equals(".xls"))
						readPeticion(file);
		}
	}

	public boolean readPeticion(File file) {

		Workbook workbook = null;
		try {

			workbook = Workbook.getWorkbook(file);

			Sheet sheet = workbook.getSheet(0);
			Cell cell1 = sheet.getCell(0, 0);
			System.out.print(cell1.getContents() + ":");    // Test Count + :
			Cell cell2 = sheet.getCell(0, 1);
			System.out.println(cell2.getContents());        // 1

			Cell cell3 = sheet.getCell(1, 0);
			System.out.print(cell3.getContents() + ":");    // Result + :
			Cell cell4 = sheet.getCell(1, 1);
			System.out.println(cell4.getContents());        // Passed

			System.out.print(cell1.getContents() + ":");    // Test Count + :
			cell2 = sheet.getCell(0, 2);
			System.out.println(cell2.getContents());        // 2

			System.out.print(cell3.getContents() + ":");    // Result + :
			cell4 = sheet.getCell(1, 2);
			System.out.println(cell4.getContents());        // Passed 2

		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} finally {

			if (workbook != null) {
				workbook.close();
			}

		}
		return true;
	}

	private static String getFileExtension(File file) {
		String extension = "";

		try {
			if (file != null && file.exists()) {
				String name = file.getName();
				extension = name.substring(name.lastIndexOf("."));
			}
		} catch (Exception e) {
			extension = "";
		}

		return extension;

	}

	public String getDirectorio() {
		return directorio;
	}

	public void setDirectorio(String directorio) {
		this.directorio = directorio;
	}

	public List<Peticion> getListPeticiones() {
		return listPeticiones;
	}

	public void setListPeticiones(List<Peticion> listPeticiones) {
		this.listPeticiones = listPeticiones;
	}
	
	public boolean addPeticion(Peticion peticion) {
		return listPeticiones.add(peticion);
	}
	
	public int counterPeticiones() {
		return listPeticiones.size();
	}
	
	public boolean clearList() {
		listPeticiones.clear();
		return true;
	}

}
