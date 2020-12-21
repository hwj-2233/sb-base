//package com.zyuc.log;
//
//
//import com.zyuc.log.mapper.IArticleMapper;
//import com.zyuc.log.model.Article;
//import com.zyuc.log.model.TestM;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class LogApplicationTests {
//
//    @Autowired
//    private IArticleMapper articleMapper;
//
//    @Autowired
//    private Article article;
//
//    @Test
//    public void contextLoads() {
//        System.out.println("hello");
//    }
//
////    @TestM
////    public void test1() {
////        Article article = new Article();
////        article.setContent("我爱你");
////        article.setSubtitle("我爱你");
////        article.setTitle("我爱你");
////        articleMapper.insert(article);
////
////    }
//
//    @Test
//    public void test2() {
//        article.setContent("张一杭是晒比");
//        System.err.println(article.toString());
//
//    }
//
//}
