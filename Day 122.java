/*There are some gas stations along a circular route. You are given two integer arrays gas[] denoted as the amount of gas present at each station and cost[] denoted as the cost of travelling to the next station. You have a car with an unlimited gas tank. You begin the journey with an empty tank from one of the gas stations. Return the index of the starting gas station if it's possible to travel around the circuit without running out of gas at any station in a clockwise direction. If there is no such starting station exists, return -1.
Note: If a solution exists, it is guaranteed to be unique.*/
class Solution {
    public int startStation(int[] gas, int[] cost) {
        int totalGas = 0 , totalCost = 0 , start = 0 , tank = 0;
        
        for(int i = 0 ; i < gas.length ; i++){
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            
            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }
        return (totalGas >= totalCost) ? start : -1;
    }
}
