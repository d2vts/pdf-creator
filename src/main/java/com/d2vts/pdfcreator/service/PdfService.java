package com.d2vts.pdfcreator.service;

import com.d2vts.pdfcreator.dto.PdfDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class PdfService {

    final static String PDF_FORM_PATH = "src/main/resources/static/pdf/application.pdf";
    final static String GULIM_PATH = "src/main/resources/static/pdf/gulim.ttf";

    /**
     * 분양승인 신청서 각 항목별 최적 폰트 사이즈
     *
     * * 아래 항목 제외 = 8 **
     *
     * appNo = 6
     * dateOfIssuance = 6
     * dateOfReceipt = 6
     * etcDescription = 6
     * domestic | oversea = 12
     * name2 = 14
     */

    public void edit(PdfDTO pdfDTO) {

        try (PDDocument pdfDocument = PDDocument.load(new File(PDF_FORM_PATH))) {

            PDAcroForm acroForm = pdfDocument.getDocumentCatalog().getAcroForm();

            PDFont font = PDType0Font.load(pdfDocument, new FileInputStream(GULIM_PATH), false);
            PDResources res = acroForm.getDefaultResources();
            String fontGulim = res.add(font).getName();

            String gulim = "/" + fontGulim + " 8 Tf 0 g"; // default
            String gulim6 = "/" + fontGulim + " 6 Tf 0 g";
            String gulim10 = "/" + fontGulim + " 10 Tf 0 g";
            String gulim12 = "/" + fontGulim + " 12 Tf 0 g";
            String gulim14 = "/" + fontGulim + " 14 Tf 0 g";

            if (acroForm == null) {
                throw new Exception("NoAcroFormError");
            }

            // area
            setFieldValue(acroForm, pdfDTO.getArea(), gulim12, "V");

            // appNo
            setFieldValue(acroForm, "appNo", gulim6, pdfDTO.getAppNo());

            // organization
            setFieldValue(acroForm, "organization", gulim, pdfDTO.getOrganization());

            // businessRegistrationNo
            setFieldValue(acroForm, "businessRegistrationNo",gulim,pdfDTO.getBusinessRegistrationNo());

            // name
            setFieldValue(acroForm, "name", gulim, pdfDTO.getName());

            // name2
            setFieldValue(acroForm, "name2", gulim14, pdfDTO.getName());

            // dateOfReceipt
            setFieldValue(acroForm, "dateOfReceipt", gulim, pdfDTO.getDateOfReceipt());

            // dateOfIssuance
            setFieldValue(acroForm, "dateOfIssuance", gulim, pdfDTO.getDateOfIssuance());

            // dateOfBirth
            setFieldValue(acroForm, "dateOfBirth", gulim, pdfDTO.getDateOfBirth());

            // officeAddress
            setFieldValue(acroForm, "officeAddress", gulim, pdfDTO.getOfficeAddress());

            // tel
            setFieldValue(acroForm, "tel", gulim, pdfDTO.getTel());

            // purpose
            setFieldValue(acroForm, "purpose", gulim, pdfDTO.getPurpose());

            // objective
            setFieldValue(acroForm, "objective", gulim, pdfDTO.getObjective());

            // item
            setFieldValue(acroForm, "item", gulim, pdfDTO.getItem());

            // institution
            setFieldValue(acroForm, "institution", gulim, pdfDTO.getInstitution());

            // totalIndividuals
            setFieldValue(acroForm, "totalIndividuals", gulim, pdfDTO.getTotalIndividuals());

            // regYear
            setFieldValue(acroForm, "regYear", gulim10, pdfDTO.getRegYear());

            // regMonth
            setFieldValue(acroForm, "regMonth", gulim10, pdfDTO.getRegMonth());

            // regDay
            setFieldValue(acroForm, "regDay", gulim10, pdfDTO.getRegDay());

            // purposeChkBox
            String purposeChkBox = pdfDTO.getPurposeChkBox();
            setFieldValue(acroForm, purposeChkBox, gulim, "V");

            // etcDescription
            if ("etc".equals(purposeChkBox)) {
                setFieldValue(acroForm, "etcDescription", gulim6, pdfDTO.getEtcDescription());
            }

            pdfDocument.save("src/main/resources/static/pdf/result.pdf");
            pdfDocument.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /** Field 값, 폰트 채워주는 Method
     *
     * @param acroForm
     * @param fieldName
     * @param font
     * @param value
     * @return
     * @throws IOException
     */
    public PDTextField setFieldValue(PDAcroForm acroForm, String fieldName, String font, String value) throws IOException {

        PDTextField field = (PDTextField) acroForm.getField(fieldName);

        field.setDefaultAppearance(font);
        field.setValue(value);

        return field;
    }

}
