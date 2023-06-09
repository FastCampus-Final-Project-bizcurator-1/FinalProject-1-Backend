package project.finalproject1backend.dto.inquiry;

import lombok.*;
import project.finalproject1backend.domain.AttachmentFile;
import project.finalproject1backend.domain.Inquiry.BuyInquiry;
import project.finalproject1backend.domain.Inquiry.BuyInquiryState;
import project.finalproject1backend.dto.AttachmentDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyInquiryResponseDTO {
    private String inquiryId;
    private String userId;

    private String email;

    private String phoneNumber;

    private String companyName;

    private String category;

    private String product;

    private int amount;

    private List<AttachmentDTO> buyImageList = new ArrayList<>();
    private List<AttachmentDTO> answerAttachmentList = new ArrayList<>();

    private String content;

    private LocalDate estimateWishDate;

    private LocalDate deliveryWishDate;

    private BuyInquiryState state;


    public BuyInquiryResponseDTO(BuyInquiry b) {
        this.inquiryId=b.getId();
        this.userId = b.getBuyInquiryId().getUserId();
        this.email = b.getBuyInquiryId().getEmail();
        this.phoneNumber = b.getBuyInquiryId().getPhoneNumber();
        this.companyName = b.getBuyInquiryId().getCompanyName();
        this.category = b.getCategory();
        this.product = b.getProduct();
        this.amount = b.getAmount();
        if(!(b.getBuyImageList()==null||b.getBuyImageList().isEmpty())) {
            this.buyImageList = b.getBuyImageList().stream().map(AttachmentDTO::new).toList();
        }
        if(!(b.getAnswerAttachmentList()==null||b.getAnswerAttachmentList().isEmpty())) {
            this.answerAttachmentList = b.getAnswerAttachmentList().stream().map(AttachmentDTO::new).toList();
        }
        this.content = b.getContent();
        this.estimateWishDate = b.getEstimateWishDate();
        this.deliveryWishDate = b.getDeliveryWishDate();
        this.state = b.getState().iterator().next();
    }
}
/*
=> 견적문의 전체조회 api
	- 구분(대량구매, 주문제작)
	- 아이디 0
	- 이메일 0
	- 연락처 0
	- 기업명 0
	- 구매희망제품명 0
	- 구매수량 0
	- 제품이미지리스트 0
	- 요청사항 0
	- 견적수령 희망일 0
	- 제품배송 희망일 0
	- 처리상태 0
 */