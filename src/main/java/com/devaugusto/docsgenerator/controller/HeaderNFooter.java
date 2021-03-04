/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devaugusto.docsgenerator.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

/**
 *
 * @author AUGUSTO
 */
public class HeaderNFooter {
    private String imgFileHeader ="C:/Users/AUGUS/DirDocx/header.png";    
    private String imgFileFooter ="C:/Users/AUGUS/DirDocx/footer.png"; 
    
    public void setHeader(XWPFDocument doc) throws FileNotFoundException, InvalidFormatException, IOException{
        XWPFParagraph headerParagraph = doc.createParagraph();
        XWPFRun headerRun = headerParagraph.createRun();
                headerRun.addPicture(new FileInputStream(imgFileHeader), 
                XWPFDocument.PICTURE_TYPE_PNG, 
                imgFileHeader,
                Units.toEMU(120), 
                Units.toEMU(100)
                );
        headerParagraph.setAlignment(ParagraphAlignment.CENTER);
        headerRun.addBreak();
    }
    
    public void setFooter(XWPFDocument doc) throws FileNotFoundException, InvalidFormatException, IOException{
        XWPFParagraph footerParagraph = doc.createParagraph();
        XWPFRun footerRun = footerParagraph.createRun();
                footerRun.addPicture(new FileInputStream(imgFileFooter), 
                XWPFDocument.PICTURE_TYPE_PNG,
                imgFileFooter,
                Units.toEMU(450), 
                Units.toEMU(80)
                );
        footerParagraph.setAlignment(ParagraphAlignment.DISTRIBUTE);
        footerRun.addBreak();
    }
}
