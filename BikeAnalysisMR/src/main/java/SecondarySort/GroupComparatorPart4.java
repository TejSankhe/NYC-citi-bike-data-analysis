package SecondarySort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupComparatorPart4 extends WritableComparator {
    public GroupComparatorPart4() {
        super(CompositeKeyWritablePart4.class,true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        CompositeKeyWritablePart4 c = (CompositeKeyWritablePart4)a;
        CompositeKeyWritablePart4 d = (CompositeKeyWritablePart4)b;
        return c.getstationName().compareTo(d.getstationName());
    }
}
