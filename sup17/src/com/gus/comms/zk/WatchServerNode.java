package com.gus.comms.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import com.gus.comms.base.Constant;


public class WatchServerNode {

	static String path = "/registry/service";

	static CuratorFramework cli = CuratorFrameworkFactory.builder()
			.connectString("172.18.111.3:2181,172.18.111.4:2181,172.18.111.5:2181")
			.sessionTimeoutMs(Constant.ZK_SESSION_TIMEOUT)
			.retryPolicy(new ExponentialBackoffRetry(Constant.ZK_RETY_INTERVAL, Constant.ZK_RETY_TIMES)).build();

	private static PathChildrenCache cache;

	public static void findService() throws Exception {

		cli.start();

		cache = new PathChildrenCache(cli, path, true);

		cache.start(StartMode.POST_INITIALIZED_EVENT);

		cache.getListenable().addListener(new PathChildrenCacheListener() {

			@Override
			public void childEvent(CuratorFramework cli, PathChildrenCacheEvent event) throws Exception {
				// TODO Auto-generated method stub

				switch (event.getType()) {
				case CHILD_ADDED:
					System.out.println("CHILD_ADDED," + event.getData().getPath());
					break;
				case CHILD_UPDATED:
					System.out.println("CHILD_UPDATED," + event.getData().getPath());
					break;
				case CHILD_REMOVED:
					System.out.println("CHILD_REMOVED," + event.getData().getPath());
					break;
				default:
					break;
				}
			}
		});

		Thread.sleep(Integer.MAX_VALUE);
	}
}
