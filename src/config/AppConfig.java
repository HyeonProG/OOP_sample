package config;

import member.repository.MemberRepository;
import member.repository.MemoryMemberRepositoryImpl;
import member.service.MemberService;
import member.service.MemberServiceImpl;
import order.repository.DiscountPolicy;
import order.repository.FixDiscountPolicyImpl;
import order.repository.PercentDiscountPolicyImpl;
import order.service.OrderService;
import order.service.OrderServiceImpl;

public class AppConfig {

    public MemberRepository getMemberRepository() {
        return MemoryMemberRepositoryImpl.getInstance();
    }

    public MemberService getMemberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    public DiscountPolicy getDiscountPolicy() {
        // 할인 정책이 지금은 고정 할인
        // 변경이 된다면 정율 할인으로 바꾸면 된다.
        // return new FixDiscountPolicyImpl(); --> 이 부분만 변경하면 된다.
        return new PercentDiscountPolicyImpl();
    }

    public OrderService getOrderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

}
