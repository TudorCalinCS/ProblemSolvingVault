#include <cstddef>
using namespace std;
/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
*/
struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
class Solution
{
public:
    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2)
    {
        ListNode *fake = new ListNode();
        ListNode *result = fake;
        while (list1 != NULL && list2 != NULL)
        {
            int v1 = list1->val;
            int v2 = list2->val;
            if (v1 <= v2)
            {
                ListNode *n = new ListNode(list1->val);
                result->next = n;
                list1 = list1->next;
            }
            else
            {
                ListNode *n = new ListNode(list2->val);
                result->next = n;
                list2 = list2->next;
            }
            result = result->next;
        }
        if (list1 != NULL)
            result->next = list1;
        else if (list2 != NULL)
            result->next = list2;
        ListNode *r = fake->next;
        delete fake;
        return r;
    }
};