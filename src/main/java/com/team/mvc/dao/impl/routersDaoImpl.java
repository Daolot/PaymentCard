package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.routersDao;
import com.team.mvc.entity.RoutesEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class routersDaoImpl extends AbstractDao<Integer,RoutesEntity> implements routersDao {
    @Override
    public RoutesEntity findById(int routeId) {
        return getByKey(routeId);
    }

    @Override
    public void saveRoute(RoutesEntity routesEntity) {
        persist(routesEntity);
    }

    @Override
    public void deleteRoutebyRouteID(int routeId) {
        Query query = getSession().createSQLQuery("delete from ROUTES where ROUTE_ID = :routeId");
        query.setParameter("routeId", routeId);
        query.executeUpdate();
    }

    @Override
    public List<RoutesEntity> findAllRoutes() {
        Criteria criteria = createEntityCriteria();
        return (List<RoutesEntity>) criteria.list();
    }

    @Override
    public List<RoutesEntity> findRouteByRouterNumber(String routeNumber) {

        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ROUTE_NUMBER", routeNumber));
        return (List<RoutesEntity>) criteria.list();
    }

    @Override
    public List<RoutesEntity> findRouteByCompanyID(long companyId) {


        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("COMPANY_ID", companyId));
        return (List<RoutesEntity>) criteria.list();
    }


}
