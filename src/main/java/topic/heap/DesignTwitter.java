package topic.heap;

import java.util.*;

public class DesignTwitter {
	static class B {
		static class Twitter {
			Map<Integer, Set<Integer>> followList;
			Map<Integer, List<int[]>> tweets;
			int time = 0;
			
			public Twitter() {
				followList = new HashMap<>();
				tweets = new HashMap<>();
			}
			
			public void postTweet(int userId, int tweetId) {
				tweets.putIfAbsent(userId, new ArrayList<>());
				tweets.get(userId).add(new int[]{tweetId, time++});
			}
			
			public List<Integer> getNewsFeed(int userId) {
				List<Integer> res = new ArrayList<>();
				PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						return o2[1] - o1[1];
					}
				});
				Set<Integer> ids = new HashSet<>();
				ids.addAll(followList.getOrDefault(userId, new HashSet<>()));
				ids.add(userId);
				for (Integer user : ids) {
					List<int[]> list = tweets.get(user);
					if (list != null) {
						for (int i = list.size() - 1; i >= 0; i--) {
							queue.offer(list.get(i));
						}
					}
				}
				for (int i = 0; i < 10 && !queue.isEmpty(); i++) {
					res.add(queue.poll()[0]);
				}
				return res;
			}
			
			public void follow(int followerId, int followeeId) {
				followList.putIfAbsent(followerId, new HashSet<>());
				followList.get(followerId).add(followeeId);
			}
			
			public void unfollow(int followerId, int followeeId) {
				if (!followList.containsKey(followerId)) {
					return;
				}
				followList.get(followerId).remove(followeeId);
			}
			
		}
	}
	
	class A {
		class Twitter {
			Map<Integer, Set<Integer>> followList;
			LinkedList<int[]> tweets;
			
			public Twitter() {
				followList = new HashMap<>();
				tweets = new LinkedList<>();
			}
			
			public void postTweet(int userId, int tweetId) {
				tweets.addFirst(new int[]{userId, tweetId});
			}
			
			public List<Integer> getNewsFeed(int userId) {
				followList.putIfAbsent(userId, new HashSet<>());
				Set<Integer> followees = followList.get(userId);
				List<Integer> res = new ArrayList<>();
				for (int[] tweet : tweets) {
					if (tweet[0] == userId || followees.contains(tweet[0])) {
						res.add(tweet[1]);
					}
					if (res.size() == 10) break;
				}
				return res;
			}
			
			public void follow(int followerId, int followeeId) {
				followList.putIfAbsent(followerId, new HashSet<>());
				followList.get(followerId).add(followeeId);
			}
			
			public void unfollow(int followerId, int followeeId) {
				Set<Integer> sets = followList.get(followerId);
				if (sets != null) {
					sets.remove(followeeId);
				}
			}
		}
	}
	
	
}
