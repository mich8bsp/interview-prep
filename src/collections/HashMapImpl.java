package collections;

/**
 *  Search/insert/delete in O(1) average
 *  (worst O(n) if hashing puts everything in the same bucket
 *
 *  Calculating bucket index for key: index = hashCode (key) & (n-1)
 *  where n is the number of buckets
 *
 *  capacity = number of buckets * load factor
 *
 *  When capacity limit is reached, the hashes are recalculated with an increased
 *  number of buckets (n is increased so index is recalculated for each hash)
 *
 * Created by Michael Bespalov on 16-Mar-18.
 */
public class HashMapImpl {
}