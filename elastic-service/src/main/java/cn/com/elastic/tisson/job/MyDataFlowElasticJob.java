/**
 * tisson.com.cn Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package cn.com.elastic.tisson.job;

import java.util.ArrayList;
import java.util.List;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Dataflow类型作业
 * Dataflow类型用于处理数据流，需实现DataflowJob接口。该接口提供2个方法可供覆盖，分别用于抓取(fetchData)和处理(processData)数据。
 * @author luohui
 * @version Id: MyDataFlowElasticJob.java, v 0.1 2017/5/12 14:25 luohui Exp $$
 */
@Slf4j
@Service
public class MyDataFlowElasticJob implements DataflowJob<Object> {

    @Override
    public List<Object> fetchData(ShardingContext shardingContext) {
        List<Object> data ;
        switch (shardingContext.getShardingItem()) {
            case 0:
                data = new ArrayList<Object>();// get data from database by sharding item 0
                data.add("a");
                log.info("执行的是0片的数据任务");
                return data;
            case 1:
                data = new ArrayList<Object>(); // get data from database by sharding item 1
                log.info("执行的是1片的数据任务");
                data.add("b");
                return data;
        }
        return new ArrayList<Object>();
    }

    @Override
    public void processData(ShardingContext shardingContext, List<Object> data) {

        log.info("执行的数据是：{}",data.get(0));

    }
}
