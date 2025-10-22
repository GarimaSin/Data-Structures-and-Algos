package Problem_Solving.Hash;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadSafeCacheWithExpiry<K, V> {


	private final ConcurrentHashMap<K, CacheEntry<V>> cache = new ConcurrentHashMap<>();
	private final ScheduledExecutorService cleaner = Executors.newSingleThreadScheduledExecutor();
	private final long ttlMillis;

	private static class CacheEntry<V> {
		final V value;
		final long expiryTime;

		CacheEntry(V value, long expiryTime) {
			this.value = value;
			this.expiryTime = expiryTime;
		}

		boolean isExpired() {
			return System.currentTimeMillis() > expiryTime;
		}
	}

	public ThreadSafeCacheWithExpiry(long ttlMillis, long cleanupIntervalMillis) {
		this.ttlMillis = ttlMillis;

		// Schedule cleanup task
		cleaner.scheduleAtFixedRate(() -> {
			for (K key : cache.keySet()) {
				CacheEntry<V> entry = cache.get(key);
				if (entry != null && entry.isExpired()) {
					cache.remove(key);
				}
			}
		}, cleanupIntervalMillis, cleanupIntervalMillis, TimeUnit.MILLISECONDS);
	}

	public void put(K key, V value) {
		long expiryTime = System.currentTimeMillis() + ttlMillis;
		cache.put(key, new CacheEntry<>(value, expiryTime));
	}

	public V get(K key) {
		CacheEntry<V> entry = cache.get(key);
		if (entry == null || entry.isExpired()) {
			cache.remove(key);
			return null;
		}
		return entry.value;
	}

	public void remove(K key) {
		cache.remove(key);
	}

	public int size() {
		return cache.size();
	}

	public void shutdown() {
		cleaner.shutdown();
	}
}
