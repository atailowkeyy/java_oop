package hus.oop.basicstatistics;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 8;
    private Number[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        /* TODO */
        data = new Number[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        /* TODO */
        return size;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Number get(int index) {
        /* TODO */
        return data[index];
    }

    /**
     * Xóa phần tử ở vị trí index trong list.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    /**
     * Thêm phần tử có dữ liệu payload vào cuối list.
     * Nếu danh sách hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
     * @param payload
     */
    @Override
    public void append(Number payload) {
        /* TODO */
        if(size == data.length){
            enlarge();
        }
        data[size] = payload;
        size++;
    }

    /**
     * Thêm phần tử có dữ liệu payload vào list ở vị trí index.
     * Nếu list hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Number payload, int index) {
        /* TODO */
        if(size == data.length){
            enlarge();
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = payload;
        size++;
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyArrayListIterator(0);
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
        Number[] newData = new Number[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    private class MyArrayListIterator implements MyIterator {
        /**
         * Vị trí hiện tại của iterator trong MyArrayList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho iterator tại vị trí position của list.
         */
        public MyArrayListIterator(int position) {
            /* TODO */
            currentPosition = position;
        }

        /**
         * Kiểm tra trong MyArrayList có còn phần tử không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition < size;
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyArrayList và trả ra dữ liệu của phần tử hiện tại của MyArrayList.
         * @return dữ liệu phần tử hiện tại.
         */
        @Override
        public Number next() {
            /* TODO */
            Number number = data[currentPosition];
            currentPosition++;
            return number;
        }

        /**
         * Iterator xóa phần tử hiện tại của MyArrayList.
         */
        @Override
        public void remove() {
            /* TODO */
            for(int i = currentPosition; i < size; i++){
                data[i] = data[i + 1];
            }
            size--;
        }
    }
}
