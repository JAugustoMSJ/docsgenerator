/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devaugusto.docsgenerator.controller;

import com.devaugusto.docsgenerator.model.Columns;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.Cleanup;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author AUGUSTO
 */
public class ExcelController {
    
    public List<Columns> create() throws FileNotFoundException, IOException{
        List<Columns> columns = new ArrayList<>();
        
        @Cleanup
        FileInputStream file = new FileInputStream("c:/Users/AUGUS/DirDocx/7ª Consulta - Kits - TESTES.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        
//      Choosing sheet
        Sheet sheet = workbook.getSheetAt(7);
        
        List<Row> rows = (List<Row>) toList(sheet.iterator());
//      Ignoring first row
        rows.remove(0);
        rows.forEach(row -> {
           List<Cell> cells = (List<Cell>) toList(row.cellIterator());
           try{
           Columns record = Columns.builder()
                   .nomeAluno(cells.get(0).getStringCellValue().trim())
                   .dataNasc(cells.get(1).getDateCellValue())
                   .matriculaAluno(new BigDecimal(cells.get(2).getNumericCellValue()))
                   .cpfAluno(new BigDecimal(cells.get(3).getNumericCellValue()))
                   .nomeMae(cells.get(4).getStringCellValue())
//                   .turma(cells.get(5).getStringCellValue())
                   .turmaInteiro(new BigDecimal(cells.get(5).getNumericCellValue()))
                   .cpfMae(new BigDecimal(cells.get(6).getNumericCellValue()))
                   .build();
           columns.add(record);
           
           }catch(Exception e){
               e.printStackTrace();
           }
        });
        return columns;
    }
    
    public List<?> toList(Iterator<?> iterator){
        return IteratorUtils.toList(iterator);
    }
    
//    public void getRecords(List<Columns> columns){
//        columns.forEach(System.out::println);
//    }
}
