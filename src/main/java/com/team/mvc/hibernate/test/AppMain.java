package com.team.mvc.hibernate.test;

import com.team.mvc.dao.CitiesDaoImpl;
import com.team.mvc.entity.CitiesEntity;
import com.team.mvc.hibernate.utils.HibernateSessionFactory;
import com.team.mvc.service.CitiesService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Nick on 15.03.2017.
 */
public class AppMain extends CitiesDaoImpl{
    public static void main(String[] args) {
        CitiesService citiesService = new CitiesService();
        System.out.println(citiesService.getCity());

    }
}
