package hus.oop.basicstatistics;

public class BasicStatistic {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public BasicStatistic(MyList data) {
        /* TODO */
        this.data = data;
    }
    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        /* TODO */
        double max =  Double.MIN_VALUE;
        MyIterator it = data.iterator();
        while (it.hasNext()) {
            max = Math.max((double)it.next(), max);
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        /* TODO */
        double min = Double.MAX_VALUE;
        MyIterator it = data.iterator();
        while (it.hasNext()) {
            min = Math.min((double)it.next(), min);
        }
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu lưu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        /* TODO */
        double sum = 0.0;
        MyIterator it = data.iterator();
        while (it.hasNext()) {
            sum += (double)it.next();
        }
        return sum / data.size();
    }

    /**
     * Tính phương sai của mẫu lưu trong list.
     * @return phương sai.
     */
    public double variance() {
        /* TODO */
        double sum = 0.0;
        double mean = mean();
        MyIterator it = data.iterator();
        while (it.hasNext()) {
            sum += Math.pow((double)it.next() - mean, 2);
        }
        sum = sum / data.size();
        return sum;
    }
}
