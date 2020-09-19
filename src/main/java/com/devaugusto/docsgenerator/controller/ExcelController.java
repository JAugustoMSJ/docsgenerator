/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devaugusto.docsgenerator.controller;

import com.devaugusto.docsgenerator.model.Columns;
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
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
        FileInputStream file = new FileInputStream("c:/Users/AUGUSTO/DirDocx/Consulta - Kits.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        
//      Choosing sheet
        Sheet sheet = workbook.getSheetAt(4);
        
        List<Row> rows = (List<Row>) toList(sheet.iterator());
//      Ignoring first row
        rows.remove(0);
        rows.forEach(row -> {
           List<Cell> cells = (List<Cell>) toList(row.cellIterator());
           
           Columns record = Columns.builder()
                   .nomeAluno(cells.get(0).getStringCellValue().trim())
                   .dataNasc(cells.get(1).getDateCellValue())
                   .matriculaAluno(new BigDecimal(cells.get(2).getNumericCellValue()))
                   .turma(cells.get(5).getStringCellValue().trim())
                   .cpfMae(new BigDecimal(cells.get(6).getNumericCellValue()))
                   .build();
           columns.add(record);
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
