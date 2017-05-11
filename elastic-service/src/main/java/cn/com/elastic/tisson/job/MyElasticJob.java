/**
 * tisson.com.cn Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package cn.com.elastic.tisson.job;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @author luohui
 * @version Id: MyElasticJob.java, v 0.1 2017/5/11 17:05 luohui Exp $$
 */
@Slf4j
@Service
public class MyElasticJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {

        switch (shardingContext.getShardingItem()) {
            case 0:
                log.info("此处执行的是分片0的任务");
                break;
            case 1:
                log.info("此处执行的是分片1的任务");
                break;
        }

    }
}
