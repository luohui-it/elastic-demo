/**
 * tisson.com.cn Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package cn.com.elastic.tisson.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.util.concurrent.AbstractIdleService;

/**
 * @author luohui
 * @version Id: Bootstrap.java, v 0.1 2017/5/11 14:12 luohui Exp $$
 */
public class Bootstrap extends AbstractIdleService {

    private ClassPathXmlApplicationContext context;
    private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class);

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.startAsync();
        try {
            Object lock = new Object();
            synchronized (lock) {
                while (true) {
                    lock.wait();
                }
            }
        } catch (InterruptedException ex) {
            LOGGER.error("ignore interruption",ex);
        }
    }

    /**
     * Start the service.
     */
    @Override
    protected void startUp() throws Exception {
        context = new ClassPathXmlApplicationContext(new String[]{"spring/spring-context.xml"});
        context.start();
        context.registerShutdownHook();
        LOGGER.info("job-service started successfully");
    }

    /**
     * Stop the service.
     */
    @Override
    protected void shutDown() throws Exception {
        context.stop();
        LOGGER.info("job-service stopped successfully");
    }
}
