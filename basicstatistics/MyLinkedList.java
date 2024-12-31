package hus.oop.basicstatistics;

import java.util.NoSuchElementException;

public class MyLinkedList extends MyAbstractList {
    private Node head;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        head = null;
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        /* TODO */
        int cnt = 0;
        Node temp = head;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Number get(int index) {
        /* TODO */
        return getNodeByIndex(index).payload;
    }

    /**
     * Xóa phần tử của list ở vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            head = head.next;
            return;
        }else{
            Node prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
        }
    }

    /**
     * Thêm vào cuối list phần tử có dữ liệu payload.
     * @param payload
     */
    @Override
    public void append(Number payload) {
        /* TODO */
        Node newNode = new Node(payload);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = getNodeByIndex(size() - 1);
        temp.next = newNode;
    }

    /**
     * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Number payload, int index) {
        /* TODO */
        Node newNode = new Node(payload);
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            newNode.next = head;
            head = newNode;
        }
        Node temp = getNodeByIndex(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyLinkedListIterator(0);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        /* TODO */
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    private class MyLinkedListIterator implements MyIterator {
        /*
         * Vị trí hiện tại của iterator trong list.
         */
        private int currentPosition;

        /**
         * Khởi tạo cho iterator ở vị trí position trong MyLinkedList.
         * @param position
         */
        public MyLinkedListIterator(int position) {
            /* TODO */
            currentPosition = position;
        }

        /**
         * Kiểm tra trong MyLinkedList có còn phần tử không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition < size();
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyLinkedList và trả ra dữ liệu (payload) của phần tử hiện tại của MyLinkedList.
         * @return payload của phần tử hiện tại.
         */
        @Override
        public Number next() {
            /* TODO */
            if(!hasNext()){
                throw new NoSuchElementException();
            }else{
                Number number = getNodeByIndex(currentPosition).payload;
                currentPosition++;
                return number;
            }

        }

        @Override
        public void remove() {
            /* TODO */
            Node curr = getNodeByIndex(currentPosition - 1);
            curr.setNext(curr.getNext().getNext());
        }
    }
}
