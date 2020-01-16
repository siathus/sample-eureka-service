package com.direa.seonggook.eurekaservice.service;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.discovery.EurekaClient;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EurekaServiceBase {

    private final ApplicationInfoManager applicationInfoManager;
    private final EurekaClient eurekaClient;
    private final DynamicPropertyFactory configInstance;

    @Inject
    public EurekaServiceBase(ApplicationInfoManager applicationInfoManager,
                              EurekaClient eurekaClient,
                              DynamicPropertyFactory configInstance) {
        this.applicationInfoManager = applicationInfoManager;
        this.eurekaClient = eurekaClient;
        this.configInstance = configInstance;
    }

    @PostConstruct
    public void start() {
        applicationInfoManager.setInstanceStatus(InstanceInfo.InstanceStatus.STARTING);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        applicationInfoManager.setInstanceStatus(InstanceInfo.InstanceStatus.UP);
        waitForRegistrationWithEureka(eurekaClient);
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("등록 완료");
    }

    private void waitForRegistrationWithEureka(EurekaClient eurekaClient) {
        String vipAddress = configInstance.getStringProperty("eureka.vipAddress", "sampleservice.mydomain.net").get();
        System.out.println(vipAddress);
        InstanceInfo nextServerInfo = null;
        while (nextServerInfo == null) {
            try {
                nextServerInfo = eurekaClient.getNextServerFromEureka(vipAddress, false);
                System.out.println(nextServerInfo.getPort());
                System.out.println(nextServerInfo.getVIPAddress());
            } catch (Throwable e) {
                System.out.println("Eureka Server에 등록되었는지 확인합니다.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
