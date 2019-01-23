package leetcode.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MajorityElementII {
	static HashMap<Integer, Integer> elementsAndTimes = new HashMap<>();

	public static void main(String[] args) {

//		int[] test1 = new int[] { 3, 2, 3 };
//		System.out.println(majorityElement(test1));

		int[] test2 = new int[] { 1, 1, 1, 3, 3, 2, 2, 2 };
		System.out.println(majorityElement(test2));

//		int[] test3 = new int[] { 1 };
//		System.out.println(majorityElement(test3));
//		
//		int[] test4 = new int[] { 2,2 };
//		System.out.println(majorityElement(test4));
	}

	public static List<Integer> majorityElement1(int[] nums) {
		HashSet<Integer> retList = new HashSet<>();
		elementsAndTimes.clear();

		for (int i = 0; i < nums.length; i++) {
			Integer temp = 0;
			if (elementsAndTimes.containsKey(nums[i])) {
				temp = elementsAndTimes.get(nums[i]);
				temp++;
				elementsAndTimes.put(nums[i], temp);

			} else {
				elementsAndTimes.put(nums[i], 1);
				temp = 1;
			}
			if (temp > nums.length / 3) {
				retList.add(nums[i]);
			}
		}
		List<Integer> retList1 = new ArrayList <Integer> (retList);
		return retList1;

	}
	
	public static List<Integer> majorityElement(int[] nums) {
        List<Integer> resultList=new ArrayList<>();
        if (nums==null||nums.length==0){
            return resultList;
        }

        //初始化，定义两个候选人以及对应的票数
        int candidateA=nums[0];
        int candidateB=nums[0];
        int countA=0;
        int countB=0;

        // 遍历数组
        for (int num:nums){
            if (num==candidateA){ //投A
                countA++;
                continue;
            }

            if (num==candidateB){// 投B
                countB++;
                continue;
            }
            //此时A,B都不投,检查是否有票数为0情况，如果为0，则更新候选人
            if (countA==0){
                candidateA=num;
                countA++;
                continue;
            }

            if (countB==0){
                candidateB=num;
                countB++;
                continue;
            }

            //此时两个候选人的票数都大于1，且当前选名不投AB，那么A,B对应的票数都要--;
            countA--;
            countB--;
        }

        // 上一轮遍历找出了两个候选人，但是这两个候选人是否均满足票数大于N/3仍然没法确定，需要重新遍历，确定票数
        countA=0;
        countB=0;

        for (int num:nums){
            if (num==candidateA){
                countA++;
            }else if (num==candidateB){
                countB++;
            }
        }



        if (countA>nums.length/3){
            resultList.add(candidateA);
        }

        if (countB>nums.length/3){
            resultList.add(candidateB);
        }

        return resultList;
    }

}
