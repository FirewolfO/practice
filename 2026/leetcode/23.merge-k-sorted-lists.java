/*
 * @lc app=leetcode.cn id=23 lang=java
 * @lcpr version=30204
 *
 * [23] 合并 K 个升序链表
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 方法一： 暴力破解 - 每次取同一个位置最小的
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         ListNode res = new ListNode();
//         ListNode tmp = res ;
//         while(true){
//             ListNode min = getMin(lists);
//             if(min == null){
//                 break;
//             }
//             tmp.next = min;
//             tmp = tmp.next;
//         }  
//         return res.next;
//     }

//     ListNode getMin(ListNode[] lists){
//         ListNode min = null;
//         int index = -1;
//         for(int i = 0; i < lists.length; i++){
//             ListNode node = lists[i];
//             if(node != null && (min == null || node.val < min.val)){
//                 min = node;
//                 index = i;
//             }
//         }
//         if(min != null){
//             lists[index] = lists[index].next;
//         }
//         return min;
//     }
// }
// 方法二：暴力破解，逐个合并
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         if (lists == null || lists.length == 0) {
//             return null;
//         }
//         return mergeK1Lists(lists, 0);
//     }

//     ListNode mergeK1Lists(ListNode[] lists, int start ){
//         if(start == lists.length-1){
//             return lists[start];
//         }
//         ListNode other = mergeK1Lists(lists, start+1);
//         ListNode current = lists[start];
//         ListNode res = new ListNode();
//         ListNode p = res;
//         while (other != null && current != null) {
//             if(other.val < current.val){
//                 p.next = other;
//                 other = other.next;
//             }else{
//                 p.next = current;
//                 current = current.next;
//             }
//             p = p.next;
//         }
//         if(current != null){
//             p.next = current;
//         }
//         if(other != null){
//             p.next = other;
//         }
//         return res.next;
//     }
// }
// 方法三： 分治
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeK1Lists(lists, 0, lists.length-1);
    }

    ListNode mergeK1Lists(ListNode[] lists, int start, int end  ){
        if(start == end){
            return lists[start];
        }
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        ListNode left = mergeK1Lists(lists, start, mid);
        ListNode right = mergeK1Lists(lists, mid+1, end);
        ListNode res = new ListNode();
        ListNode p = res;
        while (left != null && right != null) {
            if(left.val < right.val){
                p.next = left;
                left = left.next;
            }else{
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        if(left != null){
            p.next = left;
        }
        if(right != null){
            p.next = right;
        }
        return res.next;
    }
}
// @lc code=end

/*
// @lcpr case=start
// [[1,4,5],[1,3,4],[2,6]]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [[]]\n
// @lcpr case=end

 */

