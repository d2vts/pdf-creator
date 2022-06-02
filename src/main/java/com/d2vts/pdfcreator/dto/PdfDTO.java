package com.d2vts.pdfcreator.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 체크 박스의 경우 영대문자 V를 둘중 해당하는곳에 넣는것으로
 */
public class PdfDTO {

    // 접수번호
    private String appNo;
    // 접수일시
    private String dateOfReceipt;
    // 발급일
    private String dateOfIssuance;
    // 기관명
    private String organization;
    // 사업자 등록 번호
    private String businessRegistrationNo;
    // 성명
    private String name;
    // 생년월일
    private String dateOfBirth;
    // 사무실 소재지
    private String officeAddress;
    // 전화번호
    private String tel;
    // 용도
    private String purpose;
    // 목적
    private String objective;
    // 내용
    private String item;
    // 수행기관
    private String institution;
    // 총분양 개체수
    private String totalIndividuals;

    // 신청 년도( 해당 일자의 연도 )
    private String regYear;
    // 신청 월( 해당 일자의 월 )
    private String regMonth;
    // 신청 일( 해당 일자의 일 )
    private String regDay;

    // 국내 국외 CheckBox
        // 국내
    private String domestic;
        // 국외
    private String oversea;

    // 용도 CheckBox
        // 시험.연구용
    private String research;
        // 그 밖의 용도
    private String etc;

    // 그 밖의 용도 설명
    private String etcDescription;
}
