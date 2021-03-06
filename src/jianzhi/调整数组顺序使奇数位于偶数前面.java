/*
 * @Author: lsd
 * @Date: 2020-02-21 19:17:20
 * @Software: vscode
 * @Description: 
 *  双指针，[0,i]为奇数，[i + 1,array.length  - 1]为偶数
 *  i从0位置开始，如果碰到偶数，停下来
 *  j从i + 1位置开始，如果碰到奇数停下来，arr[i]到array[j-1]位置元素后移，arr[j]位置元素移到arr[i]上
 */
package cn.andios.jianzhi;

public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        reOrderArray(new int []{1,2,3,4,5,6,7});
    }
    public static void reOrderArray(int [] array) {
        if(array == null || array.length == 0){
            return;
        }
        int i = 0,j,tmp;
        while(i < array.length -1){
            j = i + 1;
            if(array[i] % 2 == 0){
                while(array[j] % 2 == 0){
                    j ++;
                    if(j >= array.length){
                        return;
                    }
                }
                tmp = array[j];
                for(int k = j;k > i ;k --){
                    array[k] = array[k - 1];
                }
                array[i] = tmp;
                
            }
            i ++;
        }
       
     }
}