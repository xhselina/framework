package org.china.framework.spring.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.china.framework.spring.curator.common.CuratorCommon;

/**
 * Created by jeffrey on 15-12-22.
 */
public class CrudMain {
    public static void main(String[] args) throws Exception {
        // 创建会话 1
        // 创建默认的重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
//        CuratorFramework client = CuratorFrameworkFactory.newClient(CuratorCommon.CONNECTION_STRING,5000,3000,retryPolicy);
//        client.start();

        // 使用fluent风格 创建会话
        CuratorFramework flumentClient = CuratorFrameworkFactory.builder()
                .connectString(CuratorCommon.CONNECTION_STRING) //zk path
                .sessionTimeoutMs(5000) // 会话超时时间 毫秒
                .connectionTimeoutMs(3000) // 连接超时时间 毫秒
//                .namespace(CuratorCommon.NAMESPACE) // 命名空间
                .retryPolicy(retryPolicy)
                .build();
        flumentClient.start();
        String path = "/zk_crud1";
        // 创建节点  1 创建普通持久节点  2 创建临时节点 3 递归创建子节点(同时创建父节点)
//        flumentClient.create().creatingParentContainersIfNeeded().forPath(path,"普通持久节点".getBytes());
        flumentClient.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/temp" ,"临时节点".getBytes());
        flumentClient.create().creatingParentsIfNeeded().forPath(path + "/parent/son1","根节点,父亲节点,儿子节点".getBytes());

        // 读取操作
        Stat stat = new Stat(); // 版本信息
        byte[] bytes = flumentClient.getData().storingStatIn(stat).forPath(path);
        System.out.println(new String(bytes) + "," + stat.getVersion());
        Thread.sleep(Integer.MAX_VALUE);


    }
}
