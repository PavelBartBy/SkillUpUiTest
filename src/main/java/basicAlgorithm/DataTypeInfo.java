package basicAlgorithm;

public class DataTypeInfo { //method for studying memory for Data Type in Java. Assignment on first lecture

    public static int sizeOf(Class dataType) {

        if (dataType==null) throw new NullPointerException();
        if (dataType==int.class || dataType==Integer.class) return 4;
        if (dataType==byte.class || dataType==Byte.class) return 1;
        if (dataType==long.class || dataType==Long.class) return 8;
        if (dataType==float.class || dataType==Float.class) return 4;
        if (dataType==double.class || dataType==Double.class) return 8;
        if (dataType==boolean.class || dataType==Boolean.class) return 4; //wo BitSet
        if (dataType==char.class || dataType==Character.class) return 2;
        if (dataType==String.class) return 5; //+ 2 on ev simbol
        return 8;
    }
}
