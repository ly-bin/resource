class MyStack {
    private Deque<Integer> q = new LinkedList<Integer>();

    public void push(int x) {
        q.add(x);
    }


    public Integer pop() {
        return q.pollLast();
    }

    public int top() {
        return q.peek();
    }


    public boolean empty() {
        return q.isEmpty();
    }

    public Integer size() {
        return q.size();
    }
}