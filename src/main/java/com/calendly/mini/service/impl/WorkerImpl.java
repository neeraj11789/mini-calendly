package com.calendly.mini.service.impl;

import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class WorkerImpl implements Worker {

    public void executeJob(){
        // fetch 1 job
        do {
            Job newJob = jobService.getNewJob();

            try {
                // execute job
                // handle of failure & success

                // Timeout should throw BusinessException class object on timeouts
                jobService.executeJob();
            } catch (NonExecutableException e) {
                // Calling all the non-executables exception class as subclass of the NonExecutableException
                // which is thrown from various places of the app

                // update the job status as NON_EXECUTABLE
                jobService.updateJobStatus(NON_EXECUTABLE);

            } catch (BusinessExecution e) {
                // For all the business exeception which would arise for different use-case which does not
                // kill the application and can be fixed by re-run are marked as subclass of BusinessExecution

                // update the status as FAILED
                jobService.updateJobStatus(FAILED);
            } finally {
                Thread.sleep(5000);
            }
        }while(true);

        // fetch next job ** handle timestamp
    }


    public void executeJob(){


        try{

            // send heartBeat every second
            Thread thread = ThreadPool.getTread();
            thread.run();

            // call hearbeat inside run of Thread


            // Make Http Call



        }catch (ReadTimeoutException rt){
            throw new BusinessExecution();
        }catch (Exception e){
            throw new BusinessExecution();
        }finally {
            // close the heartbeat thread
        }

    }
}