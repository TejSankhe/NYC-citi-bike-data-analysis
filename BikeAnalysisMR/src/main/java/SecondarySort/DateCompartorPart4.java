package SecondarySort;

import org.apache.hadoop.io.WritableComparator;

public class DateCompartorPart4 extends WritableComparator {

    public DateCompartorPart4() {
        super(CompositeKeyWritablePart4.class,true);
    }

    @Override
    public int compare(Object a, Object b) {
        CompositeKeyWritablePart4 o1= (CompositeKeyWritablePart4) a;
        CompositeKeyWritablePart4 o2= (CompositeKeyWritablePart4) b;
        int result= o1.getstationName().compareTo(o2.getstationName());
        if(result==0){
            result = (-1 * o1.gettripduration()-o2.gettripduration());
        }
        return result;
    }
}
