import java.util.PriorityQueue;

/**
 * MedianOfAStream
 */

public class MedianOfAStream {
    // max heap
    PriorityQueue<Integer> smallNumList;
    // min heap 
    PriorityQueue<Integer> largeNumList;

    public MedianOfAStream(){
        smallNumList = new PriorityQueue<>((a, b) -> (b - a));
        largeNumList = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void insertNum(int num) {
        if(smallNumList.isEmpty() || smallNumList.peek() >= num) {
            smallNumList.add(num);
        }
        else {
            largeNumList.add(num);
        }

        if(smallNumList.size() - largeNumList.size() > 1) {
            largeNumList.add(smallNumList.poll());
        }
        else if(smallNumList.size() < largeNumList.size()) {
            smallNumList.add(largeNumList.poll());
        }
    }

    public double findMedian() {
        if(largeNumList.size() == smallNumList.size()) {
            return (largeNumList.peek() + smallNumList.peek()) / 2.0;
        }

        return smallNumList.peek();
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("Median = " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("Median = " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("Median = " + medianOfAStream.findMedian());
    }
}