/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devaugusto.docsgenerator;

import com.devaugusto.docsgenerator.controller.ChecaMaiorIdade;
import com.devaugusto.docsgenerator.controller.ExcelController;
import com.devaugusto.docsgenerator.controller.HeaderNFooter;
import com.devaugusto.docsgenerator.model.Columns;
import com.devaugusto.docsgenerator.utils.DummyData;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
/**
 *
 * @author AUGUSTO
 */
public class Demo {

    public static void main(String[] args) throws FileNotFoundException, IOException, InvalidFormatException{
        ExcelController excelController = new ExcelController();
        List<Columns> records = excelController.create();
//      Return List
//        excelController.getRecords(records);
        String folder = "C:/Users/AUGUS/DirDocx/";
        String[] file = new String[records.size()];
        DummyData dummyData = new DummyData();
        XWPFDocument doc = null;
        FileOutputStream out = null;
        HeaderNFooter hf = new HeaderNFooter();

        File f = new File(folder);
        if(!f.exists()){
          System.out.println("Created folder "+folder);
          f.mkdirs();
        }

        for(int i = 0; i < 10; i++){
        doc = new XWPFDocument();
//        Para alunos menores
        file[i] = records.get(i).getTurmaInteiro()
                +" "+records.get(i).getNomeAluno().trim()+".docx";

//        Para alunos maiores
//        file[i] = records.get(i).getTurma()
//                +" "+records.get(i).getNomeAluno().trim()+".docx";

//      inserting header
        hf.setHeader(doc);
//      Creating title structure
        XWPFParagraph titleParagraph = doc.createParagraph();
        XWPFRun titletmprun = titleParagraph.createRun();
            titleParagraph.setAlignment(ParagraphAlignment.CENTER);
            titletmprun.setFontSize(20);
            titletmprun.setFontFamily("Times New Roman");
            titletmprun.setText(dummyData.getTITLE());
            titletmprun.addBreak();
//      Creating main message structure
        XWPFParagraph paragraph = doc.createParagraph();
        XWPFRun tmprun = paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.BOTH);
            tmprun.setFontFamily("Times New Roman");
            tmprun.setFontSize(12);
//            Checa se aluno é maior de idade
            ChecaMaiorIdade checaMaiorIdade = new ChecaMaiorIdade();
            if(checaMaiorIdade.checaIdade(records.get(i).getDataNasc())){
//               Texto para aluno maior
            tmprun.setText("Eu, aluno(a) "+records.get(i)
              .getNomeAluno().trim().toUpperCase()+", turma: "
             +records.get(i).getTurmaInteiro()+", inscrito(a) sob o CPF nº.: "
             +records.get(i).getCpfAluno()+", matriculado na Unidade Escolar"
             + " COLÉGIO ESTADUAL PROFESSORA ALVINA VALÉRIO DA SILVA,"
             + " sob a matrícula: "+records.get(i).getMatriculaAluno()
             + ", declaro estar recebendo um Kit de gêneros alimentícios,"
             + " contendo: "+dummyData.getKIT() + dummyData.getLAST_TEXT());
            }else{
//            Texto para aluno menor
            tmprun.setText("Eu, "+records.get(i).getNomeMae().trim().toUpperCase()
             +", inscrito(a) sob o CPF nº.: "+records.get(i).getCpfMae()
             +", responsável pelo aluno(a) "+records.get(i).getNomeAluno()
             .trim().toUpperCase()+", turma: "+records.get(i).getTurmaInteiro()
             +", matriculado na Unidade Escolar Colégio Estadual "
             + "Professora Alvina Valério da Silva, sob a matrícula: "
             +records.get(i).getMatriculaAluno()+", declaro estar recebendo"
             + " um Kit de gêneros alimentícios, contendo: "
             + dummyData.getKIT() + dummyData.getLAST_TEXT());
            }
            tmprun.addBreak();
            tmprun.addBreak();
//      Creating signature strucute
        XWPFParagraph signatureParagraph = doc.createParagraph();
        XWPFRun signaturetmprun = signatureParagraph.createRun();
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

            out = new FileOutputStream(new File(folder+file[i]));
            doc.write(out);
            
//            System.out.println("Escreveu aluno "+records.get(i).getNomeAluno());
         }
        doc.close();
        out.close();
    }
}
