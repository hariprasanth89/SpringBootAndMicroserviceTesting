package com.example.leetcodelearningor;

public class AddTwoNumbersLeet2 {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.value : 0;
			int y = (q != null) ? q.value : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;    // next item 
			if (q != null)
				q = q.next;   // next item
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;

	}
	void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println("");
    }
	public static void main(String[] args) {
		ListNode head1 = new ListNode(3);
	        
			head1.next = new ListNode(2);
	        head1.next.next = new ListNode(4);
	        head1.next.next.next = new ListNode(3);
	        System.out.print("First List is ");
	        
	       
	        
	        ListNode head2 = new ListNode(3);
	       
	        head2.next = new ListNode(5);
	        head2.next.next = new ListNode(6);
	        head2.next.next.next = new ListNode(4);
	        System.out.print("second List is ");
	        ListNode addTwoNumbers = addTwoNumbers(head1, head2);
	        
	        AddTwoNumbersLeet2 numbersLeet2 = new AddTwoNumbersLeet2();
	        numbersLeet2.printList(addTwoNumbers);
	        
		
	}

}

class ListNode {
	int value;
	ListNode next;

//	ListNode() {
//	}

	ListNode(int val) {
		this.value = val;
	}

//	ListNode(int val, ListNode next) {
//		this.value = val;
//		this.next = next;
//	}
}
