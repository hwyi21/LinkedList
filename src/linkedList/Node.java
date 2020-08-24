package linkedList;

class Node{
    private int data; // 데이터 저장 변수
    public Node next; // 다음 노드를 참조할 링크 노드
    
    public Node() {
        this.data = (Integer) null;
        this.next = null;
    }
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    
    public int getData() {
        return this.data;
    }
}



