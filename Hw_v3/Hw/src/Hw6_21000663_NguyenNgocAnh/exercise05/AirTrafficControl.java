package Hw6_21000663_NguyenNgocAnh.exercise05;

import Hw6_21000663_NguyenNgocAnh.exercise01.SortedLinkPriorityQueue;

public class AirTrafficControl {
    private SortedLinkPriorityQueue<Double, String> airTrafficPQ = new SortedLinkPriorityQueue<>();

    public void addEvent(Event e) {
        airTrafficPQ.insert(e.getTime(), e.getEvent());
    }

    public void processEvent() {
            airTrafficPQ.removeMin();
    }

    public Event getEvent() {
        return new Event((Double) airTrafficPQ.min().getKey(), (String) airTrafficPQ.min().getValue());
    }

    public boolean isEmpty() {
        return airTrafficPQ.isEmpty();
    }

    public void printMin() {
        if (!airTrafficPQ.isEmpty()) {
            System.out.println(airTrafficPQ.min().toString());
        }
    }
}
