package com.lingyi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;

/**
 * @author 咕噜科
 * ClassName: ThreadController
 * date: 2022-06-11 15:28
 * Description:
 * version 1.0
 */
@RestController
@RequestMapping("/thread")
public class ThreadController {

    @Qualifier("threadPoolInstance")
    @Autowired
    private ExecutorService executorService;

    @RequestMapping("/test")
    public void test () {
        for (int i = 0; i < 30; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"---->执行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"---->执行结束");
                }
            });
        }

    }

}
