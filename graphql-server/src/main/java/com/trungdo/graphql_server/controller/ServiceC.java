package com.trungdo.graphql_server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceC {

    Logger log = LoggerFactory.getLogger(ServiceC.class);

    @Autowired
    private List<ServiceInterface> serviceInterfaces;

}
