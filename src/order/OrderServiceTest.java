package order;

import member.Grade;
import member.Member;
import member.repository.MemberRepository;
import member.repository.MemoryMemberRepositoryImpl;
import order.repository.DiscountPolicy;
import order.repository.FixDiscountPolicyImpl;
import order.repository.PercentDiscountPolicyImpl;
import order.service.OrderService;
import order.service.OrderServiceImpl;

public class OrderServiceTest {

	public static void main(String[] args) {
		
		MemberRepository memberRepository = MemoryMemberRepositoryImpl.getInstance();
		Member member = new Member(1L, "홍길동", Grade.VIP);
		
		
		// 고정 할인 정책 테스트 
		DiscountPolicy fixDiscountPolicy = new FixDiscountPolicyImpl();
		DiscountPolicy percentDiscountPolicy = new PercentDiscountPolicyImpl();
		
		OrderService orderService1 = new OrderServiceImpl(memberRepository, percentDiscountPolicy);
		Order order1 = orderService1.createOrder(1L, "맥북", 10000);
		System.out.println(order1);
		System.out.println(order1.calculateDiscount());
		

	}

}
