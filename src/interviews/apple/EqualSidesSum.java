// time: O(n), space: O(1)
int equalSidesSum(int[] a) {
    if (a == null || a.length < 3) return -1;

    int leftSum = a[0], rightSum = 0;

    for (int i = 2; i < a.length; i++) rightSum += a[i];

    for (int i = 1; i < a.length - 1; i++) {
        if (leftSum == rightSum) return i;

        leftSum += a[i];
        rightSum -= a[i + 1];
    }

    return -1;
}

// CAUTION!!
check for case where i = 0 or i = a.length - 1 with the sum on bothsides being 0.

//debug

2,3,4,4,1
leftSum: 2, 5
rightSum: 9, 5
i: 1, 2
return 2

2,3,4,3,1
leftSum: 2, 5,9,12
rightSum: 8, 4,1,0
i: 1, 2,3
return -1

-1,11,5,2,8
leftSum: -1,10
rightSum: 15,10
i: 1,2
return 2