package project.finalproject1backend.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 주문 ID

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 구매자

    @Setter
    private int totalPrice; // 결제 금액

    @Setter
    private String paymentMethod; // 결제 방식

    @Setter
    private long number; //주문 번호(yymmdd+userID+orderID)

    @Setter
    private String deliveryName; //수령인

    @Setter
    private String deliveryPhoneNumber; // 휴대폰 번호

    @Setter
    private String deliveryMemo; // 배송 메모

    @Setter
    private String deliveryZipCode; // 우편 번호

    @Setter
    private String deliveryAddress; // 배송지

    @Setter
    private String deliveryDetailedAddress; // 상세 주소

    @Setter
    private int deliveryCharge; // 배송비

    @Setter
    private String deliveryCompany; // 배송사

    @Setter
    private long deliveryNumber; //송장 번호

    @Setter
    private LocalDate deadline; // 구매 확정 기한

    @Setter
    private OrderStatus status; // 상태

    @Setter
    private String pgUid; // 결제사 uid

    @OneToMany(mappedBy = "orders")
    private List<OrderItems> orderItems;

    public void setUser(User user){ this.user = user;}

}
