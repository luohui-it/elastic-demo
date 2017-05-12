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
 * Simple类型作业
 * 意为简单实现，未经任何封装的类型。需实现SimpleJob接口。该接口仅提供单一方法用于覆盖，此方法将定时执行。与Quartz原生接口相似，但提供了弹性扩缩容和分片等功能。
 * @author luohui
 * @version Id: MySimpleElasticJob.java, v 0.1 2017/5/11 17:05 luohui Exp $$
 */
@Slf4j
@Service
public class MySimpleElasticJob implements SimpleJob {

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
