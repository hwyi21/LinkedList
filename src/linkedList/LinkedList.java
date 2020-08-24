package linkedList;

public class LinkedList {
    private Node head;    // Node 타입의 첫번째 노드 (head 노드) 인스턴스 변수
    
    // LinkedList 생성자
    public LinkedList() {
        head = null;    // head 노드 초기화
    }
    
    // 중간에 node를 삽입하는 경우
    public void insertNode(Node pre, int data) {       
        Node newNode = new Node(data);    // 새로운 node 생성
        //pre -> newNode -> 기존 pre의 다음 노드
        //1.새로운 node의 next는 이전 node의 next를 참조
        //2.이전 node의 next는 새로운 node를 참조
        
        // 이전 node(pre)의 next는 pre의 다음 node이므로,
        // newNode.next = pre.next는 새로운 node의 next가 이전 node(pre)의 next를 참조해야 함. 
        newNode.next = pre.next;
        
        //이전 node의 next는 새로운 node를 참조 하도록 변경
        pre.next = newNode;
    }
    
    //마지막에 node를 삽입하는 경우
    public void insertNode(int data) {
        Node newNode = new Node(data);    // 새로운 node 생성
        //1. 마지막 node 찾아가기
        //2. 마지막 node의 next(포인터)는 newNode
        
        if(head == null) {
            // head 노드가 null인 경우 새로운 node가 첫번째 node가 됨
            this.head = newNode;
        } else {
            // head가 null이 아닌 경우 temp는 head를 참조.
            Node temp = head;
            
            // temp의 next가 null이 아닐 때 까지 while문 반복
            // next가 null이라면 가장 마지막 node를 의미
            while(temp.next != null) {
            	temp = temp.next;    // 다음 노드를 참조 
            }
            
            //while문 완료 후 temp는 가장 마지막 node
            // temp의 next가 새로 생성한 node를 참조 
            temp.next = newNode;
        }
    }
    
    //node를 삭제 하는 경우
    //1. head Node 삭제
    //2. 중간 Node 삭제
    //3. tail Node 삭제
    
    // head/중간에있는 node를 삭제하는 경우
    public void deleteNode(int data) {
        // pre는 head가 가리키는 node를 할당
        Node pre = head;
        // temp는 head가 가리키는 node의 다음 node
        Node temp = head.next; 
        
        //주어진 데이터가 head(pre)의 데이터가 일치할 경우 = head를 삭제하는 경우
        if(data== pre.getData()) {
            // head는 pre의 다음 노드를 참조하도록 함.
            head = pre.next;
            // 기존 head(pre)의 next는 null을 할당하여 연결을 끊음.
            pre.next = null;
        } else { //중간에 있는 node를 삭제할 경우
            // temp가 null일 때까지 반복하여 탐색
            while(temp != null) {
                // 주어진 데이터와 temp node의 데이터가 일치
                if(data==temp.getData()) {
                    if(temp.next == null) { // 삭제하려는 데이터가 마지막 node인 경우
                        pre.next = null; // 이전 node(pre)의 next를 null 값으로 변경
                    } else {
                        // temp가 마지막 node가 아닌 경우
                    	//pre -> temp(pre.next) 삭제 할 데이터 -> temp.next
                        // pre의 next는 temp의 다음 node인 temp.next를 참조
                        // 삭제할 temp의 next는 null을 할당하여 다음 node인 temp.next의 연결을 끊음.
                        pre.next = temp.next;
                        temp.next = null;
                    }
                    break;
                } else {
                    // 데이터가 일치하지 않을 경우 
                    // 이전 node(pre)에 현재 node(temp)를 할당, 
                	// 현재 node(temp)에 다음 node(temp.next) 할당.
                	//pre -> temp(pre.next) 삭제 할 데이터 -> temp.next
                	//temp(pre.next) -> temp.next -> temp.next.next
                    pre = temp;
                    temp = temp.next;
                }
            }
        }
    }
    
    //마지막에 있는 node를 삭제하는 경우
    public void deleteNode() {
        Node pre;
        Node temp;
        
        // head의 node가 null인 경우 = 모든 node가 삭제
        if(head == null) {
            return;
        }
        
        // head가 마지막 node인 경우
        if(head.next == null) {
            // head에 null을 할당 = 마지막 node를 null로 변경 = 모든 node 삭제
            head = null;
        } else {
            pre = head;
            temp = head.next;     
            
            //pre -> temp(pre.next) 삭제 할 데이터 -> temp.next
        	//temp(pre.next) -> temp.next -> temp.next.next
            //temp.next가 null이 될되까지 while문 반복
            while(temp.next != null) {
                pre = temp;
                temp = temp.next;
            }
            
            //temp.next가 null이라면 해당 temp(pre.next)는 마지막 node
            // pre의 next를 null로 만들어서 temp로의 연결을 끊음
            pre.next = null;
        }
    }
    
    // head부터 node 탐색
    public Node searchNode(int data) {
        Node temp = this.head;    // temp node에 가장 첫번째 node(head) 할당.
        
        // temp 노드가 null이 아닐 때까지 반복하여 탐색
        while(temp != null) {
            // 주어진 데이터와 temp node의 데이터가 일치할 경우 해당 temp node를 return
            if(data==temp.getData()) {
                return temp;
            } else {
                // 데이터가 일치하지 않을 경우 temp node에 다음 node 할당.
                temp = temp.next;
            }
        }
        return temp;
    }
    
    // nod의 모든 데이터 출력
    public void printList() {
        Node temp = this.head;    // temp node에 가장 첫번째 node(head) 할당.
        
        // temp가 null이 아닐 때까지 반복하여 출력
        while(temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.next;    //temp node에 다음 node 할당.
        }
        System.out.println();
    }
 
    public static void main(String args[]) {
        LinkedList linkedList = new LinkedList();    // 연결 리스트 생성
        int find = 3;
        
        for(int i=0; i<10; i++) {
        	linkedList.insertNode(i);
        }
        linkedList.printList();
        
        System.out.println(linkedList.searchNode(find).getData());
        
        linkedList.deleteNode(linkedList.searchNode(find).getData());
        linkedList.printList();
        
        find=7;
        linkedList.deleteNode(linkedList.searchNode(find).getData());
        linkedList.printList();
        
        find=2;
        linkedList.insertNode(linkedList.searchNode(find), 3);
        linkedList.printList();
        
    }
    
}


