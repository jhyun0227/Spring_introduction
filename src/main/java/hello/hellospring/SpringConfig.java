package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // private DataSource dataSource;
    // private EntityManager em;
    private final MemberRepository memberRepository;

    //        @Autowired
    //        public SpringConfig(DataSource dataSource) {
    //              this.dataSource = dataSource;
    //        }

    //        @Autowired
    //        public SpringConfig(EntityManager em) {
    //            this.em = em;
    //        }

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // ComponentScan을 이용하지 않고 직접 빈을 주입하는 방법
    //    @Bean
    //    public MemberService memberService() {
    //        return new MemberService(memberRepository());
    //    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        // return new MemoryMemberRepository();
//        // return new JdbcMemberRepository(dataSource);
//        // return new JdbcTemplateMemberRepository(dataSource);
//        // return new JpaMemberRepository(em);
//    }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
