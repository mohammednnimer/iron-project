package org.gs.scheduler;

import io.quarkus.scheduler.Scheduled;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.gs.repository.LogsRepo;

public class Logs {



    @Inject
    LogsRepo logsRepo;

    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    void sendRequest() {
        try{
            logsRepo.deleteAll();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
