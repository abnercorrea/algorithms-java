package interviews.facebook;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaxCostJobSet {

	public static void main(String[] args) throws ParseException {
		DateFormat df = DateFormat.getInstance();

		List<Job> maxJobs = new ArrayList<>();
		
		Job[] jobs = new Job[9];
		jobs[0] = new Job(1, df.parse("04/27/15 1:00 PM"), df.parse("04/27/15 1:05 PM"));
		jobs[1] = new Job(2, df.parse("04/27/15 1:10 PM"), df.parse("04/27/15 1:15 PM"));
		jobs[2] = new Job(4, df.parse("04/27/15 1:20 PM"), df.parse("04/27/15 1:35 PM"));
		jobs[3] = new Job(50, df.parse("04/27/15 1:30 PM"), df.parse("04/27/15 1:35 PM"));
		jobs[4] = new Job(100, df.parse("04/26/15 12:00 AM"), df.parse("04/26/15 11:59 PM"));
		jobs[5] = new Job(15, df.parse("04/27/15 1:40 PM"), df.parse("04/27/15 1:45 PM"));
		jobs[6] = new Job(3, df.parse("04/27/15 1:50 PM"), df.parse("04/27/15 1:55 PM"));
		jobs[7] = new Job(20, df.parse("04/27/15 2:00 PM"), df.parse("04/27/15 2:25 PM"));
		jobs[8] = new Job(6, df.parse("04/27/15 2:10 PM"), df.parse("04/27/15 2:15 PM"));
				
		int maxCost = findMaxCostJobSet(jobs, 0, new ArrayList<Job>(), 0, -1, maxJobs);
		
		System.out.println("max cost: " + maxCost);
		System.out.println("Jobs: " + maxJobs);
	}

	public static int findMaxCostJobSet(Job[] jobs, int currentJob, ArrayList<Job> jobSet, int cost, int maxCost, List<Job> maxJobs) {
		for (int i = currentJob; i < jobs.length; i++) {
			boolean jobOverlaps = false; 
			
			for (int j = 0; !jobOverlaps && j < jobSet.size(); j++)
				jobOverlaps = (jobs[i].start.compareTo(jobSet.get(j).end) <= 0) && (jobs[i].end.compareTo(jobSet.get(j).start) >= 0);
			
			if (!jobOverlaps) {
				jobSet.add(jobs[i]);
				
				maxCost = findMaxCostJobSet(jobs, i + 1, jobSet, cost + jobs[i].cost, maxCost, maxJobs);
				
				jobSet.remove(jobSet.size() - 1);
			}
		}
		
		if (cost > maxCost) {
			maxCost = cost;
			
			maxJobs.clear();
			maxJobs.addAll(jobSet); // Adds current jobSet to max list
		}
		
		return maxCost;
	}
	
	static class Job {
		int cost;
		Date start, end;
		
		public Job(int cost, Date start, Date end) {
			this.cost = cost;
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return "Job (cost = " + cost + ", start = " + start + ", end = " + end + ")";
		}
	}
	
}
