//Implement the function power(b, e), which calculates b raised to the power of e (i.e. b^e).
class Solution {
    double power(double b, int e) {
        if(e < 0)
        {
            return 1 / power(b , -e);
        }
        if(e == 0) return 1;
        if(e == 1) return b;
        
        double halfpower = power(b , e/2);
        
        if(e % 2 == 0)
        {
            return halfpower * halfpower;
        }
        return b*halfpower*halfpower;
    }
}
