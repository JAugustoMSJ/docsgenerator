/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devaugusto.docsgenerator;

import com.devaugusto.docsgenerator.controller.ExcelController;
import com.devaugusto.docsgenerator.controller.HeaderNFooter;
import com.devaugusto.docsgenerator.model.Columns;
import com.devaugusto.docsgenerator.utils.DummyData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;



/**
 *
 * @author AUGUSTO
 */
public class Demo {

    public static void main(String[] args) throws FileNotFoundException, IOException, InvalidFormatException {
        ExcelController excelController = new ExcelController();
        List<Columns> records = excelController.create();
//      Return List
//        excelController.getRecords(records);
        XWPFDocument doc = null;
        
        XWPFParagraph titleParagraph = null;
        XWPFParagraph paragraph = null;
        XWPFParagraph signatureParagraph = null;
        
        XWPFRun titletmprun = null;
        XWPFRun tmprun = null;
        XWPFRun signaturetmprun = null;
        
        FileOutputStream out = null;
        HeaderNFooter hf = new HeaderNFooter();
        String folder = "C:/Users/AUGUSTO/DirDocx/";
        String[] file = new String[3];
        DummyData dummyData = new DummyData();
        
        File f = new File(folder);
        if(!f.exists()){
          System.out.println("Created folder "+folder);
          f.mkdirs();
        }

        for(int i = 0; i < 3; i++){
        doc = new XWPFDocument();
        file[i] = records.get(i).getNomeAluno().trim()+".docx";
//      inserting header
        hf.setHeader(doc);
//      Creating title structure
        titleParagraph = doc.createParagraph();
        titletmprun = titleParagraph.createRun();
            titleParagraph.setAlignment(ParagraphAlignment.CENTER);
            titletmprun.setFontSize(20);
            titletmprun.setFontFamily("Times New Roman");
            titletmprun.setText(dummyData.getTITLE());
            titletmprun.addBreak();
//      Creating main message structure
        paragraph = doc.createParagraph();
        tmprun = paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.BOTH);
            tmprun.setFontFamily("Times New Roman");
            tmprun.setFontSize(12);
            tmprun.setText("Eu, aluno(a) "+records.get(i).getNomeAluno().toUpperCase()+
             ", turma: "+records.get(i).getTurma()+", inscrito sob o CPF nº.: "
             +records.get(i).getCpfMae()+", matriculado na Unidade Escolar"
             + " COLÉGIO ESTADUAL PROFESSORA ALVINA VALÉRIO DA SILVA, sob a matrícula: "
             +records.get(i).getMatriculaAluno()+", declaro estar recebendo um "
             + "Kit de gêneros alimentícios, contendo: "
             + dummyData.getKIT() + dummyData.getLAST_TEXT());
            tmprun.addBreak();
            tmprun.addBreak();
//      Creating signature strucute
        signatureParagraph = doc.createParagraph();
        signaturetmprun = signatureParagraph.createRun();
            signatureParagraph.setAlignment(ParagraphAlignment.CENTER);
            signaturetmprun.setFontFamily("Times New Roman");
            signaturetmprun.setFontSize(12);
            signaturetmprun.setText(dummyData.getDATA());
            signaturetmprun.addBreak();
            signaturetmprun.addBreak();
            signaturetmprun.addBreak();
            signaturetmprun.setText(dummyData.getSIGNATURE());
            signaturetmprun.addBreak();
            signaturetmprun.setText(dummyData.getSIGNATURE_TEXT());
//            tmprun.addBreak();
//            tmprun.addBreak();
//            tmprun.addBreak();
//            tmprun.addBreak();
//            tmprun.addBreak();
//            tmprun.addBreak();
//            tmprun.addBreak();
//            tmprun.addBreak();
//            tmprun.addBreak();
//            tmprun.addBreak();
//            tmprun.addBreak();
//            tmprun.addBreak();
//            
////      inserting footer
//        hf.setFooter(doc);
            
            out = new FileOutputStream(new File(folder+file[i]));
            doc.write(out);
            
            System.out.println("Escreveu aluno "+records.get(i).getNomeAluno());
         }
        doc.close();
        out.close();
            
//        System.out.println("Wrote to file "+folder + file);
    }
}
