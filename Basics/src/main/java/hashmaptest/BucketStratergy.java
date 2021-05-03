package hashmaptest;

public interface BucketStratergy {

	void init(int bucketSize);

	int getBucket(Object o);

}
