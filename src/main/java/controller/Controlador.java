package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;

import model.Aplicacion;
import model.Peticion;
import model.Usuario;

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
					if(getFileExtension(file).equals(".xls") || getFileExtension(file).equals(".xlsx"))
						readPeticion(file);
		}
	}

	public boolean readPeticion(File file) {
		List<Aplicacion> listAplicaciones = new ArrayList<Aplicacion>();
		List<Usuario> listUsuarios = new ArrayList<Usuario>();
		

		try {

            FileInputStream excelFile = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            CellReference cellReference;
            Row row;
            
            
            cellReference = new CellReference("C8");             
            row = sheet.getRow(cellReference.getRow());
            Cell tipo = row.getCell(cellReference.getCol());

                System.out.println(tipo.getStringCellValue());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		Peticion peticion = new Peticion();
		peticion.setListAplicaciones(listAplicaciones);
		peticion.setListUsuarios(listUsuarios);
		listPeticiones.add(peticion);
		return true;
	}

	private static String getFileExtension(File file) {
		String extension = "";

		try {
			if (file != null && file.exists()) {
				String name = file.getName();
				extension = name.substring(name.lastIndexOf(".xls"));
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

	public void subirPeticionActual() {
		// TODO Auto-generated method stub
		
	}

}
