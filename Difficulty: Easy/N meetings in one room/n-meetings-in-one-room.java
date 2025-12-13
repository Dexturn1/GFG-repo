class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        
        int n = start.length;
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }

        // Sort by end time
        meetings.sort(Comparator.comparingInt(m -> m.end));

        int count = 1;
        int lastEnd = meetings.get(0).end;

        for (int i = 1; i < n; i++) {
            if (meetings.get(i).start > lastEnd) {
                count++;
                lastEnd = meetings.get(i).end;
            }
        }

        return count;
       
    }
        
}

class Meeting {
    int start;
    int end;
    int index;

    Meeting(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}


