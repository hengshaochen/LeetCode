// Bad Init size but AC
public class MovingAverage {

    double[] sum;
    int count; // 當前加入的數量（累積）
    int s;  // window size
    public MovingAverage(int size) {
        sum = new double[1000000];
        count = 0;
        s  = size;
    }

    public double next(int val) {
        count++;
        sum[count] = sum[count - 1] + val;
        
        double avg = 0;
        if (count >= s) {
            avg = (sum[count] - sum[count - s]) / s;
        } else {
            avg = sum[count] / count;
        }
        return avg;
    }
}

// 滾動
public class MovingAverage {

    double[] sum;
    int count; // 當前加入的數量（累積）
    int s;  // window size
    public MovingAverage(int size) {
        sum = new double[size + 1];
        count = 0;
        s  = size;
    }
    
    int mod(int x) {
        return x % (s + 1);
    }

    public double next(int val) {
        count++;
        sum[mod(count)] = sum[mod(count - 1)] + val;
        
        double avg = 0;
        if (count >= s) {
            avg = (sum[mod(count)] - sum[mod(count - s)]) / s;
        } else {
            avg = sum[mod(count)] / count;
        }
        return avg;
    }
}