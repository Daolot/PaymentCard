package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CardsRepository extends AbstractRepository<Cards> {
    public CardsRepository() {
        super(Cards.class);
    }
    @Autowired
    TypeCardRepository typeCardRepository;

    public List<Cards> getAllBlockCards(){
//        Query query = getSession().createQuery("SELECT C FROM Cards  C ");
//
////        query.setLong("typeCard", Long.parseLong("21")); WHERE C.typeCard=:typeCard
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.in("typeCard", typeCardRepository.getByStatus("block")));
        List<Cards> cardss=criteria.list();
        return cardss;
    }

    public void blockCardById(long cardId){
     /*  Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("UPDATE Cards C SET C.typeCard =:typeCard WHERE C.cardId=:cardId");

        query.setLong("cardId",cardId);
        query.setLong("typeCard",Long.parseLong("21"));
        int result = query.executeUpdate();
        session.getTransaction().commit();*/

     /*   String UPDATE = "UPDATE Cards CM SET CM.TYPE_ID =21 WHERE CM.card_Id=" + cardId ;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery(UPDATE);
        int result = sqlQuery.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();*/
        String UPDATE = "UPDATE CARDS  SET CARDS.TYPE_ID =21 WHERE CARDS.CARD_ID="+cardId;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery(UPDATE);
        int result = sqlQuery.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();
        }


    public Cards findByCardKey(long key) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cardId", key));
        return (Cards) criteria.uniqueResult();
    }

    @Override
    public List<Cards> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("cardId"));
        return criteria.list();
    }
}
