package Hw6_21000663_NguyenNgocAnh.exercise05;

public class Event implements Comparable<Event> {
        String event;
        double time;

        public Event(Double time, String event) {
            this.event = event;
            this.time = time;
        }

        @Override
        public int compareTo(Event o) {
            return this.time - o.time == 0 ? 0 : this.time - o.time > 0 ? 1 : -1;
        }

        @Override
        public String toString() {
            return event + " " + (int) time + ":" + ((int) ((time - (int) time) * 60) > 9 ? (int) ((time - (int) time) * 60) : "0" + (int) ((time - (int) time) * 60));
        }

        public String getEvent() {
            return event;
        }

        public Double getTime() {
            return time;
        }
    }
