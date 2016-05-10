package interview;

import java.util.LinkedList;
import java.util.List;


public class testArray {

	public static void main(String[] args){
        String[] a = new String[]{"1","9","3","7"};
        String[] b = new String[]{"5","3"};
        String[] arrResult = arrContrast(a, b);   
        System.out.println(arrResult.toString());
        for (int i=0;i<arrResult.length;i++) {
            System.out.println("最后的结果：----------->" + arrResult[i]);  //输出结果为1、7
        }
    }
    
    //处理数组字符
    private static String[] arrContrast(String[] arr1, String[] arr2){
        List list = new LinkedList();
        for (int i=0;i<arr1.length;i++) {                //处理第一个数组,list里面的值为1,2,3,4
            if (!list.contains(arr1[i])) {
                list.add(arr1[i]);
            }
        }
        for (int i=0;i<arr2.length;i++) {     //如果第二个数组存在和第一个数组相同的值，就删除
            if(list.contains(arr2[i])){
                list.remove(arr2[i]);
            }
        }
        String[] result = {};   //创建空数组
        return (String[]) list.toArray(result);    //List to Array
    }
}
