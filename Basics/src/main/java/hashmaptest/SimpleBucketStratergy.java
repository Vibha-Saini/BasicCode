package hashmaptest;

public class SimpleBucketStratergy implements BucketStratergy {
	int bucketSize = -1;

	@Override
	public void init(int bucketSize) {
		this.bucketSize = bucketSize;
	}

	@Override
	public int getBucket(Object o) {
		int hashCode = o.hashCode();
		int bucketIndex = hashCode % bucketSize;
		return bucketIndex;

	}

}
