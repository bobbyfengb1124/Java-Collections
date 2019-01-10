package leetcode.challenge;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		int cost[] = new int [] {10,15,20};
		System.out.println(minCostClimbingStairs(cost));
		cost = new int [] {1,100,1};
		System.out.println(minCostClimbingStairs(cost));
		cost = new int [] {1,100,1,1,1,100,1,1,100,1};
		System.out.println(minCostClimbingStairs(cost));

	}

	public static int minCostClimbingStairs(int[] cost) {
		int[] costCache = new int[cost.length+1];
		
		if(cost.length==0) {
			return costCache[0];
		}
		
		if(cost.length==1) {
			costCache[1] = Math.min(costCache[1], cost[0]);
			return costCache[1];
		}
		int i;
		for(i=1;i<cost.length;i++) {
			int startFromCurrent = cost[i] + costCache[i];
			int startFromPrevious = cost[i-1]+ costCache[i-1];
			costCache[i+1] = Math.min(startFromCurrent, startFromPrevious);
		}
		
		return costCache[i];
		
	}

}
