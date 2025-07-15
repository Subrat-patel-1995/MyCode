package org.sb;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestController {

    public static void main3(String[] args) {
        List<Integer> list=List.of(1,2,3,3,4,5,6,7,7,8,8,9);

        list
                .stream()
                .collect(Collectors.groupingBy(x->x, Collectors.counting()))
                .entrySet().stream()
                .filter(entry->entry.getValue()>1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        List<Integer> result=new ArrayList<>();


        //select * from emmployee where city <> IN (Mumbai,Kolakata)


    }
    final static List<Integer> list=new ArrayList<>();

    public static void main4(String[] args) {
        int[] nums=new int[]{1,2,-3,4,5};
        int maxSum=Integer.MIN_VALUE;
        int curSum=nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum=Math.max(curSum+nums[i],nums[i]);
            maxSum=Math.max(curSum,maxSum);

        }
        System.out.println(maxSum);


    }

    public static void main5(String[] args) {
        String[] s = "anI need a call".split(" ");


        Arrays.sort(s,(a,b)->a.length()-b.length());
        String join = String.join(" ", s);

        System.out.println(Arrays.toString(s));
        System.out.println(join);
        //System.out.println(sortWordsByLengthStable("I need a call"));
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2},3));
    }
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = coinChange(coins, amount - coin);
            if (res >= 0) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }

        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
    public static String sortWordsByLengthStable(String sentence) {
        String[] s = sentence.split(" ");
        Arrays.sort(s,(a,b)->a.length()-b.length());
        List<String> list1 = Arrays.stream(s).sorted((a, b) -> b.length()-a.length()).toList();
        return String.join(" ",list1);



    }
    class Solution {
        public int longestSubarray(int[] nums, int k) {
            HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
            int maxLength=0;
            int prefixSum=0;
            for(int i=0;i<nums.length;i++){
                prefixSum+=nums[i];
                if(prefixSum==k){

                    maxLength=Math.max(maxLength,i+1);
                }
                if(prefixSumMap.containsKey(prefixSum-k)){
                    maxLength=Math.max(maxLength,i-prefixSumMap.get(prefixSum-k));
                }else{
                    prefixSumMap.put(prefixSum,i);        }
            }
            return maxLength;


        }
    }

    public  static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            if (count > 1) return false;
        }

        return true;
    }























    public static void main1(String[] args) {

        List<List<String>> abc = Arrays.asList(
                Arrays.asList("A","B"),
                Arrays.asList("C","D"),
                Arrays.asList("E","F")
        );
        List<String> result=abc.stream().flatMap(Collection::stream).toList();
        List<List<String>> result1=abc.stream().toList();
        System.out.println(result);
        System.out.println(result1);

        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee(1,"Sub","IT",200));
        employeeList.add(new Employee(2,"Sub1","Finance",300));
        employeeList.add(new Employee(3,"Sub2","HR",400));
        employeeList.add(new Employee(4,"Sub3","ADMIN",200));

        Map<String,List<Employee>> resultMap=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(resultMap);


        //select e.department,count(*) from employee e group by e.department;




    }
    public static void main2(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        try {
            AtomicInteger count = new AtomicInteger();

            fruits.forEach(fruit -> {
                if (fruit.startsWith("A")) {
                    count.getAndIncrement();
                }
            });
        } catch (Exception e) {
            System.out.println("Caught exception: " + e);
        }
    }
}


class Employee{

    Integer id;
    String name;
    String department;
    Integer salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee(Integer id, String name, String department, Integer salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
