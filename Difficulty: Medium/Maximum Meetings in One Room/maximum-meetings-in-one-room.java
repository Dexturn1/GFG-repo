class Meeting {
    int start, end, position;
    Meeting(int start, int end, int position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }
}

class Solution {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        int n = s.length;
        Meeting[] meetings = new Meeting[n];
        
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(s[i], f[i], i + 1);
        }
        
        // Sort by end time ascending, break ties with smaller position
        Arrays.sort(meetings, (a, b) -> {
            if (a.end != b.end) {
                return Integer.compare(a.end, b.end);
            }
            return Integer.compare(a.position, b.position);
        });
        
        ArrayList<Integer> order = new ArrayList<>();
        int freeTime = meetings[0].end;
        order.add(meetings[0].position);
        
        for (int i = 1; i < n; i++) {
            if (meetings[i].start > freeTime) {
                freeTime = meetings[i].end;
                order.add(meetings[i].position);
            }
        }
        
        // Sort selected meeting indices in increasing order
        Collections.sort(order);
        
        return order;
    }
}