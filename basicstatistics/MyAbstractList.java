package hus.oop.basicstatistics;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1 a2 a3 ... an]
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        MyIterator it = iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if(it.hasNext()){
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
