package config;

import member.Grade;
import member.Member;
import member.service.MemberService;
import order.Order;
import order.service.OrderService;

public class MainApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        // 클라이언트 입장에서 코딩

        // 회원 가입 기능이 필요
        MemberService memberService = appConfig.getMemberService();
        Member member = new Member(200L, "도시락", Grade.VIP);
        memberService.signUp(member);

        // 사용자가 주문 요청
        OrderService orderService1 = appConfig.getOrderService();
        Order order1 = orderService1.createOrder(member.getId(), "아이폰 16", 100000);
        
        System.out.println(order1);
        System.out.println(order1.getDiscountPrice());

    }

}
