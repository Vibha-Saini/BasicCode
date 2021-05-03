package hashmaptest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMap<K, V> implements Map<K, V> {
	private final int SIZE_OF_BUCKET = 10;
 
	List<Bucket> bucketList = new ArrayList<>();

	BucketStratergy bucketStretergy;

	public HashMap(BucketStratergy bucketStretergy) {
		this.bucketStretergy = bucketStretergy;
	}

	public HashMap() {
		this.bucketStretergy = new SimpleBucketStratergy();
		for (int i = 0; i < SIZE_OF_BUCKET; i++) {
			bucketList.add(i, new Bucket());
		}
	}

	private void init() {
		this.bucketStretergy.init(SIZE_OF_BUCKET);
	}

	class Bucket {
		List<Entry> entries = new LinkedList<Entry>();

		public Entry get(K key) {
			for (Entry entry : entries) {
				if (entry.key.equals(key)) {
					return entry;
				}
			}
			return null;
		}

		public void add(Entry e) {
			Entry existingEntry = get(e.key);
			if (existingEntry != null) {
				entries.remove(e);
			}
			entries.add(e);
		}
	}

	class Entry {

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		K key;
		V value;
	}

	@Override
	public void put(K key, V value) {
		Entry entry = new Entry(key, value);
		int bucketIndex = this.bucketStretergy.getBucket(key);
		if (bucketIndex < 0 || bucketIndex > SIZE_OF_BUCKET) {
			throw new Error("Invalid bucket index!!!!");
		}
		Bucket matchingBucket = bucketList.get(bucketIndex);
		matchingBucket.add(entry);

	}

	@Override
	public V get(K key) {
		int bucketIndex = this.bucketStretergy.getBucket(key);
		if (bucketIndex < 0 || bucketIndex > SIZE_OF_BUCKET) {
			throw new Error("Invalid bucket index!!!!");
		}
		Bucket matchingBucket = bucketList.get(bucketIndex);
		return matchingBucket.get(key).value;
	}

}
