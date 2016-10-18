package com.gus.comms.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * 
 * @author guxc CuratorFramework 测试类
 *
 */
public class ZookeeperUtils {

	public static void main(String[] args) throws Exception {

		CuratorFramework cli = CuratorFrameworkFactory.builder()
				.connectString("192.168.129.152:2181,192.168.129.153:2181,192.168.129.154:2181").sessionTimeoutMs(5000)
				.retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

		cli.start();

		String path = "/gus/foo";

		// 节点存在
		if (cli.checkExists().forPath(path) != null) {
			// 写数据，覆盖
			cli.setData().forPath(path, "update".getBytes());
		} else {
			// 创建节点
			cli.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path, "create".getBytes());
		}

		// 读数据
		String s = new String(cli.getData().storingStatIn(new Stat()).forPath(path));

		System.out.println(s);

		// 删除节点,CreateMode.EPHEMERAL临时节点不需要删除,CreateMode.PERSISTENT永久节点
		cli.delete().guaranteed().forPath(path);

		cli.close();

	}
}
