package com.keepstudy;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: moshengkang
 * @e-mial: 1634414600@qq.com
 * @Version: 1.0
 * @Description: 测试连接zookeeper
 */
public class ZkTest {
    private ZooKeeper zooKeeper;

    {
        String connect = "192.168.1.5:2181";
        int timeOut = 3000;
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
            }
        };
        try {
            zooKeeper = new ZooKeeper(connect, timeOut, watcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws KeeperException, InterruptedException {
        String path = "/animal/cat";
        getDataNotice(new ZkTest().zooKeeper,path);
        while (true) {
            TimeUnit.SECONDS.sleep(5);
            System.err.println("当前方法要执行的原有逻辑");
        }

    }

    public static void getDataNotice(final ZooKeeper zooKeeper, final String path) throws KeeperException, InterruptedException {
        byte[] data = zooKeeper.getData(path, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //递归调用
                try {
                    getDataNotice(zooKeeper, path);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Stat());

        String result = new String(data);
        System.err.println("当前节点值="+result);
    }

    /**
     * 异步通知（通知一次）
     * @throws KeeperException
     * @throws InterruptedException
     */
    private static void testNoticeOnce() throws KeeperException, InterruptedException {
        String path = "/animal/cat";
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("接受到了通知，值发生了修改");
            }
        };
        byte[] data = new ZkTest().zooKeeper.getData(path, watcher, new Stat());

        String result = new String(data);
        System.out.println("old value="+result);

        while (true) {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("当前方法要执行的原有逻辑");
        }
    }

    /**
     * 测试连接zookeeper
     * @throws KeeperException
     * @throws InterruptedException
     */
    private static void testConnectZooKeeper() throws KeeperException, InterruptedException {
        String path = "/animal/cat";

        ZkTest zkTest = new ZkTest();
        byte[] data = zkTest.zooKeeper.getData(path, false, new Stat());
        String result = new String(data);
        System.out.println("old value="+result);

        byte[] newDataArray = new String("miaomiao").getBytes();
        int version = -1;
        Stat stat = zkTest.zooKeeper.setData(path, newDataArray, version);
        int newVersion = stat.getVersion();
        System.out.println("new version="+newVersion);

        data = zkTest.zooKeeper.getData(path, false, new Stat());
        result = new String(data);
        System.out.println("new value="+result);
    }
}
