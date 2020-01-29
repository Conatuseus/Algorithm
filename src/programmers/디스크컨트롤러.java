package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {

    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        List<Job> jobList = new ArrayList<>();
        for (int[] job : jobs) {
            int requestTime = job[0];
            int runningTime = job[1];
            pq.add(new Job(requestTime, runningTime));
        }

        for (int i=0; i<jobs.length; i++) {
            jobList.add(pq.poll());
        }

        int now = 0;
        int result = 0;

        while (jobList.size() != 0) {

            for (int i=0; i<jobList.size(); i++) {
                Job job = jobList.get(i);
                int requestTime = job.requestTime;
                int runningTime = job.runningTime;

                if(now >= requestTime) {
                    result += now - requestTime + runningTime;
                    now += runningTime;
                    jobList.remove(i);
                    break;
                }
                if(i == jobList.size() - 1) {
                    now ++;
                }
            }
        }
        return result / jobs.length;
    }
}

class Job implements Comparable<Job> {

    int requestTime;
    int runningTime;

    public Job(final int requestTime, final int runningTime) {
        this.requestTime = requestTime;
        this.runningTime = runningTime;
    }

    @Override
    public int compareTo(Job another) {
        if(runningTime != another.runningTime) {
            return runningTime - another.runningTime;
        }
        return requestTime - another.requestTime;
    }
}