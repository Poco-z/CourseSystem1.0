package com.zxx.service;

import com.zxx.entity.StudentEntity;
import com.zxx.util.UserInfoUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Set;

/**
 * @author zxx
 * @date 2018/10/9 22:24
 */
public class StudentInfoService {



    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    static {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction =  session.beginTransaction();
    }


    private StudentEntity studentEntity;

    public StudentEntity getStudentEntity() {

        Query query = null;
        try {
            int user_id=123;
            Set<Integer> keys = UserInfoUtil.map.keySet();
            for(int a:keys){
                user_id=a;
            }
            query = session.createQuery("from StudentEntity where studentId="+user_id);
            this.studentEntity=(StudentEntity) query.list().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        transaction.commit();
        session.close();
        sessionFactory.close();

        return this.studentEntity;
    }


}
